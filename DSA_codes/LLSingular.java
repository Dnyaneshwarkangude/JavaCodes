/*
  This is Singular Linkedlist program.
  which provide : addFirst(data)
                  addLast(data)
                  addAt(index,data)     --> using this method we can add at any given index or position;
                  removeFirst()
                  removeLast()
                  remove(index)        --> using this method we can remove element from given index or position
                  getSize()

     We can create LLSingular class object and this object is our new list.
     So we can create lists as many as we want.
 */

class LLSingular {
    Node head;            // This is variable of type Node , and this variable is used to store reference to objects of Node class.(we can create this type of variable anywhere to
                          //  store reference of objects of class which is there are type of )
    private int size;

    LLSingular(){
        this.size = 0;    // we using this constructor assigning because we want size of every created object or list.
    }

    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }
    //add - first
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //add - last
    public void addLast(String data){
        Node newNode = new Node(data);
        if( head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    //add on given index or position in list
    public void addAt(int index,String data){
        Node newNode = new Node(data);
        size--;
        if(index < 0 || index > size+1){                         // Remember about corner cases to handle like this in future.(all cases handled in if statement)
            System.out.println("Invalid index to add element.");
            return;
        }
        if(head == null){
            head = newNode;
            return;
        }
        if(index == 0){
            addFirst(data); 
            return;
        } 
        if(index == size+1){
            addLast(data);  
            return;
        }
        
        size++;
        Node crrNode = head;
        for(int i=0; i < index-1; i++){
            crrNode=crrNode.next;
        }

        newNode.next = crrNode.next;
        crrNode.next = newNode;   
    }

    //print list
    public void printList(){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }

        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data+" --> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    //delete first
    public void removeFirst(){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        size--;
        head = head.next;
    }

    //delete last
    public void removeLast(){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }

        size--;

        if(head.next == null){
            head = null;
            return;
        }

        Node crrNode = head;
        while(crrNode.next.next != null){
            crrNode = crrNode.next;
        }
        crrNode.next = null;
    }

    //delete on given index or position in list
    public void remove(int index){
        if(index < 0 || index > size){                 
            System.out.println("Invalid index to remove element.");
            return;
        }
        if(head == null){                                  
            System.out.println("List is empty");
            return;
        }
        if(index == 0){
            removeFirst();
            return;
        }
        if(index == size){
            removeLast();
            return;
        }

        size--;
        Node crrNode = head;
        for(int i=0; i < index-1; i++){
            crrNode=crrNode.next;
        }
        crrNode.next = crrNode.next.next;
        
    }

    //to get size of list
    public int getSize(){
        return size;
    }

    public static void main(String[] args){
        LLSingular list = new LLSingular();   // List-1 is created
        LLSingular list2 = new LLSingular();  // List-2 is created
        // After this we can manipulate this lists as we wish.
    }
}
