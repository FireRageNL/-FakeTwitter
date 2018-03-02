import DAL.Implementations.UserCollectionDAO;
import entities.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


public class UserCollectionDAOTest {

	private UserCollectionDAO uDAO;

	@Before
	public void Setup(){
		uDAO = new UserCollectionDAO();
		User u1 = new User("Test","FakePasswordHash","FakeMail@fake.com",1);
		User u2 = new User("Test2","AnotherFakePasswordHash","Another@fakemail.coom",2);

		uDAO.add(u1);
		uDAO.add(u2);
	}

	@Test
	public void FindById_IdInCollection_ReturnsUser(){
		User toFind = uDAO.findById(1);

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
		User toAdd = new User("Testing","ShortHash","WhatWhat@no.com",3);

		User addedUser = uDAO.add(toAdd);

		Assert.assertEquals("Testing",addedUser.getUsername());
	}
}
