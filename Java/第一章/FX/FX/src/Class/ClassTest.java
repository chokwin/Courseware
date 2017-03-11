package Class;
import java.lang.reflect.*;


public class ClassTest
{
	
	static {  

        System.out.println("static block");

    }

  {
    System.out.println("dynamic block");
  }

	//为该类定义一个私有的构造器
	private ClassTest()
	{
		System.out.println("执行无参数的构造器"); 
	}
	//定义一个有参数的构造器
	public ClassTest(String name)
	{
		System.out.println("执行有参数的构造器");
	}
	//定义一个无参数的info方法
	public void info()
	{
		System.out.println("执行无参数的info方法");
	}
	//定义一个有参数的info方法
	public void info(String str)
	{
		System.out.println("执行有参数的info方法"
			+ "，其实str参数值：" + str);
	}
	
	public static void main(String[] args) 
		throws Exception
	{
		
		//调用class属性获取Class对象
		Class<ClassTest> clazz1 = ClassTest.class;
	
		//调用Class类的forName()方法获取Class对象,会抛出NoClassDefFoundError错误
		Class<?> clazz2 = Class.forName("Class.ClassTest");
		
		//调用对象的getClass方法来获取Class对象
		//ClassTest c=new ClassTest();
		//Class<?> clazz3=c.getClass();
	
		
	
		
		/**
		//获取该Class对象所对应类的全部构造器
		Constructor[] ctors = clazz.getDeclaredConstructors();
		System.out.println("ClassTest的全部构造器如下：");
		for (Constructor c : ctors)
		{
			System.out.println(c);
		}
		System.out.println("************************************************");
		//获取该Class对象所对应类的全部public构造器
		Constructor[] publicCtors = clazz.getConstructors();
		System.out.println("ClassTest的全部public构造器如下：");
		for (Constructor c : publicCtors)
		{
			System.out.println(c);
		}
		System.out.println("**************************************************");
		//获取该Class对象所对应类的全部public方法
		Method[] mtds = clazz.getMethods();
		System.out.println("ClassTest的全部public方法如下：");
		for (Method md : mtds)
		{
			System.out.println(md);
		}
		//获取该Class对象所对应类的指定方法
		System.out.println("ClassTest里带一个字符串参数的info方法为："
			+ clazz.getMethod("info" , String.class));
		System.out.println("**************************************************");
		//获取该Class对象所对应类的全部内部类
		Class<?>[] inners = clazz.getDeclaredClasses();
		System.out.println("ClassTest的全部内部类如下：");
		for (Class c : inners)
		{
			System.out.println(c);
		}
		
		System.out.println("ClassTest的包为：" + clazz.getPackage());
		System.out.println("ClassTest的父类为：" + clazz.getSuperclass());*/
	}
}
