package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;


    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }


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

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        Map<String, Integer> sortedSymptoms = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
            sortedSymptoms.put(entry.getKey(), entry.getValue());
        }
        return sortedSymptoms;
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}
