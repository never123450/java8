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


