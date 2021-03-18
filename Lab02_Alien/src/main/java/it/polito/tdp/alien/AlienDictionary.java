package it.polito.tdp.alien;
import java.util.*;
public class AlienDictionary {
 ArrayList<Word>parole=new ArrayList<Word>();
 Set<String>setWord=new HashSet<String>();
 
 public void addWord(String alienWord,String translation) {
	 Word w=new Word(alienWord,translation);
	 if(parole.isEmpty())
		 parole.add(w);
	 else {
		 for(Word wo:parole) {
			 if(wo.equals(w))
				 wo.setTranslation(translation);
			 else parole.add(w);
		 }
	 }
	
 }
 
 public String traslateWord(String alienWord) {
	 String s="";
	 for(Word w:parole) {
		 if (w.getAlienWord().equals(alienWord))
			 return w.getTranslation();
		
	 }return null;
 }
 
  
}
