package task.testTask;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
class HandlerTest {

	@Autowired
	private Handler handler;

	@MockBean
	@Qualifier("client")
	UserClientCurrency client;

	@MockBean
	@Qualifier("gif")
	UserClientGif gif;

	@Test
	void getDoubleToday() {
		assertThat(handler.getDoubleToday()).isInstanceOf(Double.class);
		assertThat(handler.getDoubleToday()).isNotNull();
	}

	@Test
	void getDoubleYesterday() {
		assertThat(handler.getDoubleYesterday()).isInstanceOf(Double.class);
		assertThat(handler.getDoubleYesterday()).isNotNull();
	}

	@Test
	void getGif() {
		assertThat(handler.getGif("rich")).isNotNull();
		assertThat(handler.getGif("broke")).isNotNull();
	}
}