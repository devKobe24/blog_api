package com.devkobe.blog.web.controller.postList;

import com.devkobe.blog.service.postList.PostListService;
import com.devkobe.blog.web.dto.postList.create.PostListCreateRequestDto;
import com.devkobe.blog.web.dto.postList.create.PostListCreateResponseDto;
import com.devkobe.blog.web.dto.postList.delete.PostListDeleteRequestDto;
import com.devkobe.blog.web.dto.postList.delete.PostListDeleteResponseDto;
import com.devkobe.blog.web.dto.postList.read.PostListReadRequestDto;
import com.devkobe.blog.web.dto.postList.read.PostListReadResponseDto;
import com.devkobe.blog.web.dto.postList.update.PostListUpdateRequestDto;
import com.devkobe.blog.web.dto.postList.update.PostListUpdateResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/v1/postList")
public class PostListController {

    private final PostListService postListService;

    // CREATE
    @PostMapping
    public ResponseEntity<PostListCreateResponseDto> createPostList(@RequestBody
        PostListCreateRequestDto requestDto) {
        PostListCreateResponseDto responseDto = postListService.save(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // READ
   @GetMapping("/{uuid}")
   public ResponseEntity<PostListReadResponseDto> findById(@PathVariable String uuid) {
        PostListReadRequestDto requestDto = new PostListReadRequestDto(uuid);
        PostListReadResponseDto responseDto = postListService.findById(requestDto);
        return ResponseEntity.ok(responseDto);
   }

   @GetMapping
   public ResponseEntity<List<PostListReadResponseDto>> findAll() {
        List<PostListReadResponseDto> postList = postListService.findAll();
        return ResponseEntity.ok(postList);
   }

    // UPDATE
    @PutMapping
    public ResponseEntity<PostListUpdateResponseDto> updatePostList(@RequestBody
        PostListUpdateRequestDto requestDto) {
        PostListUpdateResponseDto responseDto = postListService.update(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // DELETE
    @DeleteMapping
    public ResponseEntity<PostListDeleteResponseDto> deletePostList(@RequestBody PostListDeleteRequestDto requestDto) {
        PostListDeleteResponseDto responseDto = postListService.delete(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
