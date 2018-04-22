package Logic.Interfaces;

import Entities.Account;

public interface IJWTToken {

	String EncodeToken(String username);

	Boolean CheckIfTokenIsTrusted(String jwsToken);

	String GetUsernameFromToken(String jwsToken);
}
