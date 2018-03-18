import Dao.Implementations.Collections.KweetCollectionDAO;
import Dao.Implementations.JPA.KweetDAO;
import Entities.Account;
import Entities.Kweet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class KweetCollectionDAOTest {

	private KweetCollectionDAO kweetDAO;

	@Before
	public void SetUp(){
		kweetDAO = new KweetCollectionDAO();

		Account u1 = new Account("Test","FakePasswordHash","FakeMail@fake.com",1);
		Account u2 = new Account("Test2","AnotherFakePasswordHash","Another@fakemail.coom",2);

		Kweet k1 = new Kweet("Hello !", u1,1);
		Kweet k2 = new Kweet("Bye!",u1,2);
		Kweet k3 = new Kweet("This is m,y first kweet!", u2,3);

		kweetDAO.add(k1);
		kweetDAO.add(k2);
		kweetDAO.add(k3);
	}

	@Test
	public void GetKweetById_KweetInDB_ReturnsKweet(){
		Kweet k = kweetDAO.findById(1);

		Assert.assertEquals(k.getMessageContents(),"Hello !");
	}

	@Test
	public void GetKweetById_KweetNotInDB_ReturnsNull(){
		Assert.assertNull(kweetDAO.findById(33));
	}


	@Test
	public void GetKweetsByUser_TwoInDb_ReturnsListOfTwo(){

		List<Kweet> allKweets = kweetDAO.getAllMessagesFromUser("Test");

		Assert.assertEquals(2,allKweets.size());
	}

	@Test
	public void AddKweet_returnsAddedKweet(){

		Account u2 = new Account("Test2","AnotherFakePasswordHash","Another@fakemail.coom",2);
		Kweet k = new Kweet("NewKweet",u2,4);

		Kweet returnedKweet = kweetDAO.add(k);

		Assert.assertEquals(k.getMessageContents(),returnedKweet.getMessageContents());
	}

}
