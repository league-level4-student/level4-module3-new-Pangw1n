package _02_Rainbow_Zombie_Conga_Line;

import java.util.Random;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {
    
    /*
     * You are hosting a rainbow zombie conga dance party! Zombies are not very
     * smart(maybe that's why they crave brains) and need your help to direct
     * them through the choreography.
     * 
     * Each method is a dance move you will need to implement.
     * 
     * When you think you've gotten your zombies trained well enough you can
     * start the party by running the main method in RainbowZombieDanceParty and
     * typing how many rounds you want in the console to see if they followed
     * your choreography correctly.
     * 
     * Note: The party will always start with a rainbow brains and every 5
     * rounds the head and tail of the dance line will be removed.
     */

    private LinkedList<Zombie> congaLine;
    private ZombieHatColor[] zombieHats;

    public RainbowZombieCongaLine() {

        congaLine = new LinkedList<Zombie>();
        zombieHats = ZombieHatColor.values();

    }

    // Make the passed in zombie the first Zombie in the conga line!
    public void engine(Zombie dancer) {
    	Node<Zombie> newHead = new Node<Zombie>(dancer);
    	if (congaLine.getHead() == null)
    	{
    		congaLine.add(dancer);
    	}
    	else
    	{
    		Node<Zombie> oldHead = congaLine.getHead();
    		oldHead.setPrev(newHead);
    		newHead.setNext(oldHead);
    		congaLine.setHead(newHead);
    		if (oldHead.getNext() == null)
    		{
    			congaLine.setTail(congaLine.getHead());
    		}
    	}
    }

    // Make the passed in zombie the last Zombie in the conga line!
    public void caboose(Zombie dancer) {
    	congaLine.add(dancer);
    }

    // Place the zombie at the designated position in the conga line!
    public void jumpInTheLine(Zombie dancer, int position) {
    	Node<Zombie> node = congaLine.getHead();
    	int count = 0;
    	while (node != null)
    	{
    		if (count == position)
    		{
    			if (count == 0)
    			{
    				engine(dancer);
    			}
    			else if (count == congaLine.size())
    			{
    				congaLine.add(dancer);
    			}
    			else
    			{
    				Node<Zombie> newNode = new Node<Zombie>(dancer);
    				newNode.setPrev(node.getPrev());
    				newNode.getPrev().setNext(newNode);
    				node.setPrev(newNode);
    				newNode.setNext(node);
    			}
    			return;
    		}
    		else
    		{
    			count++;
    			node = node.getNext();
    		}
    	}
    }

    /*
     * Remove all zombies with the same hat color as the passed in zombie from
     * the conga line!
     */
    public void everyoneOut(Zombie dancer) {
    	Node<Zombie> node = congaLine.getHead();
    	int count = 0;
    	while (node != null)
    	{
    		if (node.getValue().getZombieHatColor().equals(dancer.getZombieHatColor()))
    		{
    			node = node.getNext();
    			congaLine.remove(count);
    		}
    		else
    		{
    			count ++;
    			node = node.getNext();
    		}
    	}
    }

    /*
     * Remove the first zombie with the same hat color as the passed in zombie
     * from the conga line!
     */
    public void youAreDone(Zombie dancer) {
    	Node<Zombie> node = congaLine.getHead();
    	int count = 0;
    	while (node != null)
    	{
    		if (node.getValue().getZombieHatColor().equals(dancer.getZombieHatColor()))
    		{
    			congaLine.remove(count);
    			return;
    		}
    		else
    		{
    			count++;
    			node = node.getNext();
    		}
    	}
    }

    /*
     * Make two more zombies with the same hat color as the passed in zombie and
     * add one to the front, one to the end and one in the middle.
     */
    public void brains(Zombie dancer) {
    	engine(dancer);
    	caboose(dancer);
    	int randomPosition;
    	randomPosition = new Random().nextInt(congaLine.size() - 1) + 1;
    	jumpInTheLine(dancer, randomPosition);
    }

    /*
     * Add the passed in zombie to the front and then add one zombie of each hat
     * color to the end of the line.
     */
    public void rainbowBrains(Zombie dancer) {
    	engine(dancer);
    	Zombie newZombie;
    	ZombieHatColor hatColors[] = ZombieHatColor.values();
    	for (int i = 0; i < hatColors.length; i++)
    	{
    		newZombie = new Zombie(hatColors[i]);
    		congaLine.add(newZombie);
    	}
    }

    public LinkedList<Zombie> getCongaLine() {
        return congaLine;
    }
}
