package com.devkobe.blog.repository;

import com.devkobe.blog.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> { }