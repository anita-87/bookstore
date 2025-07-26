package com.bookstore.books.models;

import io.awspring.cloud.dynamodb.DynamoDbTableNameResolver;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Component;

@Component
public class CustomTableNameResolver implements DynamoDbTableNameResolver {

    @Override
    public <T> String resolve(Class<T> clazz) {
        return clazz.getAnnotation(TableName.class).name();
    }
}
