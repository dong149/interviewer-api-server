package com.interview.api.service.link;

import com.interview.api.dto.request.link.LinkRequestDto;
import com.interview.api.dto.response.link.LinkResponseDto;
import com.interview.api.entity.link.Link;
import com.interview.api.entity.problem.Problem;
import com.interview.api.exception.link.AlreadyExistUrlException;
import com.interview.api.exception.link.InvalidUrlFormatException;
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
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class LinkService {

    private final LinkJpaRepository linkJpaRepository;
    private final ProblemJpaRepository problemJpaRepository;

    @Transactional(readOnly = true)
    public List<LinkResponseDto> getLinks() {

        List<Link> links = linkJpaRepository.findAllByDeletedAtIsNull();
        List<LinkResponseDto> linkResponseDtos = new ArrayList<>();

        links.forEach(link ->
                linkResponseDtos.add(LinkResponseDto.of(link)));

        return linkResponseDtos;
    }

    @Transactional(readOnly = true)
    public LinkResponseDto getLinkById(Long id) {

        Link link = linkJpaRepository.findById(id).orElseThrow(() -> {
            throw new LinkNotFoundException();
        });

        return LinkResponseDto.of(link);
    }

    public boolean createLink(LinkRequestDto[] linkRequestDtos) {

        List<Link> links = new ArrayList<>();

        Stream.of(linkRequestDtos).forEach(request -> {
            Problem problem = problemJpaRepository.findById(request.getProblemId()).orElseThrow(() -> {
                throw new ProblemNotFoundException();
            });

            String url = LinkUtil.buildUrlForSave(request.getUrl());

            boolean isExist = problem.getLinks()
                    .stream().anyMatch(link ->
                            link.getUrl().equals(url));

            if (isExist) {
                throw new AlreadyExistUrlException("이미 등록된 url 주소입니다.");
            }

            links.add(
                    Link.builder()
                            .url(url)
                            .problemId(request.getProblemId())
                            .build());
        });

        linkJpaRepository.saveAll(links);
        return true;
    }


    public boolean patchLink(Long id, String patchedUrl) {

        Link link = linkJpaRepository.findById(id).orElseThrow(() -> {
            throw new LinkNotFoundException();
        });

        LinkUtil.validateUrlFormat(patchedUrl);
        Link.patchLink(link, patchedUrl);

        linkJpaRepository.save(link);
        return true;
    }

    public boolean deleteLink(Long id) {
        Link link = linkJpaRepository.findById(id).orElseThrow(() -> {
            throw new LinkNotFoundException();
        });

        Link.setDeletedAt(link);

        linkJpaRepository.save(link);
        return true;
    }
}
