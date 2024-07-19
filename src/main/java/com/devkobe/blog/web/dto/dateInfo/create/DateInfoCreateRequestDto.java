package com.devkobe.blog.web.dto.dateInfo.create;

import com.devkobe.blog.domain.DateInfo;
import java.sql.Timestamp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DateInfoCreateRequestDto {

	private Long id;
	private Timestamp releaseDate;
	private Timestamp modificationDate;

	@Builder DateInfoCreateRequestDto(DateInfo entity) {
		this.id = entity.getId();
		this.releaseDate = entity.getReleaseDate();
		this.modificationDate = entity.getModificationDate();
	}

	public DateInfo toEntity(DateInfo dateInfo) {
		dateInfo = DateInfo.builder()
		                   .releaseDate(new Timestamp(System.currentTimeMillis()))
		                   .modificationDate(new Timestamp(System.currentTimeMillis()))
		                   .build();
		return dateInfo;
	}
}
