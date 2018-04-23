package Logic.Utilities;

import javax.ws.rs.core.Response;

public class RestHelper {

	public static Response getOptionsResponse(String Options){
		return Response.status(200).header("Allow",Options).header("Access-Control-Allow-Origin", "*")
				.header("Content-Length", "0")
				.header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
				.build();
	}
}
