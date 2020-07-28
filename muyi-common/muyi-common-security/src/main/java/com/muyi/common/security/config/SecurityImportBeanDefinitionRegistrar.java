package com.muyi.common.security.config;

import com.muyi.common.core.utils.StringUtils;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 导入 SecurityImportBeanDefinitionRegistrar 自动加载类
 *
 * @author muyi
 */
public class SecurityImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        Class<ResourceServerConfig> aClass = ResourceServerConfig.class;
        String beanName = StringUtils.uncapitalize(aClass.getSimpleName());
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(ResourceServerConfig.class);
        registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
    }
}
