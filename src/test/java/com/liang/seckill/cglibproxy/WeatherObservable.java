package com.liang.seckill.cglibproxy;

import java.util.Observable;

/**
 * Description:
 * Title : 项目：seckill
 * Created in 18/4/13 下午3:27
 *
 * @author : zhaoliang
 */
public class WeatherObservable extends Observable {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        setChanged();
        this.notifyObservers(content);
        clearChanged();
    }
}
