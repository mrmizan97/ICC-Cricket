package com.mizan;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//public class AppInitializer implements WebApplicationInitializer {
//
//	public void onStartup(ServletContext servletCxt) {
//
//		// Load Spring web application configuration
//		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//		rootContext.register(RootConfig.class);
//		rootContext.refresh();
//
//		servletCxt.addListener(new ContextLoaderListener(rootContext));
//
//		// Create and register the DispatcherServlet
//		AnnotationConfigWebApplicationContext servletRegisterer = new AnnotationConfigWebApplicationContext();
//		servletRegisterer.register(ServletConfig.class);
//		ServletRegistration.Dynamic registration = servletCxt.addServlet("servlet",
//				new DispatcherServlet(servletRegisterer));
//		registration.setLoadOnStartup(1);
//		registration.addMapping("/");
//	}
//}

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}