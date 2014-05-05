package model.writer.markov;
import java.util.*;

import utilities.*; 


public class WordMarkovModel extends AbstractModel{

	private Map<WordNgram, ArrayList<WordNgram>> myMap= new HashMap<WordNgram, ArrayList<WordNgram>>();
	private Random myRandom;
	public static final int DEFAULT_COUNT = 100; 
	private double stime=0; 
	private String myString;
	private String [] myWords;
	
	public WordMarkovModel() {
		myRandom = new Random(1234);
	}


	@Override
	public void initialize(Scanner s) {
		double start = System.currentTimeMillis();
		int count = readChars(s);
		double end = System.currentTimeMillis();
		double time = (end - start) / 1000.0;
		super.messageViews("#read: " + count + " chars in: " + time + " secs");

	}

	protected int readChars(Scanner s) {
		myString = s.useDelimiter("\\Z").next();
		s.close();    
		return myString.length();

	}


	@Override
	public void process(Object o) {
		String temp = (String) o;
		String[] nums = temp.split("\\s+");
		int k = Integer.parseInt(nums[0]);
		int numWords = DEFAULT_COUNT;
		if (nums.length > 1) {
			numWords = Integer.parseInt(nums[1]);
		}
		createMap(k);

		smarterThanBrute(k, numWords);
	}

	public void createMap(int k){
		String []myWrapAroundWordsHolder= myString.split("\\s+");
		String []myWrapAroundWords= new String[myWrapAroundWordsHolder.length+k];
		this.myWords= new String[myWrapAroundWordsHolder.length+k];

		int index2=0;
		for(int i=0; i<myWrapAroundWords.length; i++){
			if(i<myWrapAroundWordsHolder.length){
				myWrapAroundWords[i]=myWrapAroundWordsHolder[i];
				myWords[i]=myWrapAroundWords[i];
				System.out.println(myWords[i]);
			}
			else{
				myWrapAroundWords[i]=myWrapAroundWordsHolder[index2];
				index2++;
				myWords[i]=myWrapAroundWords[i];
				System.out.println(myWords[i]);
			}
		}


		stime = System.currentTimeMillis();

		for(int j=0; j<myWrapAroundWordsHolder.length; j++){
			WordNgram myWordNgram= new WordNgram(myWrapAroundWords, j, k);

			if(!myMap.containsKey(myWordNgram)){
				myMap.put(myWordNgram,new ArrayList<WordNgram>());
			}
			ArrayList<WordNgram>list=myMap.get(myWordNgram);
			WordNgram holder= new WordNgram(myWrapAroundWords, j+1, k);
			list.add(holder);			
		}

	}


	public String smarterThanBrute(int k, int numWords){
		StringBuilder build= new StringBuilder();
		int count=0;
		int start = myRandom.nextInt(myWords.length - k + 1);  
		WordNgram str= new WordNgram(myWords, start, k);
		while(count<numWords){
			ArrayList <WordNgram> values=myMap.get(str);

			int pick=myRandom.nextInt(values.size());
			WordNgram holder=values.get(pick);
			build.append(holder.returnsLastWord());
			build.append(" ");
			str=holder; 
			count++;	
		}

		double etime = System.currentTimeMillis();
		double time = (etime - stime) / 1000.0;
		this.messageViews("time to generate: " + time);
		System.out.println(build.toString());
		return build.toString(); 
		
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}


}
