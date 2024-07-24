package com.devkobe.blog.repository.post;

import com.devkobe.blog.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {
	// 필요에 따라 추가적인 커스텀 쿼리 메서드를 정의.
}
