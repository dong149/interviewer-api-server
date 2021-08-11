package com.interview.api.service.link;

import com.interview.api.repository.link.LinkJpaRepository;
import com.interview.api.service.AbstractServiceTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class LinkServiceTest extends AbstractServiceTest {

    @InjectMocks
    LinkService linkService;

    @Mock
    LinkJpaRepository linkJpaRepository;

    @BeforeAll
    static void setup(){



    }

//    @Test
//    public void 링크_생성_예외테스트(){

        //given
//        given(categoryJpaRepository.save(any())).willReturn(category);

        //when
//        Boolean res = categoryService.createCategory(categoryRequestDto);

        //then
//        assertTrue(res);



//    }


}
