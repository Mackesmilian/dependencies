package at.wolf.dependencies;

import at.wolf.dependencies.controller.CustomerController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
class BaseTest {

	@Autowired
	private CustomerController customerController;

	@BeforeAll
	public void setup() {
		StandaloneMockMvcBuilder standaloneMockMvcBuilder
				= MockMvcBuilders.standaloneSetup(customerController);
		RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
	}

}
