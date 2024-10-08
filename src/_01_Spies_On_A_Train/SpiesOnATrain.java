package _01_Spies_On_A_Train;

import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    	HashMap<String, Integer> suspects = new HashMap<String, Integer>();
    	
    	for (String s : clues)
    	{
    		System.out.println(s);
    	}

    	Node<TrainCar> node = train.getHead();
    	while (node != null)
    	{
    		String evidence = node.getValue().questionPassenger();
			System.out.println(evidence);
    		for (String c : clues)
    		{
    			if (evidence.contains(c))
    			{
    				evidence = evidence.replace(" " + c + ".", "");
    				String[] splitEvidence = evidence.split(" ");
    				String suspect = splitEvidence[splitEvidence.length - 1];
    				if (suspects.containsKey(suspect))
    				{
        				suspects.replace(suspect, suspects.get(suspect) + 1);
    				}
    				else
    				{
    					suspects.put(suspect, 1);
    				}
    				System.out.println(suspect);
    			}
    		}
    		node = node.getNext();
    	}
    	
    	String suspect = "";
    	for (String i : suspects.keySet())
    	{
			System.out.println(i + " " + suspects.get(i));
    		if (!suspects.containsKey(suspect))
    		{
    			suspect = i;
    		}
    		else 
    		{
    			if (suspects.get(i) > suspects.get(suspect))
    			{
    				suspect = i;
    			}
    		}
    	}
    	System.out.println(suspect);
    	
        return suspect;

    }

}
