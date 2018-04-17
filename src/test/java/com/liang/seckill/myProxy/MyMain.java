package com.liang.seckill.myProxy;

import java.util.List;

/**
 * Description:
 * Title : 项目：seckill
 * Created in 18/4/12 下午4:36
 *
 * @author : zhaoliang
 */
public class MyMain {
    public static void main(String[] args) {
        MySqlSesion sqlSesion = new MySqlSesion();
        IMassage massage = sqlSesion.getMapper(IMassage.class);
        List<Object> list = massage.query(new Object());
        System.out.println(list.size());

    }
}
