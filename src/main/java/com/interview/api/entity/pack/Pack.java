package com.interview.api.entity.pack;

import com.interview.api.entity.problem.Problem;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/*
문제 모음
 */
@Entity
@Getter
public class Pack {

    /*
    id : Pack Id
    List<Problem> : 문제 list
    createdAt : 생성 일자
    deletedAt : 삭제 일자
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "packId")
    private List<Problem> problems;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime deletedAt;



}
