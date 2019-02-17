package code;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jota.IotaAPI;
import jota.dto.response.SendTransferResponse;
import jota.error.ArgumentException;
import jota.model.Transaction;
import jota.model.Transfer;

public class Utils {
	public String convertStringToTrytes(String input) {
		// If input is not a string, return null

		String TRYTE_VALUES = "9ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String trytes = "";

		for (int i = 0; i < input.length(); i++) {
			char chara = input.charAt(i);
			int asciiValue = (int)chara;
			if (asciiValue > 255) {
				//asciiValue = 32
				return null;
			}

			int firstValue = asciiValue % 27;
			int secondValue = (asciiValue - firstValue) / 27;

			String trytesValue = TRYTE_VALUES.substring(firstValue, firstValue+1) + TRYTE_VALUES.substring(secondValue, secondValue+1);

			trytes += trytesValue;
		}
		//system.out.println("trytes: " + trytes);
		return trytes;
	}

	public String convertStringFromTrytes(String inputTrytes) {

		String TRYTE_VALUES = "9ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String outputString = "";
		for (int i = 0; i < inputTrytes.length(); i += 2) {
			// get a trytes pair
			String trytes = inputTrytes.substring(i, i+1) + inputTrytes.substring(i+1, i+2);

			int firstValue = TRYTE_VALUES.indexOf(trytes.charAt(0));
			int secondValue = TRYTE_VALUES.indexOf(trytes.charAt(1));

			int decimalValue = firstValue + secondValue * 27;

			char character = (char)(decimalValue);

			outputString += character;
		}
		return outputString;
	}

	public String checkCertificate(Certificatee certificatee) {
		String[] addresses = new String[1];
		addresses[0] = certificatee.certificatee_public_address;
		////system.out.println(MESSAGE);
		//turn to trytes
		String result = "";

		String TAG = "REVOKECERTIFICATE";
		int MIN_WEIGHT_MAGNITUDE = 9;
		int DEPTH = 1;

		IotaAPI iotaAPI = new IotaAPI.Builder()
				.protocol("https")
				.host("nodes.devnet.thetangle.org")
				.port("443")
				.build();
		try {

			////system.out.println(response);
			List<Transaction> transactions = iotaAPI.findTransactionObjectsByAddresses(addresses);
			for(Transaction transaction: transactions) {
				//system.out.println(transaction.toString());
				String piece = (transaction.getSignatureFragments());
				int index = piece.indexOf("9999999");
				piece = piece.substring(0, index);
				if(piece.length()!=0) {
					if(transaction.getTag().contains("GRANT")) {
						result = result + "GRANTED " + this.convertStringFromTrytes(piece) + "\n";
					}else {
						result = result + "REVOKED " + this.convertStringFromTrytes(piece) + "\n";
					}
					
				}
			}
			return result;
		} catch (ArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}


