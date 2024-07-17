package com.devkobe.blog.web.dto.postInfo;

import com.devkobe.blog.domain.PostInfo;
import com.devkobe.blog.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostInfoRequestDto {
	private String additionalInfo;
	private Long postsId;

	@Builder
	public PostInfoRequestDto(String additionalInfo, Long postsId) {
		this.additionalInfo = additionalInfo;
		this.postsId = postsId;
	}

	public PostInfo toEntity(Posts posts) {
		return PostInfo.builder()
		               .additionalInfo(additionalInfo)
		               .posts(posts)
		               .build();
	}
}

