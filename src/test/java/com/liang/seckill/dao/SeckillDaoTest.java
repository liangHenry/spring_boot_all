package com.liang.seckill.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 * Title : 项目：seckill
 * Created in 18/4/17 下午3:26
 *
 * @author : zhaoliang
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillDaoTest {
    private static final Logger logger = LogManager.getLogger(SeckillDaoTest.class);

    @Test
    public void testLogger() {
        logger.info("Hello World");
    }


}
