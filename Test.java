import sun.security.jca.GetInstance.Instance;
/** 
class Person{
    public String name;
    public int age;
    public void fun(){
        System.out.println("姓名："+this.name+ ",年龄："+this.age);
    }

public boolean equals(Object obj){
    if(!(obj instanceof Person )){
        return false;
    }
    if(obj==this){
        return true;
    }
    //向下转型，取得person的name和age属性
    Person per=(Person)obj;
    return per.name.equals(this.name) && (per.age==this.age);
    }
}

public class Test{
    public static void main(String[] args) {
        Person per1=new Person("yy",18);
        Person per2=new Person("xx",18);
        System.out.print(per1.equals(new Test()));
    }
}

interface IMessage{
    void test();
}
class Message */


//包装类
class IntDemo{
    private int intValue;
    public IntDemo(int intValue){
        this.intValue=intValue;
    }
    public int getintValue(){
        return this.intValue;
    }
}

public class Test{
    public static void main(String[] args) {
        
    }
}