
第一题：进入Exam1文件夹，mvn clean compile进行编译。
运行：mvn exec:java -Dexec.mainClass="com.hand.App" -Dexec.args="arg0 arg1 arg2"

第二题：进入Exam2文件夹，mvn clean compile进行编译。
运行：mvn exec:java -Dexec.mainClass="com.hand.App" -Dexec.args="arg0 arg1 arg2"
然后打开浏览器输入： 127.0.0.1:23333  ,返回exam2查看可得exam2.pdf。

第三题：进入Exam3文件夹，mvn clean compile进行编译。
运行：mvn exec:java -Dexec.mainClass="com.hand.App" -Dexec.args="arg0 arg1 arg2"
可以看见生成的stock.xml 和stock.json文件。