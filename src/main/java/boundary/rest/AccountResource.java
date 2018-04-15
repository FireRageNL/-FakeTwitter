package boundary.rest;

import Entities.Account;
import Logic.Implementations.UserLogic;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccountById(@PathParam("id") int id){
		Account usr = ul.getUserByID(id);
		if(usr != null) {
			return Response.ok(usr.convertToJSON()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("search/{username}")
	public Response searchAccountByUsername(@PathParam("username") String username){
		Account usr = ul.getUserFromDatabase(username);
		if(usr!= null){
			return Response.ok(usr.convertToJSON()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();

	}

}
