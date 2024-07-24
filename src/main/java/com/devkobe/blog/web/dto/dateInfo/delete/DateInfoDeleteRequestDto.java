package com.devkobe.blog.web.dto.dateInfo.delete;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DateInfoDeleteRequestDto {
	private Long id;

	@Builder
	public DateInfoDeleteRequestDto(Long id) {
		this.id = id;
	}
}
