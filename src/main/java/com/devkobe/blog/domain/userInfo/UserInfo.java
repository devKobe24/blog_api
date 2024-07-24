package com.devkobe.blog.domain.userInfo;

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
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false, unique = true)
	private Long userInfoId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String profileImage;

	@Column(nullable = false)
	private String nickName;

	@Builder
	public UserInfo(String name, String email, String profileImage, String nickName) {
		this.name = name;
		this.email = email;
		this.profileImage = profileImage;
		this.nickName = nickName;
	}

	public void update(String name, String email, String profileImage, String nickName) {
		this.name = name;
		this.email = email;
		this.profileImage = profileImage;
		this.nickName = nickName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserInfo userInfo = (UserInfo) o;
		return Objects.equals(userInfoId, userInfo.userInfoId);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(userInfoId);
	}
}
