package com.pandy.tool;

import org.elasticsearch.client.RestHighLevelClient;

@FunctionalInterface
public interface ElasticSearchTask {
    void doSomething(RestHighLevelClient client) throws Exception;
}
