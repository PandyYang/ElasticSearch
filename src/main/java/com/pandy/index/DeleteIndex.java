package com.pandy.index;

import com.pandy.tool.EsClientTool;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class DeleteIndex {

    public static void main(String[] args) throws IOException {
        EsClientTool esClientTool = new EsClientTool();
        RestHighLevelClient client = esClientTool.createClient();

        DeleteIndexRequest request = new DeleteIndexRequest("user2");

        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);

        System.out.println("response = " + response.isAcknowledged());

        esClientTool.closeClient();
    }
}
