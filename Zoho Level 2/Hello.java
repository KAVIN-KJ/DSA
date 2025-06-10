
class node {
    
    int x;
    node(int x){
        this.x = x;
    }
}
public class Hello {

    public static void main(String[] args) {

        System.out.println("Hello World !");
        node arr[] = new node[5];
        for(int i=0;i<5;i++) arr[i] = new node(i);
        for(node i : arr) System.out.println(i.x);
        
    }
}