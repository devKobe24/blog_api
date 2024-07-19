package com.devkobe.blog.web.dto.userInfo.create;

import com.devkobe.blog.domain.userInfo.UserInfo;
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
	public UserInfoCreateResponseDto(UserInfo entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.profileImage = entity.getProfileImage();
		this.nickName = entity.getNickName();
	}
}
