# Java8新特性

- 速度更快
- 代码更少（增加了新的语法Lambda表达式）
- 强大的 Stream API
- 便于并行
- 最大化减少空指针异常 Optional
- HashMap 长度超过 8 链表变红黑树
- ConcurrentHashMap 1.7 以前分段锁，1.8 开始 CAS 算法
- 永久代 换成了 元空间（MetaSpace）

# 为什么使用Lambda表达式

Lambda是一个匿名函数，我们可以把 Lambda表达式理解为是一段可以传递的代码(将代码像数据一样进行传递）。
可以写出更简洁、更灵活的代码。作为一种更紧凑的代码风格，使Java的语言表达能力得到了提升。

一、Lambda表达式的基镛语法:Java8中引入了一个新的操作符"->”该操作符称为箭头操作符或 Lambda 操作符 。箭头操作符将 Lambda 表达式拆分成两鳝分:
左侧:Lambda表达式的参数列表
右侧:Lambda表达式中所需扶行的功能,即Lambda体

语法格式一：无参数,无返回值

`()-> System.out.println( "Hello Lambda!");`

语法格式二：有一个参数,并且无返回值

`(x) ->System.out.println(x)`

语法格式三：若只有一个参数,小括号可以省略不写
x -> System.out.println(x)

语法格式四：有两个以上的多数，有返回值,并且 Lambda 体中有多条语句

`Comparator<Integer> com= (x,y)->{
    System.out.println("函数式接口");
    return Integer.compare(x, y);
}; ` 

语法格式五：若 Lambda 体中只有一条语句，return和大括号都可以省略不写

`Comparator<Integer> com= (x,y) -> Integer.compare(x, y);`

语法格式六： Lambda 表达式的参数列表的数据类型可以省略不写，因为 JVM 编译器通过上下文推断出数据类型，即 类型推断

`(Integer x,Integer y) -> Integer.compare(x,y);`

左右遇一括号省
左侧推断类型省


# Java8 内置的四大核心函数式接口

 *         Consumer<T> ：消费型接口 void accept(T t);
 *         Supplier<T> ：供给型接口 T get();
 *         Function<T,R> ： 函数型接口 R apply(T t);
 *         Predicate<T> ： 断言型接口 boolean test(T t);


# 方法引用与构造器引用

（com.xwy.one.TestLambda3）

方法引用：若 Lambda 体中的内容有方法已经实现了，我们可以使用“方法引用”

（可以理解为方法引用是 Lambda 表达式的另外一种表现形式）
主要有三种语法格式：
* 对象::实例方法名
* 类::静态方法名
* 类::实例方法名


### 注意：
- 1.Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中的抽象方法列表和返回值类型保持一致
- 2.若 Lambda 参数列表中的第一个参数是实例方法的调用者，而第二个参数是是立法法的参数时，可以使用ClassName::method

## 构造器引用： 
格式 ClassName::new   
### 注意：
需要调用的构造器列表要与函数式接口中的抽象方法的参数列表保持一致

## 数组引用


# 了解Stream
Java8中有两大最为重要的改变。第一个是 Lambda 表达式;另外一个则是 Stream API(java.util.stream.*)。
Stream 是 Java8 中处理集合的关键抽象概念，它可以指定你希望对集合进行的操作，可以执行非常复杂的查找、过滤和映射数据等操作。
使用 Stream API 对集合数据进行操作，就类似于使用SQL执行的数据库查询。也可以使用Stream API来并行执行操作。简而言之，
Stream API提供了一-种高效且易于使用的处理数据的方式。


## Stream 的三个 操作步骤：

（com.xwy.one.TestStreamAPI）
- 1.创建 Stream
- 2.中间操作

Stream的中间操作
多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理!
而在终止操作时一次性全部处理，称为“惰性求值”

- 3.终止操作（终端操作）


# 并行流与顺序流
并行流就是把一个内容分成多个数据块，并用不同的线程分别处理每个数据块的流。
Java8 中将并行进行了优化，我们可以很容易的对数据进行并行操作。Stream API可以声明性地通过parallel() 与
sequential()在并行流与顺序流之间进行切换。

## 了解 Fork/Join 框架
Fork/Join 框架：就是在必要的情况下，将一个大任务，进行拆分（fork）成若干个小任务（拆到不可再拆时），再将一个个的小任务运算的结果进行 join 汇总

## Fork/Join框架与传统线程池的区别
采用“工作窃取”模式(work-stealing) :
当执行新的任务时它可以将其拆分分成更小的任务执行，并将小任务加到线程队列中，然后再从一个随机线程的队列中偷一个并把它放在自己的队列中。

相对于一般的线程池实现，fork/join 框架的优势体现在对其中包含的任务的处理方式上.在一般的线程池中，如果一个线程正在执行的任务由于某些原因无法继续运行，
那么该线程会处于等待状态.而在 fork/join 框架实现中，如果某个子问题由于等待另外一个子问题的完成而无法继续运行.
那么处理该子问题的线程会主动寻找其他尚未运行的子问题来执行.这种方式减少了线程的等待时间，提高了性能.




