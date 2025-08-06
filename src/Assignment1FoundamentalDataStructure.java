public class Assignment1FoundamentalDataStructure {

    /* I created this outer class to contain nested classes for assignment 1 on git-hub* */


    //=============================================Exercise 1 class======================================================================
    public static class DoublyLinkedList<E> {
        /*----------------nested node class in doubly linked list-----------------
         * that store a reference to it element, the previous node and the next node
         * */
        private static class NodeOfDoublyLinkedList<E> {
            //instance variables
            private E element;
            private NodeOfDoublyLinkedList<E> previousNode;
            private NodeOfDoublyLinkedList<E> nextNode;

            //constructor
            public NodeOfDoublyLinkedList(E element, NodeOfDoublyLinkedList<E> previousNode, NodeOfDoublyLinkedList<E> nextNode) {
                this.nextNode = nextNode;
                this.element = element;
                this.previousNode = previousNode;
            }

            public NodeOfDoublyLinkedList() {
                this.nextNode = null;
                this.previousNode = null;
            }

            public NodeOfDoublyLinkedList(E element) {
                this.element = element;
            }
            //--------------end of constructor-----------


            //Accessor methods
            public E getElement() {
                return this.element;
            }

            public NodeOfDoublyLinkedList<E> getPreviousNode() {
                return this.previousNode;
            }

            public NodeOfDoublyLinkedList<E> getNextNode() {
                return this.nextNode;
            }

            //modifiers
            public void setElement(E element) {
                this.element = element;
            }

            public void setPreviousNode(NodeOfDoublyLinkedList<E> previousNode) {
                this.previousNode = previousNode;
            }

            public void setNextNode(NodeOfDoublyLinkedList<E> nextNode) {
                this.nextNode = nextNode;
            }

        }//--------end of node class-------------

        /*+++++++++++++++++++Beginning of doubly linked list++++++++++++++++++*/

        //instance variables
        //sentinel node at the beginning of the list
        private NodeOfDoublyLinkedList<E> headerNode;
        //sentinel node at the end of the list
        private NodeOfDoublyLinkedList<E> tailNode;
        //sum of contents in the list make the size
        private int size = 0;

        //constructor to construct a new empty list
        public DoublyLinkedList() {

//            //my code
            this.headerNode = null;
            this.tailNode = null;

        }

        //public accessor methods
        public boolean isEmpty() {
            return this.size == 0;
        }

        public int getSize() {
            return this.size;
        }

        //returns but does not remove the first element of the list
        public E firstListElement() {
            if (isEmpty()) return null;// if list is empty, do nothing.

            return this.headerNode.nextNode.getElement();
        }

        //returns but does not remove the last element in the list
        public E lastListElement() {
            if (isEmpty()) return null;
            return tailNode.previousNode.getElement();
        }

        //update methods
        public void addFirst(E element) {
            NodeOfDoublyLinkedList<E> inComingNode = new NodeOfDoublyLinkedList<>(element);

            if (headerNode == null) {
                this.headerNode = inComingNode;
                this.tailNode = inComingNode;
            } else {
                //my code
                inComingNode.nextNode = headerNode; //the incoming nodes next node in the list is the old head
                headerNode.previousNode = inComingNode;
                this.headerNode = inComingNode;
                // headerNode = inComingNode;// incoming node has now become the head node
            }

            size++;
        }

        private void addBetween(E element, NodeOfDoublyLinkedList<E> predecessor, NodeOfDoublyLinkedList<E> successor) {
            //create and link a new node
            NodeOfDoublyLinkedList<E> newest = new NodeOfDoublyLinkedList<>(element, predecessor, successor);
            predecessor.setNextNode(newest);
            successor.setPreviousNode(newest);
            size++;
        }

        //add to the end of the list but does not remove it
        public void addLast(E element) {

            NodeOfDoublyLinkedList<E> endNode = new NodeOfDoublyLinkedList<>(element);

            if(tailNode == null ){
                tailNode = endNode;
                tailNode.setPreviousNode(headerNode.nextNode);
            }
            else {
                //my code
                tailNode.nextNode = endNode;
                endNode.previousNode = tailNode;
                tailNode = endNode;
                tailNode.nextNode = null;
            }
            size++;
        }

        //removes a node from the list
        private E removeNode(NodeOfDoublyLinkedList<E> node) {
            NodeOfDoublyLinkedList<E> predecessor = node.getPreviousNode();
            NodeOfDoublyLinkedList<E> successor = node.getNextNode();
            predecessor.setNextNode(successor);
            successor.setPreviousNode(predecessor);
            size--;
            return node.getElement();
        }

        //removes and returns the first element of the list
        public void removeLast() {
            E removedElement = tailNode.getElement();

            NodeOfDoublyLinkedList<E> predeccessor = tailNode.previousNode;
            this.tailNode = predeccessor;
            predeccessor.nextNode = null;
            size--;

            System.out.println(removedElement + " removed from the list");
        }

        //removes and returns the first element of the list
        public void removeFirst() {
            E removedElement = headerNode.getElement();

            NodeOfDoublyLinkedList<E> successor = headerNode.nextNode;
            this.headerNode = successor;
            successor.previousNode = null;
            size--;

            System.out.println(removedElement + " removed from the list");
        }


        public void printNode() {
            //my code
            NodeOfDoublyLinkedList<E> currentNode = headerNode;

            while (currentNode != null) {
                System.out.print(currentNode.getElement() + "-");
                currentNode = currentNode.nextNode;
            }
        }

        //produces a string representation of the list
//        public String toString() {
//            StringBuilder sb = new StringBuilder("(");
//            NodeOfDoublyLinkedList<E> walk = headerNode;
//            while (walk != null) {
//                sb.append(headerNode.getElement());
//                sb.append(", ");
//                walk = headerNode.getNextNode();
//            }
//            sb.append(")");
//            return sb.toString();
//        }

        /*+++++++++++++++++++++++Exercise-1+++++++++++++++++++++++++++*/
        public void concatenate(DoublyLinkedList<E> secondList) {
            if (secondList == null || secondList.isEmpty()) return; // Nothing to concatenate
            if (this.isEmpty()) {
                // If current list is empty, point header/tail to the second list
                this.headerNode = secondList.headerNode;
                this.tailNode = secondList.tailNode;
                this.size = secondList.size;
            } else {
                // Link this current list's tail to the second list's header

                this.tailNode.setNextNode(secondList.headerNode);
                this.tailNode.nextNode = secondList.headerNode;
                secondList.headerNode.setPreviousNode(this.tailNode);
                this.tailNode = secondList.tailNode;
                this.size += secondList.size;
            }

            // Cancel the secondList
            secondList.headerNode = null;
            secondList.tailNode = null;
            secondList.size = 0;
        }

/*++++++++++++++++++++++++End of exercise 1++++++++++++++++++++++++++*/
    }
//==========================================================End of double linked list class for exercise 1======================================================================================


//++++++++++++++++++++++++++++++++++++++++++Beginning of exercise 2 - Singly linked Class+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
        //a basic singly linked list implementation
    public static class SinglyLinkedListDemo<E> implements Cloneable {

        //----------------nested node class for singly linked class------------------>
        private static class NodeDemo<E> {
            //element store at this node
            private E element;
            //reference to the subsequent node stored in this list
            private NodeDemo<E> nextNode;

            //constructor - creates a reference for the element and the next node
            public NodeDemo(E element, NodeDemo<E> nextNode) {
                this.element = element;
                this.nextNode = nextNode;
            }

            //Accessor methods
            public E getElement() {
                return this.element;
            }

            public NodeDemo<E> getNextNode() {
                return this.nextNode;
            }

            //modifier methods
            //sets the next node's reference to point to node n
            public void setNextNode(NodeDemo<E> nextNode) {
                this.nextNode = nextNode;
            }

        }//-----------------------------------------end of nested class NodeDemo----------------------------------------->

        //instance variables of the singlyLinked list
        //the head node of the list (or null if empty)
        private NodeDemo<E> headNode = null;
        //last node of the list(or null if empty)
        private NodeDemo<E> tailNode = null;
        //number of nodes in the list
        private int size = 0;

        //construct an initially empty list
        public SinglyLinkedListDemo() {
        }

        //access methods
        //returns the number of element in the linked list
        public int getSize() {
            return this.size;
        }

        //check whether the linked list is empty
        public boolean isEmpty() {
            return this.size == 0;
        }

        //  returns but does not remove the first element of the list
        public E first() {
            if (isEmpty()) return null;
            return headNode.getElement();
        }

        //return but does not remove the last element in the list
        public E last() {
            if (isEmpty()) return null;
            return tailNode.getElement();
        }

        //update methods
        //adds an element to the front of the list
        public void addFirst(E firstElement) {

            this.headNode = new NodeDemo<>(firstElement, headNode);
            if (this.size == 0) {
                this.tailNode = this.headNode;
            }
            size++;

        }

        //add an element to the end of the list
        public void addLast(E lastElement) {
            NodeDemo<E> lastNode = new NodeDemo<>(lastElement, null);
            if (isEmpty()) {
                this.headNode = lastNode;
            } else {
                this.tailNode.setNextNode(lastNode);
                this.tailNode = lastNode;
                size++;
            }
        }

        //removes and returns first element of the list
        public E removeFirst() {
            if (isEmpty()) return null;
            E firstElement = headNode.getElement();
            this.headNode = headNode.getNextNode();
            size--;
            if (size == 0) ;
            this.tailNode = null;
            return firstElement;
        }

        @SuppressWarnings("unchecked")
        public SinglyLinkedListDemo<E> clone() throws CloneNotSupportedException {
            //always use inherited object.clone() to create the initial copy
            SinglyLinkedListDemo<E> other = (SinglyLinkedListDemo<E>) super.clone(); //safe cast

            if (size > 0) {// we need independent chain of nodes
                other.headNode = new NodeDemo<>(headNode.getElement(), null);
                NodeDemo<E> walk = headNode.getNextNode(); //walk through the remainder of the list
                NodeDemo<E> otherTail = other.headNode; //remember most recently created node

                while (walk != null) {
                    NodeDemo<E> newest = new NodeDemo<>(walk.getElement(), null);
                    otherTail.setNextNode(newest); //link previous node to this one
                    otherTail = newest;
                    walk = walk.getNextNode();
                }
            }
            return other;
        }

        public int hashCode() {
            int h = 0;
            for (NodeDemo<E> walk = headNode; walk != null; walk = walk.getNextNode()) {
                h ^= walk.getElement().hashCode(); //bitwise exclusive or with element code
                h = (h << 5) | (h >>> 27); //5-bit cyclic shift of composite code
            }
            return h;
        }

    //------------------------------------------Exercise 2----------------------------------------------------

        private void swapNodes(NodeDemo<E> node1, NodeDemo<E> node2) {
            if (node1 == node2) return; // No need to swap the same node

            NodeDemo<E> node1prev = null, node2prev = null, currentNode = headNode;

            // Find previous nodes for node1 and node2
            while (currentNode != null && (node1prev == null || node2prev == null)) {
                if (currentNode.getNextNode() == node1) node1prev = currentNode;
                if (currentNode.getNextNode() == node2) node2prev = currentNode;
                currentNode = currentNode.getNextNode();
            }

            // Check if node1 or node2 is head
            if (node1 == headNode) node1prev = null;
            if (node2 == headNode) node2prev = null;

            // Swap previous pointers
            if (node1prev != null) node1prev.setNextNode(node2);
            else headNode = node2;

            if (node2prev != null) node2prev.setNextNode(node1);
            else headNode = node1;

            // Swap next pointers
            NodeDemo<E> temp = node1.getNextNode();
            node1.setNextNode(node2.getNextNode());
            node2.setNextNode(temp);

            // Fix tail if needed
            if (node1.getNextNode() == null) tailNode = node1;
            else if (node2.getNextNode() == null) tailNode = node2;
        }

//        //produces a string representation of the contents of the list
//        public String toString() {
//            StringBuilder sb = new StringBuilder("(");
//            NodeDemo<E> walk = headNode;
//            while (walk != null) {
//                sb.append(walk.getElement());
//                if (walk != tailNode)
//                    sb.append(", ");
//                walk = walk.getNextNode();
//            }
//            sb.append(")");
//            return sb.toString();
//        }
    }
/*+++++++++++++++++++++++++++++++++++++++end of exercise 2++++++++++++++++++++++++++*++++++++++++++++++++*/


/*+++++++++++++++++++++++++++++++++++++++Beginning exercise 3 - Circularly Linked List++++++++++++++++++++++++++++++++++++++++++++++++++++++++*++++++++++++++++++++*/

    public static class CircularlyLinkedList<E> implements Cloneable{

        private static class CircNode<E>{

            //instance variables
            private E element;
            private CircNode<E> nextNode;

            //constructor
            public CircNode(E element, CircNode<E> nextNode){
                this.element = element;
                this.nextNode = nextNode;
            }

            //Accessor methods
            public E getElement(){return this.element;}
            public CircNode<E> getNext(){return this.nextNode;}

            //modifiers
            public void setNext(CircNode<E> nextNode){this.nextNode = nextNode;}
        }//--------------------------end of CirNode-------------------->

        //instance variables of the Circularlylinkedlist

        private CircNode<E> tail = null; //we store tail but not head
        private int size = 0; // Number of nodes in the list

        //constructor
        public CircularlyLinkedList(){} //construct an initial empty list

        //Accessor methods
        public int getSize(){return this.size;}
        public boolean isEmpty(){return size == 0;}
        public E first(){ //returns but does not remove the first element
            if(isEmpty()) return null;

            return tail.getNext().element; //the head is after the tail
        }

        public E last(){
            if (isEmpty()) return null;

            return tail.getElement();
        }

        //modifiers/update methods
        public void rotate(){ //rotate the first element to the back of the list
            if(tail != null) //if empty, do nothing
                tail = tail.getNext();//the old head becomes the tail
        }

        public void addFirst(E e){ //adds an element to the front of the list
            if(isEmpty()){
                tail = new CircNode<>(e, null);
                tail.setNext(tail);
            }else{
                CircNode<E> newest = new CircNode<>(e, tail.getNext());
                tail.setNext(newest);
            }
            size++;
        }

        public void addLast(E e){//adds element e to the end of the list
            addFirst(e); //insert new element at the front of the list
            tail = tail.getNext(); //now new element becomes the tail
        }

        public E removeFirst(){ //removes and returns the first element
            if(isEmpty()) return null; //nothing to remove
            CircNode<E> head = tail.getNext();
            if (head == tail) tail = null; //must be the only node left
            else tail.setNext(head.getNext()); //removes "head" from the list
            size--;
            return head.getElement();
        }

        public void printNode() {
            //my code
            if (this.tail.nextNode == null){
                System.out.println("List is empty");
                return;
            }
            System.out.println("Circular linked list elements");

            CircNode<E> currentNode = this.tail.nextNode;
            do {
                System.out.println(currentNode.getElement() + " ");
                currentNode = currentNode.nextNode;
            }
            while (currentNode != tail.nextNode);{
                System.out.println();
            }
        }

//        //produces a string representation of the contents of the list
//        public String toString(){
//            if(tail == null) return "()";
//            StringBuilder sb = new StringBuilder("(");
//            CircNode<E> walk = tail;
//            do{
//                walk = walk.getNext();
////                //my code
////                if (walk == null){
////                    walk = tail.getNext();
////                    sb.append(walk.getElement());
////                }else{
//                sb.append(walk.getElement());
////                }
//                if(walk != tail)
//                    sb.append(", ");
//            }while(walk != tail);
//            sb.append(")");
//            return sb.toString();
//        }

        @SuppressWarnings({"unchecked"})
        public CircularlyLinkedList<E> clone() throws CloneNotSupportedException {
            CircularlyLinkedList<E> other = (CircularlyLinkedList<E>) super.clone();//safe cast

            if(this.size > 0){
                CircNode<E> walk = this.tail.nextNode; //start from the head
                CircNode<E> newNode = new CircNode<>(walk.getElement(), null); //create a first node head
                other.tail = newNode;
                CircNode<E> previousNode = newNode;
                walk = walk.getNext();

                while(walk != this.tail.nextNode){//loop until we are back at the head
                    CircNode<E> newestNode = new CircNode<>(walk.getElement(),null);
                    previousNode.setNext(newestNode);
                    previousNode = newestNode;
                    walk = walk.getNext();
                }

                previousNode.setNext(newNode);
                other.tail = previousNode;

            }

            return other;
        }
    }

    /*+++++++++++++++++++++++++++++++++++++++end of exercise 3++++++++++++++++++++++++++*++++++++++++++++++++*/

    //===========================================================Test Harness=================================================================
    public static void main(String[] args){

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++-Exercise 1 test-+++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Exercise 1 test
        System.out.println("+++++++++++++++++++++++++Beginning of exercise 1++++++++++++++++++++++++++++++++");
        DoublyLinkedList<Integer> firstList = new DoublyLinkedList<Integer>();
        firstList.addFirst(2);
        firstList.addFirst(3);
        firstList.addLast(3);
        firstList.addLast(1);
        firstList.addLast(2);

        DoublyLinkedList<Integer> secondList = new DoublyLinkedList<>();
        secondList.addFirst(10);
        secondList.addFirst(11);
        secondList.addFirst(12);
        secondList.addLast(4);
        secondList.addLast(5);
        secondList.addLast(6);


        System.out.print("First list before concatenation: ");
        firstList.printNode();
        System.out.println();

        System.out.print("Second list before concatenation: ");
        secondList.printNode();
        System.out.println();

        firstList.concatenate(secondList);

        System.out.print("First list after concatenation: ");
        firstList.printNode();
        System.out.println();

        System.out.print("Second list after concatenation (should be empty): ");
        secondList.printNode();
        System.out.println();
        System.out.println("+++++++++++++++++++++++++End of exercise 1++++++++++++++++++++++++++++++++");
        System.out.println();

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++-Exercise 2 test-+++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //Exercise 2 test
        System.out.println("+++++++++++++++++++++++++Beginning of exercise 2++++++++++++++++++++++++++++++++");
        SinglyLinkedListDemo<Integer> linkedListDemo = new SinglyLinkedListDemo<>();
        linkedListDemo.addFirst(1);
        linkedListDemo.addFirst(2);
        linkedListDemo.addFirst(3);

        System.out.println("Singly linked list before swapping nodes");
        System.out.println(linkedListDemo);
        System.out.println();

        linkedListDemo.swapNodes(linkedListDemo.headNode,linkedListDemo.headNode.nextNode);

        System.out.println("Singly linked list after swapping nodes");
        System.out.println(linkedListDemo);
        System.out.println("+++++++++++++++++++++++++End of exercise 2++++++++++++++++++++++++++++++++");
        System.out.println();


        //++++++++++++++++++++++++++++++++++++++++++++++++++++++-Exercise 3 test-+++++++++++++++++++++++++++++++++++++++++++++++++++++++

        System.out.println("+++++++++++++++++++++++++Beginning of exercise 3++++++++++++++++++++++++++++++++");

        //Circular linked list test
        CircularlyLinkedList<String> circularlyLinkedList = new CircularlyLinkedList<>();
        CircularlyLinkedList<String> circularlyLinkedList1 = new CircularlyLinkedList<>();
        circularlyLinkedList.addFirst("LAX");
        circularlyLinkedList.addFirst("MSP");
        circularlyLinkedList.addFirst("ATL");
        circularlyLinkedList.addFirst("BOS");

        try {
            circularlyLinkedList1 =  circularlyLinkedList.clone();
            circularlyLinkedList1.printNode();
            //System.out.println(circularlyLinkedList1); toString resulting in nullPointerException
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("+++++++++++++++++++++++++End of exercise 3++++++++++++++++++++++++++++++++");

    }

}
