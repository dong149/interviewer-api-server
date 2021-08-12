package com.interview.api.service.link;

import com.interview.api.dto.request.link.LinkRequestDto;
import com.interview.api.dto.response.link.LinkResponseDto;
import com.interview.api.entity.link.Link;
import com.interview.api.entity.problem.Problem;
import com.interview.api.exception.link.AlreadyExistUrlException;
import com.interview.api.exception.link.LinkNotFoundException;
import com.interview.api.exception.problem.ProblemNotFoundException;
import com.interview.api.repository.link.LinkJpaRepository;
import com.interview.api.repository.problem.ProblemJpaRepository;
import com.interview.api.util.LinkUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class LinkService {

    private final LinkJpaRepository linkJpaRepository;
    private final ProblemJpaRepository problemJpaRepository;


    /*
    public method
     */
    @Transactional(readOnly = true)
    public List<LinkResponseDto> getLinkResponseDtoList() {
        List<Link> links = linkJpaRepository.findAllByDeletedAtIsNull();
        List<LinkResponseDto> linkResponseDtos = new ArrayList<>();
        links.forEach(link ->
                linkResponseDtos.add(LinkResponseDto.of(link)));
        return linkResponseDtos;
    }

    @Transactional(readOnly = true)
    public LinkResponseDto getLinkResponseDtoById(Long id) {
        Link link = getLinkById(id);
        return LinkResponseDto.of(link);
    }


    @Transactional
    public boolean createLinks(LinkRequestDto[] linkRequestDtos) {
        List<Link> links = new ArrayList<>();
        Stream.of(linkRequestDtos).forEach(linkRequestDto -> {
            links.add(createLinkWithLinkRequestDto(linkRequestDto));
        });
        linkJpaRepository.saveAll(links);
        return true;
    }

    @Transactional
    public boolean patchLink(Long id, String patchedUrl) {
        Link link = getLinkById(id);
        LinkUtil.validateUrlFormat(patchedUrl);
        Link.patchUrl(link, patchedUrl);

        linkJpaRepository.save(link);
        return true;
    }

    @Transactional
    public boolean deleteLink(Long id) {
        Link link = getLinkById(id);
        Link.setDeletedAt(link);

        linkJpaRepository.save(link);
        return true;
    }


    /*
    private method
     */
    private Link getLinkById(Long id) {
        return linkJpaRepository.findById(id).orElseThrow(() -> {
            throw new LinkNotFoundException();
        });
    }

    private Link createLinkWithLinkRequestDto(LinkRequestDto linkRequestDto) {
        Problem problem = getProblemByProblemId(linkRequestDto.getProblemId());
        String url = LinkUtil.buildUrlForSave(linkRequestDto.getUrl());
        checkLinkExistInProblem(problem, url);
        return Link.builder()
                .url(url)
                .problemId(linkRequestDto.getProblemId())
                .build();
    }

    private Problem getProblemByProblemId(Long problemId) {
        return problemJpaRepository.findById(problemId).orElseThrow(() -> {
            throw new ProblemNotFoundException();
        });
    }


    private static void checkLinkExistInProblem(Problem problem, String url) {
        boolean isExist = problem.getLinks()
                .stream().anyMatch(link ->
                        link.getUrl().equals(url));

        if (isExist) {
            throw new AlreadyExistUrlException("이미 등록된 url 주소입니다.");
        }
    }
}
