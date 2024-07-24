package com.devkobe.blog.web.dto.postList.create;

import com.devkobe.blog.domain.postList.PostList;
import com.devkobe.blog.web.dto.post.create.PostCreateResponseDto;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class PostListCreateResponseDto {

	private UUID uuid;
	private List<PostCreateResponseDto> posts;

	public PostListCreateResponseDto(PostList entity) {
		this.uuid = entity.getUuid();
		this.posts = entity
			.getPosts()
			.stream()
			.map(PostCreateResponseDto::new)
			.collect(Collectors.toList());
	}
}
