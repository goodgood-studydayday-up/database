package info.lumanman.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class HelloWorld {

	public static void main(String[] args) {
		Factory<SecurityManager> factory =new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager=factory.getInstance();
		
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject currentUser=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken("java1234", "123456");
		try {
			currentUser.login(token);
			System.out.println("µÇÂ½³É¹¦");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("µÇÂ¼Ê§°Ü");
		}
		currentUser.logout();
		
		
	}
}
