package com.devkobe.blog.web.dto.post.delete;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostDeleteResponseDto {

    private Long id;
    private String status;

    public PostDeleteResponseDto(Long id, String status) {
        this.id = id;
        this.status = status;
    }
}
