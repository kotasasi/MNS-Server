package volvocars.mns.mnslog;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import volvocars.mns.mnslog.TestResult;
import volvocars.mns.mnslog.TestResultRepository;
import volvocars.mns.mnslog.TestResultNotFoundException;
import volvocars.mns.mnslog.DeviceStatusNotFoundException;

@RestController
@RequestMapping(path="/")
public class TestResultController {
	
	private static final Logger LOGGER = LogManager.getLogger(TestResultController.class.getName());
	
	@Autowired 
	private TestResultRepository resultRepository;

	@PostMapping(path="/result")
	TestResult newResult(@RequestBody TestResult newResult) {
		TestResult tr = resultRepository.save(newResult);
		LOGGER.info(tr.toSplunkString());
		return tr;
	}
	
	@GetMapping(path="/result/{id}")
	TestResult one(@PathVariable Integer id) {
		return resultRepository.findById(id)
				.orElseThrow(() -> new TestResultNotFoundException(id));
	}
	
	@DeleteMapping(path="result/{id}")
	void deleteResult(@PathVariable Integer id) {
		resultRepository.deleteById(id);
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<TestResult> getAllUsers() {
		// This returns a JSON or XML with the users
		return resultRepository.findAll();
	}
	
	@GetMapping(path="/all/{device_id}")
	Iterable<TestResult> getDeviceResults(@PathVariable String device_id) {
		return resultRepository.getDeviceResults(device_id);
	}
	
	@GetMapping(path="/status/")
	TestResult one(
			@RequestParam(value="device_id", defaultValue="GOT5CG727382G") String device_id, 
			@RequestParam(value="interval", defaultValue="120") int interval) {
		return resultRepository.getDeviceStatus(device_id, interval)
				.orElseThrow(() -> new DeviceStatusNotFoundException(device_id, interval));
	}
	
	@GetMapping(path="/alive/")
	public @ResponseBody String aliveCheck() {
		//List<TestResult> result = resultRepository.getAliveQuery();
		//String timeNow = result.get(0).getTest_timestamp().toString();
		 //LOGGER.debug("Debug Message Logged !!!");
	     //LOGGER.info("Info Message Logged !!!");	     
		return "Alive";
	}
	
}