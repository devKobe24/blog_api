package com.devkobe.domain.dateInfo;

import com.devkobe.domain.posts.Posts;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class DateInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dateInfoId;

	@Column(columnDefinition = "DATE", nullable = false)
	private Date releaseDate;

	@Column(columnDefinition = "DATE", nullable = false)
	private Date modificationDate;

	@ManyToOne
	@JoinColumn(name = "postId", nullable = false)
	private Posts posts;

	@Builder
	public DateInfo(Date releaseDate, Date modificationDate) {
		this.releaseDate = releaseDate;
		this.modificationDate = modificationDate;
	}
}
