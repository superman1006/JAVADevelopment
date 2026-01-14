package Java高级._04动态代理Proxy;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Star implements StarService {
    private String name;

    @Override
    public void sing(String song) {
        System.out.println(this.name + "正在唱" + song);
    }

    @Override
    public String dance(String name) {
        System.out.println(this.name + "正在跳" + name);
        return "thanks!";
    }
}
