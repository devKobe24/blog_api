package com.devkobe.domain.userInfo;

import com.devkobe.domain.postInfo.PostInfo;
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
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userInfoId;

	@Column(length = 255, nullable = false)
	private String name;

	@Column(length = 255, nullable = false)
	private String email;

	@Column(length = 500, nullable = false)
	private String profileImage;

	@Column(length = 255, nullable = false)
	private String nickName;

	@ManyToOne
	@JoinColumn(name = "postId", nullable = false)
	private Posts posts;

	@Builder
	public UserInfo(String name, String email, String profileImage, String nickName) {
		this.name = name;
		this.email = email;
		this.profileImage = profileImage;
		this.nickName = nickName;
	}
}
