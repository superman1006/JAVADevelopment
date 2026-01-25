package Java基础._04抽象类Abstract;

import lombok.Data;

@Data
public abstract class Father {
    protected String name;
    protected int age;
    public abstract void show();// 抽象方法
}
