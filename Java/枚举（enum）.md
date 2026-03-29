# 枚举（enum）
>特殊的数据类型，用于定义一组**固定的常量**
>因为`enum`是一个`class`，每个枚举的值都是`class`实例，因此，这些实例有一些方法
## 普通枚举常量
```java
enum Weekday {
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```
## 带有参数的枚举常量
```java
enum Weekday {
	//public static final Weekday MONDAY = new Weekday("MONDAY", 0, 1);
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);
    
    public final int dayValue;
	
    Weekday(int dayValue) {
        this.dayValue = dayValue;
    }
}
```
## 实现接口的枚举常量
## 匿名内部类的方式