package cn.tedu;

import cn.tedu.config.Config;
import cn.tedu.spring1.DemoBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        /**
         * 测试Spring可以创建管理对象（IOC)
         * Annotation:注解
         * Config:配置
         * Application:应用程序
         * Context:上下文
         * 创建对象时 必须提供配置类类名
         */
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        //Spring提供了getBean方法 参数是类型 返回值是Spring创建的对象
        DemoBean bean=ctx.getBean("demoBean",DemoBean.class);
        //检查对象 输出bean 自动调用toString()
        System.out.println(bean);
        //当按照类型获取对象有冲突的时候 就可以按照对象的ID获取对象
//         默认情况下 ID就是配置文件中创建对象的方法名
//        getBean方法根据对象ID获取对象 参数是对象ID 如果ID错误 抛出异常
        DemoBean demoBean = ctx.getBean("demoBean1",DemoBean.class);
        System.out.println(demoBean);
    }
}
