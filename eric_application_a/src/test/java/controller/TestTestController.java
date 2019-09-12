package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import eric.ApplicationEricA;

/**
 * @author zhou.hao
 * @email zhouhao@ule.com
 * @createTime 2019年9月11日 下午1:16:26
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { ApplicationEricA.class })
@AutoConfigureMockMvc
public class TestTestController {

	@Test
	public void test() {
		System.out.println("this is a test method !");
	}

	@Autowired
	private MockMvc mvc;

	@Test
	public void testHome() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/test").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
