import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayBasedStack<T> implements StackInterface <T>
{
   
   T[] data; //references an array storing elements in the list
   private int topOfStack; //an int value representing the location of the stack top in the array
   private static final int INITIAL_CAPACITY = 5; //the default capacity of the stack set to 5
   private boolean initialized; //a boolean variable that is set to true if the stack is successfully created
   private int maxSize;

   @SuppressWarnings("unchecked")
   public ArrayBasedStack(int size){
      if (size <= 0)
      {
         topOfStack = -1;
         throw new IllegalArgumentException("size must be greater than 0");
      }
      else
      {
      
         topOfStack = size;
         data = (T[])new Object[size];
         maxSize = size;
         initialized = true;
      }
   }
   
   public ArrayBasedStack() 
   { 
      this(INITIAL_CAPACITY);
   }
   
   /** Adds a new entry to the top of this stack.
       @param newEntry  An object to be added to the stack. */
   public void push(T newEntry){
      if (topOfStack >= maxSize){
         expandArray();
      }
      data[topOfStack++] = newEntry;
   }

  
   /** Removes and returns this stack's top entry.
       @return  The object at the top of the stack. 
       @throws  EmptyStackException if the stack is empty before the operation. */
   public T pop(){
      if (topOfStack <= 0){
         throw new EmptyStackException();
      }
      return data[--topOfStack];

   }

  
   /** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
       @throws  EmptyStackException if the stack is empty. */
   public T peek(){
      if (isEmpty())
      {
     
         throw new EmptyStackException();
      }
      else
      {
         return data[topOfStack];
      }
   }
 
  
   /** Detects whether this stack is empty.
       @return  True if the stack is empty. */
   public boolean isEmpty(){
      if (topOfStack < 0)
      {
         return true;
      }
      else
      {
         return false;
      }
   }

  
   /** Removes all entries from this stack. */
   public void clear(){
      topOfStack = -1;
   }
   
   private void expandArray()
   {
      data = Arrays.copyOf(data, topOfStack * 2);
      maxSize = topOfStack * 2;
   }
   
   public static void main(String[] args)
   {
      StackInterface<String> stack = new ArrayBasedStack(1);
      System.out.println(stack.isEmpty());
      stack.push("Hello");
      stack.push("World");
       System.out.println(stack.peek());
       System.out.println("1");
       System.out.println(stack.pop());
       System.out.println(stack.peek());
       System.out.println(stack.pop());
      stack.push("o");
       System.out.println(stack.peek());
       System.out.println(stack.pop());
      System.out.println(stack.isEmpty());
      stack.pop();
   
   }

}