package com.devkobe.blog.web.dto.dateInfo.create;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import jakarta.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class DateInfoCreateRequestDto {

	@NotNull
	private OffsetDateTime releaseDate;

	@NotNull
	private OffsetDateTime modificationDate;

	@Builder
	public DateInfoCreateRequestDto(OffsetDateTime releaseDate, OffsetDateTime modificationDate) {
		this.releaseDate = releaseDate;
		this.modificationDate = modificationDate;
	}

	public DateInfo toEntity() {
		return DateInfo.builder()
		               .releaseDate(this.releaseDate)
		               .modificationDate(this.modificationDate)
		               .build();
	}
}
