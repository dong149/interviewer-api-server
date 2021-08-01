package com.interview.api.dto.response.link;


import com.interview.api.entity.link.Link;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LinkResponseDto {
    private String url;

    public static List<LinkResponseDto> of(List<Link> links){
        return links.stream()
                .map(LinkResponseDto::of)
                .collect(Collectors.toList());
    }

    public static LinkResponseDto of(Link link){
        return LinkResponseDto.builder()
                .url(link.getUrl())
                .build();
    }
}
