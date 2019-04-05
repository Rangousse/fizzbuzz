package com.fizzbuzz.backend.model.services.interfaces;

import com.fizzbuzz.backend.model.objects.Entry;

/**
 * Service generic interface for the entry data
 * Can be overrided using any specific repository
 * Offers methods to collect update, save, delete entries
 */
public interface IEntryService {

    //get
    Entry getByName(String name);
    Entry getMostOccured();

    //save
    Entry save(
            int int1,
            int int2,
            int limit,
            String str1,
            String str2
    );
}
