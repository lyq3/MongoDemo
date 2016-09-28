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
 * ��ҳ
 * @author Administrator
 *
 */
public class MongoDemo5 {
	public static void main(String[] args) {
		//����Ҫ�������ݿ����ƺͶ˿�
		MongoClient client=new MongoClient("localhost",27017);
		MongoDatabase db=client.getDatabase("test");	///�������ݿ�
		//Ҫ�����ļ�������
		MongoCollection<Document> col=db.getCollection("lyq");
		Pattern pa=Pattern.compile("1");
		BasicDBObject cond=new BasicDBObject();
		cond.put("dname", new BasicDBObject("$regex",pa).append("$options", "i"));
		//��ҳ
		FindIterable<Document> cur=col.find(cond).skip(2).limit(5);
		//ѭ��������
		for(Document d:cur){
			System.out.println(d.getString("dname"));
		}
		client.close();
	}
}
