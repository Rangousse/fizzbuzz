package com.fizzbuzz.backend.model.repositories.mongo;

import com.fizzbuzz.backend.SpringMainConfig;
import com.fizzbuzz.backend.model.objects.Entry;
import com.fizzbuzz.backend.model.repositories.interfaces.IEntryRepository;

import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MongoDb override of the generic entry repository
 * Offers methods to collect update, save, delete entries
 * Unique place where you have to find mongodb code for entries collection
 */
@Component
public class MongoEntryRepository implements IEntryRepository {

    //get
    public Entry getByName(String name) {
        return getCollection().findOne("{name: '" + name + "'}").as(Entry.class);
    }

    public Entry getMostOccured() {
        return getCollection().find().sort("{occurences : -1}").as(Entry.class).next();
    }

    //save
    public void save(Entry entry) {
        getCollection().save(entry);
    }

    public void update(String name, Entry entry) {
        getCollection().update("{name: '" + name + "'}").with(entry);
    }

    private static MongoCollection getCollection() {
        return provider.getCollection(SpringMainConfig.getProperty("COLLECTION_NAME"));
    }

    @Autowired
    private static MongoProvider provider;
}
