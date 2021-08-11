package com.interview.api.controller.pack;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.api.controller.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PackControllerTest extends AbstractControllerTest {


    @Autowired
    private PackController packController;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    protected Object controller() {
        return packController;
    }


    @Test
    public void getPacks() throws Exception {
        //given

        //when
        ResultActions resultActions = mockMvc.perform(get("/api/v1/pack"));

        //then
        resultActions
                .andExpect(status().isOk());
    }

    @Test
    public void getPacksById() throws Exception {
        //given

        //when
        ResultActions resultActions = mockMvc.perform(get("/api/v1/pack/{id}", 1L));

        //then
        resultActions
                .andExpect(status().isOk());
    }

    @Test
    public void patchPackCategory() throws Exception {
        //given
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("categoryId", "1");

        //when
        ResultActions resultActions = mockMvc.perform(patch("/api/v1/pack/{id}", 1L)
                .params(params)
        );

        //then
        resultActions
                .andExpect(status().isCreated());
    }

    @Test
    public void deletePack() throws Exception {
        //given

        //when
        ResultActions resultActions = mockMvc.perform(delete("/api/v1/pack/{id}", 1L));

        //then
        resultActions
                .andExpect(status().isOk());
    }

//    @Test
//    public void createPack() throws Exception {
//        ObjectNode content = objectMapper.createObjectNode();
//        content.put("title","Pack 제목");
//        content.put("description","Pack 설명");
//        content.put("categoryId",1);
//
//        mockMvc.perform(post("/api/v1/interviewer/pack")
//                .content(objectMapper.writeValueAsString(content))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated());
//    }


}
