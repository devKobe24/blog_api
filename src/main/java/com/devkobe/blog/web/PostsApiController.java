package com.devkobe.blog.web;

import com.devkobe.blog.service.PostsService;
import com.devkobe.blog.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostsApiController {

	private final PostsService postsService;

	@PostMapping
	public ResponseEntity<Long> save(@RequestBody PostsSaveRequestDto requestDto) {
		Long id = postsService.save(requestDto);
		return ResponseEntity.ok(id);
	}
}
