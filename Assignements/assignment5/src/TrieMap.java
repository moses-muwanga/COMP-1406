//Note: All of your TrieMapInterface method implementations must function recursively
//I have left the method signatures from my own solution, which may be useful hints in how to approach the problem
//You are free to change/remove/etc. any of the methods, as long as your class still supports the TrieMapInterface
import java.util.ArrayList;
public class TrieMap implements TrieMapInterface{
  TrieMapNode root;
  
  public TrieMap(){
    root = new TrieMapNode();
  }


  //Indirectly recursive method to meet definition of interface
  public void put(String key, String value){
    put(root, key, value);
  }


  //Recursive method which adds key/value pair to the trie and if the key is already in the tree it is replaced and puts
  //the key/value into the trie
  public void put(TrieMapNode current, String curKey, String value){
    TrieMapNode node = new TrieMapNode();
    if (curKey.length() == 0){
      current.setValue(value);
      return;
    }
    if (current.getChildren().get(curKey.charAt(0)) == null){
      current.addChild(curKey.charAt(0), node);
    }
    put(current.getChildren().get(curKey.charAt(0)), curKey.substring(1), value);
  }


  //Indirectly recursive method to meet definition of interface
  public String get(String key){
    return get(root, key);
  }


  //Recursive method which returns the value associated with given key if it exists. It it does not exist, null is returned
  public String get(TrieMapNode current, String curKey){
    if (curKey.length() == 0){
      return current.getValue();
    }
    else if (current.getChildren().get(curKey.charAt(0)) == null){
      return null;
    }
    return get(current.getChildren().get(curKey.charAt(0)), curKey.substring(1));
  }


  //Indirectly recursive method to meet definition of interface
  public boolean containsKey(String key){
    return containsKey(root, key);
  }


  //Recursive method which returns true if the trie has the given key and false if it does not
  public boolean containsKey(TrieMapNode current, String curKey){
    if (curKey.length() == 0){
      if (current.getValue() != null){
        return true;
      } else {
        return false;
      }
    }
    if (current.getChildren().get(curKey.charAt(0)) == null){
        return false;
      }
    return containsKey(current.getChildren().get(curKey.charAt(0)), curKey.substring(1));
    }

  
  //Indirectly recursive method to meet definition of interface, returns new string arraylist if the found node is null
  public ArrayList<String> getKeysForPrefix(String prefix){
    TrieMapNode node = findNode(root, prefix);
    if (node == null){
      return new ArrayList<String>();
    }
    return getSubtreeKeys(node);
  }


  //Recursive helper function to find node that matches a prefix
  public TrieMapNode findNode(TrieMapNode current, String curKey){
    if (curKey.length() == 0){
      return current;
    }
    if (current.getChildren().get(curKey.charAt(0)) == null){
      return null;
    }
    return findNode(current.getChildren().get(curKey.charAt(0)), curKey.substring(1));
  }


  //Recursive helper function to get all keys in a node's subtree
  public ArrayList<String> getSubtreeKeys(TrieMapNode current){
    ArrayList<String> prefixValues = new ArrayList<String>();
    for (TrieMapNode t: current.getChildren().values()){
      if (t != null){
        prefixValues.addAll(getSubtreeKeys(t));
      }
    }
    if (current.getValue() != null){
      prefixValues.add(current.getValue());
    }
    return prefixValues;
  }


  //Indirectly recursive method to meet definition of interface
  public void print(){
    print(root);
  }


  //Recursive method to print values in tree
  public void print(TrieMapNode current){
    if (current.getValue()!= null){
      System.out.println(current.getValue());
    }
    for (TrieMapNode t : current.getChildren().values()){
      print(t);
    }
    
  }

  
  public static void main(String[] args){
  }
}