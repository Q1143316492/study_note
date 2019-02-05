# 1. Cpp 多线程学习

[TOC]

## 1.1. 第一个多线程

```cpp
#include <bits/stdc++.h>

#include <thread>

using namespace std;

void hello() {
    cout << "hello" << endl;
}

int main()
{
    thread t(hello);
    t.join();    //主线程等待子线程结束再退出

    return 0;
}
```

```cpp
#include <bits/stdc++.h>

#include <thread>

using namespace std;

void hello() {
    cout << "hello" << endl;
}

int main()
{
    thread t(hello);
    ///t.join();    //主线程等待子线程结束再退出
    ///t.detach();  //主线程不用等待

    ///由于join,detach混用会异常，可以用t.joinable()判断

    return 0;
}
```


用类创建线程

```cpp
#include <bits/stdc++.h>

#include <thread>

using namespace std;

/**
线程thread调用可调用对象，比如类，类作为可调用对象就需要重载()且不带参数
*/
class TA
{
public:
    ///线程入口
    void operator () ()
    {
        cout << "线程开始..." <<endl;

        cout << "线程结束..." <<endl;
    }

};

int main()
{
    TA ta;
    thread t(ta);   //这里是复制值，不是引用
    t.join();

    return 0;
}


```

注意：避免线程执行结束后，变量被回收，如果其他线程调用，就会出现错误

```cpp
#include <bits/stdc++.h>

#include <thread>

using namespace std;

int main()
{
    auto lambda = [] {
        cout << "线程开始..." << endl;

        cout << "线程结束..." << endl;
    };

    thread t(lambda);
    t.join();

    return 0;
}


```

## 1.2. 线程传参

```cpp
#include <bits/stdc++.h>

#include <thread>

using namespace std;

void print(int parm1, int parm2) {
    cout << "parm1 = " << parm1 << endl;
    cout << "parm2 = " << parm2 << endl;
}

int main()
{
    thread t(print, 1, 2);
    t.join();

    return 0;
}

```

问题：

- detach()的时候可能出现线程结束导致的变量释放，但是参数又是引用，就有可能出现一些线程访问错误空间的问题，指针等情况，不安全

```cpp
#include <bits/stdc++.h>

#include <thread>

using namespace std;

void print(const int &parm1) {
    printf("%x\n", &parm1);
}

int main()
{
    int a = 1;
    const int &b = a;
    printf("%x %x\n", &a, &b);
    thread t(print, b);
    t.join();
//    输出，证明多线程的引用是复制？
//    6dfee8 6dfee8
//    ba0580
    return 0;
}
```

- thread的线程函数要避免，隐式对象创建的问题 thread t(function, 1), 1传到对象的构造函数，这样是危险的

***

### 1.2.1. 线程id

```cpp
std::this_thread::get_id() //测试主线程获取不到id
```

### 1.2.2. 引用传参数的问题

为了线程的安全, 传参数&会变成拷贝，且必须加const，(在const情况下要修改类变量可以用mutable)

解决方案智能指针std::ref

```cpp
#include <bits/stdc++.h>

using namespace std;

class Obj {
public:
    mutable int a;
    Obj() {}
    Obj(int _a):a(_a) {}
};

void func(const Obj &obj) {
    obj.a = 2;
}

int main()
{
    Obj obj(1);
    thread t(func, obj);
    cout << obj.a << endl; // 1
    t.join();

    return 0;
}

```

```cpp
#include <bits/stdc++.h>

using namespace std;

class Obj {
public:
    mutable int a;
    Obj() {}
    Obj(int _a):a(_a) {}
};

void func(Obj &obj) {
    obj.a = 2;
}

int main()
{
    Obj obj(1);
    thread t(func, std::ref(obj));
    t.join();
    cout << obj.a << endl; // 2

    return 0;
}
```

注意输出结果的不同

## 1.3. 多个线程

```cpp
#include <bits/stdc++.h>

using namespace std;

void func(const int &thread_id) {
    cout << "线程开始, 编号 " << thread_id << endl;


    cout << "线程结束, 编号 " << thread_id << endl;
}

int main()
{
    vector<thread>vec;
    for(int i = 1; i <= 10; i++ ) {
        vec.push_back(thread(func, i));
    }
    for(auto &iter: vec) {
        iter.join();
    }
    cout << "test" << endl;

    return 0;
}

```

## 1.4. 互斥量

mutex lock(), unlock()

```cpp
mutex.lock()
//do something
mutex.unlock()
```

