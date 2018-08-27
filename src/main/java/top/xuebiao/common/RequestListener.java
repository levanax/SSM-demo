package top.xuebiao.common;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("RequestListener requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("RequestListener requestInitialized");
	}

}
