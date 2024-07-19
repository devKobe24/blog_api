package com.devkobe.blog.web.dto.userInfo.update;

import com.devkobe.blog.domain.userInfo.UserInfo;
import lombok.Getter;

@Getter
public class UserInfoUpdateResponseDto {
	private Long id;
	private String name;
	private String email;
	private String profileIamge;
	private String nickName;

	public UserInfoUpdateResponseDto(UserInfo entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.profileIamge = entity.getProfileImage();
		this.nickName = entity.getNickName();
	}
}
