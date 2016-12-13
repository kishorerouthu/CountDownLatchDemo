package com.tutorial.concurrency;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

/**
 * Created by kishore on 12/12/16.
 */
public class RandomGeneratorClient {

   private static final String END_POINT_ADDRESS = "http://e1253bff782eb.stage-cloud.wavemakeronline.com/RandomGen/services/randomGen/random";

    public RandomGeneratorClient() {
    }

    public int invoke(int limit) throws URISyntaxException, IOException {
        return new Random().nextInt(limit);

       /* URI uri = new URIBuilder(END_POINT_ADDRESS).addParameter("limit", String.valueOf(limit)).build();
        HttpGet httpGet = new HttpGet();
        httpGet.setURI(uri);

        HttpClient client = new DefaultHttpClient();
        HttpResponse execute = client.execute(httpGet);

        BufferedReader br = null;
        try {
            InputStream content = execute.getEntity().getContent();
            br = new BufferedReader(new InputStreamReader(content));
            String response = br.readLine();
            return Integer.parseInt(response);
        } finally {
            closeSilently(br);
        }
*/
    }

    private void closeSilently(Reader reader) {
        if (reader == null)
            return;
        try {
            reader.close();
        } catch (IOException ioe) {
            // Log and ignore exception
        }
    }
}
