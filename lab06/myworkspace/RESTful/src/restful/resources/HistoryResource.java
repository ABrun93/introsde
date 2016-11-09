package restful.resources;

import restful.dao.PersonDao;
import restful.model.Person;
import restful.model.HealthProfile;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

//Will map the resource to the URL /history
@Path("/history")
public class HistoryResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	Long id;

	public HistoryResource(UriInfo uriInfo, Request request,Long id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}

	// Application integration
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Date> getHistory() {
		List<Date> history = PersonDao.instance.getDataProvider().get(id).getHProfile().getHistory();
		if (history == null)
			throw new RuntimeException("Get: History with " + id + " not found");
		return history;
	}

	// for the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Date> getHistoryHTML() {
		List<Date> history = PersonDao.instance.getDataProvider().get(id).getHProfile().getHistory();
		if (history == null)
			throw new RuntimeException("Get: History with " + id + " not found");
		return history;
	}
}