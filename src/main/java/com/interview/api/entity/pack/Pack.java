package com.interview.api.entity.pack;

import com.interview.api.entity.category.Category;
import com.interview.api.entity.problem.Problem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/*
문제 모음
 */
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "packs")
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

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    public static void setDeletedAt(Pack pack){
        pack.deletedAt = LocalDateTime.now();
    }

    public static void patchCategory(Pack pack,Category category){
        pack.category = category;
    }



}
