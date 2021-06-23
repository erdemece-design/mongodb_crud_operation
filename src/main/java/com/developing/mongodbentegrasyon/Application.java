package com.developing.mongodbentegrasyon;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;


public class Application {
    public static void main(String[] args) {
    MongoClient client = new MongoClient("localhost",27017); // it has been made mongo db client
        MongoDatabase infoDB = client.getDatabase("info");
        MongoCollection<Document> personalCollection = infoDB.getCollection("personal");
        BasicDBObject data = new BasicDBObject();
       data.append("name","person_name");
       data.append("date","person_birth_date");
       data.append("country","nationality");

        BasicDBObject data2 = new BasicDBObject();
        data.append("name","person2_name");
        data.append("date","person2_birt_date");
        data.append("country","nationality");

      // personalCollection.insertOne(Document.parse(data.toJson())); // for make one insert
        //Write insert

       /* Document parse = Document.parse(data.toJson());
        Document parse2 = Document.parse(data.toJson());
        personalCollection.insertMany(Arrays.asList(parse,parse2));*/


        //read 
//        FindIterable<Document> documents = personalCollection.find();
//
//        for(Document doc: documents){
//            System.out.println(doc.toJson());

        // update

        Bson filter = Filters.eq("name", "erdem");
        Bson update = Updates.set("date",1922);
        personalCollection.updateOne(filter,update);
    }
    }

