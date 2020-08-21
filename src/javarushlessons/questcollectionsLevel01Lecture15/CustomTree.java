
package javarushlessons.questcollectionsLevel01Lecture15;

//1

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{
    
    Entry<String> root;
    private int size;
    
    List<Entry<String>> treeList;
    
    public CustomTree(){
        root = new Entry<>("");
        root.parent = null;
        root.leftChild = null;
        root.rightChild = null;
        size = 0;
        treeList = new ArrayList<>();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    //4 - возвращает текущее количество элементов в дереве.
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public String set(int index, String element){
        throw new UnsupportedOperationException();
    }
    
    //4 - добавляет элементы дерева, в качестве параметра принимает имя элемента(elementName), искать место для вставки начинаем слева направо.
    @Override
    public boolean add(String e) {
        root.leftChild = new Entry<>(e);
        treeList.add(root);
        size++;
        return true;
    }
    
    @Override
    public String remove(int index){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public List<String> subList(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
    
    @Override
    protected void removeRange(int fromIndex, int toIndex){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean addAll(int index, Collection<? extends String> c){
        throw new UnsupportedOperationException();
    }
    
    //4 - возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.
    public void getParent(String s){
        
    }
    
    //3.1 - класс описывающий тип элементов дерева
    static class Entry<T> implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;    
        
        public Entry(String elementName){
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }
        
        public boolean isAvailableToAddChildren(){
            return (availableToAddLeftChildren || availableToAddRightChildren);
        }
    }
}
