package com.interview.api.entity.problem;


import javax.persistence.*;

/*
문제
 */
@Entity
public class Problem {

    // TODO : 설계 마무리 및 Column 추가
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
}
