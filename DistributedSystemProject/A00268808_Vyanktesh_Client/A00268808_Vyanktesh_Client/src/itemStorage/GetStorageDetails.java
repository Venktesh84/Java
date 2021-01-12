package itemStorage;

import java.io.IOException;

import java.net.URI;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class GetStorageDetails {
	
	public static StringBuilder Details() throws Exception {
		// TODO Auto-generated method stub

		CloseableHttpResponse response = null;
		
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("localhost")
					.setPort(8080)
					.setPath("/A00268808_Server/storage/StorageService/items").build();
			
			System.out.println(uri.toString());
			
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader("Accept", "application/xml");
			
			CloseableHttpClient httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet);
			
			HttpEntity entity = response.getEntity();
			String text = EntityUtils.toString(entity);
			System.out.println(text);
			
			List<Item> storageList = new ParseItem().doParsestorage(text);
			System.out.println("-------------------------");
			StringBuilder s = new StringBuilder();
			for(Item storage : storageList) {
				s.append("ID:"+storage.getId()+"   Customer Name:"+storage.getName()+"   Mobile Number:"+storage.getNumber()+"   Cabinet number:"+storage.getCabinet()+"\n");
			}
			return s;
			
	}

}
