package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface allowing the implementation to write a map of symptoms associated with their occurrence.
 *
 */
public interface ISymptomWriter {
    void writeSymptoms(Map<String, Integer> symptoms);
}