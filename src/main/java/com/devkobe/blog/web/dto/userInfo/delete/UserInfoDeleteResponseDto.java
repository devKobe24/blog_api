package com.devkobe.blog.web.dto.userInfo.delete;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoDeleteResponseDto {
	private Long id;
	private String status;

	public UserInfoDeleteResponseDto(Long id, String status) {
		this.id = id;
		this.status = status;
	}
}
