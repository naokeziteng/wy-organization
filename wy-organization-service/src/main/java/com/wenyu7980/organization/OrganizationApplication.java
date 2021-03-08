package com.wenyu7980.organization;

import com.wenyu7980.aggregation.EnableWYAggregation;
import com.wenyu7980.authentication.common.feign.EnableWYAuthenticationFeign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author wenyu
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wenyu7980")
@EnableWYAggregation
@EnableWYAuthenticationFeign
public class OrganizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrganizationApplication.class, args);
    }
}
