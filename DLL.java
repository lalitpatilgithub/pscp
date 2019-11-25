package pscp ;

class DLL {
    Node headNode ;
    DLL(){
        this.headNode = new Node(1);
    }
    public static void main(String[] args) {
        DLL dll = new DLL();
        Node node2 = new Node(2);
        dll.add(node2);
        Node node3 = new Node(3);
        dll.add(node3);
        Node node4 = new Node(4);
        dll.add(node4);
        dll.remove(3);
        dll.remove(1);
        dll.remove(2);
        dll.remove(4);
        Node node5 = new Node(5);
        dll.add(node5);
        Node node6 = new Node(6);
        dll.add(node6);
        dll.remove(6);
        dll.remove(6);
        dll.remove(5);
        Node node = dll.headNode;
        if (node != null){
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);

            }
        }else{
            System.out.println("DLL is empty");
        }
    }

    void add(Node node){
        if(this.headNode==null) {
            this.headNode = node;
            System.out.printf("Added {%d} to list \n",node.data);
            return;
        }
        node.next = this.headNode.next;
        if(this.headNode.next!=null)
            this.headNode.next.prev = node;
        this.headNode.next = node;
        node.prev = this.headNode;
        System.out.printf("Added {%d} to list\n",node.data);

    }
    boolean remove(int i){
        Node node = this.headNode;
        boolean flag=false;
        if(node.data==i){
            if(node.next==null) {
                headNode = null;
                flag=true;
                System.out.printf("Removed {%d} from list \n",i);
                return flag;
            }else{
                this.headNode = headNode.next;
                this.headNode.prev = null;
                node.next = null;
                flag = true;
                System.out.printf("Removed {%d} from list\n",i);
                return flag;
            }
        }else{
            while(node.next!=null) {
            node = node.next;
                if(node.data==i){
                    flag=true;
                    break;
                }
            }
        }
        if(flag) {
            if(node.prev!=null)
                node.prev.next = node.next;
            if(node.next!=null)
                node.next.prev = node.prev;
            System.out.printf("Removed {%d} from list\n",i);
        }else{
            System.out.printf("Can not Removed {%d} from list as node not present\n",i);
        }
        return flag;
    }
}

class Node {
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data = data;
        this.next= null;
        this.prev = null;
    }
}