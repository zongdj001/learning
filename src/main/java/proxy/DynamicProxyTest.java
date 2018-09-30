package proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        Hello hello = new HelloImp();
        
        Hello helloProxy = (Hello)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] {Hello.class}, new LogInvocationhandler(hello));
        String result = helloProxy.sayHello("zdj");
        
        System.out.println("proxy returned result is : " + result);
        //toString, hasCode, equals, same behavior with sayHello
        System.out.println(hello.toString());
        //it's will not go proxy
        System.out.println(helloProxy.getClass());
    }
}
