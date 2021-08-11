package com.interview.api.controller.link;

import com.interview.api.dto.common.BaseResponseDto;
import com.interview.api.dto.request.link.LinkRequestDto;
import com.interview.api.service.link.LinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"3. Link"})
@RequestMapping(value = "api/v1/link")
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @GetMapping
    @ApiOperation(value = "link", notes = "link 전체 조회")
    public ResponseEntity<BaseResponseDto> getLinks() {
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.OK.value(), "link 전체 조회 성공", linkService.getLinks()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "link", notes = "Id로 link 조회")
    public ResponseEntity<BaseResponseDto> getLinkById(@PathVariable Long id) {
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.OK.value(), "Id로 link 조회 성공", linkService.getLinkById(id)), HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "link", notes = "link 여러개 생성")
    public ResponseEntity<BaseResponseDto> createLinks(@RequestBody LinkRequestDto[] linkRequestDtos) {
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.CREATED.value(), "link 생성 성공", linkService.createLinks(linkRequestDtos)), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    @ApiOperation(value = "link", notes = "link 수정")
    public ResponseEntity<BaseResponseDto> patchLink(@PathVariable Long id, @RequestParam String patchedUrl) {
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.CREATED.value(), "link 수정 성공", linkService.patchLink(id, patchedUrl)), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "link", notes = "link 삭제")
    public ResponseEntity<BaseResponseDto> deleteLink(@PathVariable Long id) {
        return new ResponseEntity<>(new BaseResponseDto(HttpStatus.OK.value(), "pack 삭제 성공", linkService.deleteLink(id)), HttpStatus.OK);
    }
}
