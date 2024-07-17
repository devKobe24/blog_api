package com.devkobe.blog.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PostInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String additionalInfo;

	@OneToOne
	@JoinColumn(name = "posts_id", nullable = false)
	private Posts posts;

	@Builder
	public PostInfo(String additionalInfo, Posts posts) {
		this.additionalInfo = additionalInfo;
		this.posts = posts;
	}

	public void update(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
		if (posts.getPostInfo() != this) {
			posts.setPostInfo(this);
		}
	}
}
