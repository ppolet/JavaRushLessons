/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task2028FromGist;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> list = new CustomTree();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("The list size is " + list.size());
        System.out.println("The expected parent is 3. The actual parent is " + ((CustomTree) list).getParent("8"));
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("20"));

        list.remove("3");
        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("8"));

        list.add("16");
        System.out.println("The expected parent is 9. The actual parent is " + ((CustomTree) list).getParent("16"));
        list.remove("4");
        list.remove("5");
        list.remove("6");

        //тесты
        //System.out.println("от 2 слева :"+  ((CustomTree) list).get("2").availableToAddLeftChildren );
        //System.out.println( "от 2 справа :"+  ((CustomTree) list).get("2").availableToAddRightChildren );
        //

        System.out.println("Expected: true. Actual: " + list.add("20"));
        System.out.println("The expected parent is 1. The actual parent is " + ((CustomTree) list).getParent("20"));/**/
    }
}