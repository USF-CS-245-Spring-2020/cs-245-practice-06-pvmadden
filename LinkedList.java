//
// Tom Sawyer Software
// Copyright 2007 - 2020
// All rights reserved.
//
// www.tomsawyer.com
//

public class LinkedList<T> implements List
{
	Node head;
	int size;

	public void add(Object item)
	{
		if(head == null)
		{
			head = new Node(item);
		}
		Node current = head;
		while(current.next != null)
		{
			 current = current.next;
		}
		current.next = new Node(item);
		size++;
	}

	public void add(int pos, Object item)
	{
//		System.out.println("pos " + pos + " size " + size);
		if(pos > size)
		{
			throw new IllegalArgumentException("position out of bounds");
		}
		//prepend
		if(pos == 0)
		{
			Node newHead = new Node(item);
			newHead.next = head;
			head = newHead;
		}
		else if(pos == size)
		{
			Node current = head;
			Node toAdd = new Node(item);

			for(int i = 0; i < pos-1; i++)
			{
				current = current.next;
			}

			current.next = toAdd;
		}
		else
		{
			Node current = head;
			Node toAdd = new Node(item);

			for(int i = 0; i < pos-1; i++)
			{
				current = current.next;
			}

			toAdd.next = current.next.next;
			current.next = toAdd;
		}
		size++;
	}

	public T get(int pos)
	{
		if(pos > size)
		{
			throw new IllegalArgumentException("position out of bounds");
		}
		Node current = head;
		for(int i = 0; i > pos; i++)
		{
			current = current.next;
		}
		return (T) current.data;
	}

	public T remove(int pos)
	{
//		System.out.println("removing " + pos + " " + size);
		if(pos > size)
		{
			throw new IllegalArgumentException("position out of bounds");
		}

		if(head == null)
		{
			return null;
		}

		Node toReturn;
		Node current = head;

		if(pos == size)
		{
			for(int i = 0; i < pos-1; i++)
			{
				current = current.next;
			}
			toReturn = current.next;
			current.next = null;
			size--;
			return (T) toReturn.data;
		}
		if(pos == 0)
		{
			toReturn = head;
			head = head.next;
			size--;
			return (T) toReturn.data;
		}

		for(int i = 0; i < pos-1; i++)
		{
			current = current.next;
		}
		toReturn = current.next;
		current.next = current.next.next;
		size--;
		return (T) toReturn.data;
	}

	public int size()
	{
		return size;
	}
}