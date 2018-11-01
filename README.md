# ReactiveX

## 官网地址
```
http://reactivex.io/
```

## 概括性介绍

```
Reactive Extensions for Async Programming

异步编程的响应式扩展
```

## 官方介绍

```
An API for asynchronous programming with observable streams

一种用于使用可观察流进行异步编程的API
```

划重点：

```
asynchronous programming with observable streams

使用可观察流进行异步编程
```

## 具体性介绍

```
The Observer pattern done right

观察者模式做得很好

ReactiveX is a combination of the best ideas from the Observer pattern, the Iterator pattern, and functional programming

ReactiveX是来自观察者模式、迭代器模式和函数式编程的最佳思想的组合
```

划重点：

```
the Observer pattern  观察者模式
the Iterator pattern 迭代器模式
functional programming 函数式编程
```
## 流程

CREATE 创造
```
Easily create event streams or data streams.

轻松创建事件流或数据流。
```

COMBINE 组合
```
Compose and transform streams with query-like operators.

使用查询操作符组合和转换流。
```

LISTEN 监听
```
Subscribe to any observable stream to perform side effects.

订阅任何可观察的流以执行副作用。
```

## 无处不在


```
Ubiquitous

ReactiveX is everywhere, and it's meant for everything.

ReactiveX 无处不在
```
FRONTEND 前端

```
Manipulate UI events and API responses, on the Web with RxJS, or on mobile with Rx.NET and RxJava

操作UI事件和API响应，在Web使用RxJS，或者在移动设备上使用Rx.NET 和 RxJava。
```

CROSS-PLATFORM 跨平台
```
Available for idiomatic Java, Scala, C#, C++, Clojure, JavaScript, Python, Groovy, JRuby, and others

可用于常用的Java, Scala, C#, C++, Clojure, JavaScript, Python, Groovy, JRuby还有其他语言。
```


BACKEND 后端
```
Embrace ReactiveX's asynchronicity, enabling concurrency and implementation independence

支持ReactiveX的异步性，支持并发性和实现独立性
```
 




## Better codebases


Functional
```
Avoid intricate stateful programs, using clean input/output functions over observable streams.

避免复杂的有状态程序，在可观察的流上使用干净的输入/输出函数。
```

Less is more
```
ReactiveX's operators often reduce what was once an elaborate challenge into a few lines of code.

ReactiveX的操作符通常会将原本复杂的挑战简化为几行代码。
```

Async error handling
```
Traditional try/catch is powerless for errors in asynchronous computations, but ReactiveX is equipped with proper mechanisms for handling errors.

传统的try/catch对于异步计算中的错误无能为力，但是ReactiveX为处理错误配备了适当的机制。
```

Concurrency made easy
```
Observables and Schedulers in ReactiveX allow the programmer to abstract away low-level threading, synchronization, and concurrency issues.

ReactiveX中的可观察对象和调度器允许程序员抽象出低级线程、同步和并发问题。
```

## Reactive Revolution

```
ReactiveX is more than an API, it's an idea and a breakthrough in programming. It has inspired several other APIs, frameworks, and even programming languages.

ReactiveX不仅仅是一个API，它是编程的一个想法和突破。它还启发了其他一些API、框架，甚至编程语言。
```

## 名词解析

```
Reactive 反应式，响应式，回应式
Extensions 扩展，扩张，延长
composing 组成，组合，构成
asynchronous 异步的，不同时的，不同期的
event-based 基于事件的
programs 程序，程序集
observable 看得见的，可以观察的，显著的
sequences 序列，顺序
Ubiquitous 无处不在
Manipulate 操作
idiomatic 惯用的
Embrace 拥抱；信奉，皈依；包含
asynchronicity 同步性
concurrency 并发性
independence 独立性
debounce 防反跳，去抖动，防止误动作，与函数去抖，防抖动
intricate 复杂的
stateful 状态性的，有状态的
elaborate 精心制作的；详尽的；煞费苦心的
powerless 无力的；无能力的，无权的
equipped 装备；预备，配备
```



# RxJava

## 概括性介绍
```
RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.

RxJava 
Java虚拟机的响应式扩展 
一个在Java虚拟机上使用可观测的序列来组成异步的、基于事件的程序的库。
```

划重点：

```
composing asynchronous and event-based programs using observable sequences

使用可观测的序列来组成异步的、基于事件的程序
```




## 优点

异步处理逻辑简洁清晰：链式调用，没有嵌套，利于阅读代码修改需求。

## 原理

### 观察者模式

观察者注册/订阅
观察者观察被观察者
被观察者通知观察者

#### 点击事件观察者模式
View 是被观察者， OnClickListener 是观察者，二者通过 setOnClickListener() 方法达成订阅关系，onClick 是事件。

#### RxJava观察者模式

Observable 是被观察者，Observer/Subscriber/Action1<String>/Action1<Throwable
/Action0 是观察者/订阅者，subscribe()是订阅，onNext()、onCompleted()、onError()是事件。

Observable 和 Observer 通过 subscribe() 方法实现订阅关系，从而 Observable 可以在需要的时候发出事件来通知 Observer，发出事件包括onNext()、onCompleted()、onError()。


### 异步：线程控制

Scheduler 调度器/线程控制器

subscribeOn() 订阅所发生的线程，订阅被激活时候所处的线程，事件产生线程。
observeOn() 观察者/订阅者所运行的线程，事件消费线程。


Schedulers.immediate() 当前线程
Schedulers.newThread() 新线程
Schedulers.io() IO线程
Schedulers.computation() CPU密集型计算线程
AndroidSchedulers.mainThread() Android主线程

### 变换：对事件序列进行变换

将事件序列中的对象或整个序列进行加工处理，转换成不同的事件或事件序列。

Func1 有返回值
Action1 无返回值

map 事件对象的直接变换
flatmap 事件对象转化为Observable 对象，常用于嵌套的异步操作例如嵌套的网络请求


lift 针对事件序列的处理和再发送
compose 对Observable整体的变换



