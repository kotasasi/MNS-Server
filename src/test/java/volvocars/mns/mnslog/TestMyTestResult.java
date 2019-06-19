package volvocars.mns.mnslog;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import volvocars.mns.mnslog.TestResult;

public class TestMyTestResult {
	
	private TestResult testObject;
	private static final Logger LOGGER = LogManager.getLogger(TestMyTestResult.class.getName());

	@Before
	public void setUp() throws Exception {
		testObject = new TestResult();
	}

	@Test
	public void testId() {
		Integer id = 1000;		
		testObject.setId(id);
		LOGGER.debug("Running testId()");
		assertEquals("Assert ID parameter set and get", id, testObject.getId());		
	}
	
	@Test
	public void testDevice_id() {
		String deviceId = "Some device ID";
		testObject.setDevice_id(deviceId);
		LOGGER.info("Running testDevice_id()");
		assertEquals("Assert DeviceId set and get", deviceId, testObject.getDevice_id());		
	}
	
	@Test
	public void testTest_type() {
		String testType = "Some testType";
		testObject.setTest_type(testType);
		assertEquals("Assert TestType set and get", testType, testObject.getTest_type());		 
	}
	
	@Test
	public void testTest_type_id() {
		String test_type_id = "Some testTypeId";
		testObject.setTest_type_id(test_type_id);
		assertEquals("Assert TestType set and get", test_type_id, testObject.getTest_type_id());
	}
	
	@Test
	public void testTimestamp() {
		@SuppressWarnings("deprecation")
		Timestamp time = new Timestamp(2000,01,01,12,00,00,00);
		testObject.setTest_timestamp(time);
		assertEquals("Assert timestamp", time, testObject.getTest_timestamp());
	}
	
	@Test
	public void testGps_lat() {
		Double lat = 57.633825;
		testObject.setGps_lat(lat);
		assertEquals("Assert GPS lat", lat, testObject.getGps_lat());
	}
	
	@Test
	public void testGps_long() {
		Double lon = 11.606126;
		testObject.setGps_long(lon);
		assertEquals("Assert GPS long", lon, testObject.getGps_long());
	}
	
	@Test
	public void testLatency() {
		Double latency = 111.111111;
		testObject.setLatency(latency);
		assertEquals("Assert latency", latency, testObject.getLatency());
	}
	
	@Test
	public void testDownload() {
		String download = "Some download speed in Mbit/s";
		testObject.setDownload(download);
		assertEquals("Assert download", download, testObject.getDownload());			
	}
	
	@Test
	public void testUpload() {
		String upload = "Some upload speed in Mbit/s";
		testObject.setUpload(upload);
		assertEquals("Assert upload", upload, testObject.getUpload());			
	}
	
	@Test
	public void testSignalStrength() {
		String signal = "Some signal strength in rssi";
		testObject.setSignalStrength(signal);
		assertEquals("Assert signal", signal, testObject.getSignalStrength());			
	}
	
	@Test
	public void testOperator() {
		String operator = "Some MNO";
		testObject.setOperator(operator);
		assertEquals("Assert operator", operator, testObject.getOperator());	
	}
	
	@Test
	public void testAdditional_info() {
		String additional_info = "Additional info such as tags for Splunk logs";
		testObject.setAdditional_info(additional_info);
		assertEquals("Assert additional_info", additional_info, testObject.getAdditional_info());	
	}
	
	@Test
	public void testGpsUrl() {
		String url = "https://www.openstreetmap.org/?mlat=57.70716&mlon=11.96679&zoom=15";
		testObject.setGps_url(url);
		assertEquals("Assert gps_url", url, testObject.getGps_url());
	}
	
	@Test
	public void testIperfServer() {
		String iperfServer = "3.120.169.210";
		testObject.setIperfServer(iperfServer);
		assertEquals("Assert iperf3 server", iperfServer, testObject.getIperfServer());
	}

}
