package pe.com.relari;

import org.junit.jupiter.api.BeforeEach;
import pe.com.relari.employee.service.EmployeeService;
import pe.com.relari.employee.util.JsonConverter;
import pe.com.relari.employee.util.DataMocks;
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
 * 
 * @version 1.0.0
 * @author Relari
 */

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeApplicationTests {

	@Value("${application.api.path}")
	String baseUrl;

	@org.springframework.beans.factory.annotation.Autowired
	private MockMvc mockMvc;

	@org.springframework.beans.factory.annotation.Autowired
	private EmployeeService demoService;

	@BeforeEach
	void init() {
		demoService.save(DataMocks.buildEmployee());
	}

	@Test
	void getDemosTest() throws Exception {
		mockMvc.perform(get(baseUrl))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void createDemoTest() throws Exception {

		var demo = DataMocks.buildEmployeeRequest();

		mockMvc.perform(post(baseUrl)
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonConverter.toJsonString(demo)))
				.andDo(print())
				.andExpect(status().isCreated());
	}

	@Test
	void createDemoButIsBadRequestTest() throws Exception {
		mockMvc.perform(post(baseUrl)
				.contentType(MediaType.APPLICATION_JSON)
				.content(""))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}

	@Test
	void demoNotFoundTest() throws Exception {
		mockMvc.perform(get(baseUrl.concat("/0")))
				.andDo(print())
				.andExpect(status().isNotFound());
	}

	@Test
	void deleteDemoTest() throws Exception {
		mockMvc.perform(delete(baseUrl.concat("/1")))
				.andDo(print())
				.andExpect(status().isNoContent());
	}

}
