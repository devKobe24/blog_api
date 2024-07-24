package com.devkobe.blog.web.dto.postInfo.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostInfoUpdateRequestDto {

    @NotBlank
    @NotNull
    private String title;

    @NotBlank
    @NotNull
    private String content;

    @NotNull
    private Integer postNumber;
}
