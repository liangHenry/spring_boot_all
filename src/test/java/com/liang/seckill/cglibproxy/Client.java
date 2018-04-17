package com.liang.seckill.cglibproxy;

/**
 * Description:
 * Title : 项目：seckill
 * Created in 18/4/13 下午3:28
 *
 * @author : zhaoliang
 */
public class Client {

    public static void main(String[] args) {
        WeatherObservable weatherObservable=new WeatherObservable();

        WeatherClient client1=new WeatherClient();
        client1.setName("A");
        WeatherClient client2=new WeatherClient();
        client2.setName("B");

        weatherObservable.addObserver(client1);
        weatherObservable.addObserver(client2);

        weatherObservable.setContent("hello");

    }
}
