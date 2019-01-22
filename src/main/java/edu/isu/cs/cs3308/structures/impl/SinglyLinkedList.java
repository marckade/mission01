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
        return tail.getData();
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
        if(element == null)
        {
            // Does nothing in the case of first value null;
            return;
        }

        // Create new node and set its next to null to signify its the end of the list.
        Node<E> newNode = new Node<>(element);
        newNode.setNext(null);

        //sets current tails to next then replaced tail with the new node (new end)
        tail.setNext(newNode);
        tail = newNode;

        size++;

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
        }

        size++;
    }

    @Override
    public E removeFirst()
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

    @Override
    public E removeLast()
    {

        // Created tempNode variable to store new head temporarily.
        Node<E> tempNode;

        // set tempNode to head.
        tempNode = head;

        while(tempNode.getNext() != null)
        {
            tempNode = tempNode.getNext();
        }

        size--;

        return (E) tail;

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
        if(element == null || index < 0)
        {
            // Do nothing.
        }
        else
        {
            if(index >= size)
            {
               addLast(element);
            }
            else
            {
                Node<E> tempnode;

                // index being 0,1,2,3
                tempnode = head;

                // Get index to the right place.
                for(int i = 0; i < index - 1; i++)
                {
                    tempnode = tempnode.getNext();
                }

                Node<E> newNode = new Node<>(element);

                newNode.setNext(tempnode.getNext());

                tempnode.setNext(newNode);

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
        Node<E> tempnode;

        // index being 0,1,2,3
        tempnode = head;

        for(int i = 0; i < index - 1; i++)
        {
            tempnode = tempnode.getNext();
        }

        Node<E> tempnodeTwo;

        // index being 0,1,2,3
        tempnodeTwo = head;

        for(int i = 0; i < index; i++)
        {
            tempnodeTwo = tempnodeTwo.getNext();
        }

        



    }

    @Override
    public E get(int index)
    {
        return null;
    }

    @Override
    public int size()
    {

        if(size < 0)
        {
            size = 0;
        }

        return size;

    }

    @Override
    public boolean isEmpty()
    {
        if(head == null)
        return false;
        else
        {
            return true;
        }
    }

    public void printList()
    {
        Node<E> tempNode;

        tempNode = head;

        while(tempNode != null)
        {
            System.out.print(tempNode.getData());

            while(tempNode.getNext() != null)
            {
                tempNode = tempNode.getNext();
            }
        }
    }






}
