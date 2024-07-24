package com.devkobe.blog.web.dto.postList.update;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.devkobe.blog.domain.postInfo.PostInfo;
import com.devkobe.blog.domain.userInfo.UserInfo;
import com.devkobe.blog.web.dto.post.create.PostCreateRequestDto;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostListUpdateRequestDto {

	private Long postId;
	private List<PostCreateRequestDto> posts;

	@Builder
	public PostListUpdateRequestDto(
		Long postId,
		List<PostCreateRequestDto> posts
	) {
		this.postId = postId;
		this.posts = posts;
	}
}
