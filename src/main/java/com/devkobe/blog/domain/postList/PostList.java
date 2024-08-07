package com.devkobe.blog.domain.postList;

import com.devkobe.blog.domain.post.Post;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
public class PostList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long postId;

    @Setter
    @Column(nullable = false, unique = true)
    private UUID uuid = UUID.randomUUID();

    @OneToMany(mappedBy = "postList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @Builder
    public PostList(List<Post> posts) {
        this.posts = posts != null ? posts : new ArrayList<>();
        this.uuid = UUID.randomUUID();
    }

    public void update (List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostList postList = (PostList) o;
        return Objects.equals(postId, postList.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(postId);
    }

    public void addPost(Post post) {
        posts.add(post);
        post.setPostList(this);
    }

    public void removePost(Post post) {
        posts.remove(post);
        post.setPostList(null);
    }
}
