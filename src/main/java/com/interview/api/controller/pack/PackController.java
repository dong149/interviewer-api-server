package com.interview.api.controller.pack;


import com.interview.api.dto.common.BaseResponseDto;
import com.interview.api.dto.request.pack.PackRequestDto;
import com.interview.api.dto.response.pack.PackResponseDto;
import com.interview.api.service.pack.PackService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = {"1. Pack"})
@RequestMapping(value = "api/v1/interviewer")
@RequiredArgsConstructor
public class PackController {

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
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.CREATED.value(), "pack 생성 성공", packService.createPack(packRequestDto.getProblems(), packRequestDto.getCategoryId())), HttpStatus.CREATED);
    }


}
