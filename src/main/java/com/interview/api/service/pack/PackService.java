package com.interview.api.service.pack;


import com.interview.api.dto.request.link.LinkDto;
import com.interview.api.dto.request.problem.ProblemDto;
import com.interview.api.dto.response.pack.PackResponseDto;
import com.interview.api.entity.category.Category;
import com.interview.api.entity.link.Link;
import com.interview.api.entity.pack.Pack;
import com.interview.api.entity.problem.Problem;
import com.interview.api.repository.category.CategoryJpaRepository;
import com.interview.api.repository.pack.PackJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PackService {


    private final PackJpaRepository packJpaRepository;
    private final CategoryJpaRepository categoryJpaRepository;

    public List<PackResponseDto> getPacks() {


        List<Pack> packs =  packJpaRepository.findAllByDeletedAtIsNull();
        List<PackResponseDto> packResponseDtos = new ArrayList<>();

        for(Pack pack : packs){
            Long categoryId;

            Category category = pack.getCategory();
//            Category category = categoryJpaRepository.findById(categoryId).orElseThrow();

            packResponseDtos.add(PackResponseDto.of(pack,category));


        }
        return packResponseDtos;
    }

    public boolean createPack(List<ProblemDto> problemDtos,Long categoryId) {

        Category category = categoryJpaRepository.findById(categoryId).orElseThrow(()->{
            throw new IllegalArgumentException();
        });

        List<Problem> problems = new ArrayList<>();
        for (ProblemDto problemDto : problemDtos) {
            List<Link> links = new ArrayList<>();
            for (LinkDto linkDto : problemDto.getLinks()) {
                links.add(Link.builder()
                        .url(linkDto.getUrl())
                        .build());
            }

            problems.add(Problem.builder()
                    .answer(problemDto.getAnswer())
                    .content(problemDto.getContent())
                    .links(links)
                    .build());
        }

        Pack pack = Pack.builder()
                .problems(problems)
                .category(category)
                .build();

        packJpaRepository.save(pack);


        return true;
    }


    /*
    ProblemDto 예시

    "content" : "웹 통신의 큰 흐름: https://www.google.com/ 을 접속할 때 일어나는 일"

    "answer" : "

    면접 단골 문제입니다. 면접관 입장에서는 한 질문으로 많은 답변을 들을 수 있기 때문에 대부분의 면접자리에서 나왔던 문제입니다. OSI 7계층과도 연관지어 설명하라는 질문을 받은적도 있습니다.

    브라우저가 URL에 적힌 값을 파싱해서 HTTP Request Message를 만들고, OS에 전송 요청을 합니다. 이 때, Domain으로 요청을 보낼 수 없기 때문에 DNS Lookup을 수행합니다.

    DNS 룩업 과정은 크롬의 경우 브라우저 → hosts 파일 → DNS Cache의 순서로 도메인에 매칭되는 ip를 찾습니다. 일반적으로 설명하는 DNS Lookup은 루트 도메인서버에서부터 서브도메인 서버순으로 찾게됩니다.

    이 요청은 프로토콜 스택이라는 OS에 내장된 네트워크 제어용 소프트웨어에 의해 패킷에 담기고 패킷에 제어정보를 덧붙여 LAN 어댑터에 전송하고, LAN 어댑터는 이를 전기신호로 변환시켜 송출합니다.

    패킷은 스위칭 허브 등을 경유하여 인터넷 접속용 라우터에서 ISP로 전달되고 인터넷으로 이동합니다.
    액세스 회선에 의해 통신사용 라우터로 운반되고 인터넷의 핵심부로 전달됩니다. 고속 라우터들 사이로 목적지까지 패킷이 흘러들어가게 됩니다.

    핵심부를 통과한 패킷은 목적지의 LAN에 도착하고, 방화벽이 패킷을 검사한 후 캐시 서버로 보내어 웹 서버에 갈 필요가 있는지 검사합니다.

    웹 서버에 도착한 패킷은 프로토콜 스택이 패킷을 추출하여 메시지를 복원하고 웹 서버 애플리케이션에 넘깁니다. 애플리케이션은 요청에 대한 응답 데이터를 작성하여 클라이언트로 회송하고, 이는 전달된 방식 그대로 전송됩니다.

    "


     */


}
