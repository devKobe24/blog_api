package com.devkobe.blog.web.dto.postList.update;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.devkobe.blog.domain.postInfo.PostInfo;
import com.devkobe.blog.domain.post.Post;
import com.devkobe.blog.domain.postList.PostList;
import com.devkobe.blog.domain.userInfo.UserInfo;
import com.devkobe.blog.web.dto.post.read.PostReadResponseDto;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class PostListUpdateResponseDto {

	private UUID uuid;
	private List<PostReadResponseDto> posts;

	public PostListUpdateResponseDto(PostList entity) {
		this.uuid = entity.getUuid();
		this.posts = entity
			.getPosts()
			.stream()
			.map(PostReadResponseDto::new)
			.collect(Collectors.toList());
	}
}
