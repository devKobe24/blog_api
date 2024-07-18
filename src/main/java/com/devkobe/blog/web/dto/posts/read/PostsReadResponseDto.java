package com.devkobe.blog.web.dto.posts.read;

import com.devkobe.blog.domain.Posts;
import com.devkobe.blog.web.dto.userInfo.read.UserInfoReadResponseDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsReadResponseDto {

	private Long id;
	private String title;
	private String content;
	private String nickName;
	private Integer postNumber;
	private String additionalInfo;
	private UserInfoReadResponseDto userInfo;

	@Builder
	public PostsReadResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.nickName = entity.getNickName();
		this.postNumber = entity.getPostNumber();
		this.additionalInfo = entity.getAdditionalInfo();
		this.userInfo = new UserInfoReadResponseDto(entity.getUserInfo());
	}
}