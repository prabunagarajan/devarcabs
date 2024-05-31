package com.devar.cabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
////@EnableEurekaClient
@ComponentScan("com.devar.*")
@EntityScan("com.devar.*")
//@EnableJpaRepositories("com.devar.*")
@EnableJpaAuditing
//@Log4j2
//@EnableDiscoveryClient
//@EnableAsync
//@RefreshScope
//@EnableScheduling
//@EnableCaching
public class DevarCabsApplication {

	
//	@Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
	public static void main(String[] args) {
		SpringApplication.run(DevarCabsApplication.class, args);
	}
	
	
	
	
//	@Bean
//	public RestTemplate restTemplate() {
//		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//		requestFactory.setReadTimeout(90000);
//		return new RestTemplate(requestFactory);
//	}
	
//	@Bean
//	public CorsFilter corsFilter() {
//	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	    final CorsConfiguration config = new CorsConfiguration();
//	    config.setAllowCredentials(true);
//	    config.addAllowedOrigin("*");
//	    config.addAllowedHeader("*");
//	    config.addAllowedMethod("OPTIONS");
//	    config.addAllowedMethod("HEAD");
//	    config.addAllowedMethod("GET");
//	    config.addAllowedMethod("PUT");
//	    config.addAllowedMethod("POST");
//	    config.addAllowedMethod("DELETE");
//	    config.addAllowedMethod("PATCH");
//	    source.registerCorsConfiguration("/**", config);
//	    return new CorsFilter(source);
//	}
//	
////	@Bean
////	StringDigester PasswordHash() {
////		final PooledStringDigester stringDigester = new PooledStringDigester();
////		stringDigester.setAlgorithm("SHA-256");
////		stringDigester.setIterations(1000);
////		stringDigester.setSaltSizeBytes(10);
////		stringDigester.setPoolSize(16);
////		stringDigester.initialize();
////		return stringDigester;
////
////	}
//	
//	/**
//	 * @return
//	 */
////	@Bean
////	public AuditorAware<Long> auditorAware() {
////		UserAuditAware userAuditAware = new UserAuditAware();
////		if (userAuditAware!=null && userAuditAware.getCurrentAuditor() != null) {
////			log.info("current user >>>> " + userAuditAware.getCurrentAuditor());
////		}
////		return userAuditAware;
////	}
//	/**
//	 * Async call execution to other services
//	 * @return
//	 */
//	@Bean(name="processExecutorHelpdesk")
//    public TaskExecutor workExecutor() {
//        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.setThreadNamePrefix("Async-");
//        threadPoolTaskExecutor.setCorePoolSize(3);
//        threadPoolTaskExecutor.setMaxPoolSize(3);
//        threadPoolTaskExecutor.setQueueCapacity(600);
//        threadPoolTaskExecutor.afterPropertiesSet();        
//        return threadPoolTaskExecutor;
//    }
//	
//	@Bean
//	public MessageSource messageSource() {
//		
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasenames("classpath:messages/messages","classpath:messages/messages_en");
//		messageSource.setDefaultEncoding("UTF-8");
//		messageSource.setFallbackToSystemLocale(false);
//		return messageSource;
//		
//	}
//	
//
//	@Bean
//	public LocaleResolver localeResolver() {
//	    AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
//	    localeResolver.setDefaultLocale(Locale.ENGLISH);
//	    return localeResolver;
//	}
//	 
//	
	

	
}
