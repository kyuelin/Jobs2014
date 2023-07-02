package dev.kyuelin.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by linken on 11/29/15.
 */
class Trie {

    private final TrieNode root;

    public void insert(String word) {
        if (search(word) == true) {
            return;
        }

        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = current.subNode(ch);
            if (child != null) {
                current=child;
            }
            else {
                current.childList.add(new TrieNode(ch));
                current=current.subNode(ch);
            }
            current.count++;
        }
        current.isLeaf=true;
    }

    public void remove(String word) {

        if (search(word) == false) {
            return;
        }

        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            TrieNode child = current.subNode(ch);
            if(child.count ==1 ) {
                current.childList.remove(child);
                return;
            }
            else {
                child.count--;
                current = child;
            }
        }
        current.isLeaf=false;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(char ch: word.toCharArray()) {
            if (current.subNode(ch) != null) {
                current=current.subNode(ch);
            }
            else {
                return false;
            }
        }
        return current.isLeaf;
    }
    public Trie() {
        root = new TrieNode(' ');
    }

}

class TrieNode {
    char content;
    List<TrieNode> childList;
    boolean isLeaf;
    int count;

    public TrieNode(char c) {
        childList = new LinkedList<TrieNode>();
        content=c;
        isLeaf=false;
        count=0;
    }

    public TrieNode subNode(char c) {
        if (childList != null) {
            for(TrieNode eachChild : childList) {
                if (eachChild.content == c) {
                    return eachChild;
                }
            }
        }
        return null;
    }
}

public class TrieTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Trie t = new Trie();

        System.out.println("Trie Test\n");
        char ch;

        do {
            System.out.println("\nTrie Operations");
            System.out.println("1. insert");
            System.out.println("2. delete");
            System.out.println("3. search");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter string element to insert");
                    t.insert(scan.next());
                    break;
                case 2:
                    System.out.println("Enter string element to delete");
                    t.remove(scan.next());
                    break;
                case 3:
                    System.out.println("Enter string element to search");
                    System.out.println("Search result: " + t.search(scan.next()));
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            System.out.println("Continue (Type y or n)\n");
            ch = scan.next().charAt(0);

        } while (ch=='Y' || ch =='y');
    }
}
