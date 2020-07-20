package com.permutations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.permutations.controller.PermutationController;
import com.permutations.service.PermutationService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(value = PermutationController.class)
public class PermutationsApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PermutationService permutationService;
	
	
	@Test
	public void getPermutations() throws Exception{
		
		Set<String> permutationList = new HashSet<String>();  
		permutationList.addAll(Arrays.asList(new String[] {"234","243","432","423","324","342"}));  
	    
		Mockito.when(
				permutationService.getPermutations("234")).thenReturn(permutationList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/permutations");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[\"234\",\"243\",\"432\",\"423\",\"324\",\"342\"]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}


	@Test
	void contextLoads() {
	}

}
