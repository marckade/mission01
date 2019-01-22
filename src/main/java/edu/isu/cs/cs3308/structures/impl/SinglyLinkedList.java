package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;
import edu.isu.cs.cs3308.structures.Node;

public class SinglyLinkedList<E> implements List<E>
{


    protected Node<E> head;

    protected Node<E> tail;

    protected int size = 0;

    /**
     * @return first element in the list or null if the list is empty.
     */
    @Override
    public E first()
    {
        if(head == null)
        {
            return null;
        }

        return head.getData();
    }

    /**
     * @return last element in the list or null if the list is empty.
     */
    @Override
    public E last()
    {
        if(size > 0)
        {
            return tail.getData();
        }
        else
        {
            return null;
        }
    }

    /**
     * Adds the provided element to the end of the list, only if the element is
     * not null.
     *
     * @param element Element to be added to the end of the list.
     */
    @Override
    public void addLast(E element)
    {
        if(size > 0)
        {
            if(element == null)
            {
                // Does nothing in the case of first value null;
                return;
            }
            else {

                // Create new node and set its next to null to signify its the end of the list.
                Node<E> newNode = new Node<>(element);
                newNode.setNext(null);

                //sets current tails to next then replaced tail with the new node (new end)
                tail.setNext(newNode);
                tail = newNode;

                size++;
            }
        }
        else
        {
            addFirst(element);
        }



    }

    /**
     * Adds the provided element to the end of the list, only if the element is
     * not null.
     *
     * @param element Element to be added to the end of the list.
     */
    @Override
    public void addFirst(E element)
    {

        if(element == null)
        {
            // Does nothing in the case of first value null;
            return;
        }
        else
        {
            Node<E> newNode = new Node<>(element);
            newNode.setNext(head);
            head = newNode;

            // Checks if the addFirst was the first
            // element to be added.
            if(size == 0)
            {
                tail = newNode;
            }


            size++;
        }


    }

    /**
     * Removes the element at the front of the list.
     *
     * @return Element at the front of the list, or null if the list is empty.
     */
    @Override
    public E removeFirst()
    {

        if(size > 0)
        {
            // Created tempNode variable to store new head temporarily.
            Node<E> tempNode;

            // the new head is in the tempNode variable.
            tempNode = head.getNext();

            // Sets next of current head to null which should leave for garbage collection.
            head.setNext(null);

            // Sets new head to the tempNode;
            head = tempNode;

            size--;

            return head.getData();
        }

        return null;
    }

    /**
     * Removes the element at the end of the list.
     *
     * @return Element at the end of the list, or null if the list is empty.
     */
    @Override
    public E removeLast()
    {

        //Check list size
        if(size > 0)
        {
            // Created tempNode variable to store new head temporarily.
            Node<E> tempNode;

            // set tempNode to head.
            tempNode = head;

            while(tempNode.getNext() != null)
            {
                tempNode = tempNode.getNext();
            }

            //Iterate size down
            size--;

            //Return tails data.
            return tail.getData();
        }
        else
        {
            return null;
        }


    }

    /**
     * Inserts the given element into the list at the provided index. The
     * element will not be inserted if either the element provided is null or if
     * the index provided is less than 0. If the index is greater than or equal
     * to the current size of the list, the element will be added to the end of
     * the list.
     *
     * @param element Element to be added (as long as it is not null).
     * @param index Index in the list where the element is to be inserted.
     */
    @Override
    public void insert(E element, int index)
    {
        //If the element is null or the index is less than 0,
        if(element == null || index < 0)
        {
            // Do nothing.
        }
        else
        {
            // If index is greater or equal to in size then do the end instead.
            if(index >= size)
            {
               addLast(element);
            }
            else
            {
                //Create new tempnode.
                Node<E> tempnode;

                // index being 0,1,2,3
                tempnode = head;

                // Get index to the right place.
                for(int i = 0; i < index - 1; i++)
                {
                    tempnode = tempnode.getNext();
                }

                // Create newnode with element parameter.
                Node<E> newNode = new Node<>(element);

                //Set the next for the new node equal to the tempnodes next.
                newNode.setNext(tempnode.getNext());

                //Set tempnodes next to the new node to complete insert.
                tempnode.setNext(newNode);

                //Iterate size
                size++;
            }

        }

    }

    /**
     * Removes the element at the given index and returns the value.
     *
     * @param index Index of the element to remove
     * @return The value of the element at the given index, or null if the index
     * is greater than or equal to the size of the list or less than 0.
     */
    public E remove(int index)
    {

        // If index is greater than or equal to size OR if index is less than 0, return null
        if(index >= size || index < 0)
        {
            return null;
        }
        else
        {

            //Create new tempnode.
            Node<E> tempnode;

            // index being 0,1,2,3
            tempnode = head;

            //Iterate tempnode to index - 1
            for(int i = 0; i < index - 1; i++)
            {
                tempnode = tempnode.getNext();
            }

            //Create new tempnode and set it equal to the node we want to remove.
            Node<E> tempnodeTwo;

            //Sets tempTwo to the pointed node of tempnode
            tempnodeTwo = tempnode.getNext();

            //Sets tempnodes next to the next of the second tempnode.
            tempnode.setNext(tempnodeTwo.getNext());

            //Deletes the second tempnode by setting it to null.
            tempnodeTwo.setNext(null);

            //Iterates down.
            size--;

            return tempnodeTwo.getData();
        }

    }

    /**
     * Retrieves the value at the specified index. Will return null if the index
     * provided is less than 0 or greater than or equal to the current size of
     * the list.
     *
     * @param index Index of the value to be retrieved.
     * @return Element at the given index, or null if the index is less than 0
     * or greater than or equal to the list size.
     */
    @Override
    public E get(int index)
    {
        if(index < 0 || index >= size)
        {
            return null;
        }
        else
        {
            Node<E> tempnode;

            // index being 0,1,2,3
            tempnode = head;

            for(int i = 0; i < index; i++)
            {
                tempnode = tempnode.getNext();
            }

            return tempnode.getData();
        }

    }

    //Checks size
    @Override
    public int size()
    {

        if(size < 0)
        {
            size = 0;
        }

        return size;

    }

    //Checks if the list is empty by checking head.
    @Override
    public boolean isEmpty()
    {
        if(head == null)
        return true;
        else
        {
            return false;
        }
    }

    /**
     * Prints the contents of the list in a single line separating each element
     * by a new line to the default System.out
     */
    public void printList()
    {
        Node<E> tempNode;

        tempNode = head;

        //Iterates through the linked list and prints the data.
        for(int i = 0; i < size; i++)
        {
            System.out.println(tempNode.getData());

            tempNode = tempNode.getNext();
        }

    }






}
