package com.up;

import javax.servlet.Filter;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	
	/**
	 * 加入struts2的Filter，相当于web.xml部分对struts2的配置
	 * @return
	 */
	@Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(someFilter());
        registration.addUrlPatterns("/*");
        registration.setName("someFilter");
        return registration;
    }
	
	
	/**
	 * 注入struts2所需要的Filter
	 * @return
	 */
    @Bean(name = "someFilter")
    public Filter someFilter() {
        return new StrutsPrepareAndExecuteFilter();
    }
    
    /**
     * 注入Hibernate的sessionFactory，以便Dao类中以Autowired方式使用
     * @return 
     */
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
	    return new HibernateJpaSessionFactoryBean();
	}

	/**
	 * 主函数，Spring Boot从这里运行
	 * @param args
	 */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}