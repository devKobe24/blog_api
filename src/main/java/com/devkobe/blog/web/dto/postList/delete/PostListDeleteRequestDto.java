package com.devkobe.blog.web.dto.postList.delete;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostListDeleteRequestDto {
	private Long postId;

	@Builder
	public PostListDeleteRequestDto(Long postId) {
		this.postId = postId;
	}
}
