package volvocars.mns.mnslog;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class TestResult {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String device_id;
    private String test_type;
    private String test_type_id;
    private Timestamp test_timestamp;
    private Double gps_lat;
    private Double gps_long;
    private String gps_url;
    private Double latency;
    private String download;
    private String upload;
    private String iperfServer;
    private String signalStrength;
    private String operator;
    private String additional_info;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getTest_type() {
		return test_type;
	}
	public void setTest_type(String test_type) {
		this.test_type = test_type;
	}
	public String getTest_type_id() {
		return test_type_id;
	}
	public void setTest_type_id(String test_type_id) {
		this.test_type_id = test_type_id;
	}
	public Timestamp getTest_timestamp() {
		return test_timestamp;
	}
	public void setTest_timestamp(Timestamp test_timestamp) {
		this.test_timestamp = test_timestamp;
	}
	public Double getGps_lat() {
		return gps_lat;
	}
	public void setGps_lat(Double gps_lat) {
		this.gps_lat = gps_lat;
	}
	public Double getGps_long() {
		return gps_long;
	}
	public void setGps_long(Double gps_long) {
		this.gps_long = gps_long;
	}
	public Double getLatency() {
		return latency;
	}
	public void setLatency(Double latency) {
		this.latency = latency;
	}
	public String getDownload() {
		return download;
	}
	public void setDownload(String download) {
		this.download = download;
	}
	public String getUpload() {
		return upload;
	}
	public void setUpload(String upload) {
		this.upload = upload;
	}
	public String getSignalStrength() {
		return signalStrength;
	}
	public void setSignalStrength(String signalStrength) {
		this.signalStrength = signalStrength;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getAdditional_info() {
		return additional_info;
	}
	public void setAdditional_info(String additional_info) {
		this.additional_info = additional_info;
	}
	
	public String toSplunkString() {
		StringBuffer sb = new StringBuffer();		
		sb.append("New test_result added: ");
		sb.append("[id=" + this.getId() + "]");
		sb.append("[test_timestamp=" + this.getTest_timestamp().toString() + "]");
		sb.append("[device_id=" + this.getDevice_id() + "]");
		sb.append("[test_type=" + this.getTest_type() + "]");
		sb.append("[test_type_id=" + this.getTest_type_id() + "]");		
		sb.append("[gps_lat=" + this.getGps_lat() + "]");
		sb.append("[gps_long=" + this.getGps_long() + "]");
		sb.append("[gps_url=" + this.getGps_url() + "]");
		sb.append("[latency=" + this.getLatency() + "]");
		sb.append("[download=" + this.getDownload() + "]");
		sb.append("[upload=" + this.getUpload() + "]");
		sb.append("[signalStrength=" + this.getSignalStrength() + "]");
		sb.append("[operator=" + this.getOperator() + "]");
		sb.append("[additional_info=" + this.getAdditional_info() + "]");		
		return sb.toString();				
	}
	
	public String getGps_url() {
		return gps_url;
	}
	public void setGps_url(String gps_url) {
		this.gps_url = gps_url;
	}
	public String getIperfServer() {
		return iperfServer;
	}
	public void setIperfServer(String iperfServer) {
		this.iperfServer = iperfServer;
	}
}