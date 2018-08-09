package com.jyf.ex.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 * //@EnableScheduling   //开启定时任务
 * //@EnableAsync        //开启异步任务
 * //@EnableCaching      //开启缓存
 */
@SpringBootApplication
@EnableCaching
public class EhcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhcacheApplication.class, args);
	}
}
