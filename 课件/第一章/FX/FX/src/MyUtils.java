//设定通配符的下限

import java.util.*;

public class MyUtils
{
	
	public static <T> void copy1
   (Collection<T> dest , Collection< ? extends T> src)
	{
		for (T ele : src)
		{
			dest.add(ele);
		}
	}
	
	public static <T> T copy2
	   (Collection<T> dest , Collection< ? extends T> src)
		{ T last = null;
			for (T ele : src)
			{  
				last = ele;
				dest.add(ele);
			}
			return last;
		}
	public static <T> T copy3
	(Collection<? super T> dest , Collection<T> src)
	{
		T last = null;
		for (T ele  : src)
		{
			last = ele;
			dest.add(ele);
		}
		return last;
	}

	
  public static void main(String[] args) 
	{
		List<Number> ln = new ArrayList<Number>();
		List<Integer> li = new ArrayList<Integer>();
		for(int i=0;i<5;i++){
			li.add(i);
		}
		copy1(ln,li);
		//Integer last=copy2(ln,li);//eroor
		System.out.println(ln);
		
		Integer last=copy3(ln,li);
		System.out.println(last);

	}
}
