package code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jota.IotaAPI;
import jota.dto.response.GetNodeInfoResponse;
import jota.dto.response.SendTransferResponse;
import jota.error.ArgumentException;
import jota.model.Transaction;
import jota.model.Transfer;

public class Driver {

	public static void main(String[] args) {
			
		Certificate certificate1 = new Certificate();
		certificate1.certificate_name = "Certificate_1";
		certificate1.expired_Date = new Date();
		certificate1.issued_Date = new Date();
		
		Certificate certificate2 = new Certificate();
		certificate2.certificate_name = "Certificate_2";
		certificate2.expired_Date = new Date();
		certificate2.issued_Date = new Date();
		
		Certificatee certificatee = new Certificatee();
		certificatee.setCertificatee_public_address("HEQLOWORLDHELLOWORLDHELLOWORLDHELLOWORLDHELLOWORLDHELLOWORLDHELLOWORLDHELLOWORHAA");
		Certificater certificater = new Certificater();
		certificater.setCertificater_public_address("PUEOTSEITFEVEWCWBTSIZM9NKRGJEIMXTULBACGFRQK9IMGICLBKW9TTEVSDQMGWKBXPVCBMMCXWMNPBB");
		certificater.verifyCertificate(certificatee, certificate1);
		certificater.verifyCertificate(certificatee, certificate2);
		
		System.out.println("revoking");
		certificater.revokeCertificate(certificatee, certificate1);
		String check = new Utils().checkCertificate(certificatee);
		System.out.println(check);
		
		System.exit(0);

	}

}
