package com.devkobe.blog.web.dto.postInfo.update;

import com.devkobe.blog.domain.postInfo.PostInfo;
import lombok.Getter;

@Getter
public class PostInfoUpdateResponseDto {

    private Long postInfoId;
    private String title;
    private String content;
    private Integer postNumber;

    public PostInfoUpdateResponseDto(PostInfo entity) {
        this.postInfoId = entity.getPostInfoId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.postNumber = entity.getPostNumber();
    }
}
