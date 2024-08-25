package com.brs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args) {
        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        buses.add(new Bus(1,true,3));
        buses.add(new Bus(2,false,45));
        buses.add(new Bus(3,false,48));

        int input =1;
        Scanner sc = new Scanner(System.in);

        for (Bus b: buses){
            b.displayBusInfo();
        }

        while (input == 1){
            System.out.println("Enter 1 to Book and 2 to Exit");
            input=sc.nextInt();
            if (input == 1){
                Booking booking = new Booking();
                if (booking.isAvailable(bookings,buses)){
                    bookings.add(booking);
                    System.out.println("Your booking s confirmed ");
                }else
                    System.out.println("Sorry bus is full. try another bus");
            }
        }
    }
}
