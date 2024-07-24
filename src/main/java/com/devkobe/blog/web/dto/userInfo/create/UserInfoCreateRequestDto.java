package com.devkobe.blog.web.dto.userInfo.create;

import com.devkobe.blog.domain.userInfo.UserInfo;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoCreateRequestDto {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String profileImage;

    @NotNull
    private String nickName;

    @Builder
    public UserInfoCreateRequestDto(String name, String email, String profileImage,
        String nickName) {
        this.name = name;
        this.email = email;
        this.profileImage = profileImage;
        this.nickName = nickName;
    }

    public UserInfo toEntity() {
        return UserInfo
            .builder()
            .name(name)
            .email(email)
            .profileImage(profileImage)
            .nickName(nickName)
            .build();
    }
}
