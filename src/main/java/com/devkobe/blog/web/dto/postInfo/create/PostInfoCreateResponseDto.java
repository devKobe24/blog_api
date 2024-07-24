package com.devkobe.blog.web.dto.postInfo.create;

import com.devkobe.blog.domain.postInfo.PostInfo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostInfoCreateResponseDto {

    private Long postInfoId;
    private String title;
    private String content;
    private Integer postNumber;

    @Builder
    public PostInfoCreateResponseDto(PostInfo entity) {
        this.postInfoId = entity.getPostInfoId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.postNumber = entity.getPostNumber();
    }
}
