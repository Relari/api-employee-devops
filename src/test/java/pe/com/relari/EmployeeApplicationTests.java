package pe.com.relari;

import lombok.RequiredArgsConstructor;
import pe.com.relari.employee.service.EmployeeService;
import pe.com.relari.employee.util.JsonConverter;
import pe.com.relari.employee.util.TestUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class: EmployeeApplicationTests.
 * @version 1.0.0
 * @author Relari
 */

@SpringBootTest
//@AutoConfigureMockMvc
//@RequiredArgsConstructor
class EmployeeApplicationTests {

//	@Value("${application.api.path}")
//	String baseUrl;
//
//	private final MockMvc mockMvc;
//	private final EmployeeService demoService;
//
////	@BeforeEach
////	void init() {
////		demoService.save(TestUtil.buildEmployee());
////	}
//
//	@Test
//    @Disabled
//    @Order(2)
//	void getDemosTest() throws Exception {
//		mockMvc.perform(get(baseUrl))
//				.andDo(print())
//				.andExpect(status().isOk());
//	}
//
//	@Test
//    @Disabled
//    @Order(1)
//	void createDemoTest() throws Exception {
//
//		var demo = TestUtil.buildEmployeeRequest();
//
//		mockMvc.perform(post(baseUrl)
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(JsonConverter.toJsonString(demo))
//				)
//				.andDo(print())
//				.andExpect(status().isCreated());
//	}
//
////	@Test
////	void createDemoButIsBadRequestTest() throws Exception {
////
////		var demo = new DemoRequest("");
////
////		mockMvc.perform(post(baseUrl)
////						.contentType(MediaType.APPLICATION_JSON)
////						.content(objectMapper.writeValueAsString(demo))
////				)
////				.andDo(print())
////				.andExpect(status().isBadRequest());
////	}
////
//	@Test
//    @Disabled
//    @Order(3)
//	void foundDemoTest() throws Exception {
//		mockMvc.perform(get(baseUrl.concat("/1")))
//				.andDo(print())
//				.andExpect(status().isOk());
//	}
//
//	@Test
//    @Disabled
//    @Order(4)
//	void demoNotFoundTest() throws Exception {
//		mockMvc.perform(get(baseUrl.concat("/0")))
//				.andDo(print())
//				.andExpect(status().isNotFound());
//	}
//
//	@Test
//    @Disabled
//    @Order(5)
//	void deleteDemoTest() throws Exception {
//		mockMvc.perform(delete(baseUrl.concat("/1")))
//				.andDo(print())
//				.andExpect(status().isNoContent());
//	}

}
