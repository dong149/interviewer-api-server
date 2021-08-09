package com.interview.api.service.category;

import com.interview.api.dto.request.category.CategoryRequestDto;
import com.interview.api.dto.response.category.CategoryResponseDto;
import com.interview.api.entity.category.Category;
import com.interview.api.repository.category.CategoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryJpaRepository categoryJpaRepository;

    public boolean createCategory(CategoryRequestDto categoryRequestDto) {


        Category category = Category.builder()
                .name(categoryRequestDto.getName())
                .build();


        categoryJpaRepository.save(category);
        return true;
    }


    public List<CategoryResponseDto> getCategories() {
        return CategoryResponseDto.of(categoryJpaRepository.findAll());
    }


}
