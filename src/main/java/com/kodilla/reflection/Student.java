package com.kodilla.reflection;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Student {
    private static final String CHARACTERS = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    private static final int NUMBER_OF_CHARACTERS = 10;
    private static final Random random = new Random();
    private final String indexNumber;

    public Student() {
        this.indexNumber = getRandomIndex();
        log.info("Created instance of {} with private field 'indexNumber' = {}" ,
                this.getClass().getSimpleName(), indexNumber);
    }

    private String getRandomIndex(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= NUMBER_OF_CHARACTERS; i++) {
            builder.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return builder.toString();
    }
}
