package BLL.Utilities;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static javax.crypto.SecretKeyFactory.getInstance;

public  class Hashing {

	public static String generatePasswordHash(String password,String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(),salt.getBytes(),1000,256);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		byte[] hash = skf.generateSecret(spec).getEncoded();
		BigInteger i = new BigInteger(1,hash);
		return String.format("%064x",i);
	}

}
