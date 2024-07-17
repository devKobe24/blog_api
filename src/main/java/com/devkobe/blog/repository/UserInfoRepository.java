package com.devkobe.blog.repository;

import com.devkobe.blog.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> { }
