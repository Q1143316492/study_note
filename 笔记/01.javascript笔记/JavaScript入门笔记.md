# JavaScript程序设计基础

[TOC]

## 控制台输出

```js
    console.log('hello world');
```

## js变量

js没有变量类型，类似python。变量命名同其他语言，非数字开头。大小写敏感。

```js
var mychar1 = "双引号包起来的字符串"; // 这是字符串
var mychar2 = '单引号包起来的字符串'; // 这也是字符串
var mychar3 = '小蒜："我喜欢我们班的小可。"'; // 字符串中有双引号，用单引号包含
var mychar4 = "Uncle Wang：\"小蒜啊，'学习好'才能吸引女孩哦~\""; // 或者在特定符号（引号）前使用 \ 符号，使其转义输出
var mynum1 = 6; // 这是数字6
var mynum2 = 6.00; // 这也是数字6
var mynum3 = 123e5; // 这是使用科学（指数）计数法来书写的12300000
var mynum4 = 123e-5; // 这是0.00123
var mybool = true; // 这是布尔值
var myarr = [1, 2, 3]; // 这是数组
var myobject = {"p": "Hello"}; // 这是对象
```

## js表达式

```js
var y = "you";
var mysay = "I" + "love" + y; // = 后面是串表达式，mysay 值是字符串
var mynum = 12 + 6 * 2; // = 后面是数值表达式，mynum 值是数值
var mybool = mynum > 12; // = 后面是布尔表达式，mybool 值是布尔值

//算术,逻辑运算符
var num1 = 24; 
var myresult = ++num1 % 4 + 6 * 2; // myresult 是 13
var myresult = num1++ % 4 + 6 * 2; // myresult 是 12
num1 += 5;

```

## js数组


### js数组简述
```js
var arr = ['a', 'b', 'c'];
or
var arr = [];
arr[0] = 'a';
arr[1] = 'b';
arr[2] = 'c';

//js数组可存放各种类型
var arr = [{a:1}, [1, 2, 3], function(){ return true; }];
arr[0];    // Object
arr[1];    // Array
arr[2];    // function
var arr = [[1, 2], [3, 4]];
arr[0][1];    // 2
arr[1][1];    // 4
//可以通过arr.length获得数组长度。越界自动增加长度。
```

### js创建数组
```js
var myarray = new Array(8);
var arr = [1,"abc",myarr];  //初始化数组
console.log(myarray);
console.log(arr);
```

## JavaScript内置对象

js对象是带有属性和方法的数据类型,传递时传递的是引用，例如

```js
var o = {
    p: "Hello" //"p": "Hello" 建名引号可有可无
};
```

### 内置对象的初始化

```js
var obj1 = {};
var obj2 = new Object();
var obj3 = Object.create(null);
```

### 对象的属性

#### 时间对象

```js
var now = new Date();

now.setTime(now.getTime()+60*60*1000);
var myyear = now.getFullYear(); // 四位数年份，如 2015
var mymonth = now.getMonth(); // 月份 [0, 11]，要加 1，如 7 (8 月)
var mydate = now.getDate(); // 月中日期，如 1 (1 号)
var myhours = now.getHours(); // 小时，24 小时制
var myminutes = now.getMinutes(); // 分钟
var myseconds = now.getSeconds(); // 秒钟
//星期
var weekday=["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
 var mynum = now.getDay();
```

#### String对象

```js
var mystr = "I like JavaScript!";
var mylen = mystr.length;
var myup = mystr.toUpperCase();
var mylow= mystr.toLowerCase();

//返回字符串指定位置
var mystr = "I love JavaScript!";
console.log(mystr.charAt(0));

//返回字符串首次出现位置
var mystr = "I like JavaScript!";
console.log(mystr.indexOf("I")); //0
console.log(mystr.indexOf("v")); //9
console.log(mystr.indexOf("v", 8)); //9
console.log(mystr.indexOf("ava",mystr.indexOf("a")+1)); // -1

//字符串分割
var mystr = "www.jisuanke.com";
console.log(mystr.split("."));

//提取字符串
var mystr = "I like JavaScript!";
console.log(mystr.substring(7));
console.log(mystr.substring(2,6));

//提取指定数目字符串
var mystr = "I like JavaScript!";
console.log(mystr.substr(7));
console.log(mystr.substr(2,4));
```

#### Math对象

```js
Math.PI
Math.abs()
Math.ceil()
Math.floor()
Math.round()
Math.random()
Math.max()
Math.min()
```

