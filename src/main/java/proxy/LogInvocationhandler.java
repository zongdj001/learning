package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationhandler implements InvocationHandler {
    private Object object;
    public LogInvocationhandler(Object obj) {
        this.object = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("This is dynamic proxy : " + proxy.getClass().getName());
        System.out.println("LogInvocationhandler invoke begin");
   
        System.out.println("method: "+ method.getName());
        if (args != null) {
            for(Object methodArg : args){ 
                System.out.println("arg: "+ methodArg); 
            }   
        }
     
        Object result = method.invoke(object, args);        
        System.out.println("LogInvocationhandler invoke end");
        return result;
    }

}
