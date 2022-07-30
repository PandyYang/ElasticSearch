package com.pandy.doc;

import com.pandy.tool.ConnElasticSearch;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;

public class BatchInsert {

    public static void main(String[] args) {
        ConnElasticSearch.connect(client -> {
            BulkRequest bulkRequest = new BulkRequest();

            bulkRequest.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "zhangsan"));
            bulkRequest.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "lisi"));
            bulkRequest.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "wangwu"));

            BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
            TimeValue took = response.getTook();
            System.out.println("took = " + took);

            BulkItemResponse[] items = response.getItems();
            System.out.println("items = " + items);
        });
    }
}
