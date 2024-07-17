package com.devkobe.blog.service;

import com.devkobe.blog.domain.PostInfo;
import com.devkobe.blog.domain.Posts;
import com.devkobe.blog.repository.PostInfoRepository;
import com.devkobe.blog.repository.PostsRepository;
import com.devkobe.blog.web.dto.postInfo.PostInfoRequestDto;
import com.devkobe.blog.web.dto.postInfo.PostInfoResponseDto;
import com.devkobe.blog.web.dto.postInfo.PostInfoUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostInfoService {

	private final PostInfoRepository postInfoRepository;
	private final PostsRepository postsRepository;

	@Transactional
	public Long save(PostInfoRequestDto requestDto) {
		Posts posts = postsRepository.findById(requestDto.getPostsId())
		                             .orElseThrow(() -> new IllegalArgumentException("Invalid postsId ==========>>>>>>>> " + requestDto.getPostsId()));

		PostInfo postInfo = requestDto.toEntity(posts);
		return postInfoRepository.save(postInfo).getId();
	}

	@Transactional
	public void delete(Long id) {
		PostInfo postInfo = postInfoRepository.findById(id)
		                                      .orElseThrow(() -> new IllegalArgumentException("Invalid postInfoId ================>>>>>>>>>>>> " + id));
		postInfoRepository.delete(postInfo);
	}

	@Transactional
	public Long update(Long id, PostInfoUpdateRequestDto requestDto) {
		PostInfo postInfo = postInfoRepository.findById(id)
		                                      .orElseThrow(() -> new IllegalArgumentException("Invalid postInfoId ============>>>>>>>> " + id));

		postInfo.update(requestDto.getAdditionalInfo());

		return postInfo.getId();
	}

	@Transactional(readOnly = true)
	public PostInfoResponseDto findById(Long id) {
		PostInfo postInfo = postInfoRepository.findById(id)
		                                      .orElseThrow(() -> new IllegalArgumentException("Invalid postInfoId ===========>>>>>>>>>>> " + id));
		return new PostInfoResponseDto(postInfo);
	}
}

