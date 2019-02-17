package code;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jota.IotaAPI;
import jota.dto.response.GetNodeInfoResponse;
import jota.dto.response.SendTransferResponse;
import jota.error.ArgumentException;
import jota.model.Transaction;
import jota.model.Transfer;

public class Certificater {
	public String certificater_name;
	public String certificater_public_address;
	public ArrayList<Certificatee> certificatees;
	public String getCertificater_name() {
		return certificater_name;
	}
	public void setCertificater_name(String certificater_name) {
		this.certificater_name = certificater_name;
	}
	public String getCertificater_public_address() {
		return certificater_public_address;
	}
	public void setCertificater_public_address(String certificater_public_address) {
		this.certificater_public_address = certificater_public_address;
	}
	public ArrayList<Certificatee> getCertificatees() {
		return certificatees;
	}
	public void setCertificatees(ArrayList<Certificatee> certificatees) {
		this.certificatees = certificatees;
	}
	
	public void verifyCertificate(Certificatee certificatee, Certificate certificate) {
		String SEED = this.certificater_public_address;
	    String ADDRESS = certificatee.getCertificatee_public_address();
	    String MESSAGE = certificate.toString();
	    //System.out.println(MESSAGE);
	    //turn to trytes
	    
	    String TAG = "GRANTCERTIFICATE";
	    int MIN_WEIGHT_MAGNITUDE = 9;
	    int DEPTH = 1;
	    List<Transfer> transfers = new ArrayList<Transfer>();
        List<Transaction> tips = new ArrayList<Transaction>();
       
        String tryte_msg = new Utils().convertStringToTrytes(MESSAGE);
        String orignal_msg = new Utils().convertStringFromTrytes(tryte_msg);
        transfers.add(new Transfer(ADDRESS, 0, StringUtils.rightPad(tryte_msg, 2188, '9'), TAG));
        
        IotaAPI iotaAPI = new IotaAPI.Builder()
                .protocol("https")
                .host("nodes.devnet.thetangle.org")
                .port("443")
                .build();
        try {
			
			SendTransferResponse str = iotaAPI.sendTransfer(SEED, 2, DEPTH, MIN_WEIGHT_MAGNITUDE, transfers, null, null, false, false, tips);
			System.out.println(str.toString());
//			System.out.println(tryte_msg);
        } catch (ArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void revokeCertificate(Certificatee certificatee, Certificate certificate) {
		String SEED = this.certificater_public_address;
	    String ADDRESS = certificatee.getCertificatee_public_address();
	    String MESSAGE = certificate.toString();
	    //System.out.println(MESSAGE);
	    //turn to trytes
	    
	    String TAG = "REVOKECERTIFICATE";
	    int MIN_WEIGHT_MAGNITUDE = 9;
	    int DEPTH = 1;
	    List<Transfer> transfers = new ArrayList<Transfer>();
        List<Transaction> tips = new ArrayList<Transaction>();
       
        String tryte_msg = new Utils().convertStringToTrytes(MESSAGE);
        String orignal_msg = new Utils().convertStringFromTrytes(tryte_msg);
        transfers.add(new Transfer(ADDRESS, 0, StringUtils.rightPad(tryte_msg, 2188, '9'), TAG));
        
        IotaAPI iotaAPI = new IotaAPI.Builder()
                .protocol("https")
                .host("nodes.devnet.thetangle.org")
                .port("443")
                .build();
        try {
			
			//System.out.println(response);
			SendTransferResponse str = iotaAPI.sendTransfer(SEED, 1, DEPTH, MIN_WEIGHT_MAGNITUDE, transfers, null, null, false, false, tips);
			System.out.println(str.toString());
			//System.out.println(tryte_msg);
        } catch (ArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
