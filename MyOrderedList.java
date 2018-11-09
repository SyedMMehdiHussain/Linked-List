

/** A class to represent an ordered list. 
 */
public class MyOrderedList<E extends Comparable<E>>{

	public MyOrderedList() {
		Node<E> head=null;
		int size=0;
	}
	private Node<E> head;
	private int size;

private static class Node<E>{
		private E data;
		private Node<E> next;
		/**
		 * @return the data
		 */
		public E getData() {
			return data;
		}
		/**
		 * @param data the data to set
		 */
		public void setData(E data) {
			this.data = data;
		}
		/**
		 * @return the next
		 */
		public Node<E> getNext() {
			return next;
		}
		/**
		 * @param next the next to set
		 */
		public void setNext(Node next) {
			this.next = next;
		}
		//Constructor
		 public Node(E item) {
	            data = item;
	            next=null;
	        }
		 //
	        public Node (E item, Node<E> nodeRef){
	
	        	data=item;
	        	next=nodeRef;  	
	        }
		public void displayNode() {
			// TODO Auto-generated method stub
			  System.out.print( data + " ");
		}       
	}	

private Node<E> getNode(int index) {
	Node<E> temp = head;

	for (int i = 0; i< index && temp != null; i++)
		temp=temp.next;
	return temp;
}
		
public E get (int index){
			if (index<0 || index > size)	
				throw new IndexOutOfBoundsException(Integer.toString(index));
			Node<E> temp = getNode(index);
			return temp.data;
}
public void reset(){ head = null;}

public E set (int index, E item){
	if (index<0 || index > size)	
		throw new IndexOutOfBoundsException(Integer.toString(index));
	Node<E> temp = getNode(index);
	E old = temp.data;
	temp.data = item;
	return old;
}

	public void addFirst(E item){
		head = new Node<E>(item, head);
		size++;
	}
	public void  addBefore(Node<E> node, E item){
	node = new Node<E>(item,node);
		size++;
	}
	public void addAfter(Node<E> node, E item){
		node.next= new Node<E>(item, node.next);
		size++;
	}

public void add(int index, E item) {
	if (index<0 || index > size){
		throw new IndexOutOfBoundsException(Integer.toString(index));
	}
		if (index == 0 )
			addFirst(item);
	
		else {
			Node<E> node = getNode(index-1);
			addAfter(node, item);
		}
}
/**
 * For this method I have used as a reference this web link:
 * http://www.javamadesoeasy.com/2015/01/sorted-linkedlistsingle-linkedlist.html
 * @param item
 * @return
 */
public boolean add(E item){
	Node<E> newNode  = new Node<>(item);
	
	//1) if list is empty
	if(head==null){
	head=newNode;
	  System.out.println("Node with data="+newNode.data+" inserted at first.");
	  size++;
      return true;
}
	//2) if newNode should be placed at first.
	 if(item.compareTo(head.data)<0){
         newNode.next=head;
         head=newNode; 
         size++;//first ---> newNode
         System.out.println("Node with data="+newNode.data+" inserted at first Node, because newNode is smallest of existing Nodes.");
         return true;
	 	}
	
	 //3) if newNode should be at some position other than first. 
	 Node<E> current = head;
     Node<E> previous=null;

     while(current!=null){
            if(item.compareTo(current.data)>0){
                  if(current.next==null){ //means current is last node, insert new node after current.
                         current.next=newNode;
                         size++;
                         System.out.println("Node with data="+newNode.data+" inserted successfully at last of LinkedList.");
                         return true;
                  }
                  
                  previous=current;
                  current=current.next;//move to next node.
            
            	}
         
            else{
                  newNode.next=previous.next; //make new node's next point to previous node's next
                  previous.next=newNode;  
                  size++;//make previous nodes' next point to new node.
                  System.out.println("Node with data="+newNode.data+" inserted successfully in middle of LinkedList.");
                  return true;
            }
     }
	return false;
}
	public int size(){
		return size;
	}
	
	public String toString() {
        String result = "";
        Node<E> current = head;
        while(current.getNext() != null){
            current = current.getNext();
            result += current.data + ", ";
        }
        return "List: " + result;
}
private E removeFirst(){
	if (head!= null){
		Node<E> temp= head;
		head = head.next;
		size--;
		return temp.data;
	}return  null;
}

public boolean remove(E item){
	return true;
} 
private E removeAfter(Node<E>t){
	Node<E> temp = t.next;
	if (temp !=null)
	{	t.next=temp.next;
		size--;
		return temp.data;
	} else return null;
}

public void displayLinkedList() {
    System.out.print("Displaying the Index (head node to last node): ");
    Node<E> temp = head; // start at the beginning of linkedList
    while (temp != null){ // Executes until we don't find end of list.
           temp.displayNode();
           temp = temp.next; // move to next Node
    }
    System.out.println();
}

}
		
	
