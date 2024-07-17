package com.devkobe.blog.web.dto.userInfo.create;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserInfoCreateResponseDto {
	private Long id;
	private String name;
	private String email;
	private String profileImage;
	private String nickName;

	@Builder
	public UserInfoCreateResponseDto(Long id, String name, String email, String profileImage, String nickName) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.profileImage = profileImage;
		this.nickName = nickName;
	}
}
