package ba.biggy.config;


import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ba.biggy.dao.FaultDAO;
import ba.biggy.dao.ProductDAO;
import ba.biggy.dao.UserInfoDAO;
import ba.biggy.dao.impl.FaultDAOImpl;
import ba.biggy.dao.impl.ProductDAOImpl;
import ba.biggy.dao.impl.UserInfoDAOImpl;


@Configuration
@ComponentScan(basePackages="ba.biggy.*")
@EnableTransactionManagement
@EnableWebMvc
@Import({ SecurityConfig.class })
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class MvcConfiguration extends WebMvcConfigurerAdapter{


	
	
	@Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	} 
	
    @Bean
    public CookieLocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.GERMAN);
        localeResolver.setCookieName("my-locale-cookie");
        localeResolver.setCookieMaxAge(3600);
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeInterceptor(){
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeInterceptor());
    }
	
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        
        //local db
        dataSource.setUrl("jdbc:mysql://localhost:3306/webprojectdb");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        
        
        //online db
        /*dataSource.setUrl("jdbc:mysql://localhost:3306/biggyba_webprojectdb");
        dataSource.setUsername("biggyba_webproje");
        dataSource.setPassword("i^+-JMn_gOee");*/
         
        return dataSource;
    }
	
	
	
	@Bean
	public FaultDAO getFaultDAO() {
		return new FaultDAOImpl(getDataSource());
	}
	
	@Bean
	public UserInfoDAO getUserInfoDAO() {
		return new UserInfoDAOImpl(getDataSource());
	}
	
	@Bean 
	public ProductDAO getProductDAO() {
		return new ProductDAOImpl(getDataSource());
	}
	
	
	
	
}
