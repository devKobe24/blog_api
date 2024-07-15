package com.devkobe.domain.dateInfo;

import static org.assertj.core.api.Assertions.assertThat;

import com.devkobe.domain.posts.Posts;
import com.devkobe.domain.posts.PostsRepository;
import com.devkobe.domain.userInfo.UserInfo;
import com.devkobe.domain.userInfo.UserInfoRepository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DateInfoRepositoryTest {

	@Autowired
	DateInfoRepository dateInfoRepository;

	@Autowired
	PostsRepository postsRepository;

	@Autowired
	UserInfoRepository userInfoRepository;

	@AfterEach
	public void cleanup() {
		dateInfoRepository.deleteAll();
		postsRepository.deleteAll();
		userInfoRepository.deleteAll();
	}

	@Test
	public void 날짜_저장_정보_불러오기() {
		// given
		String title = "게시글 제목";
		String content = "게시글 본문";
		String nickName = "빙구당";
		Integer postNumber = 1;
		UserInfo userInfo = userInfoRepository.save(
				new UserInfo("이름", "이메일", "profile_image_url", "빙구당"));

		Posts posts = postsRepository.save(Posts.builder()
		                                        .title(title)
		                                        .content(content)
		                                        .nickName(nickName)
		                                        .postNumber(postNumber)
		                                        .userInfo(userInfo)
		                                        .build());

		Timestamp releaseDate = new Timestamp(System.currentTimeMillis());

		// 특정 날짜와 시간 문자열
		String dateTimeString = "2024-07-16T10:30:00";
		// 날짜 형식 지정
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		// 문자열을 LovalDateTime 객체로 변환
		LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
		// LocalDateTime 객체를 TimeStamp로 변환
		Timestamp modificationDate = Timestamp.valueOf(localDateTime);

		dateInfoRepository.save(DateInfo.builder()
		                                .releaseDate(releaseDate)
		                                .modificationDate(modificationDate)
		                                .posts(posts)
		                                .build()
		);

		// when
		List<DateInfo> dateInfoList = dateInfoRepository.findAll();

		// then
		DateInfo dateInfo = dateInfoList.get(0);
		assertThat(dateInfo.getReleaseDate()).isEqualTo(releaseDate);
		assertThat(dateInfo.getModificationDate()).isEqualTo(modificationDate);
		assertThat(dateInfo.getPosts().getPostsId()).isEqualTo(posts.getPostsId());
	}
}
