package com.devkobe.blog.service;

import com.devkobe.blog.domain.Posts;
import com.devkobe.blog.domain.UserInfo;
import com.devkobe.blog.repository.PostsRepository;
import com.devkobe.blog.repository.UserInfoRepository;
import com.devkobe.blog.web.dto.PostsResponseDto;
import com.devkobe.blog.web.dto.PostsSaveRequestDto;
import com.devkobe.blog.web.dto.PostsUpdateRequestDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

	private final PostsRepository postsRepository;
	private final UserInfoRepository userInfoRepository;

	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		UserInfo userInfo;
		if (requestDto.getUserInfoId() != null) {
			userInfo = userInfoRepository.findById(requestDto.getUserInfoId())
			                             .orElseThrow(() -> new IllegalArgumentException("Invalid userInfoId ==========>>>>>>>>>> " + requestDto.getUserInfoId()));
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
		return post.getId();
	}

	@Transactional
	public void delete(Long id) {
		Posts post = postsRepository.findById(id)
		                            .orElseThrow(() -> new IllegalArgumentException("Invalid postId =============>>>>>>>>>>>>>>> " + id));
		postsRepository.delete(post);
	}

	@Transactional(readOnly = true)
	public List<PostsResponseDto> findAll() {
		return postsRepository.findAll().stream()
		                      .map(PostsResponseDto::new)
		                      .collect(Collectors.toList());
	}

	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		Posts post = postsRepository.findById(id)
		                            .orElseThrow(() -> new IllegalArgumentException("Invalid postId ================>>>>>>> " + id));

		post.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getNickName(), requestDto.getPostNumber(), requestDto.getAdditionalInfo());

		return post.getId();
	}

	@Transactional(readOnly = true)
	public PostsResponseDto findById(Long id) {
		Posts post = postsRepository.findById(id)
		                            .orElseThrow(() -> new IllegalArgumentException("Invalid postId ==========>>>>>>>>>>>> " + id));
		return new PostsResponseDto(post);
	}
}

