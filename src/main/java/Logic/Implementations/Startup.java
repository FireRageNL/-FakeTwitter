package Logic.Implementations;

import javax.ejb.Singleton;
import javax.inject.Inject;

@Singleton
@javax.ejb.Startup
public class Startup {

	@Inject
	UserLogic usrLogic;

	public Startup() {

	}
}
