package com.devkobe.blog.web.dto.userInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoReadRequestDto {
	private Long id;

	@Builder
	public UserInfoReadRequestDto(Long id) {
		this.id = id;
	}
}
