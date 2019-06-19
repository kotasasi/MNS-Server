/*package volvocars.mns.mnslog;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TestSpringBootApplication {

	@LocalServerPort
	int randomServerPort;

	private TestRestTemplate restTemplate;	

	@Before
	public void setUp() throws Exception {
		restTemplate = new TestRestTemplate(); 
	}

	@Test
	public void testGetTestResultListSuccess() throws URISyntaxException {    
		final String baseUrl = "http://localhost:" + randomServerPort + "/all";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.withBasicAuth("jUnit","jUnit").getForEntity(uri, String.class);

		//Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		//Verify body 
		assertEquals(true, result.getBody().contains("id"));
		assertEquals(true, result.getBody().contains("device_id"));
		assertEquals(true, result.getBody().contains("test_type"));
		assertEquals(true, result.getBody().contains("test_type_id"));
		assertEquals(true, result.getBody().contains("test_timestamp"));
		assertEquals(true, result.getBody().contains("gps_lat"));
		assertEquals(true, result.getBody().contains("gps_long"));
		assertEquals(true, result.getBody().contains("latency"));
		assertEquals(true, result.getBody().contains("download"));
		assertEquals(true, result.getBody().contains("upload"));
		assertEquals(true, result.getBody().contains("signalStrength"));
		assertEquals(true, result.getBody().contains("operator"));
		assertEquals(true, result.getBody().contains("additional_info"));
	}

	@Test
	public void testGetSingleResultSuccess() throws URISyntaxException {
		final String baseUrl = "http://localhost:" + randomServerPort + "/result/1";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.withBasicAuth("jUnit","jUnit").getForEntity(uri, String.class);

		//Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
		//Verify body 
		assertEquals(true, result.getBody().contains("id"));
		assertEquals(true, result.getBody().contains("device_id"));
		assertEquals(true, result.getBody().contains("test_type"));
		assertEquals(true, result.getBody().contains("test_type_id"));
		assertEquals(true, result.getBody().contains("test_timestamp"));
		assertEquals(true, result.getBody().contains("gps_lat"));
		assertEquals(true, result.getBody().contains("gps_long"));
		assertEquals(true, result.getBody().contains("latency"));
		assertEquals(true, result.getBody().contains("download"));
		assertEquals(true, result.getBody().contains("upload"));
		assertEquals(true, result.getBody().contains("signalStrength"));
		assertEquals(true, result.getBody().contains("operator"));
		assertEquals(true, result.getBody().contains("additional_info"));
	}

	@Test
	public void testGetTestResultListError() throws URISyntaxException
	{    
		final String baseUrl = "http://localhost:" + randomServerPort + "/all";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.withBasicAuth("error","error").getForEntity(uri, String.class);

		//Verify request response is http 401
		assertEquals(401, result.getStatusCodeValue());        
	}
	
	@Test
	public void testGetSingleTestResultError() throws URISyntaxException
	{    
		final String baseUrl = "http://localhost:" + randomServerPort + "/result/1";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.withBasicAuth("error","error").getForEntity(uri, String.class);

		//Verify request response is http 401
		assertEquals(401, result.getStatusCodeValue());        
	}

}
*/