package com.interview.api.dto.request.problem;


import com.interview.api.dto.request.link.LinkRequestDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDto {


    @ApiModelProperty(example = "TCP와 UDP의 차이점에 대해서 설명해보세요.")
    private String content;
    @ApiModelProperty(example = "TCP는 연결 지향형 프로토콜이고 UDP는 데이터를 데이터그램단위로 전송하는 프로토콜입니다.")
    private String answer;
    private List<LinkRequestDto> links;

}
