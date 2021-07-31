package com.interview.api.entity.link;

import javax.persistence.*;

/*
추천 링크
 */
@Entity
public class Link {

    // TODO : 설계 마무리 및 Column 추가
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

}
