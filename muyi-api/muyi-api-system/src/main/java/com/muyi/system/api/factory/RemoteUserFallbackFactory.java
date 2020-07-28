package com.muyi.system.api.factory;

import com.muyi.common.core.domain.R;
import com.muyi.system.api.RemoteUserService;
import com.muyi.system.api.model.UserInfo;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 用户服务降级处理
 *
 * @author muyi
 */
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteUserFallbackFactory.class);

    @Override
    public RemoteUserService create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new RemoteUserService() {
            @Override
            public R<UserInfo> getUserInfo(String username) {
                return null;
            }
        };
    }
}
