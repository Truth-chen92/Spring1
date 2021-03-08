package cn.tedu.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Component 组件 用于标注通用
 * @Service 服务 用于标注业务层组件
 * @Controller 控制器 用于标注控制器层组件
 * @Respository 仓库 用于标注数据存储组件
 */
@Service
public class ExampleBean {
    @Override
    public String toString() {
        return "ExampleBean.";
    }

}
