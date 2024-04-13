package wedsan;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
/**
 * Class responsible for fetching data from an API.
 */
public class FetcherAPI {

    public FetcherAPI() {
    }
    /**
     * Sends an HTTP GET request to the specified URL and returns the response body as a string.
     *
     * @param url The URL to which the GET request will be sent
     * @return The response body as a string
     * @throws IOException If an IO exception occurs while sending the request or processing the response
     */
    public String sendHttpGetRequest(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpget);

        return EntityUtils.toString(response.getEntity());

    }
}
