package com.lyq3.demo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * 存数据
 * @author Administrator
 *
 */
public class MongoDemo2 {
	public static void main(String[] args) {
		//设置要连接数据库名称和端口
		MongoClient client=new MongoClient("localhost",27017);
		MongoDatabase db=client.getDatabase("test");	///链接数据库
		//要操作的集合名称
		MongoCollection<Document> col=db.getCollection("lyq");
		//循环存数据
		for(int x=0 ; x<100 ;x++){
			Document obj=new Document();
			obj.append("deptno", 1000+x);
			obj.append("dname", "技术部"+x);
			obj.append("loc", "北京"+x);
			col.insertOne(obj);
		}
		client.close();
	}
}
