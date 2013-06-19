package webService;

import javax.ws.rs.*;
import dao.DatabaseService;

@Path("/Test")
public class TestService extends DatabaseService {		
	
	@GET
	@Path("/TestConnection")
	@Produces("application/json")
	public String testConnection() throws Exception {
		return String.valueOf($Db().isClosed());
	}

}
