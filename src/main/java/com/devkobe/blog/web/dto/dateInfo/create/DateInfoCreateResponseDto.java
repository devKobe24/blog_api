package com.devkobe.blog.web.dto.dateInfo.create;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DateInfoCreateResponseDto {

	private Long id;
	private LocalDateTime releaseDate;
	private LocalDateTime modificationDate;

	@Builder
	public DateInfoCreateResponseDto(DateInfo entity) {
		this.id = entity.getDateInfoId();
		this.releaseDate = entity.getReleaseDate();
		this.modificationDate = entity.getModificationDate();
	}
}
