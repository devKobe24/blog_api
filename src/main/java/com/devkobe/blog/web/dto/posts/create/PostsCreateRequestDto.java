package com.devkobe.blog.web.dto.posts.create;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.devkobe.blog.domain.posts.Posts;
import com.devkobe.blog.domain.userInfo.UserInfo;
import java.sql.Timestamp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsCreateRequestDto {

	private String title;
	private String content;
	private String nickName;
	private Integer postNumber;
	private Long userInfoId;
	private String additionalInfo;
	private String name;
	private String email;
	private String profileImage;

	@Builder PostsCreateRequestDto(Posts entity) {
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.nickName = entity.getNickName();
		this.postNumber = entity.getPostNumber();
		this.userInfoId = entity.getUserInfo().getId();
		this.additionalInfo = entity.getAdditionalInfo();
		this.name = entity.getUserInfo().getName();
		this.email = entity.getUserInfo().getEmail();
		this.profileImage = entity.getUserInfo().getProfileImage();
	}

	public Posts toEntity(UserInfo userInfo) {
		Posts post = Posts.builder()
		                   .title(title)
		                   .content(content)
		                   .nickName(nickName)
		                   .postNumber(postNumber)
		                   .additionalInfo(additionalInfo)
		                   .build();

		DateInfo dateInfo = DateInfo.builder()
		                            .releaseDate(new Timestamp(System.currentTimeMillis()))
		                            .modificationDate(new Timestamp(System.currentTimeMillis()))
		                            .posts(post)
		                            .build();

		post.setDateInfo(dateInfo);
		post.setUserInfo(userInfo);

		return post;
	}
}
