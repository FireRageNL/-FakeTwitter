package BLL.Utilities;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;


public  class Hashing {

	public static String generatePasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {

		byte[] salt = getSalt();
		int iterations = 2500;

		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(),salt,iterations,256);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		byte[] hash = skf.generateSecret(spec).getEncoded();

		BigInteger i = new BigInteger(1,hash);
		BigInteger i2 = new BigInteger(1,salt);
		String output = iterations + ":" + String.format("%064x",i2) + ":" + String.format("%064x",i);

		System.out.println(output);
		return output;
	}


	public static byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[32];
		rand.nextBytes(salt);
		return salt;
	}

	public static boolean verifyPassword(String passwordHash, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {

		String[] hashArray = passwordHash.split(":");
		byte[] salt = hashArray[1].getBytes();
		int iterations = Integer.parseInt(hashArray[0]);

		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(),salt,iterations,256);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		byte[] hash = skf.generateSecret(spec).getEncoded();

		BigInteger i = new BigInteger(1,hash);
		String toVerify =  String.format("%064x",i);

		if(toVerify.equals(hashArray[2])){
			return true;
		}
		return false;


	}
}
