
package javarushlessons.questcollectionsLevel01Lecture15;

//1

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{
    
    Entry<String> root;
    private int size;
    
    List<Entry> treeList;
    
    public CustomTree(){
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
        //Корневой узел
        if(treeList.isEmpty()){
            root = new Entry<>(e);
            root.parent = null;
            root.leftChild = null;
            root.rightChild = null;
            size = 1;
            treeList.add(root);
            return true;
        }
        for(int i=0; i<treeList.size(); i++){
            if(treeList.get(i).availableToAddLeftChildren){
                Entry newLeaf = new Entry<String>(e);
                newLeaf.parent = treeList.get(i);
                treeList.get(i).availableToAddLeftChildren = false;
                treeList.get(i).leftChild = newLeaf;
                treeList.add(newLeaf);
                size++;
                return true;
            }
            if(treeList.get(i).availableToAddRightChildren){
                Entry newLeaf = new Entry<String>(e);
                newLeaf.parent = treeList.get(i);
                treeList.get(i).availableToAddRightChildren = false;
                treeList.get(i).rightChild = newLeaf;
                treeList.add(newLeaf);
                size++;
                return true;
            }
        }

        return false;
    }
    
    //5 - удаление объекта
    @Override
    public boolean remove(Object o){
        String st = "";
        try{
            st = (String)o;
        } catch (Exception e){
            throw new UnsupportedOperationException();
        }
        
        for (int i = 0; i<treeList.size(); i++){
            if (treeList.get(i).elementName.equals(st)){
                List<Entry> listNodesForRemove = new ArrayList<>();
                Queue<Entry> queue = new LinkedList<>();
                queue.add(treeList.get(i));
                while(!queue.isEmpty()){
                    Entry node = queue.remove();
                    listNodesForRemove.add(node);
                    
                    if(node.leftChild != null){
                        queue.add(node.leftChild);
                    }
                    if(node.rightChild !=null){
                        queue.add(node.rightChild);
                    }
                }
                for(int j=0; j<listNodesForRemove.size(); j++){
                    
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String remove(int index) {
        return super.remove(index); //To change body of generated methods, choose Tools | Templates.
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
    public String getParent(String s){
        for(int i = 0; i<treeList.size(); i++){
            if (treeList.get(i).elementName.equals(s)){
                //Корневой узел
                if(treeList.get(i).parent == null){
                    return "No parent, it's ROOT";
                }
                
                return treeList.get(i).parent.elementName;
            }
        }
        return "Object " + s + " not found...";
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
