package storage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path("/StorageService")
public class StorageService {
	//get means select
	//post means insert
	//put means update
	//delete means delete

	StorageCRUD crud = new StorageCRUD();
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAILURE_RESULT = "<result>failure</result>";
	
	@GET
	@Path("/items")
	@Produces(MediaType.APPLICATION_XML)
	public List<StorageModel> getUsers() throws ClassNotFoundException, SQLException {
		return crud.getAllStoredItemsInformation();
	}

	@GET
	@Path("/items/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public StorageModel getUser(@PathParam("id") int userid) throws ClassNotFoundException, SQLException {
		return crud.getStoredItemInfo(userid);
	}

	@POST
	@Path("/items")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createUser(@FormParam("id") int id, @FormParam("name") String name, @FormParam("cabinet") int cabinet,
	@FormParam("number") String number, @Context HttpServletResponse servletResponse)throws ClassNotFoundException, SQLException {
		
		StorageModel user = new StorageModel(id, name, number, cabinet);
		//user is instance of parking model 
		int result = crud.storeItem(user);
		if (result > 0) {
			return "Success";
		} else {
			return "FAILED";
		}
	}

	@PUT
	@Path("/items")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateUser(@FormParam("id") int id, @FormParam("name") String name, @FormParam("number") String number,
			@FormParam("cabinet") int cabinet, @Context HttpServletResponse servletResponse)
			throws IOException, ClassNotFoundException, SQLException {
		StorageModel user = new StorageModel(id, name, number, cabinet);
		int result = crud.updateStoredItemInfo(user);
		if (result == 1) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

	@DELETE
	@Path("/items/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String deleteUser(@PathParam("id") int userid) throws ClassNotFoundException, SQLException {
		int result = crud.deliverItem(userid);
		if (result == 1) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}


}
