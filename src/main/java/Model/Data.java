package Model;

import java.sql.Time;
public class Data {
	public String name;//名字
	public Integer price;//人均
	public Double rating;//评分
	public String address;//地址
	
	public Data(String name_,Integer price_,Double rating_,String address_) {
		name = name_;
		price = price_;
		rating = rating_;
		address = address_;

	}

	public void out(){
		System.out.println("name:"+name);
		System.out.println("prise:"+price);
		System.out.println("rating:"+rating);
		System.out.println("address:"+address);
		System.out.println();
	}
}
