package com.lyq3.demo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDemo1 {
	public static void main(String[] args) {
		//����Ҫ�������ݿ����ƺͶ˿�
		MongoClient client=new MongoClient("localhost",27017);
		MongoDatabase db=client.getDatabase("test");	///�������ݿ�
		//�õ��������������
		for(String name:db.listCollectionNames()){
			System.out.println("�������ƣ�"+name);
		}
		client.close();//�ر����ݿ�����
		
	}
}
