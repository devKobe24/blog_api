package com.devkobe.blog.web.controller.post;

import com.devkobe.blog.service.post.PostService;
import com.devkobe.blog.web.dto.post.create.PostCreateRequestDto;
import com.devkobe.blog.web.dto.post.create.PostCreateResponseDto;
import com.devkobe.blog.web.dto.post.delete.PostDeleteRequestDto;
import com.devkobe.blog.web.dto.post.delete.PostDeleteResponseDto;
import com.devkobe.blog.web.dto.post.read.PostReadRequestDto;
import com.devkobe.blog.web.dto.post.read.PostReadResponseDto;
import com.devkobe.blog.web.dto.post.update.PostUpdateRequestDto;
import com.devkobe.blog.web.dto.post.update.PostUpdateResponseDto;
import com.devkobe.blog.web.dto.postList.create.PostListCreateResponseDto;
import com.devkobe.blog.web.dto.postList.delete.PostListDeleteRequestDto;
import com.devkobe.blog.web.dto.postList.delete.PostListDeleteResponseDto;
import com.devkobe.blog.web.dto.postList.read.PostListReadRequestDto;
import com.devkobe.blog.web.dto.postList.update.PostListUpdateRequestDto;
import com.devkobe.blog.web.dto.postList.create.PostListCreateRequestDto;
import com.devkobe.blog.web.dto.postList.read.PostListReadResponseDto;
import com.devkobe.blog.web.dto.postList.update.PostListUpdateResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/post")
public class PostController {

	private final PostService postService;

	// CREATE
	@PostMapping
	public PostCreateResponseDto save(@RequestBody PostCreateRequestDto requestDto) {
		return postService.save(requestDto);
	}

	// READ
	@GetMapping("/{id}")
	public ResponseEntity<PostReadResponseDto> findById(@PathVariable Long postId) {
		PostReadResponseDto post = postService.findById(postId);
		return ResponseEntity.ok(post);
	}

	@GetMapping
	public ResponseEntity<List<PostReadResponseDto>> findAll() {
		List<PostReadResponseDto> posts = postService.findAll();
		return ResponseEntity.ok(posts);
	}

	//SEARCH
	@GetMapping("/search")
	public ResponseEntity<List<PostReadResponseDto>> findByCriteria(
		@RequestParam(required = false) Long id,
		@RequestParam(required = false) Long postInfoId,
		@RequestParam(required = false) Long userInfoId,
		@RequestParam(required = false) Long dateInfoId,
		@RequestParam(required = false) String title,
		@RequestParam(required = false) String content,
		@RequestParam(required = false) String nickName,
		@RequestParam(required = false) Integer postNumber
		) {

		List<PostReadResponseDto> posts = postService.findByCriteria(
			id,
			postInfoId,
			userInfoId,
			dateInfoId,
			title,
			content,
			nickName,
			postNumber
		);

		return ResponseEntity.ok(posts);
	}

	// UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<PostUpdateResponseDto> update(@PathVariable Long postId,
		@RequestBody PostUpdateRequestDto requestDto) {
		PostUpdateResponseDto post = postService.update(postId, requestDto);
		return ResponseEntity.ok(post);
	}

	// DELETE
	@DeleteMapping("/delete")
	public PostDeleteResponseDto delete(@RequestBody PostDeleteRequestDto requestDto) {
		return postService.delete(requestDto.getId());
	}
}