#### 数组对象

```js
//数组连接
var mya1 = new Array("hello!");
var mya2 = new Array("I", "love");
var mya3 = new Array("JavaScript", "!");
console.log(mya1.concat(mya2,mya3));
console.log(mya1);

//数组连接成字符串
var myarr = new Array(3);
myarr[0] = "www";
myarr[1] = "jisuanke";
myarr[2] = "com";
console.log(myarr.join("."));

//数组翻转
myarr.reverse()

//选取子数组
var myarr = new Array(3);
myarr[0] = "www";
myarr[1] = "jisuanke";
myarr[2] = "com";
console.log(myarr.slice(0,2));

//数组排序
function sortNum(a, b) {
    return a - b;
    //升序，如降序，把“a - b”该成“b - a”
}
var myarr1 = new Array("Hello", "John", "love", "JavaScript");
var myarr2 = new Array("80", "16", "50", "6", "100", "1");
console.log(myarr1.sort());
console.log(myarr2.sort());
console.log(myarr2.sort(sortNum));
```

## js流程控制

### if语句
```js
if() {
    
} else if() {
    
} else {
    
}
```

### switch
```js
switch() {
    case 1: 
    case 2: xxx; break;
    case 3: xxx; break;
    default: xxx; break;
    
}
```

### for
```js
for(var i = 1; i <= 10; i++ ) {
    
}
```

### while
```js
while() {
    
}
```

## js函数

```js
function fun(arg1, arg2){
    ...
    //return ...
}
```

```js
//call可以改变this的指向
function add(a, b){
    return this + (a + b);
}
console.log(add.call(null,3,6));
console.log(add.call("www",3,6));
console.log(add.call(2,3,6));

//apply
var arr = [5, 6, 3, 2, 9, 44, 6, 3, 61, 22];
function add(a, b){
    return this + (a + b);
}
console.log(add.apply(null,[3,6]));
console.log(add.apply(2,[3,6]));
console.log(Math.min.apply(null,arr));
```

## 网页中使用js

### 使用方式

1. `<script type="text/javascript"> 这里写 JavaScript </script>`
2. `<script src="script.js"></script>`

### 事件绑定

```js
function func(a, b) {
    ......
}

btn.onclick = function (){
    func(a, b);
};
```

### 通过id获取元素

```html
    <script type="text/javascript">
        var pid = document.getElementById("pid");
        document.write("内容：" + pid.innerHTML); //输出获取的 P 标签内容。
    </script>
```

### 通过标签名获取

```html
    <script type="text/javascript">
        var p = document.getElementsByTagName("p");
        for(var i = 0 ; i < p.length ; i++){
            alert(p[i].innerHTML);
        }
    </script>
```

### 通过名称获取元素

```html
    <script type="text/javascript">
        var inp = document.getElementsByName("iname");
        for(var i=0;i<inp.length;i++){
            alert(inp[i].value);
        }
    </script>
```

### 鼠标事件

#### 鼠标单击

```html
    <script type="text/javascript">
        var btn = document.getElementById("btn");
        btn.onclick = hello;
        function hello(){
            var pid = document.getElementById("pid");
            pid.innerHTML = "Hello!";
        }
    </script>
```

#### 鼠标按下抬起

```html
    <script type="text/javascript">
        var btn = document.getElementById("btn");
        btn.onmousedown = down;
        btn.onmouseup = up;
        function up() {
            var pid = document.getElementById("pid");
            pid.innerHTML = "up";
        }
        function down() {
            var pid = document.getElementById("pid");
            pid.innerHTML = "down";
        }
    </script>
```

#### 鼠标悬停和移出

```html
    <script type="text/javascript">
        var btn = document.getElementById("btn");
        btn.onmouseover = over;
        btn.onmouseout = out;
        function over() {
            var pid = document.getElementById("pid");
            pid.innerHTML = "over";
        }
        function out() {
            var pid = document.getElementById("pid");
            pid.innerHTML = "out";
        }
    </script>
```

#### 输入框input的聚焦和失去聚焦

```html
    <script type="text/javascript">
        var inp = document.getElementById("input");
        inp.onfocus = focus;
        inp.onblur = blur;
        function focus() {
            var pid = document.getElementById("pid");
            pid.innerHTML = "focus";
        }
        function blur() {
            var pid = document.getElementById("pid");
            pid.innerHTML = "blur";
        }
    </script>
```

#### 输入框内容选中和改变

