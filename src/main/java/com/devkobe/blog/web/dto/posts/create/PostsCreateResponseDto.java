package com.devkobe.blog.web.dto.posts.create;

import com.devkobe.blog.domain.Posts;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsCreateResponseDto {
	private String title;
	private String content;
	private String nickName;
	private Integer postNumber;
	private Long userInfoId;
	private String additionalInfo;
	private String name;
	private String email;
	private String profileImage;

	@Builder
	public PostsCreateResponseDto(Posts entity) {
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.nickName = entity.getNickName();
		this.postNumber = entity.getPostNumber();
		this.userInfoId = entity.getUserInfo().getId();
		this.additionalInfo = entity.getAdditionalInfo();
		this.name = entity.getUserInfo().getName();
		this.email = entity.getUserInfo().getEmail();
		this.profileImage = entity.getUserInfo().getEmail();
	}
}
