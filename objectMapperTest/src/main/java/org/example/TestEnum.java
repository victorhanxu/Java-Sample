package org.example;

enum Color
{
    RED, GREEN, BLUE;
}

public class TestEnum {
 public static void main(String[] args) {
    Color c1=Color.RED;
    Color c2=Color.GREEN;

    System.out.println("Color is: " + c1);
    System.out.println("Color is: " + Color.RED);

    if(c1.compareTo(Color.RED)==0) {
        System.out.println("Color is RED: "+c1);
    }

    if(c1.equals(c2)){
        System.out.println("c1.equals(c2): true-->"+c1 +", "+c2);
    } else {
        System.out.println("c1.equals(c2): false-->"+c1 +", "+c2);
    }
 }   
}
