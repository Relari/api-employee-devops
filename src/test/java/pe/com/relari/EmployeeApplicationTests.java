package pe.com.relari;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pe.com.relari.employee.model.api.EmployeeRequest;
import pe.com.relari.employee.util.JsonConverter;

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

	@Autowired
	private MockMvc mockMvc;

//	@Autowired
//	private EmployeeService demoService;

	@BeforeEach
	void init() {
//		 demoService.save(DataMocks.buildEmployee());
	}

	@Test
	void getDemosTest() throws Exception {
		mockMvc.perform(get(baseUrl))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void createDemoTest() throws Exception {

		var request = JsonConverter.readJsonFromResource("data/employee_request.json", EmployeeRequest.class);

		mockMvc.perform(post(baseUrl)
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonConverter.toJsonString(request)))
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
	@Disabled
	void deleteDemoTest() throws Exception {
		mockMvc.perform(delete(baseUrl.concat("/1")))
				.andDo(print())
				.andExpect(status().isNoContent());
	}

}
