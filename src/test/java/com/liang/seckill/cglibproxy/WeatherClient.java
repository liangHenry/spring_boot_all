package com.liang.seckill.cglibproxy;

import java.util.Observable;
import java.util.Observer;

/**
 * Description:
 * Title : 项目：seckill
 * Created in 18/4/13 下午3:29
 *
 * @author : zhaoliang
 */
public class WeatherClient implements Observer {

    private String name;

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o);
        System.out.println(arg);
        System.out.println(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
