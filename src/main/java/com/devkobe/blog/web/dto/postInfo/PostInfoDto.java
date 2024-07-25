package com.devkobe.blog.web.dto.postInfo;

import com.devkobe.blog.domain.postInfo.PostInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostInfoDto {

    @JsonProperty("postInfoId")
    private Long postInfoId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("postNumber")
    private Integer postNumber;

    public PostInfoDto(PostInfo entity) {
        this.postInfoId = entity.getPostInfoId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.postNumber = entity.getPostNumber();
    }
}
