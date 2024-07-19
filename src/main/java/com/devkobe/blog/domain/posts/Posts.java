package com.devkobe.blog.domain.posts;

import com.devkobe.blog.domain.userInfo.UserInfo;
import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;

	@Column(nullable = false)
	private String nickName;

	@Column(nullable = false)
	private Integer postNumber;

	@Column(nullable = false)
	private String additionalInfo;

	@ManyToOne
	@JoinColumn(name = "userInfoId", nullable = false)
	@JsonBackReference
	private UserInfo userInfo;

	@OneToOne(mappedBy = "posts", cascade = CascadeType.ALL)
	@JsonManagedReference
	private DateInfo dateInfo;

	@Builder
	public Posts(String title, String content, String nickName, Integer postNumber, String additionalInfo) {
		this.title = title;
		this.content = content;
		this.nickName = nickName;
		this.postNumber = postNumber;
		this.additionalInfo = additionalInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
		if (!userInfo.getPosts().contains(this)) {
			userInfo.getPosts().add(this);
		}
	}

	public void setDateInfo(DateInfo dateInfo) {
		this.dateInfo = dateInfo;
		if (dateInfo.getPosts() != this) {
			dateInfo.setPosts(this);
		}
	}

	public void update(String title, String content, String nickName, Integer postNumber, String additionalInfo) {
		this.title = title;
		this.content = content;
		this.nickName = nickName;
		this.postNumber = postNumber;
		this.additionalInfo = additionalInfo;
	}
}
