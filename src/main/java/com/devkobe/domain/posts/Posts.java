package com.devkobe.domain.posts;

import com.devkobe.domain.dateInfo.DateInfo;
import com.devkobe.domain.postInfo.PostInfo;
import com.devkobe.domain.userInfo.UserInfo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postsId;

	@Column(length = 500, nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@Column(nullable = false)
	private String nickName;

	@Column(nullable = false)
	private Integer postNumber;

	@OneToOne(mappedBy = "posts", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private DateInfo dateInfo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userInfoId", nullable = false)
	private UserInfo userInfo;

	@OneToOne(mappedBy = "posts", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private PostInfo postInfo;

	@Builder
	public Posts(String title, String content, String nickName, Integer postNumber,
			UserInfo userInfo) {
		this.title = title;
		this.content = content;
		this.nickName = nickName;
		this.postNumber = postNumber;
		this.userInfo = userInfo;
	}

	public void setDateInfo(DateInfo dateInfo) {
		this.dateInfo = dateInfo;
		if (dateInfo.getPosts() != this) {
			dateInfo.setPosts(this);
		}
	}

	public void setPostInfo(PostInfo postInfo) {
		this.postInfo = postInfo;
		if (postInfo.getPosts() != this) {
			postInfo.setPosts(this);
		}
	}
}
