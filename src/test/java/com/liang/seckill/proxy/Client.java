package com.liang.seckill.proxy;

import com.liang.seckill.proxy.*;

public class Client {

	/**
	 * 测试类
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class,h);
		m.move();
	}

}
