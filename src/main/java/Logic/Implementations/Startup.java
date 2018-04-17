package Logic.Implementations;

import Entities.Account;
import Entities.Kweet;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
@javax.ejb.Startup
public class Startup {

	@Inject
	UserLogic usrLogic;

	@Inject
	KweetLogic weebLogic;

	public Startup() {

	}

	@PostConstruct
	public void dataInit() {
		try {
			Account testAccount = new Account("TestAccount1","test","test@email.com");
			Account testAccount2 = new Account("TestAccount2","test","test@email.nl");
			testAccount.setBiography("Testing!");
			testAccount2.setBiography("Teeesting!");

			testAccount = usrLogic.addUserToCollection(testAccount);
			testAccount2 = usrLogic.addUserToCollection(testAccount2);

			Kweet kweet1 = new Kweet("Look at my kweet, my kweet is amazing",testAccount);
			Kweet kweet2 = new Kweet("I am the master of Kweets :D",testAccount);

			weebLogic.addNewKweet(kweet1);
			weebLogic.addNewKweet(kweet2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
