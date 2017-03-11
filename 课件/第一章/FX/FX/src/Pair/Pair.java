package Pair;

public class Pair<T> {
  private T first;
  private T second;
  
  public Pair(){first=null;second=null;}
  public Pair(T first,T second){super();this.first=first;this.second=second;}
  
  public T getFirst(){ return this.first;}
  public T getSecond(){ return this.second;}
  
  public void setFirst(T newValue){this.first=newValue;}
  public  void setSecond(T newValue){this.second=newValue;}  
 }

