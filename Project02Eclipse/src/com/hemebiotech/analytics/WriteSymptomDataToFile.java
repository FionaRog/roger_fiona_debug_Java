package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Writes Symptoms and their occurences in a file path.
 * The file contains Symptoms and their occurences , one line per symptom, in the format:
 *      symptom: count
 */
public class WriteSymptomDataToFile implements ISymptomWriter{

    private String filePath;

    /**
     *Creates a writer that will write into a specified file.
     *
     * @param filePath the path of the file where datas are written into.
     */
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes per line each symptom and its occurences in the format "symptom: count".
     * Writer close automatically thanks to the "try-with-ressources" method.
     *
     * @param symptoms a map that contains the symptoms and their occurences.
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

              for (Map.Entry<String, Integer> symptomEntry : symptoms.entrySet()) {
              writer.write(symptomEntry.getKey()
                      + ": "
                      + symptomEntry.getValue()
                      + "\n");
              }
      } catch (IOException e) {
          e.printStackTrace();
      }
    }

  }
