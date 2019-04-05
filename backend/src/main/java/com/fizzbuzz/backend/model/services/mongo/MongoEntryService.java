package com.fizzbuzz.backend.model.services.mongo;

import com.fizzbuzz.backend.model.objects.Entry;
import com.fizzbuzz.backend.model.repositories.mongo.MongoEntryRepository;
import com.fizzbuzz.backend.model.services.interfaces.IEntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MongoDb override of generic entry service
 * Uses the mongodb entry repository
 * Offers methods to collect update, save, delete entries
 */
@Component
public class MongoEntryService implements IEntryService {

    //get
    public Entry getByName(String name) {
        return repo.getByName(name);
    }

    public Entry getMostOccured() {
        return repo.getMostOccured();
    }

    //save
    public Entry save(
            int int1,
            int int2,
            int limit,
            String str1,
            String str2) {
        String name = "Entry-" + int1 + "-" + int2 + "-" + limit + "-" + str1 + "-" + str2;
        Entry entry = getByName(name);
        if (entry == null) {
            entry = new Entry();
            entry.setName(name);
            entry.setInt1(int1);
            entry.setInt2(int2);
            entry.setLimit(limit);
            entry.setStr1(str1);
            entry.setStr2(str2);
            entry.setOccurences(1);
            repo.save(entry);
        } else {
            entry.incrementOccurences();
            repo.update(name, entry);
        }
        return entry;
    }

    @Autowired
    private MongoEntryRepository repo;
}