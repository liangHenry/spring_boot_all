package com.liang.seckill.dao;

import com.liang.seckill.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Description:
 * Title : 项目：seckill
 * Created in 18/4/17 下午3:30
 *
 * @author : zhaoliang
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SuccessKilledMapperTest {

    @Autowired
    private SuccessKilledMapper successKilledMapper;

    @Test
    public void insertSuccessKilled() throws Exception {
        long id = 1000L;
        long phone = 13234565432L;
        int insertCount = successKilledMapper.insertSuccessKilled(id, phone);
        System.out.println(insertCount);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long id = 1000L;
        long phone = 13234565432L;
        SuccessKilled successKilled= successKilledMapper.queryByIdWithSeckill(id,phone);
        System.out.println(successKilled.getUserPhone());
        System.out.println(successKilled.getSeckill().getName());
    }

}