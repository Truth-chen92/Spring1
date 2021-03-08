package cn.tedu.config;

import cn.tedu.spring1.DemoBean;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


/**
 * @Configuration Spring提供的注解 用于标注在Spring配置类上
 * 表示当前类作为Spring的配置文件 其中可以声明Spring中创建的对象
 */
@Configuration
/**
 * @ComponentScan("cn.tedu.bean")开启组件扫描功能
 * spring启动后会自动扫描cn.tedu.bean 包和其子包中的类
 * 如果类上标注了@ComponentScan就会在spring创建该类型的对象
 */
@ComponentScan("cn.tedu.bean")
public class Config {
    /**
     * @return
     * @Bean Spring提供的注解 标注在创建对象的方法上
     * Spring启动时 会自动寻找 配置类中标注了@Bean注解的方法
     * 找到以后会执行方法 创建对象
     */
    @Bean
    public DemoBean demoBean() {
        return new DemoBean();
    }
    //创建对象的方法名 就是为对象分配的唯一 BeanID
    @Bean
    //spring按照多个实例管理对象
    @Scope("prototype")
    public DemoBean demoBean1() {
        return new DemoBean();
    }

    /**
     * 利用spring管理数据库
     * @return
     */
    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName();
        dataSource.setUrl("jdbc:mysql://localhost:3306/vrd?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");
        dataSource.setUsername("root");
        dataSource.setPassword("truth");
        return dataSource;
    }
}
