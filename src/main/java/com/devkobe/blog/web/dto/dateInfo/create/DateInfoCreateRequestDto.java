package com.devkobe.blog.web.dto.dateInfo.create;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.devkobe.blog.domain.posts.Posts;
import jakarta.validation.constraints.NotNull;
import java.sql.Timestamp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class DateInfoCreateRequestDto {

	@NotNull
	private Timestamp releaseDate;

	@NotNull
	private Timestamp modificationDate;

	@NotNull
	private Posts posts;

	@Builder
	public DateInfoCreateRequestDto(DateInfo entity) {
		this.releaseDate = entity.getReleaseDate();
		this.modificationDate = entity.getModificationDate();
		this.posts = entity.getPosts();
	}

	public DateInfo toEntity(DateInfo dateInfo) {
		dateInfo = DateInfo.builder()
		                   .releaseDate(new Timestamp(System.currentTimeMillis()))
		                   .modificationDate(new Timestamp(System.currentTimeMillis()))
		                   .posts(posts)
		                   .build();
		return dateInfo;
	}
}
