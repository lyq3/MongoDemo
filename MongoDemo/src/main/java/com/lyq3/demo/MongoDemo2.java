package com.lyq3.demo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * ������
 * @author Administrator
 *
 */
public class MongoDemo2 {
	public static void main(String[] args) {
		//����Ҫ�������ݿ����ƺͶ˿�
		MongoClient client=new MongoClient("localhost",27017);
		MongoDatabase db=client.getDatabase("test");	///�������ݿ�
		//Ҫ�����ļ�������
		MongoCollection<Document> col=db.getCollection("lyq");
		//ѭ��������
		for(int x=0 ; x<100 ;x++){
			Document obj=new Document();
			obj.append("deptno", 1000+x);
			obj.append("dname", "������"+x);
			obj.append("loc", "����"+x);
			col.insertOne(obj);
		}
		client.close();
	}
}
