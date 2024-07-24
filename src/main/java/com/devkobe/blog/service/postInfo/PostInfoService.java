package com.devkobe.blog.service.postInfo;

import com.devkobe.blog.domain.postInfo.PostInfo;
import com.devkobe.blog.repository.postInfo.PostInfoRepository;
import com.devkobe.blog.web.dto.postInfo.create.PostInfoCreateRequestDto;
import com.devkobe.blog.web.dto.postInfo.create.PostInfoCreateResponseDto;
import com.devkobe.blog.web.dto.postInfo.delete.PostInfoDeleteRequestDto;
import com.devkobe.blog.web.dto.postInfo.delete.PostInfoDeleteResponseDto;
import com.devkobe.blog.web.dto.postInfo.read.PostInfoReadRequestDto;
import com.devkobe.blog.web.dto.postInfo.read.PostInfoReadResponseDto;
import com.devkobe.blog.web.dto.postInfo.update.PostInfoUpdateRequestDto;
import com.devkobe.blog.web.dto.postInfo.update.PostInfoUpdateResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostInfoService {

    private final PostInfoRepository postInfoRepository;

    // CREATE
    @Transactional
    public PostInfoCreateResponseDto save(PostInfoCreateRequestDto requestDto) {
        PostInfo postInfo = requestDto.toEntity();
        postInfoRepository.save(postInfo);
        return new PostInfoCreateResponseDto(postInfo);
    }

    // READ
    @Transactional(readOnly = true)
    public PostInfoReadResponseDto findById(PostInfoReadRequestDto requestDto) {
        PostInfo postInfo = postInfoRepository
            .findById(requestDto.getPostInfoId())
            .orElseThrow(() -> new IllegalArgumentException(
                "Invalid postInfoId ============>>>>>>>>>>>> " + requestDto.getPostInfoId()));

        return new PostInfoReadResponseDto(postInfo);
    }

    @Transactional(readOnly = true)
    public List<PostInfoReadResponseDto> findAll() {
        return postInfoRepository
            .findAll()
            .stream()
            .map(PostInfoReadResponseDto::new)
            .collect(Collectors.toList());
    }

    // UPDATE
    @Transactional
    public PostInfoUpdateResponseDto update(Long id, PostInfoUpdateRequestDto requestDto) {
        PostInfo postInfo = postInfoRepository
            .findById(id)
            .orElseThrow(() -> new IllegalArgumentException(
                "Invalid postInfoId ===========>>>>>>>>>> " + id));

        // Update fields
        postInfo.setTitle(requestDto.getTitle());
        postInfo.setContent(requestDto.getContent());
        postInfo.setPostNumber(requestDto.getPostNumber());
        postInfoRepository.save(postInfo);

        return new PostInfoUpdateResponseDto(postInfo);
    }

    // DELETE
    @Transactional
    public PostInfoDeleteResponseDto deleteById(PostInfoDeleteRequestDto requestDto) {
        PostInfo postInfo = postInfoRepository
            .findById(requestDto.getPostInfoId())
            .orElseThrow(() -> new IllegalArgumentException(
                "Invalid postInfoId ============>>>>>>>> " + requestDto.getPostInfoId()));

        postInfoRepository.delete(postInfo);

        return PostInfoDeleteResponseDto
            .builder()
            .postInfoId(requestDto.getPostInfoId())
            .build();
    }
}
