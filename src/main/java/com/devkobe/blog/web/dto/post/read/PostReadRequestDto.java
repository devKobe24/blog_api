package com.devkobe.blog.web.dto.post.read;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.devkobe.blog.domain.postInfo.PostInfo;
import com.devkobe.blog.domain.userInfo.UserInfo;
import java.time.OffsetDateTime;

public class PostReadRequestDto {

    private Long postId;
    private PostInfo postInfo;
    private UserInfo userInfo;
    private DateInfo dateInfo;
    private String title;
    private String content;
    private Integer postNumber;
    private Long userInfoId;
    private String name;
    private String email;
    private String profileImage;
    private String nickName;
    private Long dateInfoId;
    private OffsetDateTime releaseDate;
    private OffsetDateTime modificationDate;

    public PostReadRequestDto(
        Long postId,
        PostInfo postInfo,
        UserInfo userInfo,
        DateInfo dateInfo,
        String title,
        String content,
        Integer postNumber,
        Long userInfoId,
        String name,
        String email,
        String profileImage,
        String nickName,
        Long dateInfoId,
        OffsetDateTime releaseDate,
        OffsetDateTime modificationDate
    ) {
        this.postId = postId;
        this.postInfo = postInfo;
        this.userInfo = userInfo;
        this.dateInfo = dateInfo;
        this.title = title;
        this.content = content;
        this.postNumber = postNumber;
        this.userInfoId = userInfoId;
        this.name = name;
        this.email = email;
        this.profileImage = profileImage;
        this.nickName = nickName;
        this.dateInfoId = dateInfoId;
        this.releaseDate = releaseDate;
        this.modificationDate = modificationDate;
    }
}
