
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author miracle
 */
public class SampleClass {

    static String aDays[] = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    private String day;
    
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void getNextDay(String nDay) {
        for (int i = 0; i < aDays.length; i++) {
            if (aDays[i].equalsIgnoreCase(nDay)) {
                
                if (i == (aDays.length-1)) {
                    System.out.println("The Next Day is: " + aDays[0]);
                } else {
                    System.out.println("The Next Day is: " + aDays[i+1]);
                }
                break;
            }
        }
    }

    public void getPreviousDay(String pDay) {
        for (int i = 0; i < aDays.length; i++) {
            if (aDays[i].equalsIgnoreCase(pDay)) {
                int count = i - 1;
                if (count == -1) {
                    System.out.println("");
                    System.out.println("The Previous Day is: " + aDays[aDays.length - 1]);
                } else {
                    System.out.println("The Previous Day is: " + aDays[count]);
                }
                break;
            }
        }
    }

    public void addToCurrentDay(int noOfDays) {
        int count=0;
        for (int i = 0; i < aDays.length; i++) {
            if (aDays[i].equalsIgnoreCase(getDay())) {
                int j = i;
                if (noOfDays > 0) {
                    while (noOfDays > 0) {
                        j=j+1;
                        if (j == (aDays.length)) {
                            j = 0;
                        }
                        count = j;
                        noOfDays--;
                    }
                } else {
                    int absNumber = Math.abs(noOfDays);
                    while (absNumber > 0) {
                        
                        j=j-1;
                        if (j == 0) {
                            j = aDays.length - 1;
                        }
                        count = j;
                        absNumber--;
                    }
                }
                System.out.println("The skipped day is: "+aDays[count]);
                break;
            }
        }

    }

    public static void main(String args[]) throws IOException {

        System.out.println("Enter the day: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SampleClass sample = new SampleClass();
        String day = (br.readLine()).substring(0, 3);
        System.out.println(day);
        for (String ad : aDays) {
            if (ad.equalsIgnoreCase(day)) {
                sample.setDay(day);
                sample.getNextDay(day);
                sample.getPreviousDay(day);
                System.out.println("Enter the number of days to skip: ");
                int no = Integer.parseInt(br.readLine());
                sample.addToCurrentDay(no);
            }
        }
    }
}
