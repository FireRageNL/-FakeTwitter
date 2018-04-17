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
		return Response.ok(ul.convertListToJSON(accounts)).header("Access-Control-Allow-Origin", "*").build();
	}

	@OPTIONS
	@Path("createUser")
	public Response optionsResponse(){
		return Response.status(200).header("Allow","OPTIONS, POST").header("Access-Control-Allow-Origin", "*")
				.header("Content-Type", MediaType.APPLICATION_JSON)
				.header("Content-Length", "0")
				.header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept")
				.build();
	}

	@POST
	@Path("createUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAccount(Account account) {
		if (account == null) {
			Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
		}
		try {
			ul.addUserToCollection(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok(account.convertToJSON()).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccountById(@PathParam("id") int id){
		Account usr = ul.getUserByID(id);
		if(usr != null) {
			return Response.ok(usr.convertToJSON()).header("Access-Control-Allow-Origin", "*").build();
		}
		return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("search/{username}")
	public Response searchAccountByUsername(@PathParam("username") String username){
		Account usr = ul.getUserFromDatabase(username);
		if(usr!= null){
			return Response.ok(usr.convertToJSON()).header("Access-Control-Allow-Origin", "*").build();
		}
		return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();

	}

}
