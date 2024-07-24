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

	private String uuid;
	private List<PostCreateRequestDto> posts;

	@Builder
	public PostListUpdateRequestDto(
		String uuid,
		List<PostCreateRequestDto> posts
	) {
		this.uuid = uuid;
		this.posts = posts;
	}
}
