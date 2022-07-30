package com.pandy.doc;

import com.pandy.tool.ConnElasticSearch;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;

public class UpdateDoc {

    public static void main(String[] args) {
        ConnElasticSearch.connect(client -> {
            UpdateRequest request = new UpdateRequest();

            request.index("user").id("1001");
            request.doc(XContentType.JSON, "sex", "女");

            UpdateResponse response = client.update(request, RequestOptions.DEFAULT);

            String index = response.getIndex();
            System.out.println("index = " + index);

            String id = response.getId();
            System.out.println("id = " + id);

            DocWriteResponse.Result result = response.getResult();
            System.out.println("result = " + result);
        });
    }
}
