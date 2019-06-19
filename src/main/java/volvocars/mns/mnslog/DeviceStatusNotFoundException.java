package volvocars.mns.mnslog;

public class DeviceStatusNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DeviceStatusNotFoundException(String device_id, Integer interval) {
		super("No test_result found for device " + device_id 
				+ " within the last " + interval + " minutes");
	}

}
