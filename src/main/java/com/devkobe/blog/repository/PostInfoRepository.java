package com.devkobe.blog.repository;

import com.devkobe.blog.domain.PostInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostInfoRepository extends JpaRepository<PostInfo, Long> { }
