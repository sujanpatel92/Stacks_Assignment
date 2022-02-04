import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayQueue.
 */
public class ArrayQueue<T> {

    /*
     * The initial capacity of the ArrayQueue.
     *
     * DO NOT MODIFY THIS VARIABLE.
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int front;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayQueue.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayQueue() {
        // DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the back of the queue.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array and reset front to 0.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        //test
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException();
        }
        if (size != backingArray.length) {
            backingArray[(size+front)%backingArray.length]=data;
            size++;
        } else if (size==backingArray.length) {
            T[] backingArray_temp = (T[]) new Object[backingArray.length*2];
            int x = 0;
            if (front==0) {
                for (var i = 0; i < backingArray.length;i++) {
                    if (backingArray[i] != null) {
                        backingArray_temp[i]=backingArray[i];
                    }
                }
                backingArray_temp[(size+front)%backingArray_temp.length]=data;
                backingArray=backingArray_temp;
                size++;
            } else {
                for (var i = front; i < backingArray.length;i++) {
                    if (backingArray[i] != null) {
                        backingArray_temp[x]=backingArray[i];
                        x++;
                    }
                }
                for (var i = 0; i < front; i++) {
                    if (backingArray[i] != null) {
                        backingArray_temp[x]=backingArray[i];
                        x++;
                    }
                }
                front = 0;
                backingArray_temp[(size+front)%backingArray_temp.length]=data;
                backingArray=backingArray_temp;
                size++;

            }
        }
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * Do not shrink the backing array.
     *
     * Replace any spots that you dequeue from with null.
     *
     * If the queue becomes empty as a result of this call, do not reset
     * front to 0.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    
    public T dequeue() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T temp_return = backingArray[front];
        backingArray[front]=null;
        if (front==backingArray.length-1) {
            front=0;
        } else {
            front++;
        }
        size--;
        return temp_return;

    }
    
    /**
     * Returns the backing array of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the queue
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the queue
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }


    public void testPrint() {
        String answer = "";
        //int y = 0;
        for (var y = 0; y < backingArray.length;y++) {
            //if (backingArray[y] != null) {
             //   answer += backingArray[y] + " ";
           // }
            answer += backingArray[y] + " ";

        }
        System.out.println(answer); 
    }

    public static void main(String args[]) {
        ArrayQueue<String> list = new ArrayQueue<>();
        list.enqueue("1");
        list.enqueue("2");
        list.enqueue("3");
        list.enqueue("4");
        list.enqueue("5");
        list.enqueue("6");
        //list.testPrint();

        //System.out.println(list.dequeue());

        //list.addToFront("Priyal");
        //list.addToBack("Sangita");
        //list.testPrint();
        //System.out.println(list.size());
        //System.out.println(list);
        //list.testPrint();
        list.enqueue("7");
        list.enqueue("8");

        list.enqueue("9");

        list.testPrint();
        list.dequeue();
        list.dequeue();
        list.dequeue();
        list.dequeue();
        list.dequeue();






        //System.out.println(list.size());
        //System.out.println(list.removeFromBack());
        //list.testPrint();
        //System.out.println(list.size());
        //list.enqueue("10");
        //System.out.println(list.size());
        list.testPrint();
        System.out.println(list.front);
        list.dequeue();
        list.dequeue();

        list.dequeue();
        list.dequeue();
        list.testPrint();

        System.out.println(list.front);

        //list.addToFront("Test");
        //list.testPrint();
        //System.out.println(list.getBackingArray().length);
        //System.out.println(list.getTail().getData());


    }
}