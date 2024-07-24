package com.devkobe.blog.repository.postList;

import com.devkobe.blog.domain.postList.PostList;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostListRepository extends JpaRepository<PostList, UUID> {

}
