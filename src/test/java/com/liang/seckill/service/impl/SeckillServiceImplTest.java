package com.liang.seckill.service.impl;

import com.liang.seckill.dto.Exposer;
import com.liang.seckill.dto.SeckillExecution;
import com.liang.seckill.entity.Seckill;
import com.liang.seckill.exception.SeckillException;
import com.liang.seckill.service.SeckillService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 * Title : 项目：seckill
 * Created in 18/4/20 上午10:18
 *
 * @author : zhaoliang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillServiceImplTest {

    private static final Logger logger = LogManager.getLogger(SeckillServiceImplTest.class);

    @Autowired
    private SeckillService seckillService;

    @Test
    public void querySeckillList() throws Exception {
        List<Seckill> list = seckillService.querySeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void getById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}", exposer);
    }

    @Test
    public void executeSeckill() throws Exception {
        long id = 1000L;
        long phone = 1234532234L;
        String md5 = "688bf136eade1256788c25abe7dabfb8";
        SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
        logger.info("execution={}", execution);
    }

    @Test
    public void testSeckillLogic() throws Exception {
        long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer={}", exposer);
            long phone = 1234532232L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
                logger.info("execution={}", execution);
            } catch (SeckillException e) {
                logger.error("SeckillException", e.getMessage());
            }
        } else {
            logger.info("exposer={}", exposer);
        }
    }

}