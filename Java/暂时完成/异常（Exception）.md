# Java的异常
> Java 异常 = 程序出错后的**可控处理机制**
> 目的：不崩溃、能定位、可恢复
> 核心：**抛出 → 传递 → 捕获 → 处理**
> 异常可以在任何地方抛出，只需要在沿着方法调用链向上传递(上层捕获)，这样就和方法调用分离了
1. **Exception（普通异常）**
    - 用 `try-catch` 捕获
    - **捕获后程序可以继续运行**
2. **Error（错误）**
    -  `OutOfMemoryError`、`StackOverflowError`、`NoClassDefFoundError`
    - **无法捕获 / 无法恢复**
    - 程序照样会停止
    - 异常处理管不了 Error
```java
Throwable
├─ Error（错误，JVM级别，一般不处理）
│   ├─ StackOverflowError（栈溢出）
│   ├─ OutOfMemoryError（内存溢出）
│   └─ NoClassDefFoundError（找不到类定义）
│
└─ Exception（异常）
    ├─ CheckedException（编译时异常）
    │   ├─ IOException
    │   │   └─ FileNotFoundException
    │   ├─ SQLException
    │   ├─ ClassNotFoundException
    │   └─ InterruptedException
    │
    └─ RuntimeException（运行时异常）***
        ├─ NullPointerException（空指针）
        ├─ ArrayIndexOutOfBoundsException（数组越界）
        ├─ IndexOutOfBoundsException（下标越界）
        ├─ ArithmeticException（算术异常）
        ├─ ClassCastException（类型转换异常）
        ├─ IllegalArgumentException（非法参数）
        └─ ConcurrentModificationException（并发修改）
```
## printStackTrace()
- 通过`printStackTrace()`可以打印出方法的调用栈，类似：
```java
java.lang.NumberFormatException: null
    at java.base/java.lang.Integer.parseInt(Integer.java:614)
    at java.base/java.lang.Integer.parseInt(Integer.java:770)
    at Main.process2(Main.java:16)
    at Main.process1(Main.java:12)
    at Main.main(Main.java:5)
```
## 捕获异常
>程序出现异常时，不直接崩溃，而是按照预设的逻辑处理错误
### 作用
1. **防止程序意外崩溃**
2. **清晰定位错误原因**（打印堆栈、记录日志）
3. **恢复 / 退出**（关闭资源、回滚操作、给用户友好提示）
### try ... catch ... finally
>把可能发生异常的语句放在`try { ... }`中，然后使用`catch`捕获对应的`Exception`及其子类
>如果**没有**`try-catch`**捕获**对应的异常，则交给JVM处理**默认停止程序**并**打印异常信息**
```java
try {
	// 可能发生异常的代码
} catch (异常类名 变量名) {
	// 处理异常的代码
}

public static void main(String[] args) {
    try {
        process1();
    } catch (IOException | NumberFormatException e) {
        System.out.println(e);
    } catch (Exception e) {
        System.out.println(e);
    } finally {
        System.out.println("END");
    }
}
```
- `catch`的**顺序**：**子类在前，父类在后**
- **处理**异常的**代码相同**==且==异常本身**不存在继承关系**时用`|` 合并处理
	- `catch (IOException | NumberFormatException e) {}`
- `finally`： **一定执行**（除非 JVM 退出）
## 抛出异常
>主动让程序产生一个异常
>交给调用者处理
### 1. 方法内抛出：throw
- `throw new 异常类型(异常信息);`
1. 创建某个`Exception`的实例；
2. 用`throw`语句抛出。
```java
public class Main {  
    public static void main(String[] args) {  
        int[] arr = null;  
        try {  
            int a = getMax(arr);  
            System.out.println(a);  
        } catch (ArrayIndexOutOfBoundsException e) {  
            System.out.println("索引越界");  
        } catch (NullPointerException e) {  
            System.out.println("NULL");  
        }  
    }  
	
    static int getMax(int[] arr) {  
        if (arr == null) {  
            throw new NullPointerException();  
        }  
		
        if (arr.length == 0) {  
            throw new ArrayIndexOutOfBoundsException();  
        }  
		
        int max = arr[0];  
        for (int i = 1; i < arr.length; i++) {  
            if (max < arr[i]) {  
                max = arr[i];  
            }  
        }  
        return max;  
    }
}
```
### 2. 方法声明抛出：throws
- 声明方法可能会抛出哪些异常
```java
public void method() throws Exception1,Exception2... {
	 // ... 
 }
```
#### 作用
1. 声明方法**不处理**这些异常
2. 把异常**抛给上层调用者**去 try-catch
3. 编译时异常CheckedException（非 RuntimeException）==必须==**抛出** `throws` 或捕获 `try-catch`

### throw vs throws
|   对比维度   |            throw（抛出异常）             |             throws（声明异常）             |
| :------: | :--------------------------------: | :----------------------------------: |
| **使用位置** |           方法**内部**（代码块中）           |           方法**声明上**（方法名后）            |
|  **作用**  |       真正**抛出一个具体的异常对象**，触发异常       |      声明方法**可能会抛出的异常类型**，告知调用者处理      |
| **操作对象** | 异常对象（如 new NullPointerException()） |    异常类型（如 IOException、Exception）     |
| **数量限制** |          一次只能抛出**一个**异常对象          |         可声明**多个**异常类型，用逗号分隔          |
| **核心本质** |           “执行动作”，主动触发异常            |         “告知义务”，不处理异常，告知调用者处理         |
| **语法格式** |       throw new 异常类型(异常信息);        | public 方法名() throws 异常1, 异常2 { ... } |
| **易错点**  |         抛出后，当前代码块后续代码不再执行          |     声明的异常需是方法内可能抛出的，编译时异常必须声明/捕获     |

## 注意
- **抛出异常后**，`try { }` 块内从抛出点开始，**后面代码不再执行**
- 但如果被 `catch` 捕获，**catch 块和 try-catch 之后的代码会继续执行**
- 只有**没被捕获**时，程序才会直接终止
## 自定义异常*类*
1. 定义异常类
2. 写继承关系
3. 空参构造
4. 待参构造


