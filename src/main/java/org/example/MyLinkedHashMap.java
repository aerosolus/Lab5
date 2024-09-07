package org.example;

/**
 * This class provides custom implementation of LinkedHashMap(without using java api's)-
 * which allows us to store data in key-value pair form.
 * It maintains insertion order, uses DoublyLinkedList for doing so.
 * If key which already exists is added again, its value is overridden but
 * insertion order does not change,
 * BUT, if key-value pair is removed and value is again added than insertion order
 * changes(which is quite natural behavior).
 * @param <K> The type of keys in this map
 * @param <V> The type of values in this map
 */
public class MyLinkedHashMap <K, V> {

    /**
     * Array of Entry objects to store key-value pairs.
     */
    private Entry<K,V>[] table;

    /**
     * Initial capacity of the HashMap.
     */
    private int capacity= 4;

    /**
     * Head of the doubly linked list maintaining insertion order.
     */
    private Entry<K,V> header;

    /**
     * Last entry of the doubly linked list maintaining insertion order.
     */
    private Entry<K,V> last;

    /**
     * Inner static class representing an entry in the map,
     * where before and after are used for maintaining insertion order.
     */
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K,V> next;
        Entry<K,V> before,after;

        public Entry(K key, V value, Entry<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Constructs a new MyLinkedHashMap with initial capacity 4.
     */
    @SuppressWarnings("unchecked")
    public MyLinkedHashMap(){
        table = new Entry[capacity];
    }

    /**
     * Method allows you put key-value pair in LinkedHashMapCustom.
     * If the map already contains a mapping for the key, the old value is replaced.
     * Note: method does not allow you to put null key thought it allows null values.
     * Implementation allows you to put custom objects as a key as well.
     * Key Features: implementation provides you with following features:
     * provide complete functionality how to override equals method.
     * provide complete functionality how to override hashCode method.
     * @param newKey The key to add
     * @param data The value associated with the key
     */
    public void put(K newKey, V data) {
        if(newKey==null)
            return;    //does not allow to store null.

        int hash=hash(newKey);

        Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);
        maintainOrderAfterInsert(newEntry);
        if(table[hash] == null){
            table[hash] = newEntry;
        }else{
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];
            while(current != null){ //we have reached last entry of bucket.
                if(current.key.equals(newKey)){
                    if(previous==null){  //node has to be insert on first of bucket.
                        newEntry.next=current.next;
                        table[hash]=newEntry;
                        return;
                    }
                    else{
                        newEntry.next=current.next;
                        previous.next=newEntry;
                        return;
                    }
                }
                previous=current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }


    /**
     * Ensures insertion order after adding a new key-value pair.
     *
     * @param newEntry The newly added entry
     */
    private void maintainOrderAfterInsert(Entry<K, V> newEntry) {

        if (header==null) {
            header=newEntry;
            last=newEntry;
            return;
        }

        if (header.key.equals(newEntry.key)) {
            deleteFirst();
            insertFirst(newEntry);
            return;
        }

        if (last.key.equals(newEntry.key)) {
            deleteLast();
            insertLast(newEntry);
            return;
        }

        Entry<K, V> beforeDeleteEntry = deleteSpecificEntry(newEntry);
        if (beforeDeleteEntry==null) {
            insertLast(newEntry);
        }
        else {
            insertAfter(beforeDeleteEntry,newEntry);
        }
    }

    /**
     * Ensures insertion order after removing a key-value pair.
     *
     * @param deleteEntry The entry being removed
     */
    private void maintainOrderAfterDeletion(Entry<K, V> deleteEntry) {

        if (header.key.equals(deleteEntry.key)) {
            deleteFirst();
            return;
        }

        if (last.key.equals(deleteEntry.key)) {
            deleteLast();
            return;
        }

        deleteSpecificEntry(deleteEntry);
    }

    /**
     * Inserts a new entry after a specific entry.
     *
     * @param beforeDeleteEntry The entry before which to insert
     * @param newEntry The new entry to insert
     */
    private void insertAfter(Entry<K, V> beforeDeleteEntry, Entry<K, V> newEntry) {
        Entry<K, V> current=header;
        while(current!=beforeDeleteEntry){
            current=current.after;  //move to next node.
        }

        newEntry.after=beforeDeleteEntry.after;
        beforeDeleteEntry.after.before=newEntry;
        newEntry.before=beforeDeleteEntry;
        beforeDeleteEntry.after=newEntry;
    }

    /**
     * Deletes the first entry from the linked list.
     */
    private void deleteFirst() {

        if (header==last) { //only one entry found.
            header=last=null;
            return;
        }
        header=header.after;
        header.before=null;
    }

    /**
     * Inserts a new entry at the beginning of the linked list.
     *
     * @param newEntry The new entry to insert
     */
    private void insertFirst(Entry<K, V> newEntry) {

        if (header==null) { //no entry found
            header=newEntry;
            last=newEntry;
            return;
        }

        newEntry.after=header;
        header.before=newEntry;
        header=newEntry;
    }

    /**
     * Inserts a new entry at the end of the linked list.
     *
     * @param newEntry The new entry to insert
     */
    private void insertLast(Entry<K, V> newEntry) {

        if (header==null) {
            header=newEntry;
            last=newEntry;
            return;
        }
        last.after=newEntry;
        newEntry.before=last;
        last=newEntry;
    }

    /**
     * Deletes the last entry from the linked list.
     */
    private void deleteLast() {

        if (header==last) {
            header=last=null;
            return;
        }

        last=last.before;
        last.after=null;
    }


    /**
     * Deletes a specific entry and returns the entry before it.
     *
     * @param newEntry The entry to delete
     * @return The entry before the deleted entry, or null if not found
     */
    private Entry<K, V> deleteSpecificEntry(Entry<K, V> newEntry) {

        Entry<K, V> current=header;
        while (!current.key.equals(newEntry.key)) {
            if (current.after==null) {   //entry not found
                return null;
            }
            current=current.after;  //move to next node.
        }

        Entry<K, V> beforeDeleteEntry=current.before;
        current.before.after=current.after;
        current.after.before=current.before;  //entry deleted
        return beforeDeleteEntry;
    }


    /**
     * Retrieves the value corresponding to a given key.
     *
     * @param key The key to search for
     * @return The value associated with the key, or null if not found
     */
    public V get(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K,V> temp = table[hash];
            while (temp!= null) {
                if(temp.key.equals(key))
                    return temp.value;
                temp = temp.next; //return value corresponding to key.
            }
            return null;   //returns null if key is not found.
        }
    }

    /**
     * Removes a key-value pair from the map.
     *
     * @param deleteKey The key to remove
     * @return true if the entry was removed, false if not found
     */
    public boolean remove(K deleteKey) {

        int hash=hash(deleteKey);

        if (table[hash] == null) {
            return false;
        } else {
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];

            while (current != null) { //we have reached last entry node of bucket.
                if (current.key.equals(deleteKey)) {
                    maintainOrderAfterDeletion(current);
                    if (previous==null) {  //delete first entry node.
                        table[hash]=table[hash].next;
                        return true;
                    }
                    else {
                        previous.next=current.next;
                        return true;
                    }
                }
                previous=current;
                current = current.next;
            }
            return false;
        }
    }


    /**
     * Displays all key-value pairs present in the map.
     */
    public void display() {
        Entry<K, V> currentEntry=header;
        while (currentEntry!=null) {
            System.out.print("{"+currentEntry.key+"="+currentEntry.value+"}" +" ");
            currentEntry=currentEntry.after;
        }
    }

    /**
     * Implements hashing functionality to determine the appropriate bucket location for a key.
     *
     * @param key The key to hash
     * @return The index of the bucket where the key should be stored
     */
    private int hash(K key) {
            return Math.abs(key.hashCode()) % capacity;
    }
}