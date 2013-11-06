package org.bk.trade;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] params)
            throws Throwable {
        long a = System.currentTimeMillis();
        Thread.sleep(1000);
        Object result = method.invoke(target, params);
        System.out.println("total time taken  " + (System.currentTimeMillis() - a));
        return result;
    }

}