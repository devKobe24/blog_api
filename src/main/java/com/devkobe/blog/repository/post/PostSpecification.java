package com.devkobe.blog.repository.post;

import com.devkobe.blog.domain.post.Post;
import org.springframework.data.jpa.domain.Specification;

public class PostSpecification {

	public static Specification<Post> withId(Long id) {
		return (root, query, criteriaBuilder) ->
				criteriaBuilder.equal(root.get("postId").get("postId"), id);
	}

	public static Specification<Post> withPostInfoId(Long postInfoId) {
		return (root, query, criteriaBuilder) ->
				criteriaBuilder.equal(root.get("postInfoId").get("postInfoId"), postInfoId);
	}

	public static Specification<Post> withUserInfoId(Long userInfoId) {
		return (root, query, criteriaBuilder) ->
				criteriaBuilder.equal(root.get("userInfoId").get("userInfoId"), userInfoId);
	}

	public static Specification<Post> withDateInfoId(Long dateInfoId) {
		return (root, query, criteriaBuilder) ->
				criteriaBuilder.equal(root.get("dateInfoId").get("dateInfoId"), dateInfoId);
	}

	public static Specification<Post> withTitle(String title) {
		return (root, query, criteriaBuilder) ->
		title == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(root.get("title"), "%" + title + "%");
	}

	public static Specification<Post> withContent(String content) {
		return (root, query, criteriaBuilder) ->
				content == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(root.get("content"), "%" + content + "%");
	}

	public static Specification<Post> withNickName(String nickName) {
		return (root, query, criteriaBuilder) ->
				nickName == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(root.get("content"), "%" + nickName + "%");
	}

	public static Specification<Post> withPostNumber(Integer postNumber) {
		return (root, query, criteriaBuilder) ->
				postNumber == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(root.get("postNumber"), "%" + postNumber + "%");
	}
}