```html
    <script type="text/javascript">
        var inp = document.getElementById("input");
        inp.onselect = select;
        inp.onchange = change;
        function select() {
            var pid = document.getElementById("pid");
            pid.innerHTML = "select";
        }
        function change() {
            var pid = document.getElementById("pid");
            pid.innerHTML = "change";
        }
    </script>
```

### 确认框

```html
    <script type="text/javascript">
        function rec() {
            var message = confirm("Do you like me?");
            if(message == true) {
                document.write("么么哒！~");
            }
            else {
                document.write("泥奏凯！");
            }
        }
        var inp = document.getElementById("input");
        inp.onclick = rec;
    </script>
```

### 提问框

```html
    <script type="text/javascript">
        function rec(){
            var score; // score变量，用来存储用户输入的成绩值。
            score = prompt("Your score?");
            if(score >= 90) {
                document.write("你很棒！");
            } else if(score >= 75) {
                document.write("不错哦！");
            } else if(score >= 60) {
                document.write("要加油！");
            } else {
                document.write("要努力了哦！");
            }
        }
        var inp = document.getElementById("input");
        inp.onclick = rec;
    </script>
```

### 获取和设置属性

```html
    <script type="text/javascript">
        var btn = document.getElementById("btn");
        btn.onclick = attr;
        function attr() {
            var pid = document.getElementById("pid");
            alert(pid.getAttribute("id"));
            alert(pid.getAttribute("title"));
            pid.setAttribute("title","hello");
            alert(pid.getAttribute("title"));
        }
    </script>
```

### 打开新窗口

```html
<input id="input" type="button" value="点击我，打开新窗口！">
<script type="text/javascript">
    function windowOpen(){
        window.open('http://www.jisuanke.com','_blank','width = 600, height = 400, top = 100, left = 0');    
    }
    var inp = document.getElementById("input");
    inp.onclick = windowOpen;
</script>
```

### 加载页面

```html
    <script type="text/javascript">
        window.onload = load;
        function load() {
            alert("load");
        }
    </script>
```

### 杂项

```js
document.write(mychar);
alert(mychar);  //警告
```

## 浏览器对象

### 循环定时器

```html
    <input type="text" id="clock" size="50">
    <script type="text/javascript">
        function clock()
        {
            var time = new Date();
            var attime = time.getHours()+":"+time.getMinutes()+":"+time.getSeconds();
            document.getElementById("clock").value=attime;
        }
        setInterval(clock,100);
    </script>
```

### 循环定时器开关

```html
    <input type="text" id="clock">
    <input type="button" id="istart" value="Start">
    <input type="button" id="istop" value="Stop">
    <script type="text/javascript">
        var setid;
        var time;
        var attime;
        function clock(){
            time = new Date();
            attime = time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds();
            document.getElementById("clock").value = attime;
        }
        var istart = document.getElementById("istart");
        istart.onclick = function(){
            setid = setInterval(clock,100);
        }
        var istop = document.getElementById("istop");
        istop.onclick = function(){
             clearInterval(setid);
        }
    </script>
```

### 延时定时器

```html
    <input type="text" id="inum">
    <input type="button" id="ialt" value="Start">
    <script type="text/javascript">
        var inum = document.getElementById("inum");
        var ialt = document.getElementById("ialt");
        ialt.onclick = function () {
            setTimeout("inum.value = 1",1000);
            setTimeout("inum.value = 2",2000);
            setTimeout("inum.value = 3",3000);
            setTimeout("inum.value = 4",4000);
            setTimeout("alert('666')",5000);
        }
    </script>
```

```html
<input type="text" id="count">
<input type="button" id="istart" value="Start">
<input type="button" id="istop" value="Stop">
<script type="text/javascript">
    var seti;
    var num = 0;
    function startCount(){
        document.getElementById('count').value = num;
        num = num + 1;
        seti = setTimeout("startCount()",1000);      
    }
    var istart = document.getElementById("istart");
    istart.onclick = function(){
        startCount();
    }
    var istop = document.getElementById("istop");
    istop.onclick = function(){
        clearTimeout(seti);    
    }
</script>
```

### location对象

用于获取和设置窗体URL

### navigation对象

获取浏览器相关信息

### screen对象

获取显示器宽度

## DOM对象


# js原型链

