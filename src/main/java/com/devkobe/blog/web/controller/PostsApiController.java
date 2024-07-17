package com.devkobe.blog.web.controller;

import com.devkobe.blog.service.PostsService;
import com.devkobe.blog.web.dto.posts.PostsResponseDto;
import com.devkobe.blog.web.dto.posts.PostsSaveRequestDto;
import com.devkobe.blog.web.dto.posts.PostsUpdateRequestDto;
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
	public Long save(@RequestBody PostsSaveRequestDto requestDto) {
		return postsService.save(requestDto);
	}

	@GetMapping("/{id}")
	public PostsResponseDto findById(@PathVariable Long id) {
		return postsService.findById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		postsService.delete(id);
	}

	@GetMapping
	public List<PostsResponseDto> findAll() {
		return postsService.findAll();
	}

	@PutMapping("/{id}")
	public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
		return postsService.update(id, requestDto);
	}
}

