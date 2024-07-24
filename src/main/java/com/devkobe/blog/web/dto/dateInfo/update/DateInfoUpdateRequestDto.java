package com.devkobe.blog.web.dto.dateInfo.update;

import com.devkobe.blog.domain.post.Post;
import jakarta.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DateInfoUpdateRequestDto {

	@NotNull
	private OffsetDateTime releaseDate;

	@NotNull
	private OffsetDateTime modificationDate;

	@NotNull
	private Post post;
}
