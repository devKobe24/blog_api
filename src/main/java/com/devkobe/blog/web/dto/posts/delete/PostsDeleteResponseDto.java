package com.devkobe.blog.web.dto.posts.delete;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsDeleteResponseDto {
	private Long id;
	private String status;

	@Builder
	public PostsDeleteResponseDto(Long id, String status) {
		this.id = id;
		this.status = status;
	}
}
