package com.interview.api.controller.category;


import com.interview.api.dto.common.BaseResponseDto;
import com.interview.api.dto.request.category.CategoryRequestDto;
import com.interview.api.service.category.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"4. Category"})
@RequestMapping(value = "api/v1/interviewer/category")
@RequiredArgsConstructor
public class CategoryController {
    // TODO : CRUD

    private final CategoryService categoryService;

    @PostMapping
    @ApiOperation(value = "category", notes = "category 생성")
    public ResponseEntity<BaseResponseDto> createCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.CREATED.value(), "category 생성 성공", categoryService.createCategory(categoryRequestDto)), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "category", notes = "category 전체 조회")
    public ResponseEntity<BaseResponseDto> getCategories() {
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.OK.value(), "category 전체 조회 성공", categoryService.getCategories()), HttpStatus.OK);
    }
}
