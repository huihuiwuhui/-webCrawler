package com.itcv.test;

public class Test {
   public static void main(String[] args) {
	  String str ="<br> &nbsp;&nbsp;&nbsp;&nbsp;����һ���ݾͿ�ʼ���·�����һ���͸��������ˣ�����磬�������Ұɡ���";
	  str = str.replaceAll("&nbsp;","\t");
	  str = str.replaceAll("<br>", "\n");
	  System.out.println(str);
}
}
