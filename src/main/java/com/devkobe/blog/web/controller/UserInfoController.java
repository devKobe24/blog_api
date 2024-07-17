package com.devkobe.blog.web.controller;

import com.devkobe.blog.service.UserInfoService;
import com.devkobe.blog.web.dto.userInfo.create.UserInfoCreateRequestDto;
import com.devkobe.blog.web.dto.userInfo.read.UserInfoReadResponseDto;
import com.devkobe.blog.web.dto.userInfo.update.UserInfoUpdateRequestDto;
import com.devkobe.blog.web.dto.userInfo.update.UserInfoUpdateResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/userInfo")
public class UserInfoController {

	private final UserInfoService userInfoService;

	@PostMapping
	public Long save(@RequestBody UserInfoCreateRequestDto requestDto) {
		return userInfoService.save(requestDto);
	}

	@GetMapping("/{id}")
	public UserInfoReadResponseDto findById(@PathVariable Long id) {
		return userInfoService.findById(id);
	}

	@GetMapping
	public List<UserInfoReadResponseDto> findAll() {
		return userInfoService.findAll();
	}

	@PutMapping("/{id}")
	public UserInfoUpdateResponseDto update(@PathVariable Long id, @RequestBody UserInfoUpdateRequestDto requestDto) {
		return userInfoService.update(id, requestDto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userInfoService.delete(id);
	}
}

