package com.devkobe.domain.postInfo;

import static org.assertj.core.api.Assertions.assertThat;

import com.devkobe.domain.posts.Posts;
import com.devkobe.domain.posts.PostsRepository;
import com.devkobe.domain.userInfo.UserInfo;
import com.devkobe.domain.userInfo.UserInfoRepository;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostInfoRepositoryTest {

	@Autowired
	PostInfoRepository postInfoRepository;

	@Autowired
	PostsRepository postsRepository;

	@Autowired
	UserInfoRepository userInfoRepository;

	@AfterEach
	public void cleanup() {
		postInfoRepository.deleteAll();
		postsRepository.deleteAll();
		userInfoRepository.deleteAll();
	}

	@Test
	public void 게시물_저장_정보_불러오기() {
		// given
		String title = "게시물 제목";
		String content = "게시물 본문";
		Integer postNumber = 1;

		UserInfo userInfo = userInfoRepository.save(new UserInfo("유저 이름", "유저 이메일", "profile_image_url", "빙구당"));
		Posts posts = postsRepository.save(new Posts(title, content, "유저 닉네임", postNumber, userInfo));

		postInfoRepository.save(PostInfo.builder()
		                                .title(title)
		                                .content(content)
		                                .postNumber(postNumber)
		                                .posts(posts)
		                                .build());

		// when
		List<PostInfo> postInfoList = postInfoRepository.findAll();

		// then
		PostInfo postInfo = postInfoList.get(0);
		assertThat(postInfo.getTitle()).isEqualTo(title);
		assertThat(postInfo.getContent()).isEqualTo(content);
		assertThat(postInfo.getPostNumber()).isEqualTo(postNumber);
		assertThat(postInfo.getPostInfoId()).isEqualTo(posts.getPostsId());
	}
}
