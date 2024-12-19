package com.shj.restfulgraphql;

import com.shj.restfulgraphql.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestfulGraphqlApplicationTests {

    @Test
    void contextLoads() {
        User user = new User();
        user.setAge(10);

    }

}
