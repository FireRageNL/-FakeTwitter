package Collection;

import Dao.Implementations.Collections.UserCollectionDAO;
import Entities.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;


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
	public void GetAll_TwoInDatabase_ReturnsTwo(){
		List<Account> allAcc = uDAO.getAll();

		Assert.assertEquals(2,allAcc.size());
	}
	@Test
	public void FindById_IdNotInCollection_ReturnsNull(){
		Assert.assertNull(uDAO.findById(3));
	}

	@Test
	public void DeleteById_UserInDatabase_DeletesUser(){
		uDAO.deleteById(1);
		Assert.assertNull(uDAO.findById(1));
	}

	@Test
	public void Delete_UserInDatabase_DeletesUser(){
		Account toDelete = uDAO.findById(1);
		uDAO.delete(toDelete);
		Assert.assertNull(uDAO.findById(1));
	}

	@Test
	public void FindByUsername_UserInDatabase_ReturnsUser(){
		Account toFind = uDAO.findByUsername("Test");

		Assert.assertEquals(1,toFind.getId());
	}

	@Test
	public void FindByUsername_NotInDatabase_ReturnsNull(){
		Assert.assertNull(uDAO.findByUsername("Wheeeeeee"));
	}

	@Test
	public void UpdateUser_UserInDatbase_UpdatesUser(){
		Account usr = uDAO.findById(1);
		usr.setUsername("Bye");

		Account updated = uDAO.update(usr);

		Assert.assertEquals("Bye",updated.getUsername());

	}

	@Test
	public void UpdateUser_NotInDatabase_ReturnsNull(){
		Account usr = new Account("Test123","FakeHash","FakeEmails@failfail.com",3);

		Assert.assertNull(uDAO.update(usr));
	}

	@Test
	public void UpdateUser_EmptyUser_ReturnsNull(){
		Assert.assertNull(uDAO.update(new Account()));
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
