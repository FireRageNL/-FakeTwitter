import Dao.Implementations.Collections.UserCollectionDAO;
import Entities.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class AccountCollectionDAOTest {

	private UserCollectionDAO uDAO;

	@Before
	public void Setup(){
		uDAO = new UserCollectionDAO();
		Account u1 = new Account("Test","FakePasswordHash","FakeMail@fake.com",1);
		Account u2 = new Account("Test2","AnotherFakePasswordHash","Another@fakemail.coom",2);

		uDAO.add(u1);
		uDAO.add(u2);
	}

	@Test
	public void FindById_IdInCollection_ReturnsUser(){
		Account toFind = uDAO.findById(1);

		Assert.assertEquals("Test",toFind.getUsername());
	}

	@Test
	public void FindById_IdNotInCollection_ReturnsNull(){
		Assert.assertNull(uDAO.findById(3));
	}

	@Test
	public void Count_TwoUsersInDatabase_ReturnsTwo(){
	Assert.assertEquals(2,uDAO.countUsers());
	}

	@Test
	public void AddUser_NewUser_ReturnsNewUser(){
		Account toAdd = new Account("Testing","ShortHash","WhatWhat@no.com",3);

		Account addedAccount = uDAO.add(toAdd);

		Assert.assertEquals("Testing", addedAccount.getUsername());
	}
}
