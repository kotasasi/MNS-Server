package volvocars.mns.mnslog;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MoSmsRepository extends CrudRepository<MoSms, Integer> {
	
	@Query(value = "SELECT * FROM mo_sms WHERE mo_id IN "
			+ "(SELECT MAX(mo_id) FROM mo_sms r WHERE r.msisdn = ?1 "
			+ "AND r.timestamp >= DATE_SUB(NOW(), INTERVAL ?2 minute))",
			nativeQuery = true)
	Optional<MoSms> getRecentMoSms(String msisdn, Integer interval);

}
