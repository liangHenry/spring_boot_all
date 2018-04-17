package com.liang.seckill.dao;

import com.liang.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 * Title : 项目：seckill
 * Created in 18/4/17 下午3:29
 *
 * @author : zhaoliang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillMapperTest {

    @Autowired
    private SeckillMapper seckillMapper;

    @Test
    public void selectByPrimaryKey() throws Exception {
        long id = 1000;
        Seckill seckill = seckillMapper.selectByPrimaryKey(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }


    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = seckillMapper.queryAll(0, 100);
        seckills.forEach(seckill -> System.out.println(seckill.getName()));
    }


    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillMapper.reduceNumber(1000L, killTime);
        System.out.println(updateCount);
    }

}