package com.devkobe.blog.web.dto.posts.delete;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsDeleteRequestDto {
	private Long id;

	@Builder
	public PostsDeleteRequestDto(Long id) {
		this.id = id;
	}
}
