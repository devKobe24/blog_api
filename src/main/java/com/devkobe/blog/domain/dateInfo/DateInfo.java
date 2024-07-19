package com.devkobe.blog.domain.dateInfo;

import com.devkobe.blog.domain.posts.Posts;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.sql.Timestamp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
public class DateInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	@Column(nullable = false)
	private Timestamp releaseDate;

	@Setter
	@Column(nullable = false)
	private Timestamp modificationDate;

	@OneToOne
	@JoinColumn(name = "posts_id", nullable = false)
	@JsonBackReference
	private Posts posts;

	@Builder
	public DateInfo(Timestamp releaseDate, Timestamp modificationDate, Posts posts) {
		this.releaseDate = releaseDate;
		this.modificationDate = modificationDate;
		this.posts = posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
		if (posts.getDateInfo() != this) {
			posts.setDateInfo(this);
		}
	}
}
