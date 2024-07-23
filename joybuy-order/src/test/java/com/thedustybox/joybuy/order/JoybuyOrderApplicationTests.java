package com.thedustybox.joybuy.order;

import com.thedustybox.joybuy.common.utils.R;
import com.thedustybox.joybuy.order.entity.OrderReturnReasonEntity;
import com.thedustybox.joybuy.order.entity.SpuInfoEntity;
import com.thedustybox.joybuy.order.feign.CartFeignService;
import com.thedustybox.joybuy.order.feign.MemberFeignService;
import com.thedustybox.joybuy.order.feign.ProductFeignService;
import com.thedustybox.joybuy.order.feign.SearchFeignService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
class JoybuyOrderApplicationTests {



    @Autowired
    private MemberFeignService memberFeignService;

    @Autowired
    private ProductFeignService productFeignService;


    @Autowired
    private SearchFeignService searchFeignService;


    @Resource
    private CartFeignService cartFeignService;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Autowired
    RabbitTemplate rabbitTemplate;




    @Test
    public void createExchange() {

        Exchange directExchange = new DirectExchange("hello-java-exchange",true,true);
        amqpAdmin.declareExchange(directExchange);
        System.out.println("Exchange[{}]创建成功：hello-java-exchange");
    }



    @Test
    public void testCreateQueue() {
        Queue queue = new Queue("hello-java-queue",true,false,false);
        amqpAdmin.declareQueue(queue);
        System.out.println("Queue[{}]创建成功：hello-java-queue");
    }


    @Test
    public void createBinding() {

        Binding binding = new Binding("hello-java-queue",
                Binding.DestinationType.QUEUE,
                "hello-java-exchange",
                "hello.java",
                null);
        amqpAdmin.declareBinding(binding);
        System.out.println("Binding[{}]创建成功：hello-java-binding");

    }

    @Test
    public void create() {
        HashMap<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", "order-event-exchange");
        arguments.put("x-dead-letter-routing-key", "order.release.order");
        arguments.put("x-message-ttl", 60000); // 消息过期时间 1分钟
        Queue queue = new Queue("order.delay.queue", true, false, false, arguments);
        amqpAdmin.declareQueue(queue);
        System.out.println("Queue[{}]创建成功：order.delay.queue");
    }

    @Test
    public void sendMessageTest() {
        OrderReturnReasonEntity reasonEntity = new OrderReturnReasonEntity();
        reasonEntity.setId(1L);
        reasonEntity.setCreateTime(new Date());
        reasonEntity.setName("reason");
        reasonEntity.setStatus(1);
        reasonEntity.setSort(2);
        String msg = "Hello World";
        //1、发送消息,如果发送的消息是个对象，会使用序列化机制，将对象写出去，对象必须实现Serializable接口
        rabbitTemplate.convertAndSend("hello-java-exchange","hello.java",msg);

        //2、发送的对象类型的消息，可以是一个json
        rabbitTemplate.convertAndSend("hello-java-exchange","hello.java",
                reasonEntity,new CorrelationData(UUID.randomUUID().toString()));
        System.out.println("消息发送完成:{}"+reasonEntity);
    }




    @Test
    void contextLoads() {
    }

    @Test
    void testmemberFeignService(){
        R r = memberFeignService.test1();
        Integer number = (Integer)r.get("number");
        System.out.println(number);
    }

    @Test
    void testsearchFeignService(){
        R r = searchFeignService.test1();
        Integer number = (Integer)r.get("number");
        System.out.println(number);
    }

    @Test
    void testcartFeignService(){
        R r = cartFeignService.test1();
        Integer number = (Integer)r.get("number");
        System.out.println(number);
    }

    @Test
    void testProductFeignService(){
        R r = productFeignService.test1();
        Integer number = (Integer)r.get("number");
        System.out.println(number);
    }

    @Test
    void testProductFeignService2(){
        R r = productFeignService.getSpuInfoBySkuId(33L);
        Object spuInfoEntity = (SpuInfoEntity)r.get("spuInfoEntity");
        System.out.println(spuInfoEntity);
    }


}
