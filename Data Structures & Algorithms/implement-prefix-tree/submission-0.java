class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch){
        return (links[ch - 'a'] !=null);
    }
    Node get(char ch){
        return links[ch - 'a'];
    }

    void put(char ch, Node prefixTree){
        links[ch - 'a'] = prefixTree;
    }

    void setFlag(){
        flag = true;
    }

    boolean isFlag(){
        return flag;
    }



}
class PrefixTree {

    static Node root;

    public PrefixTree() {
         root = new Node();
    }


    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!(node.containsKey(word.charAt(i)))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setFlag();
    }

    public boolean search(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        if(!node.isFlag()){
            return false;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0;i<prefix.length();i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false;
            }
        node = node.get(prefix.charAt(i));
        }
        
        return true;
    }
}
