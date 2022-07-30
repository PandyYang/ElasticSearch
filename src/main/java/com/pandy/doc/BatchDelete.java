package com.pandy.doc;

import com.pandy.tool.ConnElasticSearch;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.TimeValue;

import java.util.stream.Stream;

public class BatchDelete {

    public static void main(String[] args) {
        ConnElasticSearch.connect(client -> {
            BulkRequest bulkRequest = new BulkRequest();
            bulkRequest.add(new DeleteRequest().index("user").id("1001"));
            bulkRequest.add(new DeleteRequest().index("user").id("1002"));
            bulkRequest.add(new DeleteRequest().index("user").id("1003"));

            BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);

            TimeValue took = response.getTook();
            System.out.println("took = " + took);

            BulkItemResponse[] items = response.getItems();
            Stream.of(items).forEach(System.out::println);
        });
    }
}
