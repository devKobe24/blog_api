package com.devkobe.blog.domain.postInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;
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
	private Long postInfoId;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;

	@Column(nullable = false)
	private Integer postNumber;

	@Builder
	public PostInfo(String title, String content, Integer postNumber) {
		this.title = title;
		this.content = content;
		this.postNumber = postNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PostInfo postInfo = (PostInfo) o;
		return Objects.equals(postInfoId, postInfo.postInfoId);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(postInfoId);
	}
}
