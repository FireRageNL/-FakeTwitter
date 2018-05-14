package boundary.rest;

import Entities.Account;
import Entities.Kweet;
import Logic.Implementations.KweetLogic;
import Logic.Implementations.UserLogic;
import Logic.Utilities.RestHelper;
import boundary.rest.jwtToken.JWTTokenNeeded;
import boundary.rest.restModels.kweetModel;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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
	public Response getAllKweetsFromUser(@PathParam("username") String username){
		List<Kweet> allKweets = kl.getAllKweetsFromUser(username);
		allKweets.sort(Comparator.comparing(Kweet::getPostDate).reversed());
		return Response.ok(kl.convertListToJSON(allKweets)).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("/JsonKweet/{id}")
	public JsonObject getKweetHateOAS(@PathParam("id") int id){
		Kweet kw = kl.getKweetById(id);

		UriBuilder builder = RestHelper.getUriBuilder(KweetResource.class,"getKweetHateOAS");
		Link link = Link.fromUri(builder.build(id)).rel("self").build();


		return Json.createObjectBuilder()
				.add("username", kw.getOwner().getUsername())
				.add("contents",kw.getMessageContents())
				.add("timestamp", kw.getPostDate().toString())
				.add(link.getRel(), link.getUri().getPath())
				.build();
	}

	@GET
	@Path("/JsonUserKweets/{username}")
	public List<JsonObject> allKweetsFromUserHateOAS(@PathParam("username") String username){

		UriBuilder builder = RestHelper.getUriBuilder(KweetResource.class,"getKweetHateOAS");
		UriBuilder builderDiffrentResource = RestHelper.getUriBuilder(TimelineResource.class,"getAllKweetsFromFollowers");
		Link link = Link.fromUri(builder.build(username)).rel("self").build();
		Link linkFollowing = Link.fromUri(builderDiffrentResource.build(username)).rel("followerKweets").build();

		List<Kweet> allKweets = kl.getAllKweetsFromUser(username);
		allKweets.sort(Comparator.comparing(Kweet::getPostDate).reversed());
		List<JsonObject> ret = new ArrayList<>();
		allKweets.sort(Comparator.comparing(Kweet::getPostDate).reversed());
		allKweets.forEach(item -> {
			 JsonObject toAdd = Json.createObjectBuilder()
					.add("id",item.getId())
					.add("username", item.getOwner().getUsername())
					.add("messageContents",item.getMessageContents())
					 .add(link.getRel(),link.getUri().getPath())
					 .add(linkFollowing.getRel(),linkFollowing.getUri().getPath())
					.build();
			 ret.add(toAdd);
		});

		return ret;
	}

	@POST
	@JWTTokenNeeded
	public Response postNewKweet(kweetModel model) {
		Account usr = ul.getUserFromDatabase(model.getUsername());
		Kweet toPost = new Kweet(model.getKweetContents(),usr,new Date());
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
