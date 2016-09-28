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
 * ͳ��
 * @author Administrator
 *
 */
public class MongoDemo8 {
	public static void main(String[] args) {
		//����Ҫ�������ݿ����ƺͶ˿�
		MongoClient client=new MongoClient("localhost",27017);
		MongoDatabase db=client.getDatabase("test");	///�������ݿ�
		List<BasicDBObject> all=new ArrayList<BasicDBObject>();
		//Ҫ�����ļ�������
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
