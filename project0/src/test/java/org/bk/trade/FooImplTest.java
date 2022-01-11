package org.bk.trade;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.*;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class FooImplTest {
    @Test
    public void testBar() throws Exception {

        IFoo foo = new FooImpl();

        IFoo proxy =(IFoo) Proxy.newProxyInstance(FooImplTest.class.getClassLoader(), foo.getClass().getInterfaces(), new MyInvocationHandler(foo));
        proxy.bar();
        assertNotNull(proxy);
    }
}
