package com.brs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {
    String passengerName;
    int busNo;
    Date date;

    Booking(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter passenger name");
        passengerName = sc.next();
        System.out.println("Enter Bus Number");
        busNo = sc.nextInt();
        System.out.println("Enter date dd-mm-yyyy");
        String inputdate = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

        try {
            date = dateFormat.parse(inputdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses){
        int capacity = 0;
        for (Bus bus: buses){
            if (bus.getBusNo() == busNo)
                capacity = bus.getCapacity();
        }

        int booked = 0;
        for (Booking b:bookings){
            if (b.busNo == busNo && b.date.equals(date)){
                booked++;
            }
        }
        return booked<capacity?true:false;
    }
}
