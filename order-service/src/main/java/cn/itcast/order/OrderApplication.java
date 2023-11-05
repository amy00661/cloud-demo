package cn.itcast.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 創建RestTemplate並注入Spring容器
     */
    @Bean
    @LoadBalanced   // 標註這個RestTemplate的請求，都要被Ribbon處理了
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    /*@Bean
    public IRule randomRule() {
        return new RandomRule();
    }*/
}