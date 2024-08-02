class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
class Double_linked_list{
    static void Display(Node head){
        Node current=head;
        for(;current.next!=null;current=current.next){
            System.out.print("["+ current.prev +"," + current.data +","+ current.next+"]"+"--> ");
        }
        System.out.print("[" + current.prev +"," + current.data +","+current.next+"]");
        System.out.println();
    }
    static Node insertAtBegin(Node head,int data){
        Node nn=new Node(data);
        Node current=head;
        nn.next=head;
        if(current!=null) current.prev=nn;
        head=nn;  
        return head;
    }
    static Node insertAtEnd(Node head,int data){
        Node nn=new Node(data);
        Node current=head;
        if(current==null){
            head=nn;
        }
        else{
            for(current=head;current.next!=null;current=current.next);
                current.next=nn;
                nn.prev=current;
        }
        return head;
    }
    static Node insertAtMid(Node head,int data,int pos){
        Node nn=new Node(data);
        Node current=head;
        if(pos==1){
            head=insertAtBegin(head,data);
        }
        else{
            for(int i=1;i<pos-1;i++){
                current=current.next;
            }
            nn.next=current.next;
            nn.prev=current;
            current.next=nn;
            nn.next.prev=nn;
        }
        return head;
    }
    static Node deleteAtBegin(Node head){
        if(head==null){
            System.out.println("Linked list is empty,can't perform deletion operation");
        }
        else{
            head=head.next;
            head.prev=null;
        }
        return head;
    }
    static Node deleteAtEnd(Node head){
        Node current=head;
        Node ptr=null;
        if(head==null){
            System.out.println("Linked list is empty,can't perform deletion operation");
        }
        else{
            while(current.next!=null){
                ptr=current;
                current=current.next;
             }
             current.prev=null;
             ptr.next=null;
        }
        return head;
    }
    static Node deleteAtMid(Node head,int pos){
        Node current=head;
        if(head==null){
            head=deleteAtBegin(head);
        }
        else{
            for(int i=1;i<pos-1;i++){
                current=current.next;
              }
            current.next=current.next.next;
            current.next.prev=current;
        }
        return head;
    }
    static Node reverseDisplay(Node head){
        Node nextt=null;
        Node prevv=null;
        Node current=head;
        while(current!=null){
            nextt=current.next;
            current.next=prevv;
            current.prev=nextt;
            prevv=current;
            current=nextt;
        }
        return prevv;
    }
    public static void main(String args[]){
        Node head=null;
        //System.out.print(head);
        head=deleteAtBegin(head);
        head=deleteAtMid(head,1);
        head=deleteAtMid(head,3);
        head=deleteAtEnd(head);
        head=insertAtEnd(head,8);
        head=insertAtMid(head,7,1);
        Display(head);
        head=insertAtBegin(head,4);
        head=insertAtEnd(head,6);
        Display(head);
        head=insertAtMid(head,1,1);
        head=insertAtBegin(head,2);
        Display(head);
        head=insertAtMid(head,5,3);
        head=insertAtEnd(head,3);
        Display(head);
        head=deleteAtEnd(head);
        Display(head);
        head=deleteAtMid(head,3);
        Display(head);
        head=deleteAtBegin(head);
        Display(head);
        head=reverseDisplay(head);
        Display(head);
    }
}