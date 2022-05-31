package com.oopsproject;
import java.nio.file.*;
import java.io.*;
import java.io.File;
import static java.nio.file. StandardOpenOption.*;
import java.util.Scanner;
import java.io.IOException;

public class Oops {
    public static void main(String[] args) throws IOException {
        int i;
        

        String Number = "O";
        final String QUIT = "10";
        Scanner s = new Scanner(System.in);
        System.out.println("WELCOME TO LOCKEME.COM");
        System.out.println("Devloped by:-..SUMIT KUMAR SINGH");

        for (i = 1; i < 10; i++) {
            System.out.println("\nPlease Select Your Option- \n");
            System.out.println("1.FOR-FILE LIST\n2.FOR-BUSSINESS OPERATION\n10.FOR-CLOSE THE APPLICATION");
            Number = s.nextLine();

            while (Number.equals(QUIT) == false) {
                if (Number.equals("1")) {
                    System.out.println("\nList of files in LOCKEME.COM:- \n");

                    File f = new File("E:\\LOCKEME.COM\\");
                    String[] s1 = f.list();
                    for (String s2 : s1) {
                        File f1 = new File(f, s2);
                        if (f1.isFile()) {
                            System.out.println(s2);
                            

                        }
                       
                   }
                    System.out.println("...............................................");
                    System.out.println("Please Select Your Option- \n");
                    System.out.println("1.FOR-FILE LIST\n2.FOR-BUSSINESS OPERATION\n10.FOR-CLOSE THE APPLICATION");
                }
                if (Number.equals("2")) {
                    System.out.println("For Bussiness Operation:-\nSelect Your Option:" +
                            "\n3 - CREATE FILE\n4 - DELETE FILE\n5 - SEARCH FILE");
                }
                Number = s.nextLine();

                if (Number.equals("3")) {
                    //CREATE
                    System.out.println("Enter a File Name:");
                    String Name = s.nextLine();
                    Path p1 = Paths.get("E:\\LOCKEME.COM\\" + Name);
                    try {

                        OutputStream o = new BufferedOutputStream(Files.newOutputStream(p1, CREATE));
                        o.flush();
                        o.close();
                        System.out.println("The file " + Name + " was successfully created.");
                        System.out.println("......................................................");
                        System.out.println("Please Select Your Option- \n");
                        System.out.println("1.FOR-FILE LIST\n2.FOR-BUSSINESS OPERATION\n10.FOR-CLOSE THE APPLICATION");

                    } catch (Exception e) {
                        System.out.println("Problem/s encountered while creating the file.");
                    }
                }//End of CREATE

                else if (Number.equals("4")) {
                    //DELETE
                    String Delete;
                    System.out.println("Enter File Name to be deleted:");
                    Delete = s.nextLine();
                    Path p2 = Paths.get("E:\\LOCKEME.COM\\" + Delete);
                    try {
                        Files.delete(p2);
                        System.out.println(Delete + " file has been deleted.");
                        System.out.println("..................................................................\n");
                        System.out.println("Please Select Your Option- \n");
                        System.out.println("1.FOR-FILE LIST\n2.FOR-BUSSINESS OPERATION\n10.FOR-CLOSE THE APPLICATION");

                    } catch (NoSuchFileException e) {
                        System.out.println("The file does not exist.");
                        System.out.println("\nPlease Select Your Option- \n");
                        System.out.println("1.FOR-FILE LIST\n2.FOR-BUSSINESS OPERATION\n10.FOR-CLOSE THE APPLICATION");
                    } catch (SecurityException e) {
                        System.out.println("You do not have the permission to delete this file.");
                    } catch (DirectoryNotEmptyException e) {
                        System.out.println("Directory is not empty.");
                    } catch (IOException e) {
                        System.out.println("IO Exception.");
                    }
                }//END of DELETE
                else if (Number.equals("5")) {
                    //START PROGRAMME FOR SEARCH
                    String Search;
                    System.out.println("Enter File Name :");
                    Search = s.nextLine();
                    Path p3 = Paths.get("E:\\LOCKEME.COM\\" + Search);
                    if (Files.exists(p3)) {
                        System.out.println(Search + " file exist.");
                    } else {
                        System.out.println("\"File not found\"");
                    }
                    System.out.println("..............................................................");

                    System.out.println("\nPlease Select Your Option- \n");
                    System.out.println("1.FOR-FILE LIST\n2.FOR-BUSSINESS OPERATION\n10.FOR-CLOSE THE APPLICATION");
                }
                }
            s.close();
            System.out.println(" you choose exit. The system will close");
            System.exit(0);
        }
    }
}
