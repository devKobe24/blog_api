package com.devkobe.blog.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostInfoUpdateRequestDto {
	private String additionalInfo;

	@Builder
	public PostInfoUpdateRequestDto(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
}

