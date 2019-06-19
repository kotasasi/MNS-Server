package volvocars.mns.mnslog;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

public class TestMyTestConfig {
	
	private TestConfig testObject;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		testObject = new TestConfig();
		testObject.setConfig_id(1000);
		testObject.setDevice_id("My device ID");		
		testObject.setLast_updated(new Timestamp(119, 2, 9, 8, 00, 00, 00));
		testObject.setReportEndpoint("https://mns-log.c3.volvocars.com/result/");
		testObject.setReportAdditionalInfo("@UNITTEST");
		testObject.setReportHasGps(false);
		testObject.setPingServer("8.8.8.8");
		testObject.setPingEchos(15);
		testObject.setIperfServer("ping.online.net");
		testObject.setIperfProtocol("tcp");		
	}

	@Test
	public void testId() {
		Integer id = 1001;		
		testObject.setConfig_id(id);
		assertEquals("Assert ConfigId parameter set and get", id, testObject.getConfig_id());		
	}
	
	@Test
	public void testDeviceId() {
		String id = "My new device ID";
		testObject.setDevice_id(id);
		assertEquals("Assert DeviceId parameter set and get", id, testObject.getDevice_id());
	}
	
	@Test
	public void testLastUpdatedTimestamp() {
		@SuppressWarnings("deprecation")
		Timestamp time = new Timestamp(2019,03,10,12,00,00,00);
		testObject.setLast_updated(time);;
		assertEquals("Assert LastUpdated set and get", time, testObject.getLast_updated());
	}
	
	@Test
	public void testReportEndpoint() {
		String endpoint = "8.8.8.8";
		testObject.setReportEndpoint(endpoint);
		assertEquals("Assert ReportEndpoint parameter set and get", endpoint, testObject.getReportEndpoint());		
	}
	
	@Test
	public void testReportAdditionalInfo() {
		String additionalInfo = "@TEST @MyDevice @SomethingIWantToTag";
		testObject.setReportAdditionalInfo(additionalInfo);
		assertEquals("Assert AdditionalInfo parameter set and get", additionalInfo, testObject.getReportAdditionalInfo());
	}
	
	@Test
	public void testReportHasGps() {
		Boolean hasGps = true;
		testObject.setReportHasGps(hasGps);
		assertEquals("Assert ReportHasGps parameter set and get", hasGps, testObject.getReportHasGps());
	}
	
	@Test
	public void testPingServer() {
		String pingServer = "8.8.8.8";
		testObject.setPingServer(pingServer);
		assertEquals("Assert PingServer parameter set and get", pingServer, testObject.getPingServer());
	}
	
	@Test
	public void testPingEchos() {
		int pingEchos = 10;
		testObject.setPingEchos(pingEchos);
		assertEquals("Assert PingEchos parameter set and get", pingEchos, testObject.getPingEchos());
	}

	@Test
	public void testIperfServer() {
		String iperfServer = "8.8.8.8";
		testObject.setIperfServer(iperfServer);
		assertEquals("Assert IperfServer parameter set and get", iperfServer, testObject.getIperfServer());
	}
	
	@Test
	public void testIperfProtocol() {
		String iperfProtocol = "tcp";
		testObject.setIperfProtocol(iperfProtocol);
		assertEquals("Assert IperfProtocol parameter set and get", iperfProtocol, testObject.getIperfProtocol());
	}
	
	@Test
	public void testToSplunkString() {
		String expected = "New test_config added: "
				+ "[config_id=1000]"
				+ "[last_updated=2019-03-09 08:00:00.0]"
				+ "[device_id=My device ID]"
				+ "[reportEndpoint=https://mns-log.c3.volvocars.com/result/]"
				+ "[reportAdditionalInfo=@UNITTEST]"
				+ "[reportHasGps=false]"
				+ "[pingServer=8.8.8.8]"
				+ "[pingEchos=15]"
				+ "[iperfServer=ping.online.net]"
				+ "[iperfProtocol=tcp]";
		assertEquals("Assert ToSplunkString layout", expected, testObject.toSplunkString());		
	}
}
