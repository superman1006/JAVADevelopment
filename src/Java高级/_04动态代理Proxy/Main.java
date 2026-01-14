package Java高级._04动态代理Proxy;

public class Main {
    static void main() {
        // 动态代理: 在程序运行期间动态创建一个类,该类实现指定接口,并对接口中的方法进行增强
        // 提供一个接口,对象实现这个接口，代理也实现这个接口

        // 1.创建代理对象
        Star star = new Star("ZYY");

        // 2.创建一个属于 ZYY 的代理对象
        // 写 StarService 接口类型是因为 Star实现了这个接口, Proxy也(间接)实现了这个接口,这是多态写法
        StarService proxy = StarProxy.createProxy(star);

        // 3.通过代理对象调用方法
        proxy.sing("《超人不会飞》");
        System.out.println("==========================");
        String danceReturn = proxy.dance("Jazz");
        System.out.println("dance 方法的返回值: " + danceReturn);
    }
}
