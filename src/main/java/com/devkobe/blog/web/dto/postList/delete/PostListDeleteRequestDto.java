package com.devkobe.blog.web.dto.postList.delete;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostListDeleteRequestDto {
	private String uuid;

	@Builder
	public PostListDeleteRequestDto(String uuid) {
		this.uuid = uuid;
	}
}
