
import java.util.*;

public class Apple2<T extends Number>
{
	T col;
	
	public static void main(String[] args)
	{
		Apple2<Integer> ai = new Apple2<Integer>();
		Apple2<Double> ad = new Apple2<Double>();
		//下面代码将引起编译异常
		//因为String类型传给T形参，但String不是Number的子类型。
		Apple2<String> as = new Apple2<String>();
		
	}
}

