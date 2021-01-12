package itemStorage;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class InsertItem {
	
	public static void insert(int id, String name,String number, int cabinet) {
		try {
		CloseableHttpResponse response = null;
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(8080)
				.setPath("/A00268808_Server/storage/StorageService/items").build();
		
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setHeader("Accept","text/html");
		CloseableHttpClient client = HttpClients.createDefault();
		
	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	nameValuePairs.add(new BasicNameValuePair("id",String.valueOf(id)));
	nameValuePairs.add(new BasicNameValuePair("name",name));
	nameValuePairs.add(new BasicNameValuePair("number",number));
	nameValuePairs.add(new BasicNameValuePair("cabinet",String.valueOf(cabinet)));
	httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	
	response = client.execute(httpPost);
	System.out.println(response.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
