package com.liang.seckill.service.impl;

import com.liang.seckill.dao.SeckillMapper;
import com.liang.seckill.dao.SuccessKilledMapper;
import com.liang.seckill.dto.Exposer;
import com.liang.seckill.dto.SeckillExecution;
import com.liang.seckill.entity.Seckill;
import com.liang.seckill.entity.SuccessKilled;
import com.liang.seckill.enums.SeckillStateEnum;
import com.liang.seckill.exception.RepeatKillException;
import com.liang.seckill.exception.SeckillCloseException;
import com.liang.seckill.exception.SeckillException;
import com.liang.seckill.service.SeckillService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Description:
 * Title : 项目：seckill
 * Created in 18/4/17 下午4:50
 *
 * @author : zhaoliang
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private static final Logger logger = LogManager.getLogger(SeckillServiceImpl.class);

    @Autowired
    private SeckillMapper seckillMapper;

    @Autowired
    private SuccessKilledMapper successKilledMapper;

    private final String slat = "dsdzef@.132";

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
        if (seckill == null) {
            return new Exposer(false, seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        //系统当前时间
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        //转化特定字符串的过程，不可逆
        String md5 = getMD5(seckillId);//TODO
        return new Exposer(true, md5, seckillId);


    }

    private String getMD5(long seckillId) {
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, SeckillCloseException, RepeatKillException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        //执行秒杀逻辑：减库存＋记录购买行为
        Date nowTime = new Date();
        try {
            int updateCount = seckillMapper.reduceNumber(seckillId, nowTime);
            if (updateCount <= 0) {
                //没有更新到记录
                throw new SeckillCloseException("seckill is closed");
            }
            int insertCount = successKilledMapper.insertSuccessKilled(seckillId, userPhone);
            if (insertCount <= 0) {
                //重复秒杀
                throw new RepeatKillException("seckill repeated");
            }
            //秒杀成功
            SuccessKilled successKilled = successKilledMapper.queryByIdWithSeckill(seckillId, userPhone);
            return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, successKilled);
        } catch (SeckillCloseException e) {
            throw e;
        } catch (RepeatKillException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所有编译期异常，转化为运行期异常
            throw new SeckillException("seckill inner error :" + e.getMessage());
        }
    }
}
