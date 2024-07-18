package com.devkobe.blog.repository;

import com.devkobe.blog.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostsRepository extends JpaRepository<Posts, Long>, JpaSpecificationExecutor<Posts> {
	// 필요에 따라 추가적인 커스텀 쿼리 메서드를 정의.
}
