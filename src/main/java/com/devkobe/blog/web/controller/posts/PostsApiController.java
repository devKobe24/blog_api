package com.devkobe.blog.web.controller.posts;

import com.devkobe.blog.service.posts.PostsService;
import com.devkobe.blog.web.dto.posts.create.PostsCreateResponseDto;
import com.devkobe.blog.web.dto.posts.delete.PostsDeleteRequestDto;
import com.devkobe.blog.web.dto.posts.delete.PostsDeleteResponseDto;
import com.devkobe.blog.web.dto.posts.read.PostsReadRequestDto;
import com.devkobe.blog.web.dto.posts.update.PostsUpdateRequestDto;
import com.devkobe.blog.web.dto.posts.create.PostsCreateRequestDto;
import com.devkobe.blog.web.dto.posts.read.PostsReadResponseDto;
import com.devkobe.blog.web.dto.posts.update.PostsUpdateResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostsApiController {

	private final PostsService postsService;

	@PostMapping
	public PostsCreateResponseDto save(@RequestBody PostsCreateRequestDto requestDto) {
		return postsService.save(requestDto);
	}

	@GetMapping("/{id}")
	public PostsReadResponseDto findById(@PathVariable Long id) {
		return postsService.findById(id);
	}

	@GetMapping
	public List<PostsReadResponseDto> findAll() {
		return postsService.findAll();
	}

	@GetMapping("/search")
	public List<PostsReadResponseDto> findByCriteria(PostsReadRequestDto requestDto) {
		return postsService.findByCriteria(requestDto);
	}

	@PutMapping("/{id}")
	public PostsUpdateResponseDto update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
		return postsService.update(id, requestDto);
	}

	@DeleteMapping("/delete")
	public PostsDeleteResponseDto delete(@RequestBody PostsDeleteRequestDto requestDto) {
		return postsService.delete(requestDto.getId());
	}
}

