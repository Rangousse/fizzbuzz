package com.fizzbuzz.backend.model.repositories.interfaces;

import com.fizzbuzz.backend.model.objects.Entry;

/**
 * Repository generic interface for the entry data
 * Can be overrided using any database
 * Offers methods to collect update, save, delete entries
 */
public interface IEntryRepository {
    //get
    Entry getByName(String name);
    Entry getMostOccured();

    //save
    void save(Entry rule);
    void update(String name, Entry entry);
}
