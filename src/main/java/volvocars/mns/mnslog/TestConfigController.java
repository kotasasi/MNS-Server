package volvocars.mns.mnslog;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/")
public class TestConfigController {
	
	private static final Logger LOGGER = LogManager.getLogger(TestResultController.class.getName());
	
	@Autowired
	private TestConfigRepository configRepository;
	
	@PostMapping(path="/config")
	TestConfig newResult(@RequestBody TestConfig newConfig) {
		TestConfig tc = configRepository.save(newConfig);
		LOGGER.info(tc.toSplunkString());
		return tc;
	}
	
	@GetMapping(path="/config/{config_id}")
	TestConfig one(@PathVariable Integer config_id) {
		return configRepository.findById(config_id)
				.orElseThrow(() -> new TestConfigNotFoundException(config_id));
	}
	
	@PutMapping(path="/config/{config_id}")
	TestConfig saveConfig(@RequestBody TestConfig saveConfig, @PathVariable int config_id) {
		TestConfig tcOptional = configRepository.findById(config_id)
				.orElseThrow(() -> new TestConfigNotFoundException(config_id));
		saveConfig.setConfig_id(config_id);
		configRepository.save(saveConfig);
		return saveConfig;
	}
	
	@DeleteMapping(path="config/{config_id}")
	void deleteResult(@PathVariable Integer config_id) {
		configRepository.deleteById(config_id);
	}
	
	@GetMapping(path="/config/all")
	public @ResponseBody Iterable<TestConfig> getAllConfig() {
		// This returns a JSON or XML with the users
		return configRepository.findAll();
	}
	
	@GetMapping(path="/config")
	TestConfig one(
			@RequestParam(value="device_id", defaultValue="RPI-CAR-1") String device_id) {
		return configRepository.getDeviceConfig(device_id)
				.orElseThrow(() -> new DeviceConfigNotFoundException(device_id));
	}

}
