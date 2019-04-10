package cput.ac.za.repository;

import java.util.UUID;

public class marketIDGenerate {

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
