package cn.tedu.test;

import cn.tedu.bean.*;
import cn.tedu.config.Config;
import cn.tedu.spring1.DemoBean;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * test:测试
 * case:案例
 * 测试案例类必须是 共有类！！
 */
public class TestCase {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

    /**
     * 在XXX之前 JUnit提供的注解标注方法 在测试案例之前执行
     * 一般用于初始化
     */
    @Before
    public void init(){
        System.out.println("在测试之前执行...");
    }

    /**
     * 在测试案例之后执行
     * 用于回收测试之前创建的资源
     */
    @After
    public void destroy(){
        System.out.println("释放资源...");
        //spring提供了关闭spring的方法 释放spring中的对象
        ctx.close();
    }
    /**
     * 被测试方法前面要标注@Test
     * 测试方法必须是公有 无返回值 无参数的方法
     */

    @Test
    public void hello(){
        System.out.println("Hello World!");
    }

    /**
     * 测试一下 如果spring中相同类型的对象有一个以上时候
     * 按照类型获取对象将出现异常
     */
    @Test
    public void testGetBean() {
        DemoBean bean = ctx.getBean("demoBean",DemoBean.class);
        System.out.println(bean);
    }
    @Test
    public void testBeanID() {
        DemoBean bean = ctx.getBean("demoBean",DemoBean.class);
        System.out.println(bean);
    }
    @Test
    public void testBeanIDbyType(){
        //按照类型获取全部的BeanID(对象的ID)
        String[] names=ctx.getBeanNamesForType(DemoBean.class);
        for (String name : names) {
            System.out.println(name);
        }
    }
    @Test
    public void testSingle(){
        /**
         * 测试：spring中默认情况下 Javabean是单例的
         * 多次getbean返回的对象都是同一个
         */
        DemoBean bean1=ctx.getBean("demoBean",DemoBean.class);
        DemoBean bean2=ctx.getBean("demoBean",DemoBean.class);
        DemoBean bean3=ctx.getBean("demoBean",DemoBean.class);
        System.out.println(bean1==bean2);
        System.out.println(bean1==bean3);
    }
    @Test
    public void testPrototype(){
        /**
         * 在配置中添加@scope("prototype")就会创建多个实例
         */
        DemoBean bean1=ctx.getBean("demoBean1",DemoBean.class);
        DemoBean bean2=ctx.getBean("demoBean1",DemoBean.class);
        DemoBean bean3=ctx.getBean("demoBean1",DemoBean.class);
        System.out.println(bean1==bean2);
        System.out.println(bean1==bean3);
    }
    @Test
    public void testComponentScan(){
        /**
         * 测试组件扫描功能
         */
        TestBean bean = ctx.getBean(TestBean.class);
        System.out.println(bean);
    }
    @Test
    public void testExampleBean(){
        ExampleBean bean = ctx.getBean(ExampleBean.class);
        System.out.println(bean);
    }
    @Test
    public void testBeanId(){
        String[]names=ctx.getBeanNamesForType(ExampleBean.class);
        for (String name : names) {
            System.out.println(name);
        }
        names=ctx.getBeanNamesForType(MYExampleBean.class);
        for (String name : names) {
            System.out.println(name);
        }
        names = ctx.getBeanNamesForType(TestExampleBean.class);
        for (String name : names) {
            System.out.println(name);
        }
    }
    @Test
    public void testLazy(){
        /**
         * 测试懒惰初始化
         */
        TestExampleBean teb=ctx.getBean(TestExampleBean.class);
        System.out.println(teb);
        Saw saw = ctx.getBean(Saw.class);
        System.out.println(saw);

    }
    @Test
    public void testDataSource() throws SQLException {
        DruidDataSource dataSource = ctx.getBean(DruidDataSource.class);
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
    }


}
