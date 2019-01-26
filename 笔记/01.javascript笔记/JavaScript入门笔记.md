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



