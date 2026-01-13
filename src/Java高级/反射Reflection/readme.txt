反射是在 "运行时" 获取类的信息并操作类的机制
反射作用: *1.!! 可以得到一个Class 类的全部成分然后操作
          2.可以破坏封装性,可以操作私有成员变量和私有方法
          3.可以绕过泛型检查(因为泛型检查是在编译时)
         *4.!! 适合做 java 的框架，所有主流的框架都是基于反射设计的,比如 Spring,Mybatis等等

传统方法:    实例.成员方法(参数)
反射机制:    成员方法.xx(实例,参数)
完全是反过来的,有点像脱裤子放屁,但是反射机制可以动态获取类的信息,动态调用方法,动态创建对象,非常重要!!!!


                                                           Student.class
                                                                 |    (获得class对象）
                                                             class对象
                                                                 |
           ┌────────────────────────────┐───────────────────────────────────────────┐────────────────────────────────────┐
         拿名字                       拿构造器                                     拿成员变量                            拿成员方法
           |                            |                                           |                                    |
     .getName()             .getDeclaredConstructor()                  .getDeclaredField(成员变量名字)         .getDeclaredMethod(方法名,参数类型)
    .getSimpleName()         .getDeclaredConstructor(参数类型)             .getDeclaredFields()                   .getDeclaredMethods()
                            .getDeclaredConstructors()                              /\                                   ｜
                                        |                                         /    \                          .invoke(实例,参数)
                            .newInstance(参数)创建对象                   .set(实例,新值)  .get(实例)