package com.devkobe.blog.web.dto.postList.delete;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostListDeleteResponseDto {
	private Long postId;
	private String status;

	@Builder
	public PostListDeleteResponseDto(Long postId, String status) {
		this.postId = postId;
		this.status = status;
	}
}
