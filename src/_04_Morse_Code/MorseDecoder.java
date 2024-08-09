package _04_Morse_Code;

import _03_Intro_to_Binary_Trees.BinaryTree;
import _03_Intro_to_Binary_Trees.Node;

public class MorseDecoder {

    BinaryTree<MorseCode> mcTree = new BinaryTree<MorseCode>();

    public static void main(String[] args) {

        MorseDecoder md = new MorseDecoder();
        md.initialize();
        md.decode();

    }

    public void initialize() {

        mcTree.insert(new MorseCode("start", ""));
        mcTree.insert(new MorseCode("e", "."));
        mcTree.insert(new MorseCode("t", "-"));

        mcTree.insert(new MorseCode("i", ".."));
        mcTree.insert(new MorseCode("a", ".-"));
        mcTree.insert(new MorseCode("n", "-."));
        mcTree.insert(new MorseCode("m", "--"));

        mcTree.insert(new MorseCode("s", "..."));
        mcTree.insert(new MorseCode("u", "..-"));
        mcTree.insert(new MorseCode("r", ".-."));
        mcTree.insert(new MorseCode("w", ".--"));
        mcTree.insert(new MorseCode("d", "-.."));
        mcTree.insert(new MorseCode("k", "-.-"));
        mcTree.insert(new MorseCode("g", "--."));
        mcTree.insert(new MorseCode("o", "---"));

        mcTree.insert(new MorseCode("h", "...."));
        mcTree.insert(new MorseCode("v", "...-"));
        mcTree.insert(new MorseCode("f", "..-."));
        mcTree.insert(new MorseCode("l", ".-.."));
        mcTree.insert(new MorseCode("p", ".--."));
        mcTree.insert(new MorseCode("j", ".---"));
        mcTree.insert(new MorseCode("b", "-..."));
        mcTree.insert(new MorseCode("x", "-..-"));
        mcTree.insert(new MorseCode("c", "-.-."));
        mcTree.insert(new MorseCode("y", "-.--"));
        mcTree.insert(new MorseCode("z", "--.."));
        mcTree.insert(new MorseCode("q", "--.-"));

        mcTree.printVertical();

    }

    /*
     * 1.) See if you can decode the following message using the binary tree and
     * print it to the console:
     * 
     * -.-- --- ..- .- .-. . .- -- .- --.. .. -. --.
     * 
     * 2.) Then use the binary tree and the scanner class to create a morse code
     * translator. The user should be able to type multiple letters in morse
     * code on a single line and have it repeated back to them, decoded into the
     * english alphabet.
     * 
     */
    void decode() {
        String morseCode = "-.-- --- ..- .- .-. . .- -- .- --.. .. -. --.";
        
        String[] splitString = morseCode.split(" ");
        String translatedString = "";
        for (String s : splitString)
        {
        	translatedString += decodeCharacter(s);
        }
        System.out.println(translatedString);
    }
    
    public String decodeCharacter(String value) {

        Node<MorseCode> nodeQuery = recursiveFind(mcTree.getRoot(), value);

        if (nodeQuery == null) {
            return null;
        }
        return nodeQuery.getValue().getDecoded();
    }
    
    protected Node<MorseCode> recursiveFind(Node<MorseCode> current, String value) {

        if (current == null) {
            return null;
        } else if (compareCoded(value, current.getValue().getCoded()) == 0) {
            return current;
        } else if (compareCoded(value, current.getValue().getCoded()) < 0) {

            return recursiveFind(current.getLeft(), value);
        } else {

            return recursiveFind(current.getRight(), value);
        }

    }
    
    public int compareCoded(String coded, String otherCoded) {
        if(coded.equals(otherCoded)) {
        	return 0;
        }
        else if (coded.charAt(otherCoded.length())=='-') {
            return 1;
        }
        else {
            return -1;
        }
    }
}
