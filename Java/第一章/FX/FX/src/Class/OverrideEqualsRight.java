package Class;
 
//定义一个Person类
class Person1
{
	private String name;
	public Person1(){}
	public Person1(String name)
	{
		this.name = name;
	}
	//下面是name和idStr的setter和getter方法。
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		 return this.name;
	}
	

  //重写equals方法，提供自定义的相等标准
	public boolean equals(Object obj)
	{
		//只有当obj是Person对象
		if (obj != null && obj instanceof Person1)
		{
		Person1 personObj = (Person1)obj;
			//并且当前对象的idStr与obj对象的idStr相等才可判断两个对象相等
			if (this.getName().equals(personObj.getName()))
			{
				return true;
			}
		}
		return false;
}

	//重写equals方法，提供自定义的相等标准
/*	public boolean equals(Object obj)
	{
		//待比较的两个对象是同一个对象，直接返回true
		if(this == obj)
		{
			return true;
		}
		//只有当obj是Person对象
		if (obj != null && obj.getClass() == Person1.class)
		{
			Person1 personObj = (Person1)obj;
			//并且当前对象的idStr与obj对象的idStr相等才可判断两个对象相等
			if (this.getName().equals(personObj.getName()))
			{
				return true;
			}
		}
		return false;
	}*/

}

public class OverrideEqualsRight
{
	public static void main(String[] args) 
	{
		Person1 p1 = new Person1("孙悟空");
		Person1 p2 = new Person1("孙悟空");
		Person1 p3 = new Person1("孙悟饭");
		//p1和p2的name相等，所以输出true
		System.out.println("p1和p2是否相等？" + p1.equals(p2));
		//p2和p3的name不相等，所以输出false
		System.out.println("p2和p3是否相等？" + p2.equals(p3));
		System.out.println();
		
		 Student s1=new Student("孙悟空","123","Computer");
		 System.out.println("p1和s1是否相等？" + p1.equals(s1));
		 System.out.println("s1和p1是否相等？" + s1.equals(p1));
		
		
		
	}
}

class Student extends Person1{
   private String Sid;
   private String major;
   
   Student(){}
   Student(String name,String Sid,String major){
	   super(name);
	   this.Sid = Sid;
	   this.major = major;
   }
   public void setSid(String Sid){
	   this.Sid = Sid;
   }
   public void setMajor(String major){
	   this.major=major;
   }
   public String  getSid(){
	   return this.Sid;
   }
   public String getMajor(){
	   return this.major;
   }
  public boolean equals(Object obj){
	   {
			//待比较的两个对象是同一个对象，直接返回true
			if(this == obj)
			{
				return true;
			}
			//只有当obj是Person对象
			if (obj != null && obj instanceof Student)
			//if (obj != null && obj.getClass() == Student.class)
			{
				Student studentObj = (Student)obj;
				//并且当前对象的idStr与obj对象的Sid相等才可判断两个对象相等
                super.equals(studentObj);
				if (this.getSid().equals(studentObj.getSid()))
				{
					return true;
				}
			}
			return false;
		}
   }
}

