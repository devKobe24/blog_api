package com.devkobe.blog.web.dto.postInfo;

import com.devkobe.blog.domain.PostInfo;
import lombok.Getter;

@Getter
public class PostInfoResponseDto {

	private Long id;
	private String additionalInfo;
	private Long postsId;

	public PostInfoResponseDto(PostInfo entity) {
		this.id = entity.getId();
		this.additionalInfo = entity.getAdditionalInfo();
		this.postsId = entity.getPosts().getId();
	}
}


