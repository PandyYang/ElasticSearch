package com.pandy.doc;

import com.pandy.tool.ConnElasticSearch;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;

public class GetDoc {

    public static void main(String[] args) {
        ConnElasticSearch.connect(client -> {
            GetRequest request = new GetRequest().index("user").id("1001");

            GetResponse response = client.get(request, RequestOptions.DEFAULT);

            String index = response.getIndex();
            System.out.println("index = " + index);

            String type = response.getType();
            System.out.println("type = " + type);

            String id = response.getId();
            System.out.println("id = " + id);

            String sourceAsString = response.getSourceAsString();
            System.out.println("sourceAsString = " + sourceAsString);
        });
    }
}
