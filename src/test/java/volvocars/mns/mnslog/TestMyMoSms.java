package volvocars.mns.mnslog;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

public class TestMyMoSms {
	
	private MoSms testObject;
	
	@Before
	public void setUp() throws Exception {
		testObject = new MoSms();
		testObject.setId(1000);
		testObject.setMsg("Hello World");
		testObject.setMsisdn("id-1000000");
		testObject.setScode("Some code");
		testObject.setTimestamp(new Timestamp(2000000));	
	}

	@Test
	public void testId() {
		int id = 1001;		
		testObject.setId(id);
		assertEquals("Assert MoId parameter set and get", id, testObject.getId());		
	}
	
	@Test
	public void testMsg() {
		String msg = "This is a test message body";
		testObject.setMsg(msg);
		assertEquals("Assert message body", msg, testObject.getMsg());
	}
	
	@Test
	public void testMsisdn() {
		String msisdn = "myMSISDN-ID";
		testObject.setMsisdn(msisdn);
		assertEquals("Assert MSISDN id ", msisdn, testObject.getMsisdn());
	}
	
	@Test
	public void testScode() {
		String scode = "sCode-2000";
		testObject.setScode(scode);
		assertEquals("Assert Scode", scode, testObject.getScode());		
	}
	
	@Test
	public void testTimstamp() {
		Timestamp time = new Timestamp(2000000);
		testObject.setTimestamp(time);
		assertEquals("Assert timestamp", time, testObject.getTimestamp());
	}
}
