package com.interview.api.entity.pack;

import javax.persistence.*;

/*
문제 모음
 */
@Entity
public class Pack {

    // TODO : 설계 마무리 및 Column 추가
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


}
