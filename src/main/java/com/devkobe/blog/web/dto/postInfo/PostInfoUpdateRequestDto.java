package com.devkobe.blog.web.dto.postInfo;

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

