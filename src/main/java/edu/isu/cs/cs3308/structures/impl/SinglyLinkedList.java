package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;
import edu.isu.cs.cs3308.structures.Node;

public class SinglyLinkedList<E> implements List<E>
{


    protected Node<E> head;

    protected Node<E> tail;

    @Override
    public E first()
    {
        if(head == null)
        {
            return null;
        }

        return (E) head;
    }

    @Override
    public E last()
    {
        return (E) tail;
    }

    @Override
    public void addLast(E node)
    {
        if(node == null)
        {
            // Does nothing in the case of first value null;
            return;
        }

        // Create new node and set its next to null to signify its the end of the list.
        Node<E> newNode = new Node<>(node);
        newNode.setNext(null);

        //sets current tails to next then replaced tail with the new node (new end)
        tail.setNext(newNode);
        tail = newNode;

    }

    @Override
    public void addFirst(E node)
    {
        if(node == null)
        {
            // Does nothing in the case of first value null;
            return;
        }
        else
        {
            Node<E> newNode = new Node<>(node);
            newNode.setNext(head);
            head = newNode;
        }
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

        return (E) head;
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


        return (E) tail;
    }

    @Override
    public void insert(E node, int index)
    {

    }

    public E remove(int index)
    {
        return null;
    }

    @Override
    public E get(int index)
    {
        return null;
    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    public void printList()
    {

    }






}
