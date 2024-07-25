package com.devkobe.blog.web.dto.userInfo;

import com.devkobe.blog.domain.userInfo.UserInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoDto {
    @JsonProperty("userInfoId")
    private Long userInfoId;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("profileImageUrl")
    private String profileImageUrl;

    @JsonProperty("nickName")
    private String nickName;

    public UserInfoDto(UserInfo entity) {
        this.userInfoId = entity.getUserInfoId();
        this.userName = entity.getName();
        this.email = entity.getEmail();
        this.profileImageUrl = entity.getProfileImage();
        this.nickName = entity.getProfileImage();
    }
}
