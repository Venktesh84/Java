package itemStorage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class UpdateItem {

	public static void main(String[] args) throws ClientProtocolException, URISyntaxException, IOException {
		// TODO Auto-generated method stub
		UpdateItem d = new UpdateItem();
	    d.updateItemData(1,"Jack", "0895647437",14);
	}

	/**
	 * Updates row the row in database
	 * @param id - selects row using ID
	 * @param name
	 * @param number
	 * @param cabinet
	 * @throws URISyntaxException Issues related to URI
	 * @throws ClientProtocolException Related to the client
	 * @throws IOException Issues with response from server
	 */
	public void updateItemData(int id,String name, String number, int cabinet) throws URISyntaxException, ClientProtocolException, IOException {
        CloseableHttpResponse response = null;
        URI uri = new URIBuilder().setScheme("http").setHost("localhost").setPort(8080)
                .setPath("/A00268808_Server/storage/StorageService/items").build();

        HttpPut httpPut = new HttpPut(uri);
        httpPut.setHeader("Accept", "text/html");
        CloseableHttpClient client = HttpClients.createDefault();

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("id", String.valueOf(id)));
        nameValuePairs.add(new BasicNameValuePair("name", name));
        nameValuePairs.add(new BasicNameValuePair("numb", number));
        nameValuePairs.add(new BasicNameValuePair("area", String.valueOf(cabinet)));
  
        httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        response = client.execute(httpPut);
        System.out.println(response.toString());

    }

}
