package com.pandy.index;

import com.pandy.tool.EsClientTool;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.AliasMetadata;
import org.elasticsearch.cluster.metadata.MappingMetadata;
import org.elasticsearch.common.settings.Settings;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SearchIndex {

    public static void main(String[] args) throws IOException {
        EsClientTool esClientTool = new EsClientTool();
        RestHighLevelClient client = esClientTool.createClient();

        GetIndexRequest request = new GetIndexRequest("user2");

        GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);

        Map<String, List<AliasMetadata>> aliases = response.getAliases();
        System.out.println("aliases = " + aliases);

        Map<String, MappingMetadata> mappings = response.getMappings();
        System.out.println("mappings = " + mappings);

        Map<String, Settings> settings = response.getSettings();
        System.out.println("settings = " + settings);

        esClientTool.closeClient();
    }
}
