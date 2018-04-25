package boundary.rest;


import Entities.Kweet;
import Logic.Implementations.KweetLogic;
import Logic.Utilities.RestHelper;
import boundary.rest.jwtToken.JWTTokenNeeded;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("timeline")
public class TimelineResource {

	@Inject
	KweetLogic kl;

	@GET
	@JWTTokenNeeded
	public Response GetAllKWeets(){
		List<Kweet> allKweets = kl.getAllKweets();
		return Response.ok(kl.convertListToJSON(allKweets)).header("Access-Control-Allow-Origin", "*").build();
	}

	@OPTIONS
	public Response optionsResponse(){
		return RestHelper.getOptionsResponse("OPTIONS, GET");
	}
}
