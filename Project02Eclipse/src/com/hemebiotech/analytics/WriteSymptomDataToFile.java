package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


public class WriteSymptomDataToFile implements ISymptomWriter{

    private String filePath;

    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

              for (Map.Entry<String, Integer> symptomEntry : symptoms.entrySet()) {
              writer.write(symptomEntry.getKey() + ": " + symptomEntry.getValue() + "\n");
              }
      } catch (IOException e) {
          e.printStackTrace();
      }
    }

  }
