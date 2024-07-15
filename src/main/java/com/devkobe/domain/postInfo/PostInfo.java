package com.devkobe.domain.postInfo;

import com.devkobe.domain.posts.Posts;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;

	@Column(nullable = false)
	private Integer postNumber;

	@OneToOne
	@JoinColumn(name = "postsId", nullable = false)
	private Posts posts;

	@Builder
	public PostInfo(String title, String content, Integer postNumber, Posts posts) {
		this.title = title;
		this.content = content;
		this.postNumber = postNumber;
		this.posts = posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
		if (posts.getPostInfo() != this) {
			posts.setPostInfo(this);
		}
	}
}
