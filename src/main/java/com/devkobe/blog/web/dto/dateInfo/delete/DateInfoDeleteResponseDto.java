package com.devkobe.blog.web.dto.dateInfo.delete;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DateInfoDeleteResponseDto {
	private Long id;

	@Builder
	public DateInfoDeleteResponseDto(Long id) {
		this.id = id;
	}
}
