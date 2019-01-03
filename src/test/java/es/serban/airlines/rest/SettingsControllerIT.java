package es.serban.airlines.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import es.serban.airlines.config.SettingsConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SettingsControllerIT {
	
	@TestConfiguration
	static class SettingsControllerTestContextConfiguration {
		@Bean
		public SettingsConfig settingsConfig() {
			return new SettingsConfig();
		}
	}
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@Autowired
	SettingsConfig settingsConfig;

	@Test
	public void test() {
		settingsConfig.setVersion("0.0.1");
		assertThat(settingsConfig.getVersion(), is("0.0.1"));
		String resp = restTemplate.getForObject("/version", String.class);
		assertThat(resp, is("VERSIÓN MOD: " + "0.0.1"));
	}

}
