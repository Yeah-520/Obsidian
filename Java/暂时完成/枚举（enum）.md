# 枚举（enum）
>特殊的数据类型，用于定义一组**固定的常量**
>因为`enum`是一个`class`，每个枚举的值都是`class`实例，因此，这些实例有一些方法
```java
enum 枚举类名 {
	// 枚举项1(对象1)，枚举项2(对象2)...
	// 常量
	// private构造方法(禁止外界创建对象，用于初始化对象)
}
```
## 普通枚举常量
```java
enum Weekday {
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}
```
## 带有参数的枚举常量
```java
enum Weekday {  
    //public static final Weekday MONDAY = new Weekday("MONDAY", 0, 1);  
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);  
	
    private final int dayValue;  
	
    Weekday(int dayValue) {  
        this.dayValue = dayValue;  
    }  
	
    public int getDayValue(){  
        return this.dayValue;  
    }  
}
```
## 实现接口的枚举常量
## 匿名内部类的方式