package com.thedustybox.joybuy.auth;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JoybuyAuthServerApplicationTests {

    @Test
    void contextLoads() {
        for ( int i = 0; i < 5;i++){
            String code = ((Double) (Math.random() * 100000)).toString().substring(0, 5);
            System.out.println(code);
        }
    }

}
