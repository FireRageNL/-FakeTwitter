package Logic.Implementations;

import Entities.Account;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Singleton
@javax.ejb.Startup
public class Startup {

	@Inject
	UserLogic usrLogic;

	public Startup() {

	}

	@PostConstruct
	public void dataInit() {
		try {
			Account testAccount = new Account("TestAccount1","test","test@email.com");
			Account testAccount2 = new Account("TestAccount2","test","test@email.nl");
			testAccount.setBiography("Testing!");
			testAccount2.setBiography("Teeesting!");
			usrLogic.addUserToCollection(testAccount);
			usrLogic.addUserToCollection(testAccount2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
