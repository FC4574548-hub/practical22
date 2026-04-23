import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        try{
            File f = new File("input.txt");
            Scanner sc = new Scanner(f);

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if (line.equals("")){
                    continue;
                }
                String[] arr = line.split(" ");
                String command = arr[0];

                try {
                    if(command.equals("BUILD")) {
                        for (int i = 1; i < arr.length; i++) {
                            int n = Integer.parseInt(arr[i]);
                            bst.insert(n);
                        }
                    }else if (command.equals("IN_ORDER")){
                        bst.print_in_order();
                    }else if(command.equals("INSERT")){
                        if (arr.length != 2){
                            System.out.println("Invalid input");
                        }else{
                            int n = Integer.parseInt(arr[1]);
                            bst.insert(n);
                        }
                    }else if(command.equals("DELETE")){
                        if (arr.length != 2){
                            System.out.println("Invalid input");
                        }else{
                            int n = Integer.parseInt(arr[1]);
                            bst.delete(n);
                        }
                    }else if(command.equals("SEARCH")){
                        if (arr.length != 2){
                            System.out.println("Invalid input");
                        }else{
                            int n = Integer.parseInt(arr[1]);
                            boolean found = bst.search(n);
                            System.out.println(found);
                        }
                    }else if(command.equals("SIZE")){
                        System.out.println(bst.getSize());
                    } else if(command.equals("HEIGHT")) {
                        System.out.println(bst.height());
                    }else if(command.equals("KTH_SMALLEST")){

                        if(arr.length != 2){
                            System.out.println("Invalid input");
                        }else{
                            int n = Integer.parseInt(arr[1]);
                            int result = bst.find_kth_smallest(n);

                            if(result != -1){
                                System.out.println(result);
                            }
                        }

                      }else{
                        System.out.println("Invalid input");
                    }
                } catch (Exception e) {
                    System.out.println("Ïnvalid Input");
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}

