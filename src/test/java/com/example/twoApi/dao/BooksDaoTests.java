package com.example.twoApi.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
//TODO добавить здесь тесты
@SpringBootTest
public class BooksDaoTests {
    @Sql(value = "", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    void test23(){

    }
}
