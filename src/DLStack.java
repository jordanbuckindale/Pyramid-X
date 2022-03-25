/**
 * This class represents an extended stack ADT implemented using a doubly linked list.
 * @author Jordan Buckindale
 * @Student #251246279
 * @Date March 22th 2022
 */

public class DLStack<T> implements DLStackADT<T> {

	//Private instance variables.
	
	/**
	 * This a reference to the node at the top of the stack.
	 */
	DoubleLinkedNode<T> top;
	
	/**
	 * The value of this variable is the number of data items stored in the stack.
	 */
	int numItems;
	
	/**
	 * Contructor for class that creates an empty stack, seting node top to null and variable numitems to zero.
	 */
	public void DLstack() {
		
		//sets top to null
		top = null;
		numItems = 0;
	}
	
	@Override
	/*
	 * Public method that adds the given dataitem to the top of the stack.
	 */
	public void push(T element) {
		
		//check to see if the stack is empty.
		if(top == null) {
			
			// create new node element and assign it to top.
			top = new DoubleLinkedNode<T>(element);
		}
		else {
			
			// declare new node variable for new top element. 
			DoubleLinkedNode<T> newTop;
			// assign new node for new top element. 
			newTop = new DoubleLinkedNode<T>(element);
			
			// set previous top element next reference to new top element.
			top.setNext(newTop);
			// set the reference to previous chambef for new top of stack.
			newTop.setPrevious(top);
			// set top reference to the top of the stack with new element.
			top = newTop;
			// set next node reference of top element to null.
			top.setNext(null);
		}
		// increase number of items.
		numItems ++;
	}

	@Override
	/*
	 * Public method that removes and returns the data item at the top of the stack. An EmptyStackException is thrown if the stack is empty.
	 */
	public T pop() throws EmptyStackException {
		
		// check to see if stack is empty.
		if (top == null) {
			
			// throw exception if stack is empty.
			throw new EmptyStackException("Stack is empty.");
		}
		else {
			
			// declare variable that will store popped element.
			T elemRemoved;
			// set variable to element that is at the top of the stack.
			elemRemoved = top.getElement();
			
			// check if there is more than one element in stack.
			if(top.getPrevious() == null) {
				
				// set stack as empty.
				top = null;
			}
			else {
				
			// set top element as previous element.
			top = top.getPrevious();
			// set top next element reference to null.
			top.setNext(null);
			}
			// de-increment number of items.
			numItems --;
			
			// return top element.
			return elemRemoved;
			
		}
		
	}

	@Override
	/*
	 * Public method that throws exception if stack is empty. Method returns the data item at the top of the stack without removing it. An EmptyStackException is thrown if the stack is empty.
	 */
	public T peek() {
		
		// check to see if the top of the stack is empty. 
		if (top == null) {
			
			// return null if the top of the stack is empty.
			return null;
		}
		
		// return top element if the stack is not empty.
		return top.getElement();
	}

	@Override
	/*
	 * Public method that throws exception. Method removes and returns the k-th data item from the top of the stack.
	 * An InvalidItemException is thrown if the value of k is larger than the number of data items stored in the stack. The following figure illustrates this operation.
	 */
	public T pop(int k) throws InvalidItemException {
		
		// declare variable elemRemoved that represents the element that will be removed from stack.
		T elemRemoved;
		
		// check to see if the parameter variable of index is valid input.
		if (numItems < k || k <= 0) {
			throw new InvalidItemException("Invalid");
		}
		// check to see if index was 1 and if so remove the top element of stack. variable elemRemoved holds the element of the top of the stack.
		if (k == 1) {
			elemRemoved = pop();
		}
		else {
			
			// create a node as top element.
			DoubleLinkedNode<T> current = top;
			
			// iterate through the stack and find the index that was inputed.
			for (int i = 1; i < k; i ++) {
				
				// node is stored as variable. Going through the stack until desired index.
				current = current.getPrevious();
			}
			
			// store element of node at desired index.
			elemRemoved = current.getElement();
			// declare nodes that represent the elements above and below the desired element.
			DoubleLinkedNode<T> elemAbove = current.getNext();
			DoubleLinkedNode<T> elemBelow = current.getPrevious();
				
			
			// check to see if the element before desired element in stack is null.
			if (elemBelow == null) {
				
				elemAbove.setPrevious(null);
						
			}
			else {
				
				// set element above desired to reference element below element.
				elemAbove.setPrevious(elemBelow);
				// set element below desired to reference element above element.
				elemBelow.setNext(elemAbove);	
			}		
		}
		
		// decrement number of elements.
		numItems --;
		// return the element removed at the desired index.
		return elemRemoved;
	}

	@Override
	/*
	 * Public method that returns true if the stack is empty and it returns false otherwise. 
	 */
	public boolean isEmpty() {
		
		if (top == null) {
			return true;
		}
		
		return false;
	}

	@Override
	/*
	 * Public method that returns the number of data items in the stack. 
	 */
	public int size() {
		
		// returns the number of items in the stack.
		return numItems;
	}

	@Override
	/*
	 * Public method that returns the node at the top of the stack.
	 */
	public DoubleLinkedNode<T> getTop() {
		
		// returns the node at the top of the stack.
		return top;
	}

	@Override
	/*
	 * Public method that returns a string of the format “[data1 data2 ... datan]”, where data1 is the data item at the top of the stack, and datan is the data item at the bottom of the stack.
	 */
	public String toString() {

		// declare empty string.
        String s = "";

        // create a node that references top element.
        DoubleLinkedNode<T> current = top;

        // iterate through the stack.
        for (int i = 1; i <= numItems; i++) {

        	// add element to string and add space between future elements.
            s = current.getElement() + " ";
            // set tempNode pointer to previous element to current.
            current = current.getPrevious();

        }

        // return a string concatenation of the string s and the brackets needed for format.
        return "[" + s + "]";

    }

}