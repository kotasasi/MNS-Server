package volvocars.mns.mnslog;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MoSms {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int moId;
	private String msisdn;
	private String scode;
	private String msg;
	private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	
	 public String toSplunkString() {
			StringBuffer sb = new StringBuffer();		
			sb.append("New mo_sms received: ");
			sb.append("[mo_id=" + this.getId() + "]");
			sb.append("[mo_msisdn=" + this.getMsisdn() + "]");
			sb.append("[mo_scode=" + this.getScode() + "]");
			sb.append("[mo_msg=" + this.getMsg() + "]");
			sb.append("[mo_timestamp=" + this.getTimestamp().toString() + "]");
			return sb.toString();
	 }


	public int getId() {
		return moId;
	}


	public void setId(int moId) {
		this.moId = moId;
	}


	public String getMsisdn() {
		return msisdn;
	}


	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}


	public String getScode() {
		return scode;
	}


	public void setScode(String scode) {
		this.scode = scode;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
