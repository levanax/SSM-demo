package top.xuebiao.common;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ManagerLister implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("ManagerLister requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("ManagerLister requestInitialized");
	}

}
