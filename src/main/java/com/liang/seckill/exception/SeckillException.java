package com.liang.seckill.exception;

/**
 * Description: 秒杀相关业务异常
 * Title : 项目：seckill
 * Created in 18/4/17 下午4:47
 *
 * @author : zhaoliang
 */
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
