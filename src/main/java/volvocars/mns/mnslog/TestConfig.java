package volvocars.mns.mnslog;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestConfig {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer config_id;
    private String device_id;
    private Timestamp last_updated;
    private String reportEndpoint;
    private String reportAdditionalInfo;
    private Boolean reportHasGps;
    private String pingServer;
    private int pingEchos;
    private String iperfServer;
    private String iperfProtocol;
    
    public String toSplunkString() {
		StringBuffer sb = new StringBuffer();		
		sb.append("New test_config added: ");
		sb.append("[config_id=" + this.getConfig_id() + "]");
		sb.append("[last_updated=" + this.getLast_updated().toString() + "]");
		sb.append("[device_id=" + this.getDevice_id() + "]");
		sb.append("[reportEndpoint=" + this.getReportEndpoint() + "]");
		sb.append("[reportAdditionalInfo=" + this.getReportAdditionalInfo() + "]");		
		sb.append("[reportHasGps=" + this.getReportHasGps() + "]");
		sb.append("[pingServer=" + this.getPingServer() + "]");
		sb.append("[pingEchos=" + this.getPingEchos() + "]");
		sb.append("[iperfServer=" + this.getIperfServer() + "]");
		sb.append("[iperfProtocol=" + this.getIperfProtocol() + "]");	
		return sb.toString();				
	}
    
    
	public Integer getConfig_id() {
		return config_id;
	}
	public void setConfig_id(Integer config_id) {
		this.config_id = config_id;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public Timestamp getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(Timestamp last_updated) {
		this.last_updated = last_updated;
	}
	public String getReportEndpoint() {
		return reportEndpoint;
	}
	public void setReportEndpoint(String reportEndpoint) {
		this.reportEndpoint = reportEndpoint;
	}
	public String getReportAdditionalInfo() {
		return reportAdditionalInfo;
	}
	public void setReportAdditionalInfo(String reportAdditionalInfo) {
		this.reportAdditionalInfo = reportAdditionalInfo;
	}
	public Boolean getReportHasGps() {
		return reportHasGps;
	}
	public void setReportHasGps(Boolean reportHasGps) {
		this.reportHasGps = reportHasGps;
	}
	public String getPingServer() {
		return pingServer;
	}
	public void setPingServer(String pingServer) {
		this.pingServer = pingServer;
	}
	public int getPingEchos() {
		return pingEchos;
	}
	public void setPingEchos(int pingEchos) {
		this.pingEchos = pingEchos;
	}
	public String getIperfServer() {
		return iperfServer;
	}
	public void setIperfServer(String iperfServer) {
		this.iperfServer = iperfServer;
	}
	public String getIperfProtocol() {
		return iperfProtocol;
	}
	public void setIperfProtocol(String iperfProtocol) {
		this.iperfProtocol = iperfProtocol;
	}
    

}
