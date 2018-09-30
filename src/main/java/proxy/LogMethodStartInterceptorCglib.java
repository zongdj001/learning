package proxy;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class LogMethodStartInterceptorCglib implements MethodInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogMethodStartInterceptorCglib.class);
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        LOGGER.info("Before enter into method {} at time {}", method.getName(), System.currentTimeMillis() );
        proxy.invokeSuper(obj, args);
        LOGGER.info("Finish enter into method {} at time {}", method.getName(), System.currentTimeMillis() );
        return null;
    }

}
