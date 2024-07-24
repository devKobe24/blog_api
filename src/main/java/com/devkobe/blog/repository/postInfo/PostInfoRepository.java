package com.devkobe.blog.repository.postInfo;

import com.devkobe.blog.domain.postInfo.PostInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostInfoRepository extends JpaRepository<PostInfo, Long> { }
