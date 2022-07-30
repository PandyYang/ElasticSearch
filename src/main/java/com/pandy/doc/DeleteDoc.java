package com.pandy.doc;

import com.pandy.tool.ConnElasticSearch;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.RequestOptions;

public class DeleteDoc {

    public static void main(String[] args) {
        ConnElasticSearch.connect(client -> {
            DeleteRequest request = new DeleteRequest().index("user").id("1001");

            DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);

            System.out.println("response.toString() = " + response.toString());
        });
    }
}
