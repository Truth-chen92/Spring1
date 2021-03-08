package cn.tedu.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Component组件 用于标注通用
 */
@Component
public class TestBean implements Serializable {
    @Override
    public String toString() {
        return "Test Bean.";
    }
}
