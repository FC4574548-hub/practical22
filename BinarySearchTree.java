class BinarySearchTree {
    Node root;
    int size;
    
    public BinarySearchTree(){
        this.root = null;
        this.size = 0;
    }
    
    public BinarySearchTree(Node root, int size){
        this.root = root;
        this.size = size;
    }
    
    public Node getRoot(){
        return root;
    }
    public int getSize(){
        return size;
    }
    
    public void setRoot(Node root){
        this.root = root;
    }
    public void setSize(int size){
        this.size = size;
    }
    
}
