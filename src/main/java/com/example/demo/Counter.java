package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = Counter.COLLECTION_NAME)
public class Counter implements Serializable {

    public static final String COLLECTION_NAME = "counter";

    @Id
    public String id;

    public String page;
    public String value;

    public Counter(){}

    public Counter(String page, String value){
        this.page = page;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format(
                "Counter[id=%s, page='%s', value='%s']",
                id, page, value);
    }
}
