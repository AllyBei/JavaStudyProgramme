package cn.hrs.allybei.JavaStudy.SpringBoot.testConditionalAnnotation;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

@ConditionalOnExpression
public class MagicCondition implements Condition {

    private final String beanName;
    private final Long id;
    private static MagicCondition bean = null;

    private MagicCondition() {
        this.beanName = "MagicConditionalBean";
        this.id = 1l;
    }


    public static MagicCondition ConditionalBeanTestFactory() {
        if (bean == null) {
            bean = new MagicCondition();
        }
        return bean;

    }


    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

       Environment env = conditionContext.getEnvironment();

       if (env.containsProperty("magic")){
           if(env instanceof Map){
               String magicProperty = (String)((Map) env).get("magic");
               return magicProperty.equals("true");
           }
       }
        return false;
    }
}
