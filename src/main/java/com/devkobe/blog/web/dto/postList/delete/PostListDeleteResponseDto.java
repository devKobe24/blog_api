package com.devkobe.blog.web.dto.postList.delete;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostListDeleteResponseDto {
	private String uuid;
	private String status;

	@Builder
	public PostListDeleteResponseDto(String uuid, String status) {
		this.uuid = uuid;
		this.status = status;
	}
}
