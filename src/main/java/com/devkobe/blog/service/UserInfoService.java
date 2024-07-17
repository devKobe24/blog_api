package com.devkobe.blog.service;

import com.devkobe.blog.domain.UserInfo;
import com.devkobe.blog.repository.UserInfoRepository;
import com.devkobe.blog.web.dto.userInfo.UserInfoRequestDto;
import com.devkobe.blog.web.dto.userInfo.UserInfoResponseDto;
import com.devkobe.blog.web.dto.userInfo.UserInfoUpdateRequestDto;
import com.devkobe.blog.web.dto.userInfo.UserInfoUpdateResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserInfoService {

	private final UserInfoRepository userInfoRepository;

	@Transactional
	public Long save(UserInfoRequestDto requestDto) {
		UserInfo userInfo = requestDto.toEntity();
		userInfoRepository.save(userInfo);
		return userInfo.getId();
	}

	@Transactional(readOnly = true)
	public UserInfoResponseDto findById(Long id) {
		UserInfo userInfo = userInfoRepository.findById(id)
		                                      .orElseThrow(() -> new IllegalArgumentException("invalid userInfoId ===========>>>>>> " + id));
		return new UserInfoResponseDto(userInfo);
	}

	@Transactional(readOnly = true)
	public List<UserInfoResponseDto> findAll() {
		return userInfoRepository.findAll().stream()
		                         .map(UserInfoResponseDto::new)
		                         .collect(Collectors.toList());
	}

	@Transactional
	public UserInfoUpdateResponseDto update(Long id, UserInfoUpdateRequestDto requestDto) {
		UserInfo userInfo = userInfoRepository.findById(id)
		                                      .orElseThrow(() -> new IllegalArgumentException("Invalid userInfoId ===========>>>>>>>> " + id));

		userInfo.update(requestDto.getName(), requestDto.getEmail(), requestDto.getProfileImage(), requestDto.getNickName());

		return new UserInfoUpdateResponseDto(userInfo);
	}

	@Transactional
	public void delete(Long id) {
		UserInfo userInfo = userInfoRepository.findById(id)
		                                      .orElseThrow(() -> new IllegalArgumentException("Invalid userInfoId ===========>>>>>>>> " + id));

		userInfoRepository.delete(userInfo);
	}
}

