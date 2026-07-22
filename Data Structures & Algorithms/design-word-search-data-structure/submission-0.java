class Node {
    Node[] link = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch){
        return (link[ch - 'a'] != null);
    }

    Node get(char ch){
        return link[ch - 'a'];
    }

    void put(char ch, Node node){
        link[ch - 'a'] = node;
    }

    void setFlag(){
        flag = true;
    }

    boolean isFlag(){
        return flag;
    }
}
class WordDictionary {
    static Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;

        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(!(node.containsKey(ch))){
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setFlag();

    }

    public boolean search(String word) {

        Node node = root;
        return dfs(word,0,node);

    }

    private boolean dfs(String word, int i, Node node){

        if(i == word.length()){
            return node.isFlag();
        }
        char ch = word.charAt(i);
        if(ch == '.'){
            for(int j =0;j<26;j++){
                char c = (char)('a' + j);
                if(node.containsKey(c)){
                    if(dfs(word, i+1, node.get(c))){
                        return true;
                    }
                }
            }
            return false;
        } else {
            if(!node.containsKey(ch)){
                return false;
            } 
             return dfs(word, i+1, node.get(ch));
        }
       
    
    }
}
