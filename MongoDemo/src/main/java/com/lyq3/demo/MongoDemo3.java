package com.lyq3.demo;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * 读取数据
 * @author Administrator
 *
 */
public class MongoDemo3 {
	public static void main(String[] args) {
		//设置要连接数据库名称和端口
		MongoClient client=new MongoClient("localhost",27017);
		MongoDatabase db=client.getDatabase("test");	///链接数据库
		//要操作的集合名称
		MongoCollection<Document> col=db.getCollection("lyq");
		BasicDBObject cond=new BasicDBObject();
		cond.put("deptno", new BasicDBObject("$gt",1000).append("$lt", 1005));
		FindIterable<Document> cur=col.find(cond);
		//循环读数据
		for(Document d:cur){
			System.out.println(d.getString("dname"));
		}
		client.close();
	}
}
