package com.devkobe.blog.web.dto.dateInfo;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DateInfoDto {
    @JsonProperty("dateInfoId")
    private Long dateInfoId;

    @JsonProperty("releaseDate")
    private String releaseDate;

    @JsonProperty("modificationDate")
    private String modificationDate;

    public DateInfoDto(DateInfo entity) {
        this.dateInfoId = entity.getDateInfoId();
        this.releaseDate = entity.getReleaseDate().toString();
        this.modificationDate = entity.getModificationDate().toString();
    }
}
