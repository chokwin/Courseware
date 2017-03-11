
import java.util.*;

public class TestGMethod {

	
    static  void fromArrayToCollection(Object[] a, Collection<Object> c)
    //static <T> void fromArrayToCollection(T[] a, Collection<T> c)
    {
	    for(Object o:a)  
	    //for(T o:a)  
	    {
	    	c.add(o);
	    }
	}

	
	public static void main(String[] args) 
	{
		String[] str={"a","b"};
		List<String>  strList=new ArrayList<String>();
		TestGMethod.fromArrayToCollection(str, strList);
	}
}

