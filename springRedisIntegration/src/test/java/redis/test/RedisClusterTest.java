package redis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-redis-cluster-config.xml"})
public class RedisClusterTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){


        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {

                connection.set("redis".getBytes(),"redis you are the best one".getBytes());
                connection.set("cluster".getBytes(),"cluster you are the best one".getBytes());
                return null;
            }
        });

        List<String> keys= Arrays.asList("foo","hello","key:{test}:555","key:{test}:666","a","b","c","redis","cluster");
        for(final String key:keys){
            String value = (String)redisTemplate.execute(new RedisCallback() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    byte[] result = connection.get(key.getBytes());
                    return new String(result);
                }
            });
            System.out.println(value);
        }
    }
}
