package com.hrm.utils;

import java.util.Random;

public class HumanIdFactory {
	static Random random=new Random(System.currentTimeMillis());
	public static String getWorke(){ 
		while(true){
			int i=random.nextInt(91);
			if(i < 91 && i>64){
				char result=(char)i;
				return result+"";
			}
		}
	}
	public static String getHumanId(){
		StringBuilder strb=new StringBuilder();
		System.out.println((int)'Z'); //65-90
		strb.append(HumanIdFactory.getWorke());
		strb.append(HumanIdFactory.getWorke());
		strb.append(HumanIdFactory.getWorke());
		for(int i=0;i<20;i++){
			strb.append(random.nextInt(10)); 
		}
		return strb.toString(); 
	}
	public static void main(String[] args) {
		System.out.println(HumanIdFactory.getHumanId()); 
	}
}
