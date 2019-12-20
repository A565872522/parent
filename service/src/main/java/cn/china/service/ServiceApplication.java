package cn.china.service;

import entity.Student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.StudentService;

@EnableEurekaClient //让他注册服务,告诉service层可以向注册中心注册服务,不注册中心,注册用户获取不到
@SpringBootApplication()
//exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}表示加载数据库的配置文件
@ComponentScan("service")
@MapperScan("mapper")
@RestController
//@MapperScan("mapping")
public class ServiceApplication {

    @Autowired
    StudentService ss;

    @RequestMapping("/getInfo")
    public Student getInfo(){
        return ss.getInfo();
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

}