package Logic;

import Dao.Interfaces.IKweetDAO;
import Entities.Account;
import Entities.Kweet;
import Logic.Implementations.KweetLogic;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class KweetLogicTest {

	@Mock
	private IKweetDAO kweetDAO;

	private KweetLogic kl;

	private Account a1;
	private Kweet k1;

	@Before
	public void Setup(){
		MockitoAnnotations.initMocks(this);
		kl = new KweetLogic(kweetDAO);

		a1 = new Account("Hello","hello","hello@fakemail.com");
		k1 = new Kweet("Nyello",a1, new Date());
	}

	@Test
	public void AddKWeet_FullKweet_KweetAdded(){
		Kweet added = kl.addNewKweet(k1);

		verify(kweetDAO,times(1)).add(k1);
	}
}
