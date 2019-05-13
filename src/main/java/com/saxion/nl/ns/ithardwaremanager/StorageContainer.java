package com.saxion.nl.ns.ithardwaremanager;

public class StorageContainer {

    private static Storage storage;

    public static Storage getStorage() {
        if (storage == null) {
            storage = new Storage();
        }

        return storage;
    }
}
