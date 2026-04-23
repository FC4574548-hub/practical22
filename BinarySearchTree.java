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

    //2.2
    public void insert(int data){
        if(search(data)){
            System.out.println("Invalid input");
            return;
        }
        root = insert(root, data);
        size++;
    }

    public Node insert(Node n, int data){
        if(n == null){
            return new Node(data,null,null);
        }
        if(data > n.getData()){
            n.setRight(insert(n.getRight(), data));
        }else if (data < n.getData()){
            n.setLeft(insert(n.getLeft(), data));
        }
        return n;
    }
    //2.3
    public int height(){
        return height(root);
    }
    public int height(Node n){
        if(n == null){
            return 0;
        }
        int leftHeight = height(n.getLeft());
        int rightHeight = height(n.getRight());

        if(leftHeight > rightHeight){
            return leftHeight + 1;
        }else {
            return rightHeight + 1;
        }
    }
     //2.4
    public void print_in_order(){
        print_in_order(root);
        System.out.println();
    }
    public void print_in_order(Node n){
        if(n == null){
            return;
        }
        print_in_order(n.getLeft());
        System.out.print(n.getData());
        print_in_order(n.getRight());
    }

    //2.5
    private int count = 0;
    private int result = -1;
    public int find_kth_smallest(int k){
        if(k > size || k <= 0){
            System.out.println("invalid input");
            return -1;
        }
        count = 0;
        result = -1;

        find_kth_smallest(root, k);
        return  result;
    }
    public void find_kth_smallest(Node n, int k){
        if(n == null){
            return;
        }
        find_kth_smallest(n.getLeft(), k);

        count++;
        if(count == k){
            result = n.getData();
            return;
        }
        find_kth_smallest(n.getRight(), k);
    }

    //2.6
    public void delete(int data){
        if(!search(data)){
            System.out.println("invalid input");
            return;
        }
        root = delete(root, data);
        size--;
    }
    public Node delete(Node n, int data){
        if(n == null){
            return null;
        }
        if(data < n.getData()){
            n.setLeft(delete(n.getLeft(), data));
        }else if(data > n.getData()){
            n.setRight(delete(n.getRight(), data));
        }else {
            if (n.getLeft() == null && n.getRight() == null) {
                return null;
            } else if (n.getLeft() == null) {
                return n.getRight();
            } else if (n.getRight() == null) {
                return n.getLeft();
            } else {
                Node temp = n.getLeft();
                while (temp.getRight() != null) {
                    temp = temp.getRight();
                }
                n.setData(temp.getData());
                n.setLeft(delete(n.getLeft(), temp.getData()));
            }
        }
        return n;
    }
    
}
