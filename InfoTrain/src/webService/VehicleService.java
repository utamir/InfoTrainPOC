/**
 * TODO Add proper copyright notice
 */
package webService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import dao.DatabaseService;

/**
 * @author nzrbfy
 * Vehicle related services 
 */

@Path("/vehicle")
public class VehicleService extends DatabaseService {
	/*
	 * Retrieves all vehicles list from the database
	 */
	@GET
	@Path("/getvehicles.{type}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getVehicles(@PathParam("type") String type) {
		return $Response("SELECT * FROM vehicles", "Vehicle", type);
	}
}

