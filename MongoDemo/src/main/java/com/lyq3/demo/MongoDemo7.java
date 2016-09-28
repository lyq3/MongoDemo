package com.lyq3.demo;


import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * 删除数据
 * @author Administrator
 *
 */
public class MongoDemo7 {
	public static void main(String[] args) {
		//设置要连接数据库名称和端口
		MongoClient client=new MongoClient("localhost",27017);
		MongoDatabase db=client.getDatabase("test");	///链接数据库
		//要操作的集合名称
		MongoCollection<Document> col=db.getCollection("lyq");
		BasicDBObject conda=new BasicDBObject("deptno",1002);
		DeleteResult res=col.deleteOne(conda);
		System.out.println(res.getDeletedCount());
		client.close();
	}
}
