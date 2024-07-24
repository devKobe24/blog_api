package com.devkobe.blog.web.dto.dateInfo.update;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import lombok.Getter;

@Getter
public class DateInfoUpdateResponseDto {

	private Long id;
	private OffsetDateTime releaseDate;
	private OffsetDateTime modificationDate;

	public DateInfoUpdateResponseDto(DateInfo entity) {
		this.id = entity.getDateInfoId();
		this.releaseDate = entity.getReleaseDate();
		this.modificationDate = entity.getModificationDate();
	}
}
