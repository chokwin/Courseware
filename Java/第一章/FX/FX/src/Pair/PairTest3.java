package Pair;

public class PairTest3 {

	public static void main(String[] args) {
		Manager ceo= new Manager("Gus Gready",800000,"A");
		Manager cfo= new Manager("Sid Sneaky",600000,"B");
        Pair<Manager> dubbies=new Pair<>(ceo,cfo);
        printBuddies(dubbies);
        ceo.setSalary(1000000);
        cfo.setSalary(50000);
        Manager[] managers={ceo,cfo};
        Pair<Employee> result=new Pair<>();
        minmaxBonus(managers,result);
        System.out.println(result.getFirst().getName()+" and "
                          +result.getSecond().getName()+"are buddies.");
        maxminBouns(managers,result);
        System.out.println(result.getFirst().getName()+" and "
                +result.getSecond().getName()+"are buddies.");
        
	}
	//Pair<? extends Employee>产生实例p给方法printBuddies使用(被读入)，用extends
	public static void printBuddies(Pair<? extends Employee> p){
		//编译器知道getFirst返回的类型一定是Employee或者其子类，类型确定
		Employee first=p.getFirst();
		Employee second=p.getSecond();
		//编译器只知道需要某个Employee的子类型，但是不知道具体是什么类型，拒绝传递任何特定的类型
		//p.setFirst(second);
		System.out.println(first.getName()+" and "+second.getName()+"are buddies.");
	}
    
	//方法中无法接受Pair<Manager>
	public static void printBuddies2(Pair<Employee> p){
		Employee first=p.getFirst();
		Employee second=p.getSecond();
		System.out.println(first.getName()+" and "+second.getName()+"are buddies.");
	}
	
	//不能保证方法中传入的是Employee或者是其子类
	public static void printBuddies3(Pair<?> p){
		Object first=p.getFirst();
		Object second=p.getSecond();
		//p.setFirst(second);//error
		//System.out.println(first.getName()+" and "+second.getName()+"are buddies.");
	}
	
	//result实例通过方法minmaxBons中第一个数组实例a消费(被写入)，用super
	public static void minmaxBonus(Manager[] a, Pair<? super Manager> result){
		if(a==null||a.length==0) return;
		Manager min=a[0];
		Manager max=a[0];
		for(int i=0;i<a.length;i++){
			if(min.getSalary()>a[i].getSalary()) min=a[i];
			if(max.getSalary()<a[i].getSalary()) max=a[i];
		}
		result.setFirst(min);//编译器不知道setFirst方法的确切类型，但是可以用任意Manager调用它
		result.setSecond(max);
		//Manager mm=result.getFirst();//error 返回的的对象类型不能得到保证，但是可以赋给Object
		//Object mm=result.getFirst();//ok
	}
	
	public static void maxminBouns(Manager[] a, Pair<? super Manager> result){
		minmaxBonus(a,result);
		PairAlg3.swap(result);
		
	}

}

class PairAlg3{
	public static boolean hasNull(Pair<?> p){
		return p.getFirst()==null||p.getSecond()==null;
	}
	
	public static void swap(Pair<?> p){
		 //? t=p.getFirst();
		// Object t=p.getFirst();
		 //p.setFirst(p.getSecond());
		 //p.setSecond(t);
		swapHelper(p);
	}
	
	public static <T> void swapHelper(Pair<T> p){
		T t=p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(t);
	}
}
class Employee {
	private String name;
	private double salary;
	public Employee() { }
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
class Manager extends Employee{
	private  String department;
	public Manager(){}
	public Manager(String name, double salary,String department) {
		super(name,salary);
		this.department = department;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}