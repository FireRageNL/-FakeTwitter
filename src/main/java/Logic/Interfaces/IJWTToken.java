package Logic.Interfaces;

public interface IJWTToken {

	String EncodeToken(String username);

	Boolean CheckIfTokenIsTrusted(String jwsToken);

	String GetUsernameFromToken(String jwsToken);
}
