package com.devkobe.blog.web.dto.posts.update;

import com.devkobe.blog.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
	private String title;
	private String content;
	private String nickName;
	private Integer postNumber;
	private String additionalInfo;

	@Builder
	public PostsUpdateRequestDto(Posts entity) {
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.nickName = entity.getNickName();
		this.postNumber = entity.getPostNumber();
		this.additionalInfo = entity.getAdditionalInfo();
	}
}
