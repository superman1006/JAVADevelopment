package Java高级._01单元测试Junit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringUtilTest {
    // 测试方法: 必须是 public , void , 无参数
    // 测试方法必须加上@Test 注解

    @Test
    public void tesPrintNumber(){
        StringUtil.printNumber("hello");
        StringUtil.printNumber("");
        StringUtil.printNumber(null);
    }

    @Test
    public void testGetMaxIndex(){
        int index1 = StringUtil.getMaxIndex("hello");
        int index2 = StringUtil.getMaxIndex("");
        int index3 = StringUtil.getMaxIndex(null);

        Assert.assertEquals(index1, 4);
        Assert.assertEquals(index2, -1);
        Assert.assertEquals(index3, -1);
    }
}
