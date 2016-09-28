package com.lyq3.demo;

import java.util.regex.Pattern;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * 模糊查询
 * @author Administrator
 *
 */
public class MongoDemo4 {
	public static void main(String[] args) {
		//设置要连接数据库名称和端口
		MongoClient client=new MongoClient("localhost",27017);
		MongoDatabase db=client.getDatabase("test");	///链接数据库
		//要操作的集合名称
		MongoCollection<Document> col=db.getCollection("lyq");
		Pattern pa=Pattern.compile("10");
		BasicDBObject cond=new BasicDBObject();
		cond.put("dname", new BasicDBObject("$regex",pa).append("$options", "i"));
		FindIterable<Document> cur=col.find(cond);
		//循环存数据
		for(Document d:cur){
			System.out.println(d.getString("dname"));
		}
		client.close();
	}
}
