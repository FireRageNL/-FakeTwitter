package boundary.rest;


import Entities.Account;
import Entities.Kweet;
import Logic.Implementations.KweetLogic;
import Logic.Implementations.UserLogic;
import Logic.Utilities.RestHelper;
import boundary.rest.jwtToken.JWTTokenNeeded;
import javafx.animation.Timeline;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.naming.TimeLimitExceededException;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.lang.reflect.Array;
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
	public Response getAllKWeets(){
		List<Kweet> allKweets = kl.getAllKweets();
		allKweets.sort(Comparator.comparing(Kweet::getPostDate).reversed());
		return Response.ok(kl.convertListToJSON(allKweets)).header("Access-Control-Allow-Origin", "*").build();
	}

	@GET
	@Path("{username}")
	@JWTTokenNeeded
	public Response getAllKweetsFromFollowers(@PathParam("username") String username){
		List<Kweet> allKweets = GetListOfKweets(username);
		return Response.ok(kl.convertListToJSON(allKweets)).header("Access-Control-Allow-Origin","*").build();
	}

	@GET
	@Path("JsonTimeline/{username}")
	public List<JsonObject> getAllKWeetsFromFollowersHateOAS(@PathParam("username") String username){
		List<Kweet> allKweets = GetListOfKweets(username);
		List<JsonObject> ret = new ArrayList<>();
		UriBuilder selfBuilder = RestHelper.getUriBuilder(TimelineResource.class,"getAllKWeetsFromFollowersHateOAS");
		UriBuilder builder = RestHelper.getUriBuilder(AccountResource.class,"searchAccountByUsername");
		Link linkSelf = Link.fromUri(selfBuilder.build(username)).rel("self").build();

		allKweets.forEach(item -> {
			Link link = Link.fromUri(builder.build(item.getOwner().getUsername())).rel("AccountLocation").build();
			JsonObject toAdd = Json.createObjectBuilder()
					.add("id",item.getId())
					.add("username", item.getOwner().getUsername())
					.add("messageContents",item.getMessageContents())
					.add(link.getRel(),link.getUri().getPath())
					.add(linkSelf.getRel(),linkSelf.getUri().getPath())
					.build();
			ret.add(toAdd);
		});
		return ret;
	}

	private List<Kweet> GetListOfKweets(String username){
		Account acc = ul.getUserFromDatabase(username);
		List<Kweet> allKweets = new ArrayList<>();
		for(Account a : acc.getFollowing()){
			allKweets.addAll(kl.getAllKweetsFromUser(a.getUsername()));
		}
		allKweets.addAll(kl.getAllKweetsFromUser(username));
		allKweets.sort(Comparator.comparing(Kweet::getPostDate).reversed());
		return allKweets;
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
