package Logic.Utilities;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class RestHelper {

	public static Response getOptionsResponse(String Options){
		return Response.status(200).header("Allow",Options).header("Access-Control-Allow-Origin", "*")
				.header("Content-Length", "0")
				.header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
				.header("Access-Control-Allow-Methods", Options)
				.build();
	}

	public static UriBuilder getUriBuilder(Class resource, String method){
		return UriBuilder.fromResource(resource)
				.path(resource,method);
	}
}
