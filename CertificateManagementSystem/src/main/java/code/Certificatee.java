package code;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jota.IotaAPI;
import jota.dto.response.GetNodeInfoResponse;
import jota.dto.response.SendTransferResponse;
import jota.error.ArgumentException;
import jota.model.Transaction;
import jota.model.Transfer;
import jota.utils.Converter;

public class Certificatee {
	public String certificatee_name;
	public String certificatee_public_address;
	public ArrayList<Certificate> verified_certificate;
	public String getCertificatee_name() {
		return certificatee_name;
	}
	public void setCertificatee_name(String certificatee_name) {
		this.certificatee_name = certificatee_name;
	}
	public String getCertificatee_public_address() {
		return certificatee_public_address;
	}
	public void setCertificatee_public_address(String certificatee_public_address) {
		this.certificatee_public_address = certificatee_public_address;
	}
	public ArrayList<Certificate> getVerified_certificate() {
		return verified_certificate;
	}
	public void setVerified_certificate(ArrayList<Certificate> verified_certificate) {
		this.verified_certificate = verified_certificate;
	}
	
}
