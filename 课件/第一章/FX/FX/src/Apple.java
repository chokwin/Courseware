//定义自己的泛型类

//定义Apple类时使用了泛型声明
public class Apple<T>
{
	//使用T类型形参定义属性
	private T info;

	public Apple(){}
	//下面方法中使用T类型形参来定义方法
	public Apple(T info)
	{
		this.info = info;
	}
	public void setInfo(T info)
	{
		this.info = info;
	}
	public T getInfo()
	{
		 return this.info;
	}
	public static void main(String[] args)
	{
		//因为传给T形参的是String实际类型，所以构造器的参数只能是String
		Apple<String> a1 = new Apple<String>("苹果");
		System.out.println(a1.getInfo());
		//因为传给T形参的是Double实际类型，所以构造器的参数只能是Double或者double
		Apple<Double> a2 = new Apple<Double>(5.67);
		System.out.println(a2.getInfo());
	}
}

//class sub extends Apple<T>{  }