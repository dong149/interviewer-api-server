package com.interview.api.service.pack;


import com.interview.api.dto.request.link.LinkDto;
import com.interview.api.dto.request.problem.ProblemDto;
import com.interview.api.dto.response.pack.PackResponseDto;
import com.interview.api.entity.category.Category;
import com.interview.api.entity.link.Link;
import com.interview.api.entity.pack.Pack;
import com.interview.api.entity.problem.Problem;
import com.interview.api.exception.category.CategoryNotFoundException;
import com.interview.api.exception.pack.PackNotFoundException;
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


        List<Pack> packs = packJpaRepository.findAllByDeletedAtIsNull();
        List<PackResponseDto> packResponseDtos = new ArrayList<>();

        for (Pack pack : packs) {
            Long categoryId;

            Category category = pack.getCategory();

            packResponseDtos.add(PackResponseDto.of(pack, category));


        }
        return packResponseDtos;
    }

    public PackResponseDto getPackById(Long id) {

        Pack pack = packJpaRepository.findById(id).orElseThrow(() -> {
            throw new PackNotFoundException();
        });

        return PackResponseDto.of(pack);

    }

    public boolean createPack(List<ProblemDto> problemDtos, Long categoryId) {

        Category category = categoryJpaRepository.findById(categoryId).orElseThrow(() -> {
            throw new CategoryNotFoundException();
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

    public boolean patchPackCategory(Long packId, Long categoryId) {

        Category category = categoryJpaRepository.findById(categoryId).orElseThrow(() -> {
            throw new CategoryNotFoundException();
        });

        Pack pack = packJpaRepository.findById(packId).orElseThrow(() -> {
            throw new PackNotFoundException();
        });

        Pack.patchCategory(pack, category);
        packJpaRepository.save(pack);
        return true;
    }


    public boolean deletePack(Long id) {
        Pack pack = packJpaRepository.findById(id).orElseThrow(() -> {
            throw new PackNotFoundException();
        });
        Pack.setDeletedAt(pack);

        packJpaRepository.save(pack);
        return true;
    }

}
