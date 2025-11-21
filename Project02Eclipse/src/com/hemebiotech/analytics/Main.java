package com.hemebiotech.analytics;

import com.hemebiotech.analytics.reader.ISymptomReader;
import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.writer.ISymptomWriter;
import com.hemebiotech.analytics.writer.WriteSymptomDataToFile;

import java.util.List;
import java.util.Map;

/**
 * The Main class runs the process described in Analytics counter:
 *      Reading symptoms from a data source
 *      Counting the number of occurrences of each symptom
 *      Sorting symptoms alphabetically
 *      Writting results to an output file
 */
public class Main {

    /**
     * Execution method.
     * Instantiates the required components and runs the full analysis
     * @param args unused
     */
    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = counter.getSymptoms();

        Map<String, Integer> countedSymptoms = counter.countSymptoms(symptoms);

        Map<String, Integer> sortedSymptoms = counter.sortSymptoms(countedSymptoms);

        counter.writeSymptoms(sortedSymptoms);




    }

}