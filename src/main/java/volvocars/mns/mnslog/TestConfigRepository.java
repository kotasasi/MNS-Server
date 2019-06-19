package volvocars.mns.mnslog;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TestConfigRepository extends CrudRepository<TestConfig, Integer>{
	
	@Query(value = "SELECT * FROM test_config WHERE CONFIG_ID IN ("
			+ "SELECT MAX(CONFIG_ID) AS CONFIG_ID FROM test_config r WHERE r.DEVICE_ID = ?1)",
			nativeQuery = true)
	Optional<TestConfig> getDeviceConfig(String device_id);

}
