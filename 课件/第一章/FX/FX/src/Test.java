//类型通配符

import java.util.*;

public class Test
{
	

	public static void printListObject(List<Object> list) {
	    for (Object elem : list)
	        System.out.println(elem + "");
	    System.out.println();
	}
	
	public static void printListAllType(List<?> list) {
	    for (Object elem: list)
	        System.out.print(elem + "");
	    System.out.println();
	}

	public static void main(String[] args) 
	{
		
		List<Integer> li = Arrays.asList(1, 2, 3);
		List<String>  ls = Arrays.asList("one", "two", "three");
		//printListObject(li);//Error，List<Integer>不是List<Object>的子类
		//printListObject(ls);//Error，List<String>不是List<Object>的子类
		
		printListAllType(li);//Ok,List<Integer>是List<?>的子类
		printListAllType(ls);//Ok,List<String>是List<?>的子类
		
		List<?> list=ls;
		ls.add(new String("four"));//Ok
		//list.add(new String("four"));//Error
		
		
	}
}
