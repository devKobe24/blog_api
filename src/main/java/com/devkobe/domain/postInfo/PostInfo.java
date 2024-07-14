package com.devkobe.domain.postInfo;

import com.devkobe.domain.posts.Posts;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class PostInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postInfoId;

	@Column(length = 500, nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@Column(columnDefinition = "INT", nullable = false)
	private Integer postNumber;

	@ManyToOne
	@JoinColumn(name = "postsId", nullable = false)
	private Posts posts;

	@Builder
	public PostInfo(String title, String content, Integer postNumber) {
		this.title = title;
		this.content = content;
		this.postNumber = postNumber;
	}
}
