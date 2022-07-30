package com.pandy.tool;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ConnElasticSearch {

    public static void connect(ElasticSearchTask task) {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        try {
            task.doSomething(client);
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
