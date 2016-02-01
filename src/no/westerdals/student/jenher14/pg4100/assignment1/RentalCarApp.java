package no.westerdals.student.jenher14.pg4100.assignment1;

import java.util.Scanner;

/**
 * Created by Herman on 25.01.2016.
 */
public class RentalCarApp
{
    public RentalCarApp()
    {
        Rental rental = new Rental();

        Scanner in = new Scanner(System.in);

        Thread[] customers = new Thread[10];

        System.out.println("Welcome to Car Rental Simulator 2016!");
        System.out.println("First, we need to make some customers.");
        System.out.println("Do you want me to make them for you? y/n");

        String answer = in.nextLine().substring(0, 1);
        while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")))
        {
            System.out.println("It's a simple yes or no question.");
            answer = in.nextLine().substring(0, 1);
        }

        if (answer.equalsIgnoreCase("y"))
        {
            System.out.println("Creating 10 customers for you.");
            String[] names = {
                "Thorstein", "Herman", "Per", "Pål", "Stein",
                "Listog", "Rolando", "Ronaldo", "Thomas", "Bastian"
            };

            for (int i = 0; i < 5; i++)
                customers[i] = new Thread(new Customer(names[i], rental));

            for (int i = 0; i < 5; i++)
                customers[i].start();

            for (int i = 5; i < 10; i++)
            {
                customers[i] = new Thread(new Customer(names[i], rental));
                customers[i].start();
            }
        }
        else {
            System.out.println("Type the name of 10 customers. They will start renting cars when there are 5 customers.");

            for (int i = 0; i < 5; i++)
            {
                System.out.print("Customer " + (i + 1) + ": ");
                String name = in.nextLine();
                customers[i] = new Thread(new Customer(name, rental));
            }

            for (int i = 0; i < 5; i++)
                customers[i].start();

            for (int i = 5; i < 10; i++)
            {
                System.out.print("Customer " + (i + 1) + ": ");
                String name = in.nextLine();
                customers[i] = new Thread(new Customer(name, rental));
                customers[i].start();
            }
        }

        in.close();
    }

    public static void main (String[] args)
    {
        new RentalCarApp();
    }


}
