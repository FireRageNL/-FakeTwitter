package Collection;

import Dao.Implementations.Collections.TrendCollectionDAO;
import Entities.Account;
import Entities.Kweet;
import Entities.Trend;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TrendCollectionDAOTest {

	private TrendCollectionDAO trendDao;
	@Before
	public void SetUp(){
		trendDao = new TrendCollectionDAO();

		Account u1 = new Account("Test","FakePasswordHash","FakeMail@fake.com",1);

		Kweet k1 = new Kweet("hello #there", u1,1);
		Kweet k2 = new Kweet("Bye! #there",u1,2);
		ArrayList<Kweet> thereTrend = new ArrayList<>();
		thereTrend.add(k1);
		thereTrend.add(k2);

		Trend t1 = new Trend(1,"Testing",new ArrayList<>());
		Trend t2 = new Trend(2,"there",thereTrend);

		trendDao.add(t1);
		trendDao.add(t2);
	}

	@Test
	public void GetTrendById_TrendInDB_ReturnsTrend(){
		Trend t = trendDao.findById(1);

		Assert.assertEquals("Testing",t.getName());
	}

	@Test
	public void GetTrendByID_TrendNotInDB_ReturnsNull(){
		Assert.assertNull(trendDao.findById(100));
	}

}
