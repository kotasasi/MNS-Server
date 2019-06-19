package volvocars.mns.mnslog;

public class DeviceConfigNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	DeviceConfigNotFoundException(String id) {
		super("Could not find any config for device: " + id);
	}

}
