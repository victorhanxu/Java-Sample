package org.example;

import org.junit.Test;

public class EnumTest {


    @Test
    public void test1() {
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



     public static enum AccountType {
        SAA("SAA Account", "PLU"),
        SBA("SBA Account", "PER"),
        SSA("SSA Account", "EMP"),
        PRA("PRA Account", "PLU");

        String accountType;
        String plan;

        AccountType(String accType, String plan) {
            this.accountType=accType;
            this.plan=plan;
        }

        public String getAccType(){
            return accountType;
        }
        public String getPlan(){
            return plan;
        }
     }

     @Test
     public void test2() {
        AccountType[] accountTypes=AccountType.values();

        for(AccountType accountType: accountTypes) {
            System.out.println(accountType.name());
            System.out.println(accountType.ordinal());
            System.out.println(accountType.getAccType());
        }
        AccountType type1=AccountType.SSA;

        if(type1==AccountType.SAA) {
            System.out.println("type1 is SAA: " + type1.name().toString() +","+type1.getAccType().toString()+","+type1.getPlan().toString());
        } else {
            System.out.println("type1 is not SAA: " + type1.name().toString() +","+type1.getAccType().toString()+","+type1.getPlan().toString());
        }
    }
     

    
}
