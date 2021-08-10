package com.interview.api.service.category;

import com.interview.api.dto.request.category.CategoryRequestDto;
import com.interview.api.entity.category.Category;
import com.interview.api.repository.category.CategoryJpaRepository;
import com.interview.api.service.AbstractServiceTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


public class CategoryServiceTest extends AbstractServiceTest {

    @InjectMocks
    CategoryService categoryService;

    @Mock
    CategoryJpaRepository categoryJpaRepository;


    static CategoryRequestDto categoryRequestDto;
    static Category category;
    static final String NAME = "새로운 카테고리 이름";



    @BeforeAll
    static void setup(){

        categoryRequestDto = CategoryRequestDto.builder()
                .name(NAME)
                .build();

        category = Category.builder()
                .name(NAME)
                .build();
    }

    @Test
    public void 카테고리_생성되는지_확인(){
        //given
        given(categoryJpaRepository.save(any())).willReturn(category);

        //when
        Boolean res = categoryService.createCategory(categoryRequestDto);

        //then
        assertTrue(res);
    }




}
