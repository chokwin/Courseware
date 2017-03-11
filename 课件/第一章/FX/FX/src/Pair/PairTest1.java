 package Pair;

public class PairTest1 {

	public static void main(String[] args) {
		String[] words={"Mary","had","a","little","lamb"};
		Pair<String> mm=ArrayAlg.minmax(words);
		System.out.println(mm.getFirst());
		System.out.println(mm.getSecond());
		
		String middle1=ArrayAlg.getMiddle("John","Q","public");
		//下面代码中T代表String类型
		System.out.println(middle1);
		//编译器会自动打包参数为1个Double和2个Integer对象，而后去寻找他们的共同的父类。
		//而事实上编译器找到了2个这样的父类：Number和Comparable,无法准确推断出它的类型，所以出错
		double middle2=ArrayAlg.getMiddle(3.14,0,1927);
	}

}

class ArrayAlg{
	public ArrayAlg(){}
	public static  Pair<String> minmax(String[] a){
		if(a==null|a.length==0) return null;
		String min=a[0];
		String  max=a[0];
		for( int i=0;i<a.length;i++){
			if(min.compareTo(a[i])>0) min=a[i];
			if(max.compareTo(a[i])<0) max=a[i];
		}
		return new Pair<>(min,max);
	}
	
	public static <T> T getMiddle(T...a){
		return a[a.length/2];
	}
	/*
	public static <T> Pair<T> minmax(T[] a){
	//public static <T extends Comparable> Pair<T> minmax(T[] a){
		if(a==null|a.length==0) return null;
		T min=a[0];
		T  max=a[0];
		for( int i=0;i<a.length;i++){
			if(min.compareTo(a[i])>0) min=a[i];
			if(max.compareTo(a[i])<0) max=a[i];
		}
		return new Pair<>(min,max);
	}*/
}
