package itemStorage;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class DeleteItem {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DeleteItem  d = new DeleteItem();
		d.testIntegrityUnicityError(6);
	}
	
	/**
	 * Deletes the row in the database
	 * @param id1 ID of the row
	 * @throws IOException Issues with response from server
	 */
	public void testIntegrityUnicityError(int id1) throws IOException {
		final HttpDelete httpdelete = new HttpDelete("http://localhost:8080//A00268808_Server/storage/StorageService/items/"+id1);
		HttpResponse response = null;
		try {
			CloseableHttpClient HttpClient = HttpClients.createDefault();
			response = HttpClient.execute(httpdelete);
			System.out.println(response.toString());
			System.out.println("Deleted sucessfully");
		} finally {
			if (response != null) {
				response.getEntity().getContent().close();
			}
		}
	}

}
