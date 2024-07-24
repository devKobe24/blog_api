package com.devkobe.blog.web.dto.post.delete;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostDeleteRequestDto {

    private Long id;

    @Builder
    public PostDeleteRequestDto(Long id) {
        this.id = id;
    }
}
