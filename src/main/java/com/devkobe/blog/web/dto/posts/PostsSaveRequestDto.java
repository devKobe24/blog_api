package com.devkobe.blog.web.dto;

import com.devkobe.blog.domain.DateInfo;
import com.devkobe.blog.domain.PostInfo;
import com.devkobe.blog.domain.Posts;
import com.devkobe.blog.domain.UserInfo;
import java.sql.Timestamp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

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
	public PostsSaveRequestDto(
			String title,
			String content,
			String nickName,
			Integer postNumber,
			Long userInfoId,
			String additionalInfo,
			String name,
			String email,
			String profileImage
	) {
		this.title = title;
		this.content = content;
		this.nickName = nickName;
		this.postNumber = postNumber;
		this.userInfoId = userInfoId;
		this.additionalInfo = additionalInfo;
		this.name = name;
		this.email = email;
		this.profileImage = profileImage;
	}

	public Posts toEntity(UserInfo userInfo) {
		Posts post = Posts.builder()
		                   .title(title)
		                   .content(content)
		                   .nickName(nickName)
		                   .postNumber(postNumber)
		                   .additionalInfo(additionalInfo)
		                   .build();

		PostInfo postInfo = PostInfo.builder()
		                            .additionalInfo(additionalInfo)
		                            .posts(post)
		                            .build();

		DateInfo dateInfo = DateInfo.builder()
		                            .releaseDate(new Timestamp(System.currentTimeMillis()))
		                            .modificationDate(new Timestamp(System.currentTimeMillis()))
		                            .posts(post)
		                            .build();

		post.setPostInfo(postInfo);
		post.setDateInfo(dateInfo);
		post.setUserInfo(userInfo);

		return post;
	}
}
