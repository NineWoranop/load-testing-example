package com.nineworanop.schoolexample.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
class SleepRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("GET /api/sleep/1 Positive 1")
	void testFindAllSchoolsPositive1() throws Exception {
		// When
		ResultActions result = mockMvc.perform(get("/api/sleep/1").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		
		// Then validate the response code and content type
		result.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))

		// Then validate result
		.andExpect(mvcResult -> {
			String actualResult = mvcResult.getResponse().getContentAsString();
			assertThat(actualResult).isEqualTo("1");
		});
	}

}
