package boundary.rest;

import Logic.Implementations.JWTTokenLogic;
import Logic.Utilities.RestHelper;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("verify")
public class LoginVerificationResource {

	@Inject
	JWTTokenLogic tokenLogic;

	@POST
	public Response verifyResponse(String token){
		if(tokenLogic.CheckIfTokenIsTrusted(token)){
			return Response.ok(Json.createObjectBuilder().add("valid",true).build()).header("Access-Control-Allow-Origin", "*").build();
		}
		return Response.ok(Json.createObjectBuilder().add("valid",false).build()).header("Access-Control-Allow-Origin", "*").build();
	}
	@OPTIONS
	public Response optionsResponse(){
		return RestHelper.getOptionsResponse("OPTIONS, POST");
	}
}
