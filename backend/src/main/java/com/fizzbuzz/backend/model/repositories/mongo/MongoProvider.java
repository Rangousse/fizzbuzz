package com.fizzbuzz.backend.model.repositories.mongo;

import com.fizzbuzz.backend.SpringMainConfig;
import com.mongodb.DB;
import com.mongodb.MongoClient;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.stereotype.Component;

/**
 * Class providing in static the access to db and collections
 */
@Component
public class MongoProvider {
    public static MongoCollection getCollection(String collection) {
        return getDB().getCollection(collection);
    }

    private static Jongo getDB() {
        if (jongo == null) {
            MongoClient mongoClient = new MongoClient(
                    SpringMainConfig.getProperty("DB_SERVER"),
                    SpringMainConfig.getIntProperty("DB_PORT")
            );
            DB database = mongoClient.getDB(SpringMainConfig.getProperty("DB_NAME"));
            jongo = new Jongo(database);
            return jongo;
        }
        return jongo;
    }

    private static Jongo jongo;
}
