package boundary.rest;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Logic.Implementations.JWTTokenLogic;
import Logic.Implementations.UserLogic;
import Logic.Utilities.RestHelper;
import boundary.rest.restModels.loginModel;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Path("login")
public class LoginResource {

	@Inject
	UserLogic ul;

	@Inject
	JWTTokenLogic tokenLogic;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginResponse(loginModel model) throws InvalidKeySpecException, NoSuchAlgorithmException {
		if(ul.loginUser(model.getUsername(),model.getPassword())) {
			return Response.ok(Json.createObjectBuilder().add("Token", tokenLogic.EncodeToken(model.getUsername())).add("valid",1).add("username",model.getUsername()).build()).header("Access-Control-Allow-Origin", "*").build();
		}
		else{
			return Response.ok(Json.createObjectBuilder().add("valid",0).build()).header("Access-Control-Allow-Origin", "*").build();
		}
	}

	@OPTIONS
	public Response optionsResponse(){
		return RestHelper.getOptionsResponse("OPTIONS, POST");
	}
 }
