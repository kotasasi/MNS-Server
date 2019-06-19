package volvocars.mns.mnslog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/")
public class MoSmsController {
	
	private static final Logger LOGGER = LogManager.getLogger(MoSmsController.class.getName());
	
	@Autowired 
	private MoSmsRepository moSmsRepository;
	
	@PostMapping(path="/sms")
	MoSms newResult(@RequestBody MoSms newSms) {
		MoSms mo = moSmsRepository.save(newSms);
		LOGGER.info(mo.toSplunkString());
		return mo;
	}
	
	@GetMapping(path="/sms/{id}")
	MoSms one(@PathVariable Integer id) {
		return moSmsRepository.findById(id)
				.orElseThrow(() -> new MoSmsNotFoundException(id));
	}
	
	@GetMapping(path="/sms/recent")
	MoSms one(@RequestParam(value="msisdn", defaultValue="004912345") String msisdn, 
			@RequestParam(value="interval", defaultValue="5") int interval) {
		return moSmsRepository.getRecentMoSms(msisdn, interval)
				.orElseThrow(() -> new MoSmsNotFoundException());
	}
}
