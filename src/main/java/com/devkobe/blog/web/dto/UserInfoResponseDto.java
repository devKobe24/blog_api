package com.devkobe.blog.web.dto;

import com.devkobe.blog.domain.UserInfo;
import lombok.Getter;

@Getter
public class UserInfoResponseDto {

	private Long id;
	private String name;
	private String email;
	private String profileImage;
	private String nickName;

	public UserInfoResponseDto(UserInfo entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.profileImage = entity.getProfileImage();
		this.nickName = entity.getNickName();
	}
}



