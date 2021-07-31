package com.interview.api.controller.pack;


import com.interview.api.dto.common.BaseResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackController {


    @GetMapping
    public ResponseEntity<BaseResponseDto> getPacks(){
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.OK.value(), "pack 전체 조회 성공", "OK"), HttpStatus.OK);
    }



}
