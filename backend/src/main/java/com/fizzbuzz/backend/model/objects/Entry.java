package com.fizzbuzz.backend.model.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Entry : has a name, fizz data and number of occurences
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entry {

    private String name;

    private int int1;
    private int int2;
    private int limit;
    private String str1;
    private String str2;

    private int occurences;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public int getInt2() {
        return int2;
    }

    public void setInt2(int int2) {
        this.int2 = int2;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public int getOccurences() {
        return occurences;
    }

    public void setOccurences(int occurences) {
        this.occurences = occurences;
    }

    public void incrementOccurences() {
        ++this.occurences;
    }

    public String toString() {
        return "Entry {" + name + " / " + occurences + "}";
    }
}
