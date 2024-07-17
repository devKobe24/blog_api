package com.devkobe.blog.web.dto.userInfo.read;

import com.devkobe.blog.domain.UserInfo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserInfoReadResponseDto {

	private Long id;
	private String name;
	private String email;
	private String profileImage;
	private String nickName;

	@Builder
	public UserInfoReadResponseDto(UserInfo entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.profileImage = entity.getProfileImage();
		this.nickName = entity.getNickName();
	}
}
