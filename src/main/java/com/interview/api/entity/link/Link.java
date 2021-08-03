package com.interview.api.entity.link;

import com.interview.api.entity.problem.Problem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
추천 링크
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "links")
public class Link {

    /*
    id : Link Id
    url : url 주소
    problemId : 문제 ID
    createdAt : 생성 일자
    deletedAt : 삭제 일자
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String url;

    @Column
    private Long problemId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime deletedAt;

    public static void setDeletedAt(Link link) {
        link.deletedAt = LocalDateTime.now();
    }

    public static void patchLink(Link link, String patchedUrl) {
        link.url = patchedUrl;
    }
}