```cpp
std::lock_guard(std::mutex) guard(my_mutex);
//构造函数上锁，析构函数解锁
```

避免死锁

```cpp
std::lock(mutex1, mutex2); //避免多个互斥量死锁，同时加锁

// 。。 。。 。

mutex1.unlock();
mutex2.unlock();
```

如果还想使用lock_guard需要如下操作，用lock, unlock需要解锁

```cpp
std::lock(mutex1, mutex2); //避免多个互斥量
std::lock_guard(std::mutex) guard1(mutex1, std::adopt_lock);
std::lock_guard(std::mutex) guard2(mutex2, std::adopt_lock); //后一个参数避免再次加锁，结构体对象
// 。。 。。 。

``
```

## 1.5. unique_lock

效率可能不如lock_guard, 常规使用上和lock_guard没有区别

```cpp
std::unique_lock(std::mutex) guard(my_mutex);
```

```cpp
#include <iostream>
#include <list>
#include <queue>
#include <stack>
#include <cstdio>
#include <cstring>
#include <thread>
#include <mutex>

using namespace std;
const int N = 100000;

int a[5];

int main() {

    std::mutex mutex1;
    unique_lock<std::mutex> lock1(mutex1);

    ///如果互斥量已经被lock，就必须加 std::adopt_lock，否则有异常
    ///如果有这个参数，互斥量没被锁也会异常
    unique_lock<std::mutex> lock2(mutex1, std::adopt_lock);

    ///尝试去锁，失败了就返回
    ///注意前提是自己不能去加锁
    unique_lock<std::mutex> lock3(mutex1, std::try_to_lock);

    ///初始一个不加锁的mutex, 方便调用成员函数
    ///前提是不能lock
    unique_lock<std::mutex> lock4(mutex1, std::defer_lock);

    lock4.lock();   ///加锁
    lock4.unlock();  ///解锁
    lock4.try_lock(); ///尝试加锁，不成功false

    mutex *p =  lock4.release(); ///放弃和互斥量的关系
    p->unlock();        ///解除关系后就要手动解锁


    ///睡眠
//    std::chrono::milliseconds a(5 * 1000);
//    this_thread::sleep_for(a);

    return 0;
}

```

### std::call_once(flag, function)

## 条件变量

```cpp
#include <iostream>
#include <list>
#include <queue>
#include <stack>
#include <cstdio>
#include <cstring>
#include <thread>
#include <mutex>

using namespace std;
const int N = 100000;

int a[5];

int main() {

    std::mutex mutex1;
    std::unique_lock lock(mutex1);
    std::condition_variable my_cond;    ///生成条件对象

    ///没有第二个参数默认false，当时唤醒的时候无条件唤醒
    my_cond.wait(lock, [this] {
        if( xxx ) {
           return true;
        } else {
            return false;
        }
    });
    ///上面lock了才能往下走，如果这个lamdba是false那么就堵在这里。
    ///释放互斥量
    ///直到其他线程调用notify_one()
    ///如果notify_one() / notify_all()调用，抢锁，抢不到就卡着。
    ///抢到了继续lambda，false就释放

    return 0;
}

```

## 后台任务，返回结果

std::async是个函数类模板，启动一个异步任务，启动后放回std::future

```cpp
    std::future<int> result = std::async(mythread);
    int value = result.get();   //卡在线程等待结果的返回
    result.wait();  //等待结果但是不返回
```

```cpp
    ///std::lunnch 枚举类型
    ///std::launch::deferred() 线程延迟到get,wait的时候执行
    std::future<int>result = std::async(std::launch::deferred, function);
```

std::packaged_task

```cpp
#include <bits/stdc++.h>
#include <thread>
using namespace std;
int mythread(int a) {
    return a;
}
int main()
{

    /// std::packaged_task 打包任务，把任务包装起来
    std::packaged_task<int(int)>mypt(mythread);
    std::thread t1(std::ref(mypt), 1);
    t1.join();
    std::future<int>result = mypt.get_future();
    cout << result.get() << endl;
    return 0;
}

```

std::promise<int>

```cpp
#include <bits/stdc++.h>
#include <thread>
using namespace std;
int mythread(std::promise<int> &p) {
    p.set_value(2);
    return 0;
}
int main()
{

    std::promise<int> myprom; ///
    std::thread t1(mythread, std::ref(myprom));

    std::future<int> ful = myprom.get_future();
    auto res = ful.get();
    cout << res << endl;
    return 0;
}

```