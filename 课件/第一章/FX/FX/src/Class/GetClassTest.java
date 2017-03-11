package Class;

public class GetClassTest {
	public static void main(String[] args) {
	 GetClassTest test = new GetClassTest();
	    if(test.ClassCheck())
	     System.out.println("OK");

	}

	public boolean ClassCheck() {
	    try {
	     System.out.println("通过类本身获得对象");
	     Class userClass = this.getClass() ;
	     System.out.println(userClass.getName());
	     System.out.println("===========");
	    
	     System.out.println("通过子类的实例获得父类对象");
	     UseInfo useInfo = new UseInfo();
	     userClass = useInfo.getClass();
	     System.out.println(userClass.getName());
	     Class subUserClass = userClass.getSuperclass() ;
	     System.out.println(subUserClass.getName());
	     System.out.println("===========");
	    
	     System.out.println("通过类名.class获取对象");
	     Class forClass = UseInfo.class ;
	     System.out.println(forClass.getName());
	     System.out.println("===========");
	    
	     System.out.println("通过类名的字符串获取对象");
	     Class forName = Class.forName("Class.UseInfo") ;
	     System.out.println(forName.getName());
	     System.out.println("=============");
	    
	    } catch (Exception e) {
	     e.printStackTrace();
	     return false;
	    }
	    return true;
	 }
	 }
