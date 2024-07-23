package com.thedustybox.joybuy.search;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
class JoybuySearchApplicationTests {
    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    void contextLoads() throws IOException {
        System.out.println(restHighLevelClient);

        IndexRequest indexRequest = new IndexRequest("user");
        indexRequest.id("2");
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);
        user.setGender("男");
        String jsonString = JSON.toJSONString(user);
        indexRequest.source(jsonString, XContentType.JSON);
        IndexResponse index = restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);
        System.out.println(index);

    }

    @Data
    class User{
        private String username;
        private String gender;
        private Integer age;
    }

}
