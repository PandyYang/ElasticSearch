package com.pandy.index;

import com.pandy.tool.EsClientTool;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

public class CreateIndex {

    public static void main(String[] args) throws IOException {
        EsClientTool esClientTool = new EsClientTool();
        RestHighLevelClient client = esClientTool.createClient();

        CreateIndexRequest request = new CreateIndexRequest("user2");

        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);

        boolean acknowledged = response.isAcknowledged();

        System.out.println("acknowledged = " + acknowledged);

        esClientTool.closeClient();
    }
}
