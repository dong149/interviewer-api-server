package com.interview.api.controller.pack;


import com.interview.api.dto.common.BaseResponseDto;
import com.interview.api.dto.request.pack.PackRequestDto;
import com.interview.api.service.pack.PackService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"1. Pack"})
@RequestMapping(value = "api/v1/interviewer/pack")
@RequiredArgsConstructor
public class PackController {

    // TODO : create를 좀 더 빨리할 수 있는 방법이 없을까
    // TODO : random으로 return 하는 방법
    // TODO : Validation 해주기

    private final PackService packService;

    @GetMapping
    @ApiOperation(value = "pack", notes = "pack 전체 조회")
    public ResponseEntity<BaseResponseDto> getPacks() {
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.OK.value(), "pack 전체 조회 성공", packService.getPacks()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "pack", notes = "Id로 pack 조회")
    public ResponseEntity<BaseResponseDto> getPackById(@PathVariable Long id) {
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.OK.value(), "Id로 pack 조회 성공", packService.getPackById(id)), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "pack", notes = "pack 생성")
    public ResponseEntity<BaseResponseDto> createPack(@RequestBody PackRequestDto packRequestDto) {
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.CREATED.value(), "pack 생성 성공", packService.createPack(packRequestDto.getProblems(), packRequestDto.getCategoryId(),packRequestDto.getTitle(),packRequestDto.getDescription())), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{packId}")
    @ApiOperation(value = "pack", notes = "pack 카테고리 수정")
    public ResponseEntity<BaseResponseDto> patchPackCategory(@PathVariable Long packId,@RequestParam Long categoryId) {
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.CREATED.value(), "pack 카테고리 수정 성공", packService.patchPackCategory(packId,categoryId)), HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation(value = "pack", notes = "pack 삭제")
    public ResponseEntity<BaseResponseDto> deletePack(@PathVariable Long id) {
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.OK.value(), "pack 삭제 성공", packService.deletePack(id)), HttpStatus.OK);
    }



}
