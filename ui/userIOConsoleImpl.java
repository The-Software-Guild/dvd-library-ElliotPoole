package dvdroster.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class userIOConsoleImpl implements userIO{
    
    final private Scanner user_input = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public void print(Date date){
        System.out.println(date);
    }

    @Override
    public String next(){
        String input;
        while (true) {
            Scanner user_input = new Scanner(System.in);
            input = user_input.nextLine();
            if(1==2); else break;
                // User hit enter without any data. Display error message then back to top of loop
        };
        return input;
    }

    @Override
    public String getString() {
        String input;
        while (true) {
            input = user_input.nextLine();
            if(input == null || input.isEmpty()); else break;
                // User hit enter without any data. Display error message then back to top of loop
        };
        return input;
    }

    @Override
    public int getInt() {
        int input;
        while (true) {  
            try{
                input = user_input.nextInt();
            }   catch(Exception e){
                System.out.println("That was not a whole number!");
                continue;
            }
                break;
            };
        return input;
    }

    @Override
    public int getInt(int min, int max){
        int number;
        do{
            number = getInt();
        }while (number < min || number > max);

        return number;
    }

    @Override
    public float getFloat() {
        float input;
        while (true) {
            try{
                System.out.println("Enter a number: ");
                input = user_input.nextFloat();
            }   catch(Exception e){
                System.out.println("That was not a number!");
                continue;
            }
                break;
            };
        return input;
    }

    @Override
    public double getDouble() {
        double input;
        while (true) {
            try{
                System.out.println("Enter a number: ");
                input = user_input.nextDouble();
            }   catch(Exception e){
                System.out.println("That was not a number!");
                continue;
            }
            break;
        };
        return input;
    }

    @Override
    public Date getDate(){
        Date input;
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/m/y");
        System.out.println("Date Format: dd/mm/yyyy");

        while(true){
            try {
                input = dateFormat.parse(user_input.next());
            } catch (Exception e) {
                System.out.println("That was not a date");
                continue;
            }
            break;
        };
        return input;
    }

    @Override
    public long getLong(){
        long input;
        while(true){
            try {
                input = user_input.nextLong();
            } catch (Exception e) {
                System.out.println("That was not a number");
                continue;
            }
            break;
        }
        return input;
    }
}




