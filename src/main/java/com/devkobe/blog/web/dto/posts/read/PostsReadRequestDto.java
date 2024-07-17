package com.devkobe.blog.web.dto.posts.read;

import com.devkobe.blog.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsReadRequestDto {
	private Long id;

	@Builder
	public PostsReadRequestDto(Posts entity) {
		this.id = entity.getId();
	}
}
