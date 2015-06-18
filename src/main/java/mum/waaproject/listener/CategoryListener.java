package mum.waaproject.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import mum.waaproject.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * @author sachindra
 *
 */
@Component
public class CategoryListener implements ServletContextListener, HttpSessionAttributeListener, HttpSessionListener {
	
	@Autowired
	CategoryService categoryService;
	
	public void contextInitialized(ServletContextEvent sce) {
        WebApplicationContextUtils
            .getRequiredWebApplicationContext(sce.getServletContext())
            .getAutowireCapableBeanFactory()
            .autowireBean(this);
     }

	/**
	 * Loads category list in the sessionAttribute
	 */
	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		HttpSession session = sessionEvent.getSession();
		 
       session.setAttribute("categoryList", categoryService.findAll());
    }

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
	
	
}
