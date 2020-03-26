//
// Tom Sawyer Software
// Copyright 2007 - 2020
// All rights reserved.
//
// www.tomsawyer.com
//

import java.lang.reflect.Array;

public class ArrayList<T> implements List
{
	private int size = 0;
	private int cap;

	private Object[] content;

	public ArrayList(int cap)
	{
		if(cap < 0)
		{
			throw new IllegalArgumentException("Capacity must be greater than 0: " + cap);
		}
		this.cap = cap;
		this.content =  new Object[cap];
	}

	public ArrayList()
	{
		this(10);
	}

	public void add(Object item)
	{
		if(size + 1 >= content.length)
		{
			doubleArray();
		}
		content[size++] = item;
	}

	public void add(int pos, Object item)
	{
		//System.out.println("before double array" + pos + " " + content.length + " " + size);
		if(size + 1 >= content.length)
		{
			doubleArray();
		//	System.out.println("after double" + pos + " " + content.length + " " + size);
		}

		content[pos] = item;
		size++;
	}

	public T get(int pos)
	{
		//System.out.println("pos " + pos + " size: " + size + " content[pos]" + content[pos]);
		if(pos > size)
		{
			throw new IllegalArgumentException("position out of bounds");
		}
		return (T) content[pos];
	}

	public T remove(int pos)
	{
		T oldValue = (T) content[pos];
		for(int i = pos; i > size - 1; i++)
		{
			content[pos] = content[pos+1];
		}
		content[size] = null;
		size--;
		return oldValue;
	}
	public int size()
	{
		return size;
	}

	private void doubleArray()
	{
		//System.out.println("content length " + content.length);
//		for(Object ob : content)
//		{
//			System.out.println(ob);
//		}
		cap = cap * 2;
		Object[] temp = new Object[cap];
		for(int i = 0; i < size; i++)
		{
			temp[i] = content[i];
		}
		//System.out.println("temp length " + temp.length);
//		for(Object ob : temp)
//		{
//			System.out.println(ob);
//		}
		content = temp;
	}
}
