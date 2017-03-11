

import java.util.*;
public class ErrorGMethod {
	//声明一个泛型方法，该泛型方法中带一个T形参
   static <T> void test(Collection<T> a, Collection<T> c)
	//static <T> void test(Collection<? extends T> a, Collection<T> c)

	{
		for (T o : a)
		{
			c.add(o);
		}
	}
	public static void main(String[] args) 
	{
		List<Object> ao = new ArrayList<Object>();
		List<String> as = new ArrayList<String>();
		//下面代码将产生编译错误
		test(as , ao);
	}
}

