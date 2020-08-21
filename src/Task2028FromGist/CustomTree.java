/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task2028FromGist;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable,Serializable
{
    List <Entry> list ;
    Entry<String> root; //корешок

    public CustomTree()
    {
        list = new ArrayList();
        this.root = new Entry<String>("0"); //
        list.add(this.root);
    }

    @Override
    public boolean remove(Object o)
    {
        String s="";
        try
        {
            s = (String) o;
        }
        catch (Exception e )
        {
           throw new UnsupportedOperationException();
        }

        for (int i = 0; i <list.size() ; i++)
        {
            if (list.get(i).elementName.equals(s))
            {
                HelpRemove(i);
                return true;
            }
        }

        return false;
    }

    private void HelpRemove(int i)
    {
        // Очищение родителя
        Entry removedElement = list.get(i);
        String nameParent = getParent(list.get(i).elementName);
        Entry elementParent = get(nameParent);
        if ( elementParent.rightChild !=null)
            if (elementParent.rightChild.equals(  removedElement ))
            {
                elementParent.rightChild=null;
                elementParent.availableToAddRightChildren=true;
            }
        if ( elementParent.leftChild !=null)
            if (elementParent.leftChild.equals(  removedElement ))
            {
                elementParent.leftChild=null;
                elementParent.availableToAddLeftChildren=true;
            }
        //System.out.println("Удаляем : " + removedElement.elementName);
        if (removedElement.leftChild!=null)
            remove (removedElement.leftChild.elementName);
        if (removedElement.rightChild!=null)
            remove (removedElement.rightChild.elementName);

        list.remove(i);
        //i элемент надо удлаить.
    }


    public Entry get(String sName) //Возврат элемента по имени.
    {

        for (int i = 0; i <list.size() ; i++)
        {
            if (list.get(i).elementName.equals(sName))
                    return list.get(i);
        }
        return null;
    }


    @Override
    public int size()
    {
        return list.size()-1;
    }

    @Override
    public boolean add(String elementName)
    {
        for (int i = 0; i <list.size() ; i++)
        {
            if ( list.get(i).availableToAddLeftChildren == true )
            {
                Entry entry = new Entry<String>(elementName);
                list.get(i).leftChild = entry;
                list.get(i).availableToAddLeftChildren=false;
                list.add(entry);
                entry.parent = list.get(i);
                return true;
            }

            else if (list.get(i).availableToAddRightChildren ==true)
            {
                Entry entry = new Entry<String>(elementName);
                list.get(i).rightChild = entry;
                list.get(i).availableToAddRightChildren=false;
                list.add(entry);
                entry.parent = list.get(i);
                return true;
            }

        }

        return false;
    }

    public String getParent(String s)
    {
        for (int i = 0; i <list.size() ; i++)
        {
            if (list.get(i).elementName.equals(s) )
                return list.get(i).parent.elementName;
        }
        return null;
    }


    static class Entry<T> implements Serializable
    {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;


        public Entry(String elementName)
        {
            this.elementName = elementName;
            this.availableToAddLeftChildren =true;
            this.availableToAddRightChildren =true;
        }

        boolean isAvailableToAddChildren()
        {
            return availableToAddLeftChildren|availableToAddRightChildren;
        }


    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c)
    {
        throw new UnsupportedOperationException();
        //return super.addAll(index, c);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException();
        //super.removeRange(fromIndex, toIndex);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex)
    {
        throw new UnsupportedOperationException();
        //return super.subList(fromIndex, toIndex);
    }

    @Override
    public void add(int index, String element)
    {
        throw new UnsupportedOperationException();
        //super.add(index, element);
    }

    @Override
    public String set(int index, String element)
    {
        throw new UnsupportedOperationException();
        //return super.set(index, element);
    }

    @Override
    public String remove(int index)
    {
        throw new UnsupportedOperationException();
        //return super.remove(index);
    }

    @Override
    public String get(int index) //throws UnsupportedOperationException
    {

        throw new UnsupportedOperationException();
        //return null;
    }


}