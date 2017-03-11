
import java.util.*;

public class Canvas
{
	//同时在画布上绘制多个形状
	public void drawAll(List<Shape> shapes)
	//public void drawAll(List<?> shapes)
	//public void drawAll(List<? extends Shape> shapes)
	{
		for (Shape s : shapes)
		//for (Object o : shapes)
		{
			//Shape s=(Shape)o;
			s.draw(this);
		}
	}
	
	public static void main(String[] args)
	{
		List<Circle> circleList = new ArrayList<Circle>();
		List<Rectangle> rectangle = new ArrayList<Rectangle>();
		circleList.add(new Circle());
		rectangle.add(new Rectangle());
		Canvas c = new Canvas();
		c.drawAll(circleList);
	}
}

//定义一个抽象类Shape
 abstract class Shape
{ 
	public abstract void draw(Canvas c); 
}


class Rectangle extends Shape 
{
	//实现画图方法，以打印字符串来模拟画图方法实现
	public void draw(Canvas c) 
	{ 
		System.out.println("把一个矩形画在画布" + c + "上");
	} 
} 

//定义Shape的子类Circle
 class Circle extends Shape
{
	//实现画图方法，以打印字符串来模拟画图方法实现
	public void draw(Canvas c)
	{
		System.out.println("在画布" + c + "画一个圆");
	}
}