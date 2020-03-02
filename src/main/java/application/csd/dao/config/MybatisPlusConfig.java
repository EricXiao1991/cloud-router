package application.csd.dao.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能:mybatis-plus 配置
 *
 * @date: 2019-06-25 14:02
 * @author: allenZyhang@163.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        System.out.println("------》》》mybatis-plus-config-初始化！！！");
        return new PaginationInterceptor();
    }
}
