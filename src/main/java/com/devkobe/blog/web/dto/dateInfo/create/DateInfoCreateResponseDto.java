package com.devkobe.blog.web.dto.dateInfo.create;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DateInfoCreateResponseDto {

	private Long id;
	private Timestamp releaseDate;
	private Timestamp modificationDate;

	public DateInfoCreateResponseDto(DateInfo entity) {
		this.id = entity.getId();
		this.releaseDate = entity.getReleaseDate();
		this.modificationDate = entity.getModificationDate();
	}
}
