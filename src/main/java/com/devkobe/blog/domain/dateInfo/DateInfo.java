package com.devkobe.blog.domain.dateInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
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
	private OffsetDateTime releaseDate;

	@Column(nullable = false)
	private OffsetDateTime modificationDate;

	@Builder
	public DateInfo(OffsetDateTime releaseDate, OffsetDateTime modificationDate) {
		this.releaseDate = releaseDate;
		this.modificationDate = modificationDate;
	}

	public void update(OffsetDateTime releaseDate, OffsetDateTime modificationDate) {
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
