package com.devkobe.blog.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.devkobe.blog.domain.posts.Posts;
import com.devkobe.blog.domain.userInfo.UserInfo;
import com.devkobe.blog.repository.posts.PostsRepository;
import com.devkobe.blog.repository.userInfo.UserInfoRepository;
import com.devkobe.blog.service.posts.PostsService;
import com.devkobe.blog.web.dto.posts.PostsSaveRequestDto;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PostsServiceTest {

	@Mock
	private PostsRepository postsRepository;

	@Mock
	private UserInfoRepository userInfoRepository;

	@InjectMocks
	private PostsService postsService;

	private UserInfo existingUserInfo;
	private UserInfo newUserInfo;

	@Captor
	private ArgumentCaptor<Posts> postsCaptor;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		existingUserInfo = UserInfo.builder()
				.name("Existing User")
				.email("existing@example.com")
				.profileImage("http://example.com/image.png")
				.nickName("existing_nick")
				.build();
		existingUserInfo.setId(1L);

		newUserInfo = UserInfo.builder()
				.name("New User")
				.email("new@example.com")
				.profileImage("http://example.com/image.png")
				.nickName("new_nick")
				.build();
	}

	@Test
	public void testSaveWithExistingUserInfo() {
		// given
		PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
				.title("Test title")
				.content("Test content")
				.nickName("existing_nick")
				.postNumber(1)
				.userInfoId(existingUserInfo.getId())
				.additionalInfo("Some additional info")
				.build();

		when(userInfoRepository.findById(existingUserInfo.getId())).thenReturn(Optional.of(existingUserInfo));
		when(postsRepository.save(any(Posts.class))).thenAnswer(invocation -> {
			Posts savedPost = invocation.getArgument(0);
			savedPost.setId(1L);
			return savedPost;
		});

		// when
		Long postId = postsService.save(requestDto);

		// then
		assertThat(postId).isNotNull();
		assertThat(postId).isEqualTo(1L);
		Mockito.verify(postsRepository).save(postsCaptor.capture());
		Posts capturedPosts = postsCaptor.getValue();
		assertThat(capturedPosts.getId()).isEqualTo(1L);
	}

	@Test
	public void testSaveWithNewUserInfo() {
		// given
		PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
				.title("Test Title")
				.content("Test Content")
				.nickName("new_nick")
				.postNumber(1)
				.name(newUserInfo.getName())
				.email(newUserInfo.getEmail())
				.profileImage(newUserInfo.getProfileImage())
				.additionalInfo("Some additional info")
				.build();

		when(userInfoRepository.save(any(UserInfo.class))).thenAnswer(invocation -> {
			UserInfo savedUser = invocation.getArgument(0);
			savedUser.setId(2L); // ID 설정
			return savedUser;
		});
		when(postsRepository.save(any(Posts.class))).thenAnswer(invocation -> {
			Posts savedPost = invocation.getArgument(0);
			savedPost.setId(1L); // ID 설정
			return savedPost;
		});

		// when
		Long postId = postsService.save(requestDto);

		// then
		assertThat(postId).isNotNull();
		assertThat(postId).isEqualTo(1L);
		Mockito.verify(postsRepository).save(postsCaptor.capture());
		Posts capturedPosts = postsCaptor.getValue();
		assertThat(capturedPosts.getId()).isEqualTo(1L);
	}
}
