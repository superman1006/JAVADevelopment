package Java基础._01Class重要小技巧;

import lombok.AllArgsConstructor; // 导入Lombok的@AllArgsConstructor注解
import lombok.Data; // 导入Lombok的@Data注解
import lombok.NoArgsConstructor;

@Data
//作用: 自动生成getter、setter方法

@AllArgsConstructor
//作用: 自动生成包含所有字段的构造方法Card(String CarID, String name, String phone, double money)

@NoArgsConstructor
//作用: 自动生成无参构造方法Card()

public class Card {
    private String CarID;
    private String name;
    private String phone;
    private double money = 0.0;

}


/*
*  第一次使用lombok时要  启动IDEA的注解处理器!!

  1. 打开 File → Settings (Ctrl+Alt+S)
  2. 进入 Build, Execution, Deployment → Compiler → Annotation Processors
  3. 勾选 "Enable annotation processing"
  4. 点击 Apply 和 OK

* */