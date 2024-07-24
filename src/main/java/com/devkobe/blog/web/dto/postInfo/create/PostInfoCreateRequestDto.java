package com.devkobe.blog.web.dto.postInfo.create;

import com.devkobe.blog.domain.postInfo.PostInfo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostInfoCreateRequestDto {

    @NotBlank
    @NotNull
    private String title;

    @NotBlank
    @NotNull
    private String content;

    @NotNull
    private Integer postNumber;

    @Builder
    public PostInfoCreateRequestDto(String title, String content, Integer postNumber) {
        this.title = title;
        this.content = content;
        this.postNumber = postNumber;
    }

    public PostInfo toEntity() {
        PostInfo postInfo = PostInfo
            .builder()
            .title(title)
            .content(content)
            .postNumber(postNumber)
            .build();

        return postInfo;
    }
}
