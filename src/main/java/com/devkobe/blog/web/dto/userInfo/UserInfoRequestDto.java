package com.devkobe.blog.web.dto.userInfo;

import com.devkobe.blog.domain.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoRequestDto {
	private String name;
	private String email;
	private String profileImage;
	private String nickName;

	@Builder
	public UserInfoRequestDto(String name, String email, String profileImage, String nickName) {
		this.name = name;
		this.email = email;
		this.profileImage = profileImage;
		this.nickName = nickName;
	}

	public UserInfo toEntity() {
		return UserInfo.builder()
		               .name(name)
		               .email(email)
		               .profileImage(profileImage)
		               .nickName(nickName)
		               .build();
	}
}

