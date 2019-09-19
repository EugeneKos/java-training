package ru.eugene.java.learn.config;

import net.sf.ehcache.Cache;
import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
@PropertySource("classpath:cache/cache-config.properties")
public class EhCacheConfiguration {
    @Value("${cache.timeToLiveSeconds}")
    private String timeToLiveSeconds;

    @Bean
    public CacheManager cacheManager() {
        net.sf.ehcache.CacheManager cacheManager = ehCacheCacheManager().getObject();
        Cache cache = cacheManager.getCache("exampleCache");
        CacheConfiguration cacheConfiguration = cache.getCacheConfiguration();
        cacheConfiguration.setTimeToLiveSeconds(Long.parseLong(timeToLiveSeconds));
        return new EhCacheCacheManager(cacheManager);
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager() {
        EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
        cmfb.setConfigLocation(new ClassPathResource("cache/ehcache.xml"));
        cmfb.setShared(true);
        return cmfb;
    }
}
