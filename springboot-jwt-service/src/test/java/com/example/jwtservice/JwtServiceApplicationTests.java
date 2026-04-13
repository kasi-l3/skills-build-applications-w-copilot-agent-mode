package com.example.jwtservice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class JwtServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldRejectProtectedEndpointWithoutToken() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isForbidden());
    }

    @Test
    void shouldReturnTokenAndAllowProtectedEndpoint() throws Exception {
        MvcResult loginResult = mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"demo\",\"password\":\"demo123\"}"))
                .andExpect(status().isOk())
                .andReturn();

        String response = loginResult.getResponse().getContentAsString();
        JsonNode json = objectMapper.readTree(response);
        String token = json.get("token").asText();

        mockMvc.perform(get("/api/hello")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }
}
