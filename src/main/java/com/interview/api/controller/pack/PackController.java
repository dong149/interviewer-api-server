package com.interview.api.controller.pack;


import com.interview.api.dto.common.BaseResponseDto;
import com.interview.api.dto.response.pack.PackResponseDto;
import com.interview.api.service.pack.PackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackController {

    private PackService packService;

    public PackController(PackService packService) {
        this.packService = packService;
    }

    @GetMapping
    public ResponseEntity<BaseResponseDto> getPacks(){
        List<PackResponseDto> packResponseDtos = PackResponseDto.of(packService.getPacks());
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.OK.value(), "pack 전체 조회 성공", packResponseDtos), HttpStatus.OK);
    }

    // TODO : getPackById() GET , createPack() POST with Excel, csv
    @GetMapping
    public ResponseEntity<BaseResponseDto> getPackById(){
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.OK.value(), "Id로 pack 조회 성공", "OK"), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BaseResponseDto> createPack(){
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.CREATED.value(), "pack 생성 성공", "OK"), HttpStatus.CREATED);
    }




}
