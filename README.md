
<pre>
android环境搭建不用那么复杂，在其官网下载的ADT（adt-bundle-windows-x86_64-20130522.zip）（已下载到本目录），里面已经有Eclipse，并且把SDK在解压时配好了路径。所以android环境搭建只需两步：
1、官网下载ADT，解压
2、配置SDK的环境变量
</pre>

---

只要本机有安装过Java以及配置好Java环境变量，解压即可用

---
<pre>
若需要环境变量配置sdk：
依次点击：“我的电脑”－(右键)“属性”－“高级”－“环境变量”，弹出Windows的“环境变量”配置卡。
在“系统变量”栏下执行三项操作：
①新建“Android_Home”，值：SDK所在的绝对路径(例如 F:\软件\编程学习软件\Android\sdk\adt-bundle-windows-x86_64-20130522\sdk)。
②新建“Path”(如果已有，则直接编辑),值： %Android_Home%\platform-tools; (若值中原来有内容，用分号与之隔开)。
③%Android_Home%\tools;
</pre>
