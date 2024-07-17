package com.devkobe.blog.web.dto.posts.update;

import com.devkobe.blog.domain.Posts;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsUpdateResponseDto {

	private Long id;
	private String title;
	private String content;
	private String nickName;
	private Integer postNumber;
	private String additionalInfo;

	@Builder
	public PostsUpdateResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.nickName = entity.getNickName();
		this.postNumber = entity.getPostNumber();
		this.additionalInfo = entity.getAdditionalInfo();
	}
}
