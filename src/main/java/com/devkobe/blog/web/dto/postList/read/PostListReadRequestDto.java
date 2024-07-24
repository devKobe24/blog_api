package com.devkobe.blog.web.dto.postList.read;

import com.devkobe.blog.domain.post.Post;
import com.devkobe.blog.domain.postList.PostList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;

@Getter
public class PostListReadRequestDto {

	private String uuid;

	public PostListReadRequestDto(
		String uuid
	) {
		this.uuid = uuid;
	}
}
