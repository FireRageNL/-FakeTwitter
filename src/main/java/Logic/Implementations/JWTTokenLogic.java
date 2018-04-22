package Logic.Implementations;

import Entities.Account;
import Logic.Interfaces.IJWTToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;

public class JWTTokenLogic implements IJWTToken {

	Key key = MacProvider.generateKey();


	@Override
	public String EncodeToken(String username) {
		return Jwts.builder().setSubject("login").signWith(SignatureAlgorithm.HS512, key).claim("username", username).compact();
	}

	@Override
	public Boolean CheckIfTokenIsTrusted(String jwsToken) {
		try{
		Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken).getBody();
		if (claims.getSubject() == "login") {
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
