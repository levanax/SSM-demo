package top.xuebiao.security;

import javax.annotation.PostConstruct;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ModelAttribute;

@Configuration
public class ShiroSecurityConfig {

	@Bean
	public Realm realm() {
		TextConfigurationRealm realm = new TextConfigurationRealm();
		realm.setUserDefinitions("joe.coder=password,user\n" + "jill.coder=password,admin");

		realm.setRoleDefinitions("admin=read,write\n" + "user=read");
		realm.setCachingEnabled(true);
		return realm;
	}
	@Bean
    public DefaultSecurityManager securityManager(){
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(realm());
        return securityManager;
    }
	
//	@Autowired
//	private SecurityManager securityManager;
//	    
//	 @PostConstruct
//	 private void initStaticSecurityManager() {
//	     SecurityUtils.setSecurityManager(securityManager);
//	 }

	@Bean
	public ShiroFilterChainDefinition shiroFilterChainDefinition() {
		DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
		chainDefinition.addPathDefinition("/**", "anon"); // all paths are managed via annotations

		// or allow basic authentication, but NOT require it.
		// chainDefinition.addPathDefinition("/**", "authcBasic[permissive]");
		return chainDefinition;
	}

	@ModelAttribute(name = "subject")
	public Subject subject() {
		return SecurityUtils.getSubject();
	}

}
