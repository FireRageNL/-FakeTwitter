package boundary.rest;

import Entities.Account;
import Logic.Implementations.UserLogic;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@Path("account")
public class AccountResource {

	@Inject
	UserLogic ul;

	@GET
	@Path("getall")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAllAccounts(){
		List<Account> accounts = ul.getAllUsersFromDatabase();
		return Response.ok(ul.convertListToJSON(accounts)).build();
	}

	@POST
	@Path("createUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Account createAccount(Account account) {
		if (account == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		try {
			ul.addUserToCollection(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

}
