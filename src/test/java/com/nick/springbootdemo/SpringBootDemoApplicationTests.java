package com.nick.springbootdemo;

import com.nick.springbootdemo.web.HelloWorldController;
import com.nick.springbootdemo.web.WebController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

	private MockMvc mockMvc;

	@Resource
	private WebProperties webProperties;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(new WebController()).build();
	}

	@Test
	public void getHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello?name=小明").accept(MediaType.APPLICATION_JSON_UTF8))
				.andDo(print());
	}

	@Test
	public void getUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/getUser")).andDo(print());
	}

	@Test
	public void getUsers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/getUsers")).andDo(print());
	}

	@Test
	public void testProperties() {
		System.out.println(webProperties.getUserName());
		System.out.println(webProperties.getUserDescription());
	}
}
