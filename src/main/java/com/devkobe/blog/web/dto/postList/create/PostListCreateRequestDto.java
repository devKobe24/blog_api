package com.devkobe.blog.web.dto.postList.create;

import com.devkobe.blog.domain.postList.PostList;
import com.devkobe.blog.web.dto.post.create.PostCreateRequestDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostListCreateRequestDto {

	private List<PostCreateRequestDto> posts;

	@Builder
	public PostListCreateRequestDto(List<PostCreateRequestDto> posts) {
		this.posts = posts;
	}

	public PostList toEntity() {
		return PostList.builder()
		               .posts(posts
			               .stream()
			               .map(PostCreateRequestDto::toEntity)
			               .collect(Collectors.toList()))
		               .build();
	}
}

