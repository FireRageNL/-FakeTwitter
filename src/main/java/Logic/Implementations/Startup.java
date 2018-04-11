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
			Account testAccount = new Account("Hello","test","test@email.com");
			testAccount.setBiography("Testing!");
			usrLogic.addUserToCollection(testAccount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
