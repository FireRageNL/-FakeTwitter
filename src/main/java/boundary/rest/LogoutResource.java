package boundary.rest;

import Logic.Utilities.RestHelper;
import websocket.Listner;

import javax.json.Json;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("logout")
public class LogoutResource {

	@OPTIONS
	public Response optionsResponse(){
		return RestHelper.getOptionsResponse("OPTIONS");
	}

	@Path("{username}")
	@OPTIONS
	public Response usernameOptionsResponse(){
		return RestHelper.getOptionsResponse("OPTIONS,POST");
	}

	@Path("{username}")
	@POST
	public Response logout(@PathParam("username") String username){
		Listner.getInstance().getUsers().remove(username);
		return Response.ok(Json.createObjectBuilder().build()).header("Access-Control-Allow-Origin", "*").build();
	}

}
