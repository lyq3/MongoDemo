package com.lyq3.demo;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * 统计
 * @author Administrator
 *
 */
public class MongoDemo8 {
	public static void main(String[] args) {
		//设置要连接数据库名称和端口
		MongoClient client=new MongoClient("localhost",27017);
		MongoDatabase db=client.getDatabase("test");	///链接数据库
		List<BasicDBObject> all=new ArrayList<BasicDBObject>();
		//要操作的集合名称
		MongoCollection<Document> col=db.getCollection("lyq");
		BasicDBObject cond=new BasicDBObject("$group",new BasicDBObject("_id","$loc").append("count", new BasicDBObject("$sum",1)));
		all.add(cond);
		AggregateIterable<Document> list=col.aggregate(all);
		for(Document d:list){
			System.out.println(d);
		}
		client.close();
	}
}
