package boundary.rest;

import Entities.Account;
import Logic.Implementations.UserLogic;
import Logic.Utilities.RestHelper;
import boundary.rest.jwtToken.JWTTokenNeeded;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("follow")
public class FollowerResource {

	@Inject
	UserLogic ul;

	@OPTIONS
	@Path("{username}")
	public Response optionsResponse(){
		return RestHelper.getOptionsResponse("OPTIONS, GET, POST, DELETE");
	}

	@OPTIONS
	public Response generalOptionsResponse(){return RestHelper.getOptionsResponse("OPTIONS, GET, POST, DELETE");}

	@OPTIONS
	@Path("{username}/{follower}")
	public Response optionsAddResponse(){
		return RestHelper.getOptionsResponse("OPTIONS, GET, POST, DELETE");
	}

	@GET
	@JWTTokenNeeded
	@Path("{username}")
	public Response getFollowing(@PathParam("username") String username){
		Account acc = ul.getUserFromDatabase(username);
		return Response.ok(ul.convertListToJSON(acc.getFollowing())).header("Access-Control-Allow-Origin", "*").build();
	}

	@POST
	@Path("{username}/{follower}")
	public Response setNewFollower(@PathParam("username") String username, @PathParam("follower") String following){
		Account toEdit = ul.getUserFromDatabase(username);
		Account follow = ul.getUserFromDatabase(following);
		ul.addFollower(toEdit,follow);
		return Response.ok().header("Access-Control-Allow-Origin", "*").build();
	}

	@DELETE
	@JWTTokenNeeded
	@Path("{username}/{follower}")
	public Response deleteFollower(@PathParam("username") String username, @PathParam("follower") String following){
		Account toEdit = ul.getUserFromDatabase(username);
		Account follow = ul.getUserFromDatabase(following);
		ul.deleteFollower(toEdit,follow);
		return Response.ok().header("Access-Control-Allow-Origin", "*").build();
	}
}
