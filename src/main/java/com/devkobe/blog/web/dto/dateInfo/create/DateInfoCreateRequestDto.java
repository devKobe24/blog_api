package com.devkobe.blog.web.dto.dateInfo.create;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class DateInfoCreateRequestDto {

	@NotNull
	private LocalDateTime releaseDate;

	@NotNull
	private LocalDateTime modificationDate;

	@Builder
	public DateInfoCreateRequestDto(LocalDateTime releaseDate, LocalDateTime modificationDate) {
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
