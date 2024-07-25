package com.devkobe.blog.domain.dateInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class DateInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false, unique = true)
	private Long dateInfoId;

	@Column(nullable = false)
	LocalDateTime releaseDate;

	@Column(nullable = false)
	LocalDateTime modificationDate;

	@Builder
	public DateInfo(LocalDateTime releaseDate, LocalDateTime modificationDate) {
		this.releaseDate = releaseDate != null ? releaseDate : LocalDateTime.now();
		this.modificationDate = modificationDate != null ? modificationDate : LocalDateTime.now();
	}

	@PrePersist
	public void onPrePersist() {
		LocalDateTime now = LocalDateTime.now();
		this.releaseDate = now;
		this.modificationDate = now;
	}

	@PreUpdate
	public void onPreUpdate() {
		this.modificationDate = LocalDateTime.now();
	}

	public void update(LocalDateTime releaseDate, LocalDateTime modificationDate) {
		this.releaseDate = releaseDate;
		this.modificationDate = modificationDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DateInfo dateInfo = (DateInfo) o;
		return Objects.equals(dateInfoId, dateInfo.dateInfoId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateInfoId);
	}
}
