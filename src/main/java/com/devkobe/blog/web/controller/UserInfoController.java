package com.devkobe.blog.web.controller;

import com.devkobe.blog.service.UserInfoService;
import com.devkobe.blog.web.dto.UserInfoRequestDto;
import com.devkobe.blog.web.dto.UserInfoResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/userInfo")
public class UserInfoController {

	private final UserInfoService userInfoService;

	@PostMapping
	public Long save(@RequestBody UserInfoRequestDto requestDto) {
		return userInfoService.save(requestDto);
	}

	@GetMapping("/{id}")
	public UserInfoResponseDto findById(@PathVariable Long id) {
		return userInfoService.findById(id);
	}

	@GetMapping
	public List<UserInfoResponseDto> findAll() {
		return userInfoService.findAll();
	}

	@PutMapping("/{id}")
	public Long update(@PathVariable Long id, @RequestBody UserInfoRequestDto requestDto) {
		return userInfoService.update(id, requestDto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userInfoService.delete(id);
	}
}

