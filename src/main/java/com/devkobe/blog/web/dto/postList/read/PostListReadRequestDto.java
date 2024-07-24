package com.devkobe.blog.web.dto.postList.read;

import com.devkobe.blog.domain.post.Post;
import com.devkobe.blog.domain.postList.PostList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;

@Getter
public class PostListReadRequestDto {

	private Long postId;

	public PostListReadRequestDto(
		Long postId
	) {
		this.postId = postId;
	}
}
