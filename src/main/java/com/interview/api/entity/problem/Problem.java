package com.interview.api.entity.problem;


import com.interview.api.entity.link.Link;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/*
문제
 */
@Entity
public class Problem {

    /*
    id : Problem Id
    content : 문제 지문
    answer : 문제 정답
    packId : pack ID ( many to one )
    List<Link> : link list
    createdAt : 생성 일자
    deletedAt : 삭제 일자
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private String answer;

    @Column
    private Long packId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "linkId")
    private List<Link> links;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime deletedAt;


}
