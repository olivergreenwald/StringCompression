import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Name: olivergreenwald
 * Lab Name: ArrayDictionary
 * Lab purpose: The goal of ArrayDictionary is to create a program that
 * Date: 10/29/17
 * Collaborators: None
 */

public class ArrayDictionary<E, T> {

    public ArrayList<E> keys;
    public ArrayList<T> values;
    public int size;

    /*  A Java dictionary should use generics for the
    *  types of both key and value. E and T here.
    */

    public ArrayDictionary(){
        keys = new ArrayList<E>();
        values = new ArrayList<T>();
        size = 0;
    }

    public ArrayDictionary(E key, T value){
        keys = new ArrayList<E>();
        keys.add(key);
        values = new ArrayList<T>();
        values.add(value);
        size = 1;
    }

    //add an key-value pair to the dictionary //If the key already exists, then replace the old value with the new value
    public void put(E key, T value){
        if (keys.contains(key) == true){
            int index = keys.indexOf(key);
            values.set(index, value);
        } else {
            keys.add(key);
            values.add(value);
            size++;
        }
    }


    //get the value associated with a given key
    public T get(E key){
        int index = keys.indexOf(key);

        if (index == -1){
            throw new NoSuchElementException();
        } else {
            return values.get(index);
        }

    }

    //remove a key-value pair and return its value
    public T remove(E key){
        int index = keys.indexOf(key);
        keys.remove(index);
        size--;
        return values.remove(index);
    }

    //returns true if the given key has an associated value
    public boolean contains(E key){
        return keys.contains(key);
    }

    //returns true if the dictionary is empty
    public boolean isEmpty(){
        return size == 0;
    }

    //returns the number of key-value pairs in the dictionary
    public int size(){
        return size;
    }

    //returns a Collection¹ of key-value pairs
    public Collection<E> keys(){
        ArrayList<E> temp = new ArrayList<E>();
        for (int i = 0; i < keys.size(); i++) {
            temp.add(keys.get(i));
        }
        return temp;
    }

    //returns a Collection of values
    public Collection<T>  values(){
        ArrayList<T> temp = new ArrayList<T>();
        for (int i = 0; i < values.size(); i++) {
            temp.add(values.get(i));
        }
        return temp;
    }

    public String toString(){
        String comp = "";
        if (size == 0){
            return "Nothing In Dictionary";
        } else {

            for (int i = 0; i < size; i++) {
                comp+="[(K = \"" + keys.get(i) + "\")(V = \"" + values.get(i) + "\")]";
            }
        }

        return comp;
    }

    public static void main(String[] args) {
        ArrayDictionary a = new ArrayDictionary("name", "Oliver");

        System.out.println("should say Oliver: " +a.get("name"));
        a.put("age", 10);
        a.put("cool?", "absolutely");
        System.out.println("should say true: " + a.contains("age"));
        System.out.println("should say absolutely: " + a.get("cool?"));
        System.out.println("should say false: " +a.isEmpty());
        System.out.println("should say 10: " +a.remove("age"));
        System.out.println("should say false: " +a.contains("age"));
        System.out.println("should say [name, cool?]: " +a.keys());
        System.out.println("should say [Oliver, absolutely]: " +a.values());

    }

}


