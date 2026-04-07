# ArrayList
## 一、创建 ArrayList
```java
// 1. 创建空的 ArrayList（存储字符串）
ArrayList<String> list = new ArrayList<>();

// 2. 创建带初始容量的 ArrayList（优化性能）
ArrayList<Integer> numList = new ArrayList<>(10);
```
---
## 二、增
### 1. 末尾添加元素
```java
list.add("苹果");
list.add("香蕉");
// 结果：[苹果, 香蕉]
```
### 2. 指定索引位置添加
```java
list.add(1, "橙子"); 
// 结果：[苹果, 橙子, 香蕉]
```
---
## 三、删
### 1. 根据索引删除
```java
list.remove(0); // 删除第 1 个元素
// 结果：[橙子, 香蕉]
```
### 2. 根据元素值删除（删除第一个匹配项）
```java
list.remove("香蕉");
// 结果：[橙子]
```
### 3. 清空所有元素
```java
list.clear();
// 结果：[]
```
---
## 四、改
```java
list.set(0, "西瓜"); // 把索引 0 的元素改成西瓜
```
---
## 五、查
### 1. 根据索引获取元素
```java
String fruit = list.get(0); // 获取第 1 个元素
System.out.println(fruit); // 输出：西瓜
```
### 2. 获取集合大小（元素个数）
```java
int size = list.size();
System.out.println(size); // 输出：1
```
### 3. 判断是否为空
```java
boolean empty = list.isEmpty(); // 空返回 true，否则 false
```
### 4. 判断是否包含某个元素
```java
boolean has = list.contains("西瓜"); // 包含返回 true
```
### 5. 查找元素索引
```java
int index = list.indexOf("西瓜"); // 找到返回索引，没找到返回 -1
```
---
## 六、遍历 ArrayList
### 1. 普通 for 循环
```java
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}
/*  输出：
	苹果
	橙子 */
```
### 2. 增强 for 循环
```java
for (String s : list) {
    System.out.println(s);
}
/*  输出：
	苹果
	橙子 */
```
### 3. forEach（Java 8+）
```java
list.forEach(System.out::println);
/*  输出：
	苹果
	橙子 */
```
---
## 七、其他常用方法
### 1. 截取子集合
```java
// 从索引 1（包含）到 3（不包含）
List<String> subList = list.subList(1, 3);
```
### 2. 转换成普通数组
```java
String[] arr = list.toArray(new String[0]);
```
### 3. 添加另一个集合
```java
ArrayList<String> other = new ArrayList<>();
other.add("葡萄");
list.addAll(other); // 把 other 所有元素加到 list 末尾
```