package com.liang.seckill.exception;

/**
 * Description: 重复秒杀异常
 * Title : 项目：seckill
 * Created in 18/4/17 下午4:44
 *
 * @author : zhaoliang
 */
public class RepeatKillException extends SeckillException {
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
