package com.devkobe.blog.web.dto.posts.read;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsReadRequestDto {

	private String title;
	private String content;
	private String nickName;
	private Integer postNumber;
	private String additionalInfo;
	private Long userInfoId;

	@Builder
	public PostsReadRequestDto(String title, String content, String nickName, Integer postNumber, String additionalInfo, Long userInfoId) {

		this.title = title;
		this.content = content;
		this.nickName = nickName;
		this.postNumber = postNumber;
		this.additionalInfo = additionalInfo;
		this.userInfoId = userInfoId;
	}
}
