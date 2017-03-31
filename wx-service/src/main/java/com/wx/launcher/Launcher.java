package com.wx.launcher;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.container.Main;

public class Launcher {
	private static volatile boolean running = true;

	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring/applicationContext.xml" });
		context.start();
		System.out.println("Æô¶¯³É¹¦!");
		synchronized (Main.class) {
			while (running) {
				try {
					Main.class.wait();
				} catch (Throwable e) {
					System.out.println("Error"+ e);
				}
			}
		}
	}
}
