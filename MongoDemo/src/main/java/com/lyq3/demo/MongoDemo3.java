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
 * ��ȡ����
 * @author Administrator
 *
 */
public class MongoDemo3 {
	public static void main(String[] args) {
		//����Ҫ�������ݿ����ƺͶ˿�
		MongoClient client=new MongoClient("localhost",27017);
		MongoDatabase db=client.getDatabase("test");	///�������ݿ�
		//Ҫ�����ļ�������
		MongoCollection<Document> col=db.getCollection("lyq");
		BasicDBObject cond=new BasicDBObject();
		cond.put("deptno", new BasicDBObject("$gt",1000).append("$lt", 1005));
		FindIterable<Document> cur=col.find(cond);
		//ѭ��������
		for(Document d:cur){
			System.out.println(d.getString("dname"));
		}
		client.close();
	}
}
