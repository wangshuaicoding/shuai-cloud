package com.shuai.message.api.config;


import com.shuai.common.autoconfigure.mq.RabbitMqHelper;
import com.shuai.message.api.client.AsyncSmsClient;
import feign.RequestInterceptor;
import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.shuai.common.constants.Constant.*;


@Configuration
@EnableFeignClients(basePackages = "com.shuai.message.api.client")
public class MessageClientConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public RequestInterceptor requestIdInterceptor(){
        return template -> template
                .header(REQUEST_ID_HEADER, MDC.get(REQUEST_ID_HEADER))
                .header(REQUEST_FROM_HEADER, FEIGN_ORIGIN_NAME);
    }

    @Bean
    public AsyncSmsClient smsClient(RabbitMqHelper mqHelper){
        return new AsyncSmsClient(mqHelper);
    }
}