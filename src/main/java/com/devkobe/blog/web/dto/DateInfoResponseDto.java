package com.devkobe.blog.web.dto;

import com.devkobe.blog.domain.DateInfo;
import java.sql.Timestamp;
import lombok.Getter;

@Getter
public class DateInfoResponseDto {

	private Long id;
	private Timestamp releaseDate;
	private Timestamp modificationDate;

	public DateInfoResponseDto(DateInfo entity) {
		this.id = entity.getId();
		this.releaseDate = entity.getReleaseDate();
		this.modificationDate = entity.getModificationDate();
	}
}

