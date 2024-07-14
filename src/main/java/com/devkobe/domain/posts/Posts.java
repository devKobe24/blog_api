package com.devkobe.domain.posts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postsid;

	@Column(length = 500, nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@Column(length = 255, nullable = false)
	private String  nickName;

	@Column(columnDefinition = "TIMESTAMP", nullable = false)
	private Date releaseDate;

	@Column(columnDefinition = "TIMESTAMP", nullable = false)
	private Date modificationDate;

	@Column(columnDefinition = "INT", nullable = false)
	private Integer postNumber;

	@Builder
	public Posts(String title, String content, String nickName, Date releaseDate, Date modificationDate, Integer postNumber) {
		this.title = title;
		this.content = content;
		this.nickName = nickName;
		this.releaseDate = releaseDate;
		this.modificationDate = modificationDate;
		this.postNumber = postNumber;
	}
}
