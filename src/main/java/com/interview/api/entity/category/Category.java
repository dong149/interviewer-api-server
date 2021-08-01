package com.interview.api.entity.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "categories")
public class Category {

    /*
    id : Category Id
    name : Category 이름
     */


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column
    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;




}
