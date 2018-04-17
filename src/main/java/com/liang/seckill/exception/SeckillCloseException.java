package com.liang.seckill.exception;

/**
 * Description: 秒杀关闭异常
 * Title : 项目：seckill
 * Created in 18/4/17 下午4:46
 *
 * @author : zhaoliang
 */
public class SeckillCloseException extends SeckillException  {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
