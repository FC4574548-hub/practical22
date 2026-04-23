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

    //2.1
    public boolean search(int data){
        return search(root, data);
    }

    public boolean search(Node n, int data){
        if(n == null){
            return false;
        }
        if(data == n.getData()) {
            return true;
        }
        if(data < n.getData()){
            return search(n.getLeft(), data);
        }else{
            return search(n.getRight(), data);
        }
    }
    
}
