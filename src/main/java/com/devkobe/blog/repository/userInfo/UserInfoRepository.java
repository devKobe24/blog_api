package com.devkobe.blog.repository.userInfo;

import com.devkobe.blog.domain.userInfo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> { }
