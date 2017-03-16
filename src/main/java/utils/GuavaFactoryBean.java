package utils;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangjin on 17/3/15.
 */
public class GuavaFactoryBean implements FactoryBean<GuavaCache>, BeanNameAware, InitializingBean {

    private String name = "";

    private int expired;

    private TimeUnit unit;

    private GuavaCache cache;

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    public void setExpired(int expired) {
        this.expired = expired;
    }

    @Override
    public void setBeanName(String beanName) {
        if (!StringUtils.hasLength(this.name)) {
            setName(beanName);
        }
    }

    @Override
    public GuavaCache getObject() throws Exception {
        return new GuavaCache(name,expired,unit);
    }

    @Override
    public Class<?> getObjectType() {
        return GuavaCache.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //this.cache = new GuavaCache(name);
    }
}
