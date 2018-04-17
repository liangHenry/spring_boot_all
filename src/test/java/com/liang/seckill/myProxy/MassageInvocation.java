package com.liang.seckill.myProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Title : 项目：seckill
 * Created in 18/4/12 下午4:26
 *
 * @author : zhaoliang
 */
public class MassageInvocation implements InvocationHandler {



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //System.out.println("proxy " + proxy);
        System.out.println("method " + method);
        System.out.println("args " + args);
        List<Object> list=new ArrayList<Object>();
        list.add("1");
        list.add("2");
        list.add("3");
        return list;
    }
}
