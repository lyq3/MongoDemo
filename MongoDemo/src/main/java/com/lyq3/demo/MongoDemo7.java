package com.lyq3.demo;


import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * ɾ������
 * @author Administrator
 *
 */
public class MongoDemo7 {
	public static void main(String[] args) {
		//����Ҫ�������ݿ����ƺͶ˿�
		MongoClient client=new MongoClient("localhost",27017);
		MongoDatabase db=client.getDatabase("test");	///�������ݿ�
		//Ҫ�����ļ�������
		MongoCollection<Document> col=db.getCollection("lyq");
		BasicDBObject conda=new BasicDBObject("deptno",1002);
		DeleteResult res=col.deleteOne(conda);
		System.out.println(res.getDeletedCount());
		client.close();
	}
}
