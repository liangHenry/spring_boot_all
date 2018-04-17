package com.liang.seckill.service.impl;

import com.liang.seckill.dao.SeckillMapper;
import com.liang.seckill.dao.SuccessKilledMapper;
import com.liang.seckill.dto.Exposer;
import com.liang.seckill.dto.SeckillExecution;
import com.liang.seckill.entity.Seckill;
import com.liang.seckill.exception.RepeatKillException;
import com.liang.seckill.exception.SeckillCloseException;
import com.liang.seckill.exception.SeckillException;
import com.liang.seckill.service.SeckillService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Description:
 * Title : 项目：seckill
 * Created in 18/4/17 下午4:50
 *
 * @author : zhaoliang
 */
public class SeckillServiceImpl implements SeckillService {

    private static final Logger logger = LogManager.getLogger(SeckillServiceImpl.class);

    @Autowired
    private SeckillMapper seckillMapper;

    @Autowired
    private SuccessKilledMapper successKilledMapper;

    @Override
    public List<Seckill> querySeckillList() {
        return seckillMapper.queryAll(0, 4);
    }

    @Override
    public Seckill getById(long seckillId) {
        return seckillMapper.selectByPrimaryKey(seckillId);
    }

    @Override
    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillMapper.selectByPrimaryKey(seckillId);
        if (seckill == null) return null;
        return null;
    }

    @Override
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, SeckillCloseException, RepeatKillException {
        return null;
    }
}
