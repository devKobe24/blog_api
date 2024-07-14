package com.devkobe.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;

	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}

	@Test
	public void 게시글저장_불러오기() throws ParseException {
		// given
		String title = "게시글 제목";
		String content = "게시글 본문";
		String nickName = "빙구당";
		java.sql.Timestamp releaseDate = new Timestamp(100000);
		java.sql.Timestamp modificationDate = new Timestamp(100000);

		Integer postNumber = 1;

		postsRepository.save(Posts.builder()
				.title(title)
				.content(content)
				.nickName(nickName)
				.releaseDate(releaseDate)
				.modificationDate(modificationDate)
				.postNumber(postNumber)
				.build());

		// when
		List<Posts> postsList = postsRepository.findAll();

		// then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);
		assertThat(posts.getNickName()).isEqualTo(nickName);
		assertThat(posts.getReleaseDate()).isEqualTo(releaseDate);
		assertThat(posts.getPostNumber()).isEqualTo(postNumber);
	}
}