```js
function Student(name,age,gender){
  this.name = name;
  this.age = age;
  this.gender = gender;
  this.sayHi = function(){
       console.log("hi");
  }
}

var s1 = new Student('zhangsan', 18, 'male');
s1.sayHi(); //打印 hi
var s2 = new Student('lisi',18,'male');
s2.sayHi(); //打印 hi
console.log(s1.sayHi == s2.sayhi); //结果为false
```

每次new出的对象都具有单独的sayHi实体，造成内存的浪费。

## 原型 prototype

    在 JavaScript 中，每一个函数都有一个 prototype 属性，指向另一个对象。这个对象的所有属性和方法，都会被构造函数的实例继承

```js
function Student(name, age, gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
}
Student.prototype.sayHi = function(){
    console.log("hi");
}
var s1 = new Student('zhangsan', 18, 'male');
s1.sayHi();//打印 hi
var s2 = new Student('lisi', 18, 'male');
s2.sayHi();//打印 hi
console.log(s1.sayHi == s2.sayHi);//结果为true
```

## 构造函数、实例、原型三者之间的关系

每一个函数都有一个 prototype 属性，指向另一个对象。在编辑器中输入以下代码：

```js
<script type="text/javascript">
    function F() {}
    console.log(F.prototype);
</script>
```

上述代码在浏览器中打印结果为 Object，验证了我们所说的 prototype 属性，指向另一个对象。构造函数的 prototype 对象默认都有一个 constructor 属性，指向 prototype 对象所在函数。在控制台中运行下面的代码：

```js
function F() {}
console.log(F.prototype.constructor === F);//结果为ture
```

通过构造函数得到的实例对象内部会包含一个指向构造函数的 prototype 对象的指针__proto__。__proto__属性最早是火狐浏览器引入的，用以通过实例对象来访问原型，这个属性在早期是非标准的属性。在控制台中运行下面的代码：

```js
function F() {}
var a = new F();
console.log(a.__proto__ === F.prototype); //结果为true
```

实例对象可以直接访问原型对象成员。所有实例都直接或间接继承了原型对象的成员。

总结：每个构造函数都有一个原型对象，原型对象包含一个指向构造函数的指针 constructor，而实例都包含一个指向原型对象的内部指针__proto__ 。

## 原型链

我们说过所有的对象都有原型，而原型也是对象，也就是说原型也有原型，那么如此下去，也就组成了我们的原型链。

### 属性搜索原则

属性搜索原则，也就是属性的查找顺序，在访问对象的成员的时候，会遵循以下原则：
- 首先从对象实例本身开始找，如果找到了这个属性或者方法，则返回。
- 如果对象实例本身没有找到，就从它的原型中去找，如果找到了，则返回。
- 如果对象实例的原型中也没找到，则从它的原型的原型中去找，如果找到了，则返回。
- 一直按着原型链查找下去，找到就返回，如果在原型链的末端还没有找到的话，那么如果查找的是属性则返回 undefined，如果查找的是方法则返回 xxx is not a function。

### 更简单的原型语法

在前面的例子中，我们是使用 xxx.prototype. 然后加上属性名或者方法名来写原型，但是每添加一个属性或者方法就写一次显得有点麻烦，因此我们可以用一个包含所有属性和方法的对象字面量来重写整个原型对象：

```js
function Student(name, age, gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
}
Student.prototype = {
    hobby:"study",
    sayHi:function(){
    console.log("hi");
    }
}
var s1 = new Student("wangwu",18,"male");
console.log(Student.prototype.constructor === Student);//结果为 false
```

但是这样写也有一个问题，那就是原型对象丢失了 constructor 成员。所以为了保持 constructor 成员的指向正确，建议的写法是：

```js
function Student(name, age, gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
}
Student.prototype = {
    constructor: Student, //手动将 constructor 指向正确的构造函数
    hobby:"study",
    sayHi:function(){
    console.log("hi");
    }
}
var s1 = new Student("wangwu",18,"male");
console.log(Student.prototype.constructor === Student);//结果为 true

```

## 原型链继承

```js
function Student(name, age, gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
}
Student.prototype.sayHi = function(){
    console.log("hi");
}
var s1 = new Student("zhangsan",18,"male");
s1.sayHi(); //打印 hi
var s2 = new Student("lisi",18,"male");
s1.sayHi(); //打印 hi
```

上述例子中实例化对象 s1 和 s2 都继承了 sayHi 方法。


# call、apply、bind

在学习 call、apply、bind 方法之前，我们先来复习一下 this 的指向问题，我们前面说过一个口诀：谁调用 this，它就指向谁。让我们先来来看一个例子：

