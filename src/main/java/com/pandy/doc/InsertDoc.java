package com.pandy.doc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pandy.domain.User;
import com.pandy.tool.ConnElasticSearch;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;

public class InsertDoc {

    public static void main(String[] args) {
        ConnElasticSearch.connect(client -> {
            IndexRequest request = new IndexRequest();

            request.index("user").id("1001");

            User user = new User();
            user.setName("zhangsan");
            user.setAge(30);
            user.setSex("男");

            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(user);
            request.source(s, XContentType.JSON);

            IndexResponse response = client.index(request, RequestOptions.DEFAULT);

            String index = response.getIndex();
            System.out.println("index = " + index);

            String id = response.getId();
            System.out.println("id = " + id);

            DocWriteResponse.Result result = response.getResult();
            System.out.println("result = " + result);
        });
    }
}
