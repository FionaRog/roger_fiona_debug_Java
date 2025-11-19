package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

/**
 * AnalyticsCounter class coordinates the processing of symptoms:
 *      Reading symptoms from a data source
 *      Counting the number of occurrences of each symptom
 *      Sorting symptoms alphabetically
 *      Writting results to an output file
 */
public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;

    /**
     * Creates a new AnalyticsCounter with the mentioned reader and writer.
     *
     * @param reader an implementation of ISymptomReader to read symptoms
     * @param writer an implementation of ISymptomWriter to write symptoms
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Gets a list of symptoms using ISymptomReader.
     *
     * @return a list of symptoms that may duplicate
     * */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
     * Counts the number of each symptom in the list.
     *
     * @param symptoms a list containing symptoms names that may duplicate
     * @return a map associating symptoms with its occurrences
     * */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> countedSymptoms = new HashMap<>();

        for (String symptom : symptoms) {
            if (countedSymptoms.containsKey(symptom)) {
                countedSymptoms.put(symptom, countedSymptoms.get(symptom) + 1);
            } else {
                countedSymptoms.put(symptom, 1);
            }
        }
        return countedSymptoms;
    }
    /**
     * Sorts each symptom and its occurences in an ordered list.
     *
     * @param symptoms a map that associates symptoms and its occurrences
     * @return a new TreeMap with symptoms in alphabetical order and its occurrences
     * */
    // could use : return new TreeMap<>(symptoms);
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        Map<String, Integer> sortedSymptoms = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
            sortedSymptoms.put(entry.getKey(), entry.getValue());
        }
        return sortedSymptoms;
    }

    /**
     * Writes the ordered symptoms and their occurrences using ISymptomWriter.
     *
     * @param symptoms a Map with symptoms in alphabetical order and its occurrences.
     * */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}
