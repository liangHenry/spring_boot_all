package com.liang.seckill.myProxy;

import org.omg.CORBA.Object;

import java.lang.reflect.Proxy;

/**
 * Description:
 * Title : 项目：seckill
 * Created in 18/4/12 下午4:28
 *
 * @author : zhaoliang
 */
public class MySqlSesion {


    public <T> T getMapper(Class<T> type) {
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new MassageInvocation());
    }


}
