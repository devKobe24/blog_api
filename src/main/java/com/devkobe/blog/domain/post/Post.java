package com.devkobe.blog.domain.post;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.devkobe.blog.domain.postInfo.PostInfo;
import com.devkobe.blog.domain.postList.PostList;
import com.devkobe.blog.domain.userInfo.UserInfo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.util.Objects;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false, unique = true)
	private Long postId;

	@Column(nullable = false, unique = true)
	private UUID uuid = UUID.randomUUID();

    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_info_id", nullable = false)
	private PostInfo postInfo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_info_id", nullable = false)
	private UserInfo userInfo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "date_info_id", nullable = false)
	private DateInfo dateInfo;

	@Setter
    @ManyToOne
	@JoinColumn(name = "post_list_uuid")
	private PostList postList;

	@Builder
	public Post(
		Long postId,
		PostInfo postInfo,
		UserInfo userInfo,
		DateInfo dateInfo,
		PostList postList
	) {
		this.postId = postId;
		this.postInfo = postInfo;
		this.userInfo = userInfo;
		this.dateInfo = new DateInfo(); // DateInfo 객체를 자동으로 초기화
		this.postList = postList;
	}

	public void update (
		PostInfo postInfo,
		UserInfo userInfo,
		DateInfo dateInfo
	) {
		this.postInfo = postInfo;
		this.userInfo = userInfo;
		this.dateInfo = dateInfo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Post post = (Post) o;
		return Objects.equals(postId, post.postId);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(postId);
	}
}
