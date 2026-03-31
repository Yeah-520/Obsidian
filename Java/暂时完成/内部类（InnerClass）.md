# 成员内部内
>定义在了成员位置 (类中方法外称为成员位置，无static修饰的内部类)
## 获取成员内部类对象的两种方式
1. 外部直接创建成员内部类的对象
```java
外部类.内部类 变量 = new 外部类（）.new 内部类（）;
public class Test {
    public static void main(String[] args) {
        // 创建内部类对象
        Outer.Inner oi = new Outer().new Inner();
        oi.method();
    }
}

class Outer {
    // 成员内部类，属于外部类对象的
    // 拓展：成员内部类不能定义静态成员
    public class Inner{
        // 这里面的东西与类是完全一样的
        public void method(){
            System.out.println("内部类中的方法被调用了");
        }
    }
}
```
2. 在外部类中定义一个方法提供内部类的对象
```java
public class Outer {
    String name;
    private class Inner{
        static int a = 10;
    }
    public Inner getInstance(){
        return new Inner();    // 提供内部类的对象
    }
}

public class Main {
    public static void main(String[] args) {
        Outer o = new Outer();
        System.out.println(o.getInstance());
    }
}
```
# 静态内部类
>定义在了成员位置 (类中方法外称为成员位置，有static修饰的内部类)
>有static修饰，属于外部类本身`Outer.Inner`
```java
class Outer{
    private static String sc_name = "字节跳动";
    // 内部类: Inner
    public static class Inner01{
        // 与类是完全一样
        private String name;
        public Inner01(String name) {
            this.name = name;
        }
        public void showName(){
            System.out.println(this.name);
            // 静态内部类可以直接访问外部类的静态成员
            System.out.println(sc_name);
        }
    }
}

public class StaticInnerClass {
    public static void main(String[] args) {
        // 创建静态内部类对象。
        // 外部类.内部类  变量 = new  外部类.内部类构造方法;
        Outer.Inner in  = new Outer.Inner("张三");
        in.showName();
    }
}
```
## 静态内部类对象的创建格式
```java
外部类.内部类  变量 = new  外部类.内部类构造方法;
```
# 局部内部类
>定义在方法内
```java
class 外部类名 {
	数据类型 变量名;
	
	修饰符 返回值类型 方法名(参数列表) {
		// 成员变量
		// 成员方法
		class 内部类 {
			// 成员变量
			// 成员方法
		}
	}
}
```
# ==匿名内部类==（重要）
>没有名字的内部类，可以在方法中，也可以在类中方法外
>没有名字的Java类`(){}` + 继承类/实现接口`父类名/接口名` + 重写方法`@Override` + 创建对象`new`
- `()`是调用匿名类的默认无参构造方法（继承关系则调用父类构造方法）
- 使用jps 和 jhsdb hsdb 查看
```java
new 父类名/接口名(){
    // 重写方法
    @Override 
    public void method() {
        // 方法体
    }
};
```
## 作用
1. **继承==一个==类 / 实现==一个==接口**
2. **重写方法**
3. **直接创建对象**
## 案例
```java
interface Swim {
    void swimming();
}

public class Main {  
    public static void main(String[] args) {  
        /*AnonymousClass.goSwimming()*/  
        // 参数列表为引用类型时  
        goSwimming(new Swim() {  
            @Override  
            public void swimming() {  
                System.out.println("快速创建实现类");  
            }  
        });  
		  
        // 接口 变量 = new 实现类(){};  
        Swim s = new Swim() {  
            @Override  
            public void swimming() {  
                System.out.println("我是匿名内部类(实现关系)");  
            }  
        };  
        s.swimming();  
    }  
    
    private static void goSwimming(Swim s) { 
        s.swimming();  
    }  
}
```