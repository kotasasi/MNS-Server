package volvocars.mns.mnslog;

public class TestResultNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TestResultNotFoundException(Integer id) {
		super("Could not find result with id: " + id);
	}

}
