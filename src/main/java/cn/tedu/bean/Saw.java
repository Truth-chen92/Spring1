package cn.tedu.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Saw 锯
 */
@Component
@Lazy
public class Saw implements Serializable {
    public Saw (){
        System.out.println("创建了Saw");
    }

    @Override
    public String toString() {
        return "电锯";
    }
}
