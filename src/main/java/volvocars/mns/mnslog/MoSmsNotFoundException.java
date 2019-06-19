package volvocars.mns.mnslog;

public class MoSmsNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	MoSmsNotFoundException(Integer id) {
		super("Could not find moSms with id: " + id);
	}
	
	MoSmsNotFoundException() {
		super("Could not find any moSms with the defined search-criteria.");
	}
	
}
