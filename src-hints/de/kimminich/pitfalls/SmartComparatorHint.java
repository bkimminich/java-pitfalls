package de.kimminich.pitfalls;

import de.kimminich.ValueObject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.*;

public class SmartComparatorHint {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void defaultSortOrder() {
        List<ValueObject> valueObjects = new ArrayList<>();
        valueObjects.add(new ValueObject(2));
        valueObjects.add(new ValueObject(1));
        valueObjects.add(new ValueObject(3));

        Collections.sort(valueObjects, new SmartComparator(false));

        System.out.println("Default sort order: " + valueObjects);
    }

    @Test
    public void reversedSortOrder() {
        List<ValueObject> valueObjects = new ArrayList<>();
        valueObjects.add(new ValueObject(2));
        valueObjects.add(new ValueObject(1));
        valueObjects.add(new ValueObject(3));

        Collections.sort(valueObjects, new SmartComparator(true));

        System.out.println("Reversed sort order: " + valueObjects);
    }

    @Test
    public void valueObjectsWithSameValueInSet() {
        Set<ValueObject> valueObjects = new HashSet<>();
        valueObjects.add(new ValueObject(1));
        valueObjects.add(new ValueObject(2));
        valueObjects.add(new ValueObject(3));
        valueObjects.add(new ValueObject(3));

        System.out.println("ValueObjects in HashSet: " + valueObjects);
    }

    @Test
    public void serialization() throws Exception {
        Map<ValueObject, String> valueObjects = new TreeMap<>(new SmartComparator(false));
        valueObjects.put(new ValueObject(1), "One");
        valueObjects.put(new ValueObject(2), "Two");

        File file = temporaryFolder.newFile();

        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(out);
            o.writeObject(valueObjects);
        } catch (Exception e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
        } finally {
            out.close();
        }
    }

}
