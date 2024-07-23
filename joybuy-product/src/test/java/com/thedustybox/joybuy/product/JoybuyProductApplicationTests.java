package com.thedustybox.joybuy.product;

import com.thedustybox.joybuy.common.utils.R;
import com.thedustybox.joybuy.product.entity.BrandEntity;
import com.thedustybox.joybuy.product.feign.CouponFeignService;
import com.thedustybox.joybuy.product.feign.SearchFeignService;
import com.thedustybox.joybuy.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.UUID;

@SpringBootTest
class JoybuyProductApplicationTests {
    @Autowired
    BrandService brandService;

//    @Autowired
//    OSS ossClient;

    @Autowired
    CouponFeignService couponFeignService;

    @Autowired
    SearchFeignService searchFeignService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedissonClient redissonClient;

    @Test
    void contextLoads1() {
        System.out.println(redissonClient);

    }



    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功");
    }


    @Test
    void testCouponFeignService(){
        R r = couponFeignService.test1();
        Integer number = (Integer)r.get("number");
        System.out.println(number);
    }

    @Test
    void testsouponFeignService(){
        R r = searchFeignService.test1();
        Integer number = (Integer)r.get("number");
        System.out.println(number);
    }

    @Test
    public void redistemplate(){

        // hello world
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        // 保存
        ops.set("hello","world_" + UUID.randomUUID().toString());
        // 查询
        String hello = ops.get("hello");
        System.out.println("之前保存的数据是："  + hello);

    }
}
