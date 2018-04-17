package boundary.rest;

import Entities.Kweet;
import Logic.Implementations.KweetLogic;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("kweet")
public class KweetResource {

	@Inject
	KweetLogic kl;

	@GET
	@Path("{username}")
	public Response GetAllKweetsFromUser(@PathParam("username") String username){
		List<Kweet> allKweets = kl.getAllKweetsFromUser(username);
		return Response.ok(kl.convertListToJSON(allKweets)).header("Access-Control-Allow-Origin", "*").build();
	}

}
