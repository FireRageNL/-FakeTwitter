package boundary.rest;

import Entities.Account;
import Logic.Implementations.UserLogic;
import Logic.Utilities.RestHelper;
import boundary.rest.jwtToken.JWTTokenNeeded;

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
	@JWTTokenNeeded
	public Response getAllAccounts(){
		List<Account> accounts = ul.getAllUsersFromDatabase();
		return Response.ok(ul.convertListToJSON(accounts)).header("Access-Control-Allow-Origin", "*").build();
	}

	@OPTIONS
	@Path("getall")
	public Response optionsResponseGetall(){return RestHelper.getOptionsResponse("OPTIONS, POST, GET");}

	@OPTIONS
	@Path("createUser")
	public Response optionsResponse(){
		return RestHelper.getOptionsResponse("OPTIONS, POST");
	}

	@POST
	@Path("createUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAccount(Account account) {
		if (account == null) {
			return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
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
	@JWTTokenNeeded
	public Response getAccountById(@PathParam("id") int id){
		Account usr = ul.getUserByID(id);
		if(usr != null) {
			return Response.ok(usr.convertToJSON()).header("Access-Control-Allow-Origin", "*").build();
		}
		return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("search/{username}")
	@JWTTokenNeeded
	public Response searchAccountByUsername(@PathParam("username") String username){
		Account usr = ul.getUserFromDatabase(username);
		if(usr!= null){
			return Response.ok(usr.convertToJSON()).header("Access-Control-Allow-Origin", "*").build();
		}
		return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
	}




}
