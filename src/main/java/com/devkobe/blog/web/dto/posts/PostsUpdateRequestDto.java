package com.devkobe.blog.web.dto.posts;

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
	public PostsUpdateRequestDto(String title, String content, String nickName, Integer postNumber, String additionalInfo) {
		this.title = title;
		this.content = content;
		this.nickName = nickName;
		this.postNumber = postNumber;
		this.additionalInfo = additionalInfo;
	}
}
