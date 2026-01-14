package Java高级._04动态代理Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Star的代理类
public class StarProxy {
    public static StarService createProxy(Star s){
        // 创建代理对象
        StarService sProxy= (StarService) Proxy.newProxyInstance(
                // 参数一: 类加载器
                StarProxy.class.getClassLoader(),
                // 参数二: 代理类实现的所有接口,这里是 StarService 接口,底层会去实现这个接口
                s.getClass().getInterfaces(),
                // 参数三: 处理类,当调用代理对象的方法时,会调用该处理类中的 invoke 方法
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 重要的是第二和三个参数
                        // method 代表用户在调用代理对象的哪个方法,比如说Main中调用 proxy.sing("..."), 那么 method 就代表 sing 方法
                        // args 代表调用代理对象的方法时传递的参数,比如说 Main 中调用 proxy.dance("Jazz"), 那么 args 就是"Jazz"
                        if (method.getName().equals("sing")) {
                            System.out.println("StarProxy: sing 前面要执行的操作...");
                        }else if(method.getName().equals("dance")){
                            System.out.println("StarProxy: dance 前面要执行的操作...");
                        }
                        // 调用真实对象的方法 (反射写法: method.invoke(对象, 参数数组))
                        Object result = method.invoke(s,args);
                        return result;
                    }
                }
        );
        return sProxy;
    }
}
