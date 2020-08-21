
package javarushlessons.questcollectionsLevel01Lecture15;

import java.util.List;


public class Solution {
    public static void main(String[] args) {
        List<String> test = new CustomTree();
        for(int i = 0; i<16; i++){
            test.add("" + i);
        }
        System.out.println("Size: " + test.size());
        for(int i=0; i<test.size(); i++){
            System.out.println("Parent for " + i + ": " + ((CustomTree)test).getParent(String.valueOf(i)));
        }
        //System.out.println(test);
    }
    
}
