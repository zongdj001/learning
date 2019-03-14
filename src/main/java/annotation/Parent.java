package annotation;
@MyAnnoation(value = "on class Parent")
public abstract class Parent {
    @MyAnnoation(value = "on parent abstract")
    public abstract void m1();
    
    @MyAnnoation(value = "on parent method2")
    public  void m2() {
        System.out.println("method2");
    };
    
}
