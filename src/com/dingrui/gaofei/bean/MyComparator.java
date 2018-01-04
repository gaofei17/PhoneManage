package com.dingrui.gaofei.bean;

import java.util.Comparator;

/*五、Comparable 与Comparator区别

上面已经分别实现了Comparable 与Comparator对List进行排序，他们有相似的地方，也有不同的地方：

1）Comparable 与Comparator都是java的接口，用来对自定义的实体对象进行比较；

2）Comparable 是定义在实体类内部的，所以实体类对象本身就有比较大小的可能。但如果想换一种比较规则，如先按年龄后按名字排序，那么就必须修改实体类Person本身；

3）Comparator是在实体类外部实现比较器的，所以对List排序时必须同时传入数据和比较器，如Collections.sort(list, new MyComparator());如果想换一种比较规则，则仅需要修改比较器MyComparator,而实体类Person则不需要改变；所以建议使用这种方法；

4）Comparable实现代码相对简单，Comparator实现代码相对复杂一点，但还是建议使用Comparator方法。
 * 
 * */

public class MyComparator implements Comparator<Manage> {

	public int compare(Manage one, Manage two) {
		int i = one.getMan_model().compareTo(two.getMan_model()); //比较名字字符串
		/**if (i == 0) { //如果名字一样，则继续比较年龄
			return one.age - two.age;
		} else { //首先比较名字，名字不一样，则返回比较结果
			return i;
		}**/
		return i;
	}
	
}
