package com.press;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Proxy;

public class FooImplTest {
    @Test
    public void testBar() throws Exception {

        IFoo foo = new FooImpl();

        IFoo proxy =(IFoo) Proxy.newProxyInstance(FooImplTest.class.getClassLoader(), foo.getClass().getInterfaces(), new MyInvocationHandler(foo));
        proxy.bar();
        assertNotNull(proxy);
    }
}
