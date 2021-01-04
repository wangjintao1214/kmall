package com.kgc.kmall.manager;

import com.kgc.kmall.manager.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@SpringBootTest
class KmallManagerServiceApplicationTests {

	@Resource
	RedisUtil redisUtil;

	@Test
	void contextLoads() {
        try {
            Jedis jedis = redisUtil.getJedis();
            String name = jedis.get("name");
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
