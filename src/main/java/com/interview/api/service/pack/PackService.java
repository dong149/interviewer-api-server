package com.interview.api.service.pack;


import com.interview.api.entity.pack.Pack;
import com.interview.api.repository.pack.PackJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackService {


    private PackJpaRepository packJpaRepository;

    public PackService(PackJpaRepository packJpaRepository) {
        this.packJpaRepository = packJpaRepository;
    }

    public List<Pack> getPacks(){
        return packJpaRepository.findAllExists();
    }



}
