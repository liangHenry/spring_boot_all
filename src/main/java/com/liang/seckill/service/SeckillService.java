package com.liang.seckill.service;

import com.liang.seckill.dto.Exposer;
import com.liang.seckill.dto.SeckillExecution;
import com.liang.seckill.entity.Seckill;
import com.liang.seckill.exception.RepeatKillException;
import com.liang.seckill.exception.SeckillCloseException;
import com.liang.seckill.exception.SeckillException;

import java.util.List;

/**
 * Description:
 * Title : 项目：seckill
 * Created in 18/4/17 下午4:26
 *
 * @author : zhaoliang
 */
public interface SeckillService {
    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    List<Seckill> querySeckillList();

    /**
     * 查询单个
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启是输出秒杀接口地址，否则输出系统时间和秒杀时间
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, SeckillCloseException, RepeatKillException;


    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);


}
