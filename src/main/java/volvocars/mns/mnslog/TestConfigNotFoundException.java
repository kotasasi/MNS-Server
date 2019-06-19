package volvocars.mns.mnslog;

public class TestConfigNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TestConfigNotFoundException(Integer id) {
		super("Could not find config with id: " + id);
	}
}