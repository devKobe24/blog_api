package com.devkobe.blog.web;

import com.devkobe.blog.service.PostInfoService;
import com.devkobe.blog.web.dto.PostInfoRequestDto;
import com.devkobe.blog.web.dto.PostInfoResponseDto;
import com.devkobe.blog.web.dto.PostInfoUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/postInfo")
public class PostInfoController {

	private final PostInfoService postInfoService;

	@PostMapping
	public Long save(@RequestBody PostInfoRequestDto requestDto) {
		return postInfoService.save(requestDto);
	}

	@GetMapping("/{id}")
	public PostInfoResponseDto findById(@PathVariable Long id) {
		return postInfoService.findById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		postInfoService.delete(id);
	}

	@PutMapping("/{id}")
	public Long update(@PathVariable Long id, @RequestBody PostInfoUpdateRequestDto requestDto) {
		return postInfoService.update(id, requestDto);
	}
}

