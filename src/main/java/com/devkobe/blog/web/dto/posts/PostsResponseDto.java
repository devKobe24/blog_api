package com.devkobe.blog.web.dto.posts;

import com.devkobe.blog.domain.Posts;
import com.devkobe.blog.web.dto.userInfo.UserInfoResponseDto;
import lombok.Getter;

@Getter
public class PostsResponseDto {

	private Long id;
	private String title;
	private String content;
	private String nickName;
	private Integer postNumber;
	private String additionalInfo;
	private UserInfoResponseDto userInfo;

	public PostsResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.nickName = entity.getNickName();
		this.postNumber = entity.getPostNumber();
		this.additionalInfo = entity.getAdditionalInfo();
		this.userInfo = new UserInfoResponseDto(entity.getUserInfo());
	}
}

