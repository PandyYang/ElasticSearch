package com.pandy.tool;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class EsClientTool {

    RestHighLevelClient client = null;

    public RestHighLevelClient createClient() {

        client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
        return client;
    }


    public void closeClient() throws IOException {
        client.close();
    }
}
