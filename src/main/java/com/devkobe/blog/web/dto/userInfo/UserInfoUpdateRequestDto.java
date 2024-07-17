package com.devkobe.blog.web.dto.userInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoUpdateRequestDto {
	private String name;
	private String email;
	private String profileImage;
	private String nickName;

	@Builder
	public UserInfoUpdateRequestDto(String name, String email, String profileImage, String nickName) {
		this.name = name;
		this.email = email;
		this.profileImage = profileImage;
		this.nickName = nickName;
	}
}
