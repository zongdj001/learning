package annotation;

import java.lang.reflect.Method;

public class Sub extends Parent {

    @Override
    public void m1() {
        System.out.println("in Sub m1");
    }
//    @Override
//    public void m2() {
//        super.m2();
//        System.out.println("in Sub m2");
//    }
    public static void main(String[] args) throws SecurityException,  
        NoSuchMethodException {

        Class<Sub> clazz = Sub.class;

        if (clazz.isAnnotationPresent(MyAnnoation.class)) {
            MyAnnoation cla = clazz.getAnnotation(MyAnnoation.class);
            System.out.println("子类继承到父类类上Annotation,其信息如下：" + cla.value());
        } else {
            System.out.println("子类没有继承到父类类上Annotation");
        }

        // 实现抽象方法测试
        Method method = clazz.getMethod("m1", new Class[] {});
        if (method.isAnnotationPresent(MyAnnoation.class)) {
            MyAnnoation ma = method.getAnnotation(MyAnnoation.class);
            System.out.println("子类实现父类的abstractMethod抽象方法，继承到父类抽象方法中的Annotation,其信息如下：" + ma.value());
        } else {
            System.out.println("子类实现父类的abstractMethod抽象方法，没有继承到父类抽象方法中的Annotation");
        }

        // 覆盖测试
        Method methodOverride = clazz.getMethod("m2", new Class[] {});
        if (methodOverride.isAnnotationPresent(MyAnnoation.class)) {
            MyAnnoation ma = methodOverride.getAnnotation(MyAnnoation.class);
            System.out.println("子类继承父类的doExtends方法，继承到父类doExtends方法中的Annotation,其信息如下：" + ma.value());
        } else {
            System.out.println("子类继承父类的doExtends方法，没有继承到父类doExtends方法中的Annotation");
        }

    
    }  
}
