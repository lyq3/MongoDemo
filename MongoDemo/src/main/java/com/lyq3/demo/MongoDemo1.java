package com.lyq3.demo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDemo1 {
	public static void main(String[] args) {
		//设置要连接数据库名称和端口
		MongoClient client=new MongoClient("localhost",27017);
		MongoDatabase db=client.getDatabase("test");	///链接数据库
		//得到并输出集合名字
		for(String name:db.listCollectionNames()){
			System.out.println("集合名称："+name);
		}
		client.close();//关闭数据库连接
		
	}
}
