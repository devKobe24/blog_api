package com.devkobe.blog.web.dto.userInfo.delete;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoDeleteRequestDto {
	private Long id;

	@Builder
	public UserInfoDeleteRequestDto(Long id) {
		this.id = id;
	}
}
