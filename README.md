#  底部导航栏设置

### 参考[oschina-app](https://github.com/yangxiaoge/oschina-android-app)写的一个小demo

1. 将底部tab页icon,title,页面等 存放在 enum枚举类MainTab中
2. 在主页中 初始化 FragmentTabHost对象 ,创建底部导航按钮(获取indicator布局,设置title,icon等),设置默认页卡, TabChangedListener监听

>更多的功能点需要参考 **oschina-app**

#*效果图如下*:

>![home.png](http://upload-images.jianshu.io/upload_images/1798697-98c81db06d9c143a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)![bundle.png](http://upload-images.jianshu.io/upload_images/1798697-0b29ac939631e68d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![bill.png](http://upload-images.jianshu.io/upload_images/1798697-d894b241ce959fca.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
