package com.arizona.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;



import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class CoreNLP implements Serializable{
	

	private List<CoreMap> sentences;
	private List<String> sent= new ArrayList<String>();
	private List<String> words= new ArrayList<String>();
	private List<String> nouns=new ArrayList<String>();
	private List<String> adj=new ArrayList<String>();
	private int sentencecount=0;
	private int wordcount=0;
	private int nounscount=0;
	private int adjcount=0;

	public CoreNLP(String t){
	  	System.out.println("Here");
        // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        props.setProperty("parse.keepPunct", "false");

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // read some text in the text variable
        String text = t;

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);

        sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        sentencecount=sentences.size();
        System.out.println(sentences);	
        for (CoreMap sentence : sentences) {
        	sent.add(sentence.toString());
            // traversing the words in the current sentence
            // a CoreLabel is a CoreMap with additional token-specific methods
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
            	word = word.replaceAll("\\p{P}", "");
            	System.out.println(word);
            	if (word.equals("")){
            		System.out.println("Skippd");
            	}
            	else {
            		
                	words.add(word);
                	wordcount++;
            	}
            	// this is the text of the token


                // this is the POS tag of the token
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                if (pos.equals("NN")){
                	nouns.add(word);
                	nounscount++;
                }
                if (pos.equals("JJ")){
                	adj.add(word);
                	adjcount++;
                }
                // this is the NER label of the token
                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);

                System.out.println(String.format("Print: word: [%s] pos: [%s] ne: [%s]", word, pos, ne));
            }
        }

		
	}
	
	public int numberofwords() {
		return wordcount;	
	}
	public int numberofadjectives() {
		return adjcount;	
	}
	public int numberofsentences() {
		return sentencecount;
	}
	public int numberofnouns() {
		return nounscount;
	}
	public List<String> getwords(){
		return words;
	}  
	public List<String> getnouns(){
		return nouns;
	}
	public List<String> getadjectives(){
		return adj;
	}
	public List<String> getsentences(){
		return sent;
	}
	public Object[] getAllData(){
		Object[] objects = new Object[6];
		objects[0] = wordcount;
		objects[1] = sentencecount;
		objects[2] = nounscount;
		objects[3] = words;
		objects[4] = sent;
		objects[5] = nouns;
		return objects;
		
	}
	
	
	
	
	
}
