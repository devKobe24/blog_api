package com.devkobe.blog.service.post;

import com.devkobe.blog.domain.post.Post;
import com.devkobe.blog.repository.post.PostRepository;
import com.devkobe.blog.repository.post.PostSpecification;
import com.devkobe.blog.web.dto.post.create.PostCreateRequestDto;
import com.devkobe.blog.web.dto.post.create.PostCreateResponseDto;
import com.devkobe.blog.web.dto.post.delete.PostDeleteResponseDto;
import com.devkobe.blog.web.dto.post.read.PostReadResponseDto;
import com.devkobe.blog.web.dto.post.update.PostUpdateRequestDto;
import com.devkobe.blog.web.dto.post.update.PostUpdateResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    // CREATE
    @Transactional
    public PostCreateResponseDto save(PostCreateRequestDto requestDto) {
        Post post = requestDto.toEntity();
        postRepository.save(post);
        return new PostCreateResponseDto(post);
    }

    // READ
    @Transactional(readOnly = true)
    public List<PostReadResponseDto> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts
            .stream()
            .map(PostReadResponseDto::new)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostReadResponseDto findById(Long postId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("Post not found with id ======>>> " + postId));
        return new PostReadResponseDto(post);
    }

    // UPDATE
    @Transactional
    public PostUpdateResponseDto update(
        Long postId,
        PostUpdateRequestDto requestDto
    ) {
        Post post = postRepository
            .findById(postId)
            .orElseThrow(() -> new RuntimeException("Post not found with id ======>>> " + postId));

        post.update(requestDto.getPostInfo(), requestDto.getUserInfo(), requestDto.getDateInfo());
        postRepository.save(post);

        return new PostUpdateResponseDto(post);
    }

    // DELETE
    @Transactional
    public PostDeleteResponseDto delete(Long postId) {
        String successMessage = "SUCCESS TO DELETE";
        String failMessage = "FAIL TO DELETE";
        try {
            Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id =======>>> " + postId));
            postRepository.delete(post);
            return new PostDeleteResponseDto(postId, successMessage);
        } catch (Exception e) {
            return new PostDeleteResponseDto(postId, failMessage);
        }
    }

    // SEARCH
    @Transactional(readOnly = true)
    public List<PostReadResponseDto> findByCriteria(
        Long id,
        Long postInfoId,
        Long userInfoId,
        Long dateInfoId,
        String title,
        String content,
        String nickName,
        Integer postNumber
    ) {
        Specification<Post> specification = Specification.where(PostSpecification.withId(id))
            .and(PostSpecification.withPostInfoId(postInfoId))
            .and(PostSpecification.withUserInfoId(userInfoId))
            .and(PostSpecification.withDateInfoId(dateInfoId))
            .and(PostSpecification.withTitle(title))
            .and(PostSpecification.withContent(content))
            .and(PostSpecification.withNickName(nickName))
            .and(PostSpecification.withPostNumber(postNumber));

        List<Post> posts = postRepository.findAll(specification);

        return posts.stream()
            .map(PostReadResponseDto::new)
            .collect(Collectors.toList());
    }
}