```
function foods() {
}
foods.prototype = {
    price: "￥15",
    say: function() {
        console.log("My price is " + this.prise);
    }
}

var apple = new foods();
apple.say();    //My price is ￥15
var orange = new foods();
orange.say();  // My price is ￥15
```
也就是说上述例子调用 say 方法，最后打印的结果都是一样的，但是如果我们想打印橘子的价钱是 10 元呢？又不想重新定义 say 方法。JavaScript 为我们专门提供了一些函数方法用来帮我们更优雅的处理函数内部 this 指向问题。这就是接下来我们要学习的 call、apply、bind 三个函数方法。

## call

call() 方法调用一个函数, 其具有一个指定的 this 值和分别地提供的参数(参数的列表)。语法为：fun.call(thisArg, arg1, arg2, ...)

    注：
    thisArg 指的是在 fun 函数中指定的 this 的值。如果指定了 null 或者 undefined 则内部 this 指向 window，同时值为原始值(数字，字符串，布尔值)的 this 会指向该原始值的自动包装对象。是一个可选项。
    arg1, arg2, ...指定的参数列表。也是可选项。
    使用调用者提供的 this 值和参数调用该函数的返回值。若该方法没有返回值，则返回 undefined。
    call() 允许为不同的对象分配和调用属于一个对象的函数/方法。
    call() 提供新的 this 值给当前调用的函数/方法。你可以使用 call 来实现继承：写一个方法，然后让另外一个新的对象来继承它（而不是在新对象中再写一次这个方法）。


使用 call() 方法调用函数并且指定上下文的 'this'。前面的例子可以改写成： 

```js
function foods() {

 }
 foods.prototype = {
     price: "￥15",
     say: function() {
         console.log("My price is " + this.prise);
     }
 }
 var apple = new foods();
 orange = {
     price: "￥10"
 }
 apple.say.call(orange); // My price is ￥10
```

在一个子构造函数中，你可以通过调用父构造函数的 call() 方法来实现继承。在控制台输入如下代码： 

```js
function Father(name, age) {
   this.name = name;
   this.age = age;
 }

 function Son(name, age) {
   Father.call(this, name, age);
   this.hobby = 'study';
 }

 var S1 = new Son('zhangsan', 18);
 S1; // Son {name: "zhangsan", age: 18, hobby: "study"}
```

## apply

apply() 方法与 call() 方法类似，唯一的区别是 call() 方法接受的是参数，apply() 方法接受的是数组。语法为：

```js
 var array = ['a', 'b','c'];
 var nums = [1, 2, 3];
 array.push.apply(array, nums);
 array //["a", "b", "c", 1, 2, 3]
// 注：concat() 方法连接数组，不会改变原数组，而是创建一个新数组。而使用 push 是接受可变数量的参数的方式来添加元素。使用 apply 则可以连接两个数组。

```

使用 apply() 方法和内置函数。

 ```js
 var numbers = [7, 10, 2, 1, 11, 9];
 var max = Math.max.apply(null, numbers); 
 max; //11
 ```

 注：直接使用 max() 方法的写法为： Math.max(7, 10, 2, 1, 11, 9);

## bind

bind() 方法创建一个新的函数（称为绑定函数），在调用时设置 this 关键字为提供的值。并在调用新函数时，将给定参数列表作为原函数的参数序列的前若干项。语法为：fun.bind(thisArg[, arg1[, arg2[, ...]]])

    注：参数 thisArg ：当绑定函数被调用时，该参数会作为原函数运行时的 this 指向。当使用 new 操作符调用绑定函数时，该参数无效。参数：arg1, arg2, ...表示当目标函数被调用时，预先添加到绑定函数的参数列表中的参数。


```js
var bin = function(){
    console.log(this.x);
}
var foo = {
x:10
}
bin(); // undefined
var func = bin.bind(foo); //创建一个新函数把 'this' 绑定到 foo 对象
func(); // 10
```

```js
this.num = 6;
var test = {
  num: 66,
  getNum: function() { return this.num; }
};

test.getNum(); // 返回 66

var newTest = test.getNum;
newTest(); // 返回 6, 在这种情况下，"this"指向全局作用域

// 创建一个新函数，将"this"绑定到 test 对象
var bindgetNum = newTest.bind(test);
bindgetNum(); // 返回 66
```

```js
var newTest = test.getNum;
newTest(); 

//上面这两行代码其实相当于：

var newTest(){
    return this.num;
}
//所以 this 指向的是全局作用域，返回 6。
```