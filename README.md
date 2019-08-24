### 主题选择：音视频

**一款首页像B站但是视频源不是B站的app**

### 1.项目构建：MVP+Retrofit2+Rxjava2+EventBus+Okhttp3

### 2.功能（具体功能看apk）

1.结合leancloud实现用户名登陆注册，短信等暂未实现（签名死活通不过）

2.实现长短视频的播放，和播放器的常用功能，数据api来源不止一个

3.用户的数据在leancloud储存并非完美，第一次用这个有点坑，但是基本的增删改查实现了，用户可以评论，收藏，喜欢，每一个视频的这些数据都会在leancloud存储。具体效果看apk。

4.app主题的三种切换，绿，蓝，粉，具体效果看apk。

5.视频截屏和弹幕（弹幕有时有有时没有，弹幕功能有问题）



### 3.使用的技术

1.Fragment懒加载，项目中所有的fragment都为懒加载

2.MVP架构，Retrofit2，Rxjava2，EventBus，Okhttp3等常用第三方库

3.使用kotlin自定义扩展函数简化代码，比如给imageView设置url,给各种Bean类添加扩展函数转化为自己的Bean类。（由于api来源不一样，数据格式也完全不一样，需要将其他的请求下来的bean类转化为自己的视频bean类来方便leancloud储存），大量使用kotlin函数表达式 with,let等

4.在必要的情况下将lambda的定义与实现分离，更好的实现功能（具体代码中看吧）

5.继承开源播放器[GSYVideoPlayer](https://github.com/CarGuo/GSYVideoPlayer)，实现一些自己的ui和逻辑

6.各种base类的封装

7.切换主题的时候用到了代理模式，结合了kotlin的委托实现主题切换,具体看代码（我知道完全没有这个必要用一个设计模式只为了完成一个功能，但是我想把我会的都用上）

8.使用了一个贝塞尔曲线来做的波浪效果（只会这个），和一些简单的自定义view.

9.一些单例工具类的封装，具体看代码吧，我也不知道哪些可以拿上台面的技术



##### 4.使用的api,（免费的视频api不多）

1.开眼视频api

2.一个网上找的百思不得解的api

3.一个bilibili的非视频api（B站本来开放的api关了，我只能找到一个非video的api）



##### 5.使用到的常用第三方库

1.Retrofit2+Rxjava2+EventBus+Okhttp3+leakcanary

2.circleimageview ,圆形图片

3.Glide

4.GSYVideoPlayer开源播放器

5.DanmakuFlameMaster  Bilibili开源烈焰弹幕使（很坑，而且好像还没有实现）

6.xpopup，弹窗库，更好的实现交互



##### 6.要说一下， 并非完全模仿B站，除了首页以外都是自己想的，但是多多少少有其他app的影子。之所以选择以B站的主页面为向导是因为过去的经验告诉我，如果ui完全自己想的话将会丑哭，真的，所以首页选择B站首页为向导。图片是我在github上面另一个项目上拉的。



### GIF图
<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491135231566648805754.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491156211566648720866.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491187671566648469187.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491206721566648434256.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491223291566648381459.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491238811566648332939.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491254621566648283089.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491269251566648228300.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491285161566648175509.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491306241566648069959.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491321441566648006130.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491340281566647905580.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491361101566647834202.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491377961566647747000.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491400381566647691133.gif>

<https://raw.githubusercontent.com/cuihengyuan/anotherBiliBili/master/15666491425861566647620927.gif>




