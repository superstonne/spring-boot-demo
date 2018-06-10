package com.nick.springbootdemo;

import com.nick.springbootdemo.controller.HelloWorldController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
public class SpringBootDemoApplicationTests {

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
	}

	@Test
	public void getHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello?name=小明").accept(MediaType.APPLICATION_JSON_UTF8))
				.andDo(print());
	}
}
