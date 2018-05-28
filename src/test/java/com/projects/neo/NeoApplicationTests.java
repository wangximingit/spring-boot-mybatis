package com.projects.neo;

import com.projects.neo.api.service.Observer;
import com.projects.neo.api.service.impl.User;
import com.projects.neo.api.service.impl.WechatServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NeoApplicationTests {

	@Test
	public void contextLoads() {

		WechatServer server = new WechatServer();

		Observer userZhang = new User("ZhangSan");
		Observer userLi = new User("LiSi");
		Observer userWang = new User("WangWu");

		server.registerObserver(userZhang);
		server.registerObserver(userLi);
		server.registerObserver(userWang);
		server.setInfomation("PHP是世界上最好用的语言！");

		System.out.println("----------------------------------------------");
		server.removeObserver(userZhang);
		server.setInfomation("JAVA是世界上最好用的语言！");

	}


}
