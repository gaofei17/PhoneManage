package com.dingrui.gaofei.bean;

import java.util.Comparator;

/*�塢Comparable ��Comparator����

�����Ѿ��ֱ�ʵ����Comparable ��Comparator��List�����������������Ƶĵط���Ҳ�в�ͬ�ĵط���

1��Comparable ��Comparator����java�Ľӿڣ��������Զ����ʵ�������бȽϣ�

2��Comparable �Ƕ�����ʵ�����ڲ��ģ�����ʵ�����������бȽϴ�С�Ŀ��ܡ�������뻻һ�ֱȽϹ������Ȱ����������������ô�ͱ����޸�ʵ����Person����

3��Comparator����ʵ�����ⲿʵ�ֱȽ����ģ����Զ�List����ʱ����ͬʱ�������ݺͱȽ�������Collections.sort(list, new MyComparator());����뻻һ�ֱȽϹ��������Ҫ�޸ıȽ���MyComparator,��ʵ����Person����Ҫ�ı䣻���Խ���ʹ�����ַ�����

4��Comparableʵ�ִ�����Լ򵥣�Comparatorʵ�ִ�����Ը���һ�㣬�����ǽ���ʹ��Comparator������
 * 
 * */

public class MyComparator implements Comparator<Manage> {

	public int compare(Manage one, Manage two) {
		int i = one.getMan_model().compareTo(two.getMan_model()); //�Ƚ������ַ���
		/**if (i == 0) { //�������һ����������Ƚ�����
			return one.age - two.age;
		} else { //���ȱȽ����֣����ֲ�һ�����򷵻رȽϽ��
			return i;
		}**/
		return i;
	}
	
}
