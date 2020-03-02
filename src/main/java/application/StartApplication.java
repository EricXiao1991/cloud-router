package application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/***
 * spring boot 启动器
 * 注意：请保证controller/dao等需要扫描的组件目录或父级目录必须与StartApplication.java保持同级
 * 例如：
 *  startApplication.java
 *  controller
 *      democontroller.java
 *  dao
 *      comdao.java
 *  service
 *      comservice.java
 */


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("application.csd.dao.interfaces.com")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
        System.out.println("------》》》启动成功！我的FOUNDER!!!!");
    }





}
