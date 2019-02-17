package code;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Certificate {
	public String certificate_name;
	public Date issued_Date;
	public Date expired_Date;
	public String certificate_description;
	public String getCertificate_name() {
		return certificate_name;
	}
	public void setCertificate_name(String certificate_name) {
		this.certificate_name = certificate_name;
	}
	public Date getIssued_Date() {
		return issued_Date;
	}
	public void setIssued_Date(Date issued_Date) {
		this.issued_Date = issued_Date;
	}
	public Date getExpired_Date() {
		return expired_Date;
	}
	public void setExpired_Date(Date expired_Date) {
		this.expired_Date = expired_Date;
	}
	public String getCertificate_description() {
		return certificate_description;
	}
	public void setCertificate_description(String certificate_description) {
		this.certificate_description = certificate_description;
	}
	
	public String toString() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("certificate_name", certificate_name);
		map.put("issued_Date", issued_Date.toString());
		map.put("expired_Date", expired_Date.toString());
		map.put("certificate_description", certificate_description);
		JSONObject jo = new JSONObject(map);
		return jo.toString();
		
	}
	
}
