package com.lyq3.demo;


import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

/**
 * �޸�����
 * @author Administrator
 *
 */
public class MongoDemo6 {
	public static void main(String[] args) {
		//����Ҫ�������ݿ����ƺͶ˿�
		MongoClient client=new MongoClient("localhost",27017);
		MongoDatabase db=client.getDatabase("test");	///�������ݿ�
		//Ҫ�����ļ�������
		MongoCollection<Document> col=db.getCollection("lyq");
		//��ѯ����
		BasicDBObject conda=new BasicDBObject("deptno",1002);
		//��������
		BasicDBObject condb=new BasicDBObject("$set",new BasicDBObject("dname","�ͷ���"));
		UpdateResult res=col.updateMany(conda, condb);
		System.out.println(res);
		client.close();
	}
}
