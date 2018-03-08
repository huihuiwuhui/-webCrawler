package com.itcv.test;

public class Test {
   public static void main(String[] args) {
	  String str ="<br> &nbsp;&nbsp;&nbsp;&nbsp;陈三一进屋就开始脱衣服，我一看就给他跪下了，“大哥，你饶了我吧。”";
	  str = str.replaceAll("&nbsp;","\t");
	  str = str.replaceAll("<br>", "\n");
	  System.out.println(str);
}
}
