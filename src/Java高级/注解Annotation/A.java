package Java高级.注解Annotation;

public @interface A {
    // 如果注解中只有一个属性,且属性名为value,则在使用注解时可以省略属性名
    // 例如: @A(value = "someValue")  可以简化成  @A("someValue")
    String value();
}
