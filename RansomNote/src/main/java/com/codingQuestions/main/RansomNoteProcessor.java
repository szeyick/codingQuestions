package com.codingQuestions.main;

import java.util.HashMap;
import java.util.Map;

/**
 * The RansomNoteProcessor.
 * <p>
 * This class is responsible for wrapping the code that is
 * used to process the magazine and ransom note to determine
 * if the ransom note can be made from the words in the magazine.
 * <p>
 * @author szeyick
 */
public class RansomNoteProcessor {

	/**
	 * A collection of all the words in the magazine.
	 */
    private Map<String, Integer> magazineMap;
    
    /**
     * A collection of all the words in the note.
     */
    Map<String, Integer> noteMap;
    
    /**
     * Constructor.
     * @param magazine - The words from the magazine.
     * @param note - The words from the note.
     */
    public RansomNoteProcessor() {
        magazineMap = new HashMap<String, Integer>();
        noteMap = new HashMap<String, Integer>();
    }
    
    /**
     * @param magazine - The words from the magazine.
     * @param note - The words from the note.
     * @return YES if a ransom note can be made, NO otherwise.
     */
    public String canRansomNoteBeMade(String magazine, String note) {
    	processWords(magazine, magazineMap);
        processWords(note, noteMap);
        
        String canBeMade = "NO";
        boolean answer = solve();
        if (answer) {
        	canBeMade = "YES";
        }
    	return canBeMade;
    }
    
    /**
     * Store the words into a map.
     * @param sentence - The sentence to store.
     * @param wordMap - The map to store the words from the sentence into.
     */
    private void processWords(String sentence, Map<String, Integer> wordMap) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (wordMap.containsKey(word)) {
                Integer count = wordMap.get(word);
                count++;
                wordMap.put(word, count);
            }
            else {
                wordMap.put(word, 1);
            }
        }
    }
    
    /**
     * @return <code>true</code> if the ransom note can be made from the
     * magazine, <code>false</code> otherwise.
     */
    private boolean solve() {
        boolean canComplete = true;
        for (String word : noteMap.keySet()) {
            Integer count = noteMap.get(word);
            
            if (magazineMap.containsKey(word)) {
                Integer magazineWordCount = magazineMap.get(word);
                if (count <= magazineWordCount) {
                    continue;
                }
                else {
                    canComplete = false;
                    break;
                }
            }
            else {
                canComplete = false;
                break;
            }
		}
        return canComplete;
    }
}
