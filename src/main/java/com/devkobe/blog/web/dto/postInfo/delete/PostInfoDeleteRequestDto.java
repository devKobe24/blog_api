package com.devkobe.blog.web.dto.postInfo.delete;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostInfoDeleteRequestDto {

    private Long postInfoId;

    @Builder
    public PostInfoDeleteRequestDto(Long postInfoId) {
        this.postInfoId = postInfoId;
    }
}
