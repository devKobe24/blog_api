package com.devkobe.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import com.devkobe.domain.dateInfo.DateInfoRepository;
import com.devkobe.domain.userInfo.UserInfo;
import com.devkobe.domain.userInfo.UserInfoRepository;
import jakarta.transaction.Transactional;
import java.text.ParseException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;

	@Autowired
	UserInfoRepository userInfoRepository;

	@AfterEach
	public void cleanup() {
		postsRepository.deleteAll();
		userInfoRepository.deleteAll();
	}

	@Test
	@Transactional
	public void 게시글저장_불러오기() throws ParseException {
		// given
		String title = "게시글 제목";
		String content = "게시글 본문";
		String nickName = "빙구당";
		Integer postNumber = 1;
		UserInfo userInfo = userInfoRepository.save(new UserInfo("이름", "이메일", "profile_image_url", "빙구당"));

		postsRepository.save(Posts.builder()
		                          .title(title)
		                          .content(content)
		                          .nickName(nickName)
		                          .postNumber(postNumber)
		                          .userInfo(userInfo)
		                          .build());

		// when
		List<Posts> postsList = postsRepository.findAll();

		// then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);
		assertThat(posts.getNickName()).isEqualTo(nickName);
		assertThat(posts.getPostNumber()).isEqualTo(postNumber);
		assertThat(posts.getUserInfo()).isEqualTo(userInfo);
	}
}
