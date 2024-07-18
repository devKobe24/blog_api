package com.devkobe.blog.service;

import com.devkobe.blog.domain.Posts;
import com.devkobe.blog.domain.UserInfo;
import com.devkobe.blog.repository.PostsRepository;
import com.devkobe.blog.repository.PostsSpecification;
import com.devkobe.blog.repository.UserInfoRepository;
import com.devkobe.blog.web.dto.posts.create.PostsCreateResponseDto;
import com.devkobe.blog.web.dto.posts.delete.PostsDeleteResponseDto;
import com.devkobe.blog.web.dto.posts.read.PostsReadRequestDto;
import com.devkobe.blog.web.dto.posts.update.PostsUpdateRequestDto;
import com.devkobe.blog.web.dto.posts.create.PostsCreateRequestDto;
import com.devkobe.blog.web.dto.posts.read.PostsReadResponseDto;
import com.devkobe.blog.web.dto.posts.update.PostsUpdateResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

	private final PostsRepository postsRepository;
	private final UserInfoRepository userInfoRepository;

	@Transactional
	public PostsCreateResponseDto save(PostsCreateRequestDto requestDto) {
		UserInfo userInfo;
		if (requestDto.getUserInfoId() != null) {
			userInfo = userInfoRepository.findById(requestDto.getUserInfoId())
			                             .orElseThrow(() -> new IllegalArgumentException(
					                             "Invalid userInfoId ==========>>>>>>>>>> "
							                             + requestDto.getUserInfoId()));
		} else {
			userInfo = UserInfo.builder()
			                   .name(requestDto.getName())
			                   .email(requestDto.getEmail())
			                   .profileImage(requestDto.getProfileImage())
			                   .nickName(requestDto.getNickName())
			                   .build();

			userInfoRepository.save(userInfo);
		}

		Posts post = requestDto.toEntity(userInfo);
		postsRepository.save(post);
		return new PostsCreateResponseDto(post);
	}

	@Transactional
	public PostsDeleteResponseDto delete(Long id) {
		PostsDeleteResponseDto responseDto;
		try {
			Posts post = postsRepository.findById(id)
			                            .orElseThrow(() -> new IllegalArgumentException("Invalid postId ================>>>>>>> " + id));
			postsRepository.delete(post);
			responseDto = PostsDeleteResponseDto.builder()
			                                    .id(id)
			                                    .status("SUCCESS TO DELETE")
			                                    .build();
		} catch (Exception e) {
			responseDto = PostsDeleteResponseDto.builder()
			                                    .id(id)
			                                    .status("FAIL TO DELETE")
			                                    .build();
		}
		return responseDto;
	}

	@Transactional(readOnly = true)
	public List<PostsReadResponseDto> findAll() {
		return postsRepository.findAll().stream()
		                      .map(PostsReadResponseDto::new)
		                      .collect(Collectors.toList());
	}

	@Transactional
	public PostsUpdateResponseDto update(Long id, PostsUpdateRequestDto requestDto) {
		Posts post = postsRepository.findById(id)
		                            .orElseThrow(() -> new IllegalArgumentException("Invalid postId ================>>>>>>> " + id));

		post.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getNickName(), requestDto.getPostNumber(), requestDto.getAdditionalInfo());

		return new PostsUpdateResponseDto(post);
	}

	@Transactional(readOnly = true)
	public PostsReadResponseDto findById(Long id) {
		Posts post = postsRepository.findById(id)
		                            .orElseThrow(() -> new IllegalArgumentException("Invalid postId ==========>>>>>>>>>>>> " + id));
		return new PostsReadResponseDto(post);
	}

	// 조건 검색
	@Transactional(readOnly = true)
	public List<PostsReadResponseDto> findByCriteria(PostsReadRequestDto requestDto) {
		// 이곳에 적절한 쿼리 또는 필터링 로직 작성

		Specification<Posts> spec = Specification.where(PostsSpecification.withTitle(requestDto.getTitle()))
				.and(PostsSpecification.withContent(requestDto.getContent()))
				.and(PostsSpecification.withNickName(requestDto.getNickName()))
				.and(PostsSpecification.withPostNumber(requestDto.getPostNumber()))
				.and(PostsSpecification.withAdditionalInfo(requestDto.getAdditionalInfo()))
				.and(PostsSpecification.withUserInfoId(requestDto.getUserInfoId()));

		List<Posts> posts = postsRepository.findAll(spec);
		return posts.stream()
				.map(PostsReadResponseDto::new)
				.collect(Collectors.toList());
	}
}


