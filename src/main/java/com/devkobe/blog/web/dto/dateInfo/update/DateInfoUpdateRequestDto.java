package com.devkobe.blog.web.dto.dateInfo.update;

import com.devkobe.blog.domain.post.Post;
import jakarta.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DateInfoUpdateRequestDto {

	@NotNull
	private LocalDateTime releaseDate;

	@NotNull
	private LocalDateTime modificationDate;

	@NotNull
	private Post post;
}
