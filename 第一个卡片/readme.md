# 第一个前端项目
## 准备
编译环境：vscode+前端插件套餐

## 执行环境
edge浏览器
## 遇到的坑
 不知道为什么html没有报错，class写错了没提醒导致不能识别类。
![alt text](0136E5B8.png)  
js执行时类名错误

## 实现逻辑
这段代码是一个基于 JavaScript 的事件监听器代码片段。

首先，通过 document.querySelectorAll('.panel') 获取了页面中所有具有 panel 类名的元素，并将它们存储在名为 panels 的变量中。

接着，使用 panels.forEach(panel => {...}) 循环遍历了每一个 panel 元素，为每一个 panel 元素添加了一个点击事件监听器。当点击某个 panel 元素时，会执行回调函数 () => {...}。

在回调函数中，首先调用 removeActiveClasses() 函数，这个函数的作用是移除所有具有 active 类名的元素的 active 类。然后，给当前被点击的 panel 元素添加一个新的类名 active，通过 panel.classList.add('active') 实现。

最后，定义了 removeActiveClasses() 函数，这个函数的作用是移除所有具有 active 类名的元素的 active 类。这样确保在点击某个 panel 元素时，其他的 panel 元素会被移除 active 类，保证只有当前被点击的 panel 元素拥有 active 类。

这段代码的作用是实现一个点击切换效果，点击不同的 panel 元素会给被点击的元素添加 active 类，同时移除其他 panel 元素的 active 类，以达到突出显示被点击元素的效果。