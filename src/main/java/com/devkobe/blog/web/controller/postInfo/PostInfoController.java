package com.devkobe.blog.web.controller.postInfo;

import com.devkobe.blog.service.postInfo.PostInfoService;
import com.devkobe.blog.web.dto.postInfo.create.PostInfoCreateRequestDto;
import com.devkobe.blog.web.dto.postInfo.create.PostInfoCreateResponseDto;
import com.devkobe.blog.web.dto.postInfo.delete.PostInfoDeleteRequestDto;
import com.devkobe.blog.web.dto.postInfo.delete.PostInfoDeleteResponseDto;
import com.devkobe.blog.web.dto.postInfo.read.PostInfoReadRequestDto;
import com.devkobe.blog.web.dto.postInfo.read.PostInfoReadResponseDto;
import com.devkobe.blog.web.dto.postInfo.update.PostInfoUpdateRequestDto;
import com.devkobe.blog.web.dto.postInfo.update.PostInfoUpdateResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/postInfo")
public class PostInfoController {

    private final PostInfoService postInfoService;

    // CREATE
    @PostMapping
    public PostInfoCreateResponseDto save(@RequestBody PostInfoCreateRequestDto requestDto) {
        return postInfoService.save(requestDto);
    }

    // READ
    @GetMapping("/{id}")
    public PostInfoReadResponseDto findById(@PathVariable Long id) {
        PostInfoReadRequestDto requestDto = new PostInfoReadRequestDto();
        requestDto.setPostInfoId(id);
        return postInfoService.findById(requestDto);
    }

    @GetMapping
    public List<PostInfoReadResponseDto> findAll() {
        return postInfoService.findAll();
    }

    // UPDATE
    @PutMapping("/{id}")
    public PostInfoUpdateResponseDto update(@PathVariable Long id, @RequestBody PostInfoUpdateRequestDto requestDto) {
        return postInfoService.update(id, requestDto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public PostInfoDeleteResponseDto deleteById(@PathVariable Long id) {
        PostInfoDeleteRequestDto requestDto = new PostInfoDeleteRequestDto(id);

        return postInfoService.deleteById(requestDto);
    }
}
