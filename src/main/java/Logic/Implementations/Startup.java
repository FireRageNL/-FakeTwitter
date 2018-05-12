package Logic.Implementations;

import Entities.Account;
import Entities.Kweet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	final Logger logger = LoggerFactory.getLogger(Startup.class);

	public Startup() {

	}

	@PostConstruct
	public void dataInit() {
		try {
			Account testAccount = new Account("TestAccount1","test","test@email.com");
			Account testAccount2 = new Account("TestAccount2","test","test@email.nl");
			Account testAccount3 = new Account("test","test","spam@spam.nl");
			testAccount.setBiography("Testing!");
			testAccount2.setBiography("Teeesting!");
			testAccount3.setBiography("Wheeeeee!");

			testAccount = usrLogic.addUserToCollection(testAccount);
			testAccount2 = usrLogic.addUserToCollection(testAccount2);
			testAccount3 = usrLogic.addUserToCollection(testAccount3);

			usrLogic.addFollower(testAccount2,testAccount);

			Kweet kweet1 = new Kweet("Look at my kweet, my kweet is amazing",testAccount);
			Kweet kweet2 = new Kweet("I am the master of Kweets :D",testAccount);
			Kweet kweet3 = new Kweet("Wow what an amazing kweet application",testAccount3);

			weebLogic.addNewKweet(kweet1);
			weebLogic.addNewKweet(kweet2);
			weebLogic.addNewKweet(kweet3);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
