package org.example.spring_exercice7_forum.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    private String content;
    @ManyToOne
    private MyUser author;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
