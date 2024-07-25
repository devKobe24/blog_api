package com.devkobe.blog.service.postList;

import com.devkobe.blog.domain.dateInfo.DateInfo;
import com.devkobe.blog.domain.post.Post;
import com.devkobe.blog.domain.postInfo.PostInfo;
import com.devkobe.blog.domain.postList.PostList;
import com.devkobe.blog.domain.userInfo.UserInfo;
import com.devkobe.blog.repository.dateInfo.DateInfoRepository;
import com.devkobe.blog.repository.postInfo.PostInfoRepository;
import com.devkobe.blog.repository.postList.PostListRepository;
import com.devkobe.blog.repository.userInfo.UserInfoRepository;
import com.devkobe.blog.web.dto.post.create.PostCreateRequestDto;
import com.devkobe.blog.web.dto.postList.create.PostListCreateRequestDto;
import com.devkobe.blog.web.dto.postList.create.PostListCreateResponseDto;
import com.devkobe.blog.web.dto.postList.delete.PostListDeleteRequestDto;
import com.devkobe.blog.web.dto.postList.delete.PostListDeleteResponseDto;
import com.devkobe.blog.web.dto.postList.read.PostListReadRequestDto;
import com.devkobe.blog.web.dto.postList.read.PostListReadResponseDto;
import com.devkobe.blog.web.dto.postList.update.PostListUpdateRequestDto;
import com.devkobe.blog.web.dto.postList.update.PostListUpdateResponseDto;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostListService {

    private final PostListRepository postListRepository;
    private final PostInfoRepository postInfoRepository;
    private final UserInfoRepository userInfoRepository;
    private final DateInfoRepository dateInfoRepository;

    // CREATE
    @Transactional
    public PostListCreateResponseDto save(PostListCreateRequestDto requestDto) {
        PostList postList = requestDto.toEntity();

        postList.getPosts().forEach(post -> {
            post.setPostInfo(mergePostInfo(post.getPostInfo()));
            post.setUserInfo(mergeUserInfo(post.getUserInfo()));
            post.setDateInfo(mergeDateInfo(post.getDateInfo()));
            post.setPostList(postList); // PostList 설정
        });

        postListRepository.save(postList);
        return new PostListCreateResponseDto(postList);
    }

    // READ
    @Transactional(readOnly = true)
    public List<PostListReadResponseDto> findAll() {
        List<PostList> postList = postListRepository.findAll();
        return postList.stream()
            .map(PostListReadResponseDto::new)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostListReadResponseDto findById(PostListReadRequestDto requestDto) {
        Long postId = requestDto.getPostId();
        PostList postList = postListRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("PostList not found with postId =======>>> " + postId));

        return new PostListReadResponseDto(postList);
    }

    // UPDATE
    @Transactional
    public PostListUpdateResponseDto update(PostListUpdateRequestDto requestDto) {
        Long postId = requestDto.getPostId();
        PostList postList = postListRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("PostList not found with postId =======>>> " + postId));

        // Map PostCreateRequestDto to Post entity
        List<Post> updatedPosts = requestDto
            .getPosts()
            .stream()
            .map(PostCreateRequestDto::toEntity)
            .collect(Collectors.toList());

        // Update PostList entity
        postList.update(updatedPosts);
        postListRepository.save(postList);

        return new PostListUpdateResponseDto(postList);
    }

    // DELETE
    @Transactional
    public PostListDeleteResponseDto delete(PostListDeleteRequestDto requestDto) {
        String successMessage = "SUCCESS TO DELETE";
        String failMessage = "FAIL TO DELETE";
        Long postId = requestDto.getPostId();

        try {
            PostList postList = postListRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("PostList not found with postId =======>>> " + postId));
            postListRepository.delete(postList);
            return new PostListDeleteResponseDto(postId, successMessage);
        } catch (Exception e) {
            return new PostListDeleteResponseDto(postId, failMessage);
        }
    }

    // MERGE ENTITIES
    @Transactional
    public PostInfo mergePostInfo(PostInfo postInfo) {
        return postInfoRepository.findById(postInfo.getPostInfoId())
                                 .map(existing -> {
                                     existing.setTitle(postInfo.getTitle());
                                     existing.setContent(postInfo.getContent());
                                     existing.setPostNumber(postInfo.getPostNumber());
                                     return existing;
                                 })
                                 .orElse(postInfo);
    }

    @Transactional
    public UserInfo mergeUserInfo(UserInfo userInfo) {
        return userInfoRepository.findById(userInfo.getUserInfoId())
                                 .map(existing -> {
                                     existing.setName(userInfo.getName());
                                     existing.setEmail(userInfo.getEmail());
                                     existing.setProfileImage(userInfo.getProfileImage());
                                     existing.setNickName(userInfo.getNickName());
                                     return existing;
                                 })
                                 .orElse(userInfo);
    }

    @Transactional
    public DateInfo mergeDateInfo(DateInfo dateInfo) {
        return dateInfoRepository.findById(dateInfo.getDateInfoId())
                                 .map(existing -> {
                                     existing.setReleaseDate(dateInfo.getReleaseDate());
                                     existing.setModificationDate(dateInfo.getModificationDate());
                                     return existing;
                                 })
                                 .orElse(dateInfo);
    }
}
