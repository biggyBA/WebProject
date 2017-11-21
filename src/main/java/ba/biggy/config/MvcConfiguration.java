package ba.biggy.config;


import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.mobile.device.DeviceWebArgumentResolver;
import org.springframework.mobile.device.site.SitePreferenceHandlerInterceptor;
import org.springframework.mobile.device.site.SitePreferenceHandlerMethodArgumentResolver;
import org.springframework.mobile.device.switcher.SiteSwitcherHandlerInterceptor;
import org.springframework.mobile.device.view.LiteDeviceDelegatingViewResolver;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

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
	public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
	    return new DeviceResolverHandlerInterceptor();
	}
	
	@Bean
	public SitePreferenceHandlerInterceptor sitePreferenceHandlerInterceptor() {
	    return new SitePreferenceHandlerInterceptor();
	}
	
	@Bean
	public SitePreferenceHandlerMethodArgumentResolver sitePreferenceHandlerMethodArgumentResolver() {
	    return new SitePreferenceHandlerMethodArgumentResolver();
	}
	
	@Bean
	public DeviceHandlerMethodArgumentResolver deviceHandlerMethodArgumentResolver() {
	    return new DeviceHandlerMethodArgumentResolver();
	}
	
	

	@Bean
	public ViewResolver beanNameViewResolver() {
	      ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
	      resolver.setOrder(1);
	      resolver.setBasename("views");
	      return resolver;
	}
	
	
	@Bean
	public LiteDeviceDelegatingViewResolver liteDeviceAwareViewResolver() {
	    InternalResourceViewResolver delegate = new InternalResourceViewResolver();
	    delegate.setOrder(2);
	    delegate.setPrefix("/WEB-INF/views/");
	    delegate.setSuffix(".jsp");
	    LiteDeviceDelegatingViewResolver resolver = new LiteDeviceDelegatingViewResolver(delegate);
	    resolver.setMobilePrefix("mobile/");
	    resolver.setTabletPrefix("tablet/");
	    resolver.setNormalPrefix("web/");
	    resolver.setEnableFallback(true);
	    return resolver;
	}
	
	
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	} 
	
    /*@Bean (name = "localeResolver")
    public LocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.GERMAN);
        localeResolver.setCookieName("my-locale-cookie");
        localeResolver.setCookieMaxAge(3600);
        return localeResolver;
    }*/
    
    @Bean (name = "localeResolver")
    public SessionLocaleResolver sessionLocaleResolver() {
    	SessionLocaleResolver localeResolver = new SessionLocaleResolver();
    	localeResolver.setDefaultLocale(Locale.GERMAN);
    	return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeInterceptor(){
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("language");
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeInterceptor());
        registry.addInterceptor(deviceResolverHandlerInterceptor());
	    registry.addInterceptor(sitePreferenceHandlerInterceptor());
    }
    
    @Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
	    argumentResolvers.add(sitePreferenceHandlerMethodArgumentResolver());
	    argumentResolvers.add(deviceHandlerMethodArgumentResolver());
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
