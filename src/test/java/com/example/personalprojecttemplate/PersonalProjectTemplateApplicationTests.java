package com.example.personalprojecttemplate;

import static com.example.personalprojecttemplate.util.TestUtils.readAndMapToObject;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.personalprojecttemplate.application.request.AccountRequest;
import com.example.personalprojecttemplate.application.response.AccountResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PersonalProjectTemplateApplicationTests {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void integrationTest() throws Exception {
        AccountRequest accountRequest = readAndMapToObject("fixture/account.json", AccountRequest.class);

        // insert
        MvcResult mvcResult1 = mockMvc.perform(post("/account")
                                                       .contentType(MediaType.APPLICATION_JSON)
                                                       .content(objectMapper.writeValueAsString(accountRequest)))
                                      .andExpect(status().isOk())
                                      .andDo(print())
                                      .andReturn();

        AccountResponse response1 = objectMapper.readValue(mvcResult1.getResponse().getContentAsString(), AccountResponse.class);
        assertThat(response1).isNotNull();

        // get
        MvcResult mvcResult2 = mockMvc.perform(get("/account/" + response1.getId()))
                                      .andExpect(status().isOk())
                                      .andDo(print())
                                      .andReturn();

        AccountResponse response2 = objectMapper.readValue(mvcResult2.getResponse().getContentAsString(), AccountResponse.class);
        assertThat(response2).isEqualTo(response1);

        // update
        accountRequest.setName("updated name");
        MvcResult mvcResult3 = mockMvc.perform(put("/account/" + response1.getId())
                                                            .contentType(MediaType.APPLICATION_JSON)
                                                            .content(objectMapper.writeValueAsString(accountRequest)))
                                           .andExpect(status().isOk())
                                           .andDo(print())
                                           .andReturn();
        AccountResponse response3 = objectMapper.readValue(mvcResult3.getResponse().getContentAsString(), AccountResponse.class);
        assertThat(response3.getName()).isEqualTo(accountRequest.getName());
    }

}
