Proxy代理:
    proxy 的作用:一些方法需要在执行前后做一些附加操作,但是又不想修改原有类的代码,这时就可以使用动态代理.！！！！！！
        后续的 Spring AOP 就是基于动态代理实现的.
    可以理解为 Star s 是一个明星,他有 sing 和 dance 两个操作,
    但是我们不直接找 明星本人 去 sing 和 dance, 而是通过一个经纪人(StarProxy的实例)去找明星,经纪人帮我们完成唱歌跳舞的操作.
    这样做的好处是,我们可以在经纪人类里对唱歌跳舞的操作进行一些附加操作,比如收钱,安排时间等等.
    比如说:StarProxy实例会调用 sing(xxx),然后在知道有人想要明星sing 后，执行明星 sing()之前经纪人需要执行的操作(比如收钱),然后再调用明星的 sing() 方法.
    结构图:
                                  interface接口(包含需要实现的方法)
                                        /              \
                                       /                \
                      (implements)    /                  \    (!不用implements) >------------------┐
                                 Star类                 StarProxy类(star的代理类)-------->(类加载器,所有接口,重写invoke)
                                   /                        \
                              s.sing(xxx)               proxy.sing(xxx)
                             s.dance(xxx)             调用proxy.dance(xxx)  ---->  proxy执行 重写好的invoke方法
                                                                                                ｜
                                                                                             invoke 知道 1.method 参数是 dance
                                                                                                |       2.args 参数是 "xxx"
                                                                                                V
                                                                                  先执行 自定义操作,在执行 method("xxx")
