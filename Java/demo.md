

# 字符串
- ## ==
	- 对于**基本类型**（long / int / double）`==` 比较**值**是否相等
	- 对于**引用类型**（String / 对象等）`==` 比较的是**堆内存地址**
- ## equals()
	- 比较**字符串内容**是否相同

# 包（package）
- 把比较接近的类，规划在同一个包下
- ```
  package 包名;
  ```
- ## import
	- 使用其他包下的类，必须import
	- import 包名;
# 引用
- 引用的概念，如果一个变量的类型是 类类型，而非基本类型，那么该变量又叫做引用。
- Class **p** = new Class( );
# 对象(Object)
- 创建对象(实例化)(类名 对象名 = new 类名();)
	- 分配内存空间
	- 初始化空间（填充数据）
	- 返回地址（对象引用）
	- Class **p** = new Class( );
# 实例化
- 通过一个类创建一个对象，这个过程叫做实例化


# 作用域
- ## public
	- 定义为`public`的`class`、`interface`可以被其他任何类访问：
- ## private
	- 实际上，确切地说，`private`访问权限被限定在`class`的内部，而且与方法声明顺序_无关_。推荐把`private`方法放到后面，因为`public`方法定义了类对外提供的功能，阅读代码的时候，应该先关注`public`方法：
	- ```java
		public class Hello {
			public void hello() {
			  this.hi();
			}
			private void hi() {}
		}
	  ```
- ## protected
- ## package
- ## 局部变量
- ## final
	1. 阻止继承
	2. 阻止覆写
	3. 阻止被重新赋值
	4. 阻止**局部变量**被重新赋值
