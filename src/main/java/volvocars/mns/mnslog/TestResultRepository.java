package volvocars.mns.mnslog;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import volvocars.mns.mnslog.TestResult;

public interface TestResultRepository extends CrudRepository<TestResult, Integer> {
	
	@Query(value = "SELECT * FROM test_result r where r.DEVICE_ID = ?1",
			nativeQuery = true)
	List<TestResult> getDeviceResults(String device_id);
	
	@Query(value = "SELECT * FROM test_result WHERE ID IN ("
			+ "SELECT MAX(ID) AS ID FROM test_result r WHERE r.DEVICE_ID = ?1 "
			+ "AND r.TEST_TIMESTAMP >= DATE_SUB(NOW(), INTERVAL ?2 minute))",
			nativeQuery = true)
	Optional<TestResult> getDeviceStatus(String device_id, Integer interval);
	
	@Query(value="SELECT ID, NOW() AS TIMESTAMP FROM test_result r "
			+ "WHERE r.ID IN (SELECT MAX(ID) AS ID FROM test_result)",
			nativeQuery = true)
	List<TestResult> getAliveQuery();
	
}
