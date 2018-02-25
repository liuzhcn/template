package cn.sibetech;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@Controller
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



	//首页入口
	@RequestMapping("/")
	public String index(){
		return "/index";
	}

	@RequestMapping("/login")
	public String login(){
		return "/login";
	}

	@Bean
	public Realm realm(){
		return new SibeRealm();
	}

	@Bean
	public ShiroFilterChainDefinition shiroFilterChainDefinition() {
		DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
		chainDefinition.addPathDefinition("/console", "authc");

		return chainDefinition;
	}


}
