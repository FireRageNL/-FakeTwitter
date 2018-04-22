package Logic.Implementations;

import Entities.Account;
import Logic.Interfaces.IJWTToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;


public class JWTTokenLogic implements IJWTToken {

	static String key = "b858b430e82c39965277796185c4272398ffd1f47cbdd12a398f4d91c9ee90cf";


	@Override
	public String EncodeToken(String username) {
		System.out.print(key);
		return Jwts.builder().setSubject("login").signWith(SignatureAlgorithm.HS512, key).claim("username", username).compact();
	}

	@Override
	public Boolean CheckIfTokenIsTrusted(String jwsToken) {
		try{
		Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken).getBody();
		System.out.print(claims.getSubject());
		if (claims.getSubject().equals("login")) {
			return true;
		}
		return false;

		}
		catch(SignatureException e){
			return false;
		}
	}

	@Override
	public String GetUsernameFromToken(String jwsToken) {

		if(CheckIfTokenIsTrusted(jwsToken)){
			Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken).getBody();
			return (String) claims.get("username");
		}
		return null;
	}

}
