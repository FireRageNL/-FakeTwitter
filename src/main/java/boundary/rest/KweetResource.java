package boundary.rest;

import Entities.Account;
import Entities.Kweet;
import Logic.Implementations.KweetLogic;
import Logic.Implementations.UserLogic;
import Logic.Utilities.RestHelper;
import boundary.rest.jwtToken.JWTTokenNeeded;
import boundary.rest.restModels.kweetModel;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("kweet")
public class KweetResource {

	@Inject
	KweetLogic kl;

	@Inject
	UserLogic ul;

	@GET
	@Path("{username}")
	@JWTTokenNeeded
	public Response GetAllKweetsFromUser(@PathParam("username") String username){
		List<Kweet> allKweets = kl.getAllKweetsFromUser(username);
		return Response.ok(kl.convertListToJSON(allKweets)).header("Access-Control-Allow-Origin", "*").build();
	}

	@POST
	@JWTTokenNeeded
	public Response postNewKweet(kweetModel model) {
		Account usr = ul.getUserFromDatabase(model.getUsername());
		Kweet toPost = new Kweet(model.getKweetContents(),usr);
		kl.addNewKweet(toPost);
		return Response.ok().header("Access-Control-Allow-Origin", "*").build();
	}

	@OPTIONS
	public Response optionsResponse(){
		return RestHelper.getOptionsResponse("OPTIONS, POST, GET");
	}

	@OPTIONS
	@Path("{username}")
	public Response optionsResponseUsername(){ return RestHelper.getOptionsResponse("OPTIONS,POST,GET"); }
}
