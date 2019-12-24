# tacomall

#### 关于tacomall-springboot
基于springboot开发的maven多模块商城后台


#### 关于tacomall
tacomall，正如墨西哥taco一样，让商城代码在开发者手中充满异域风味。同时致力于打造一个全面，可商用的，同时赋能社交流量推广的平台商城（将接入微信，今日头条，抖音等热门平台），tacomall包含如下主要模块：

**tacomall-uniapp**

基于uniapp开发的适用于微信小程序，头条小程序，支付宝小程序，H5端的商城。

**tacomall-springboot**

基于springboot开发的maven多模块商城后台[前往查看](https://gitee.com/running-cat/tacomall-springboot)。

**tacomall-admin**

基于iview开发的前后分离商城管理后台[前往查看](https://gitee.com/running-cat/tacomall-admin)。

**tacomall-sql**

mysql文件


#### APP预览

**登录:**

<img src='https://cdn.kyeteo.cn/tacomall/login.jpg' height='500px'>

**个人中心:**

<img src='https://cdn.kyeteo.cn/tacomall/center.jpg' height='500px'>

**购物车:**

<img src='https://cdn.kyeteo.cn/tacomall/cart.jpg' height='500px'>

**详情:**

<img src='https://cdn.kyeteo.cn/tacomall/goods.jpg' height='500px'>

#### 软件架构

~~~
tacomall-uniapp    根目录
├─api                   与服务端对接
├─common                项目公共目录，包括未编译之前的less,es6文件
├─compoents             被页面公用的组件
├─hybrid                混合页面，适用于编译成navtive app时嵌入的HTML网页
├─libs                  js库，例如http请求库
├─pages                 页面
├─platforms             适用于编译不同平台的兼容代码
├─plugins               Vue的插件库
├─service               平台提供的服务，例如微信登陆服务
├─static                静态目录，严禁将未编译的静态资源放入该目录
├─store                 vuex状态管理
├─utils                 js方法库
├─App.vue               App启动
├─config.js             App配置文件
├─main.js               App编译入口
├─manifest.json         App项目配置文件
├─page.json             App页面配置
~~~


#### 安装教程

1.  克隆项目
2.  安装hbuilderx
3.  导入项目
4.  编译运行

#### 使用说明

1.  项目允许进行商用
2.  项目使用iconfont图标，如需针对图标库进行修改，请私信获取iconfont

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 码云特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5.  码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
