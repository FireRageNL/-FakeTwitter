package boundary.rest;


import Entities.Account;
import Entities.Kweet;
import Logic.Implementations.KweetLogic;
import Logic.Implementations.UserLogic;
import Logic.Utilities.RestHelper;
import boundary.rest.jwtToken.JWTTokenNeeded;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Path("timeline")
public class TimelineResource {

	@Inject
	KweetLogic kl;

	@Inject
	UserLogic ul;

	@GET
	@JWTTokenNeeded
	public Response GetAllKWeets(){
		List<Kweet> allKweets = kl.getAllKweets();
		allKweets.sort(Comparator.comparing(Kweet::getPostDate).reversed());
		return Response.ok(kl.convertListToJSON(allKweets)).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("{username}")
	@JWTTokenNeeded
	public Response GetAllKweetsFromFollowers(@PathParam("username") String username){
		Account acc = ul.getUserFromDatabase(username);
		List<Kweet> allKweets = new ArrayList<>();
		for(Account a : acc.getFollowing()){
			allKweets.addAll(kl.getAllKweetsFromUser(a.getUsername()));
		}
		allKweets.addAll(kl.getAllKweetsFromUser(username));
		allKweets.sort(Comparator.comparing(Kweet::getPostDate).reversed());
		return Response.ok(kl.convertListToJSON(allKweets)).header("Access-Control-Allow-Origin","*").build();
	}

	@OPTIONS
	@Path("{username}")
	public Response followersOptionsResponse(){
		return RestHelper.getOptionsResponse("OPTIONS,GET");
	}

	@OPTIONS
	public Response optionsResponse(){
		return RestHelper.getOptionsResponse("OPTIONS, GET");
	}
}
