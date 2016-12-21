/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 * 
 * JDK 8 MOOC Lesson 3 homework
 */
package es.joseoc.java.learning.lambdas.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Class to generate a list of random words
 *
 * @author Simon Ritter (@speakjava)
 */
public class RandomWords {
//  private static final String FILENAME = "words";
  private static final String FILENAME = "/home/jose/code/jose/oracle-java8-lambda-mooc/src/test/resources/es/joseoc/java/learning/lambdas/lesson3/words.txt";
private final List<String> sourceWords;

  /**
   * Constructor
   * 
   * @throws IOException If the source words file cannot be read
   */
  public RandomWords() throws IOException {   
    try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILENAME))) {
      sourceWords = reader.lines().collect(Collectors.toList());
      
      System.out.println("Loaded " + sourceWords.size() + " words");
    }
  }

  /**
   * Create a list of a given size containing random words
   *
   * @param listSize The size of the list to create
   * @return The created list
   */
  public List<String> createList(int listSize) {
    Random rand = new Random();

    // This can give repeated words
    List<String> wordList = rand.ints(0, listSize)
    		.limit(listSize)
    		.mapToObj(i -> this.sourceWords.get(i))
    		.collect(Collectors.toList());

    return wordList;
  }

  /**
   * Return the list of all source words, which cannot be modified
   *
   * @return The unmodifiable list of all source words
   */
  public List<String> allWords() {
    return Collections.unmodifiableList(sourceWords);
  }
}