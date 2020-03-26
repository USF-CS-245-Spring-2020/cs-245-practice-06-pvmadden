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
	Node first;
	int size;

	public void add(Object item)
	{
		Node<Object> h = head;
		Node<Object> newNode = new Node<>(item);
		head = newNode;

		if(h == null)
		{
			first = newNode;
		}
		else
		{
			h.next = newNode;
		}
		size++;
	}
	public void add(int pos, Object item)
	{
		if(pos > size)
		{
			throw new IllegalArgumentException("position out of bounds");
		}
		Node<Object> h = head;
		Node<Object> newNode = new Node<>(item);
		System.out.println(size + " " + pos);
		if(h == null)
		{
			first = newNode;
		}
		else
		{
			Node temp = first;
			for(int i = 0; i < pos-1; i++)
			{
				System.out.println(temp.data);
				temp = temp.next;
			}
			temp.next = newNode;
		}
		size++;
	}
	public T get(int pos)
	{
		if(pos > size)
		{
			throw new IllegalArgumentException("position out of bounds");
		}
		Node temp = first;
		for(int i = 0; i < pos; i++)
		{
			temp = temp.next;
		}
		return (T) temp.data;
	}

	public T remove(int pos)
	{
		Node temp = null;
		if(pos > size)
		{
			throw new IllegalArgumentException("position out of bounds");
		}

		//if we  are removing the first node
		if(pos == 0)
		{
			temp = first;
			first.next = first;
			size--;
			return (T) first.data;
		}

		//if we are  removing the head
		if(pos == size - 1)
		{
			Node secondTemp = head;
			for(int i = 0; i < pos; i++)
			{
				temp = temp.next;
			}

			head = temp;
			size--;
			return (T) secondTemp.data;

		}

		for(int i = 0; i < pos; i++)
		{
			temp = temp.next;
		}
		Node secondTemp = temp.next;
		size--;
		temp.next  = temp.next.next;
		return (T) secondTemp.data;
	}
	public int size()
	{
		return size;
	}
}