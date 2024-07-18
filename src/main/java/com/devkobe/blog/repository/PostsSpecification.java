package com.devkobe.blog.repository;

import com.devkobe.blog.domain.Posts;
import org.springframework.data.jpa.domain.Specification;

public class PostsSpecification {

	public static Specification<Posts> withTitle(String title) {
		return (root, query, criteriaBuilder) ->
		title == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(root.get("title"), "%" + title + "%");
	}

	public static Specification<Posts> withContent(String content) {
		return (root, query, criteriaBuilder) ->
				content == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(root.get("content"), "%" + content + "%");
	}

	public static Specification<Posts> withNickName(String nickName) {
		return (root, query, criteriaBuilder) ->
				nickName == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(root.get("content"), "%" + nickName + "%");
	}

	public static Specification<Posts> withPostNumber(Integer postNumber) {
		return (root, query, criteriaBuilder) ->
				postNumber == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(root.get("postNumber"), "%" + postNumber + "%");
	}

	public static Specification<Posts> withAdditionalInfo(String additionalInfo) {
		return (root, query, criteriaBuilder) ->
				additionalInfo == null ? criteriaBuilder.conjunction() : criteriaBuilder.like(root.get("additionalInfo"), "%" + additionalInfo + "%");
	}

	public static Specification<Posts> withUserInfoId(Long userInfoId) {
		return (root, query, criteriaBuilder) ->
				userInfoId == null ? criteriaBuilder.conjunction() : criteriaBuilder.equal(root.get("userInfo").get("id"), userInfoId);
	}

}
