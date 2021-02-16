package school;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class School {
//scanner class here

    Scanner s;

    //sql connection here
    Connection cn;
    Statement st;
    ResultSet rs;

    public School() throws Exception {
        s = new Scanner(System.in);

        //made connection 
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gmsss23", "root", "3224");
        st = cn.createStatement();

    }

    public static void main(String[] args) throws Exception {

        School scl = new School();

       scl.mainmenu();
    }

    //main menu Data Here
    public void mainmenu() {

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t____SCHOOL MANAGEMENT DATA SYSTEM____\n\t\t\t\t\t\t\t\t\t GOVT. MODEL. SR. SEC. SCHOOL SECTOR 23-A CHANDIGARH");

        System.out.println("\n\n\t\t\t Select 1 Option: \n\n\t\t\t\t\t 1.STUDENT CORNER \n\t\t\t\t\t 2.TEACHER CORNER \n\t\t\t\t\t 3.FEE COLLECTION \n\t\t\t\t\t 4.REPORT \n\t\t\t\t\t 5.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");
        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    stdc();
                    break;
                case 2:
                    techc();
                    break;
                case 3:
                    fee();
                    break;
               
                case 4:
                    rep();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }

        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 6 number only");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //                              STUDENT CORNER DATA HERE
    private void stdc() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t____STUDENT DATA SYSTEM____ \n\t\t\t\t\t\t\t\t\t GOVT. MODEL. SR. SEC. SCHOOL SECTOR 23-A CHANDIGARH");

        System.out.println("\n\n\t\t\t Select 1 Option From Student : \n\n\t\t\t\t\t 1.ADD NEW STUDENT RECORDS \n\t\t\t\t\t 2.MODIFY STUDENT RECORDS \n\t\t\t\t\t 3.DELETE STUDENT RECORDS \n\t\t\t\t\t 4.SHOW STUDENT RECORDS \n\t\t\t\t\t 5.GO BACK TO MAIN MENU \n\t\t\t\t\t 6.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    modify();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    printstd();
                    break;
                case 5:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 5 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    
    //add student records 
    public void addStudent() throws Exception {

       
        int age;
        String AdmId, names, gender, fname, frtname, lastname, ffrtname, flastname, dob, classs, address;

        System.out.println("\n\n\n\n\t\t\t\t\t Student record add");
        System.out.println("PLEASE FILL ALL THE DETAILS CAREFULLY  ");

        System.out.println("\n\n\n\t\t\t\t\t ENTER ADMISSION ID OF STUDENT **please enter unqiue value ");
        System.out.println(" 4 numbers only ex=[S002] ");
        System.out.print(" ENTER AdmId: ");
        AdmId = s.next().toUpperCase();

        System.out.println("\n\n\n\t\t\t\t\t ENTER FULL STUDENT NAME BELOW [ ex = firstname lastname ] ");
        System.out.print(" FIRST NAME : ");
        frtname = s.next().toUpperCase();
        System.out.print(" LAST NAME : ");
        lastname = s.next().toUpperCase();
        names = frtname + " " + lastname;

        System.out.println("\n\n\n\t\t\t\t\t ENTER YOUR AGE BELOW [ ex= 12 ]");
        System.out.print(" ENTER AGE : ");
        age = s.nextInt();

        System.out.println("\n\n\n\t\t\t\t\t ENTER YOUR GENDER BELOW [ ex= male ] ");
        System.out.print(" GENDER : ");
        gender = s.next().toUpperCase();

        System.out.println("\n\n\n\t\t\t\t\t ENTER FULL FATHER NAME  [ ex= firstname lastname ] ");
        System.out.print(" FIRST NAME : ");
        ffrtname = s.next().toUpperCase();
        System.out.print(" LAST NAME  : ");
        flastname = s.next().toUpperCase();
        fname = ffrtname + " " + flastname;

        System.out.println("\n\n\n\t\t\t\t\t ENTER DATE OF BIRTH ex=(yyyy-mm-dd) : ");
        System.out.print(" YEAR : ");
        int yy = s.nextInt();
        System.out.print(" MONTH : ");
        int mm = s.nextInt();
        System.out.print(" DATE : ");
        int dd = s.nextInt();
        dob = yy + "-" + mm + "-" + dd;

        System.out.println("\n\n\n\t\t\t\t\t ENTER CLASS AND SECTION OF STUDENT ex ( class=12th   section=IT ) etc");
        System.out.print(" ENTER CLASS : ");
        String c = s.next().toUpperCase();
        System.out.print(" ENTER SECTION : ");
        String ss = s.next().toUpperCase();
        classs = c + " " + ss;

        System.out.println("\n\n\n\t\t\t\t\t ENTER FULL ADDRESS [ ex= flatnumber city state ] ");
        System.out.print("ENTER FLAT NUMBER : ");
        String fn = s.next();
      
        System.out.print("ENTER PLACE NAME : ");
        String pn = s.next().toUpperCase();
         System.out.print("ENTER CITY NAME : ");
            String cn = s.next().toUpperCase();
        System.out.print("ENTER STATE : ");
        String sn = s.next().toUpperCase();
        address = "#" + fn + " "+pn+" " + cn + " " + sn;

        String q = "insert into student values('" + AdmId + "','" + names + "'," + age + ",'" + gender + "','" + fname + "','" + dob + "','" + classs + "','" + address + "')";

        st.executeUpdate(q);
        System.out.println("\n\n\n\t\t\t\t\t\t\t STUDENT DATA SUCCESSFULLY ADDED");
       System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int chs;
            chs = s.nextInt();

            switch (chs) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    
    
    //modify student records
    public void modify() throws Exception {

        System.out.println("\n\n\n\n\t\t\t\t\t Welcome To MODIFY OR UPDATE Student Records ");
        System.out.println("\t\t Please choose 1 option to Modifiy Student Record ");

        System.out.println("\n\n\t\t\t which field you wanted to update : \n\n\t\t\t\t\t 1.ADMID \n\t\t\t\t\t 2.NAME \n\t\t\t\t\t  3.AGE \n\t\t\t\t\t 4.GENDER \n\t\t\t\t\t 5.FATHER NAME \n\t\t\t\t\t  6.DOB \n\t\t\t\t\t  7.CLASS \n\t\t\t\t\t  8.ADDRESS ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        int ch;
        ch = s.nextInt();
        switch (ch) {
            case 1:

                updateADMID();
                break;
            case 2:
                updateName();
                break;

            case 3:
               updateAge();
                break;
            case 4:
              updateGender();
                break;
            case 5:
               updateFather();
                break;
            case 6:
                updateDob();
                break;
            case 7:
              updateClasss();
                break;
            case 8:
                updateAddress();
                break;
            default:
                System.out.println("Please choice between 1 to 8 only");
                modify();
        }

    }

//update admid field
    public void updateADMID() throws Exception {
        System.out.print("\n\n\n\n\t\t ENTER ADMID FIELD NUMBER TO UPDATE ADMID RECORDS : ");
        String old = s.next().toUpperCase();

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t OLD DATA ");
         System.out.println("\n\n\t\t\t\t NOTE** please don't enter any record if old data not visible ");
        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }

        System.out.print("\n\n\t\t ENTER NEW ADMID NUMBER : ");
        String news = s.next().toUpperCase();
        String q = "update student set AdmId='" + news + "' where AdmId='" + old + "'";
        st.executeUpdate(q);

        System.out.println("\n\n\t\t\t\t\t\t\t\t\t ADMID FIELD SUCCESSFULLY UPDATED ");

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t UPDATED DATA ");

        rs = st.executeQuery("select*from student where AdmId='" + news + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }
   System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    
    
    
    
    
    
    //update name
    public void updateName() throws Exception {
        System.out.print("\n\n\n\n\t\t ENTER ADMID FIELD NUMBER TO UPDATE NAME RECORDS : ");
        String old = s.next().toUpperCase();

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t OLD DATA ");
         System.out.println("\n\n\t\t\t\t NOTE** please don't enter any record if old data not visible ");
        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }

        System.out.println("\n\n\t\t ENTER NEW FULLNAME TO UPDATE   : ");
        System.out.print("\n\t\t\t FIRSTNAME : ");
        String fn = s.next().toUpperCase();
        System.out.print("\n\t\t\t LASTNAME : ");
        String ln = s.next().toUpperCase();
        String name = fn + " " + ln;
        String qq = "update student set name='" + name + "' where AdmId='" + old + "'";
        st.executeUpdate(qq);

        System.out.println("\n\n\t\t\t\t\t\t\t\t\t NAME FIELD SUCCESSFULLY UPDATED ");

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t UPDATED DATA ");

        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }
    System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    
    
    
    
    
    
    
    
    //update age
    public void updateAge() throws Exception {
        System.out.print("\n\n\n\n\t\t ENTER ADMID FIELD NUMBER TO UPDATE AGE RECORDS : ");
        String old = s.next().toUpperCase();

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t OLD DATA ");
         System.out.println("\n\n\t\t\t\t NOTE** please don't enter any record if old data not visible ");
        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }

        System.out.println("\n\n\t\t ENTER NEW AGE TO UPDATE   : ");
        System.out.print("\n\t\t\t AGE : ");
        int age = s.nextInt();

        String q = "update student set age=" + age + " where AdmId='" + old + "'";
        st.executeUpdate(q);

        System.out.println("\n\n\t\t\t\t\t\t\t\t\t AGE FIELD SUCCESSFULLY UPDATED ");

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t UPDATED DATA ");

        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }
    System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
     //update gender
    public void updateGender() throws Exception {
        System.out.print("\n\n\n\n\t\t ENTER ADMID FIELD NUMBER TO UPDATE GENDER RECORDS : ");
        String old = s.next().toUpperCase();

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t OLD DATA ");
         System.out.println("\n\n\t\t\t\t NOTE** please don't enter any record if old data not visible ");
        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }

        System.out.println("\n\n\t\t ENTER NEW GENDER TO UPDATE   : ");
        System.out.print("\n\t\t\t GENDER : ");
        String gender=s.next().toUpperCase();

        String q = "update student set gender='" + gender + "' where AdmId='" + old + "'";
        st.executeUpdate(q);

        System.out.println("\n\n\t\t\t\t\t\t\t\t\t GENDER FIELD SUCCESSFULLY UPDATED ");

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t UPDATED DATA ");

        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }
   System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
//update father name
    
     public void updateFather() throws Exception {
        System.out.print("\n\n\n\n\t\t ENTER ADMID FIELD NUMBER TO UPDATE FATHER RECORDS : ");
        String old = s.next().toUpperCase();

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t OLD DATA ");
         System.out.println("\n\n\t\t\t\t NOTE** please don't enter any record if old data not visible ");
        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }

        System.out.println("\n\n\t\t ENTER NEW FATHER FULLNAME TO UPDATE   : ");
        System.out.print("\n\t\t\t FIRSTNAME : ");
        String fn = s.next().toUpperCase();
        System.out.print("\n\t\t\t LASTNAME : ");
        String ln = s.next().toUpperCase();
        String name = fn + " " + ln;
     

        String q = "update student set fname='" + name + "' where AdmId='" + old + "'";
        st.executeUpdate(q);

        System.out.println("\n\n\t\t\t\t\t\t\t\t\t FATHER FIELD SUCCESSFULLY UPDATED ");

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t UPDATED DATA ");

        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }
    System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
     
     
     //update dob
   
    
     public void updateDob() throws Exception {
        System.out.print("\n\n\n\n\t\t ENTER ADMID FIELD NUMBER TO UPDATE DOB RECORDS : ");
        String old = s.next().toUpperCase();

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t OLD DATA ");
         System.out.println("\n\n\t\t\t\t NOTE** please don't enter any record if old data not visible ");
        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }

       
     
      System.out.println("\n\n\n\t\t\t\t\t ENTER NEW DATE OF BIRTH ex=(yyyy-mm-dd) : ");
        System.out.print(" YEAR : ");
        int yy = s.nextInt();
        System.out.print(" MONTH : ");
        int mm = s.nextInt();
        System.out.print(" DATE : ");
        int dd = s.nextInt();
        String dob = yy + "-" + mm + "-" + dd;
        
         String q = "update student set dob='" + dob + "' where AdmId='" + old + "'";
        st.executeUpdate(q);

        System.out.println("\n\n\t\t\t\t\t\t\t\t\t DOB FIELD SUCCESSFULLY UPDATED ");

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t UPDATED DATA ");

        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }
    System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
     
   
     
     
     
     //update class field
     
     public void updateClasss()throws Exception{
     
      System.out.print("\n\n\n\n\t\t ENTER ADMID FIELD NUMBER TO UPDATE CLASS RECORDS : ");
        String old = s.next().toUpperCase();

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t OLD DATA ");
         System.out.println("\n\n\t\t\t\t NOTE** please don't enter any record if old data not visible ");
        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }

       
     
            System.out.println("\n\n\n\t\t\t\t\t ENTER NEW CLASS AND SECTION OF STUDENT ex ( class=12th   section=IT ) etc");
        System.out.print(" ENTER CLASS : ");
        String c = s.next().toUpperCase();
        System.out.print(" ENTER SECTION : ");
        String ss = s.next().toUpperCase();
        String classs = c + " " + ss;
        
         String q = "update student set class='" + classs + "' where AdmId='" + old + "'";
        st.executeUpdate(q);

        System.out.println("\n\n\t\t\t\t\t\t\t\t\t CLASS FIELD SUCCESSFULLY UPDATED ");

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t UPDATED DATA ");

        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }
      System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
     }
     
     
     
     //update address
      public void updateAddress()throws Exception{
     
      System.out.print("\n\n\n\n\t\t ENTER ADMID FIELD NUMBER TO UPDATE ADDRESS RECORDS : ");
        String old = s.next().toUpperCase();

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t OLD DATA ");
         System.out.println("\n\n\t\t\t\t NOTE** please don't enter any record if old data not visible ");
        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }

       
     
                   System.out.println("\n\n\n\t\t\t\t\t ENTER FULL ADDRESS [ ex= flatnumber city state ] ");
        System.out.print("ENTER FLAT NUMBER : ");
        String fn = s.next();
          System.out.print("ENTER PLACE NAME : ");
        String pn = s.next().toUpperCase();
        System.out.print("ENTER CITY NAME : ");
        String cn = s.next().toUpperCase();
        System.out.print("ENTER STATE : ");
        String sn = s.next().toUpperCase();
        String address = "#" + fn + " " +pn+""+ cn + " " + sn;
        
         String q = "update student set address='" + address + "' where AdmId='" + old + "'";
        st.executeUpdate(q);

        System.out.println("\n\n\t\t\t\t\t\t\t\t\t ADDRESS  FIELD SUCCESSFULLY UPDATED ");

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t UPDATED DATA ");

        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }
      System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
     }
     
     
      
 
      
      //delete records
      public void delete()throws Exception{
          System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t ___DELETE RECORDS OF STUDENTS___");
       System.out.print("\n\n\n\n\t\t ENTER ADMID FIELD NUMBER TO DELETE RECORDS : ");
        String old = s.next().toUpperCase();

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t DO YOU WANT TO DELETE THIS DATA ");
        
         System.out.println("\n\n\t\t\t\t NOTE** please don't delete any record if data not visible ");
        rs = st.executeQuery("select*from student where AdmId='" + old + "'");
        System.out.println("\n\t AdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }

            System.out.println("\n\n\n\t\t\t\t\t ARE YOU SURE YOU WANTED TO DELETE THIS RECORD ");
        System.out.println("\n\n\t\t\t 1:YES \n\t\t\t 2:NO  ");
          System.out.print("\n\n\t\t\t\t YOUR CHOICE : ");
        int ch=s.nextInt();
        switch(ch){
            
            case 1:
                
                 int dr=st.executeUpdate("delete from student where AdmId='"+old+"'");
       String q = "update student set address='" + old+ "' where AdmId='" + old + "'";
        st.executeUpdate(q);
        System.out.println("\n\n\t\t\t\t\t\t\t\t\t RECORD SUCCESSFULLY DELETED ");
          System.out.println("\n\n\t\t\t TOTAL NUMBER OF RECORDS DELELTED: "+dr);
    
          
              System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int chs;
            chs = s.nextInt();

            switch (chs) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
        
                break;
                
            case 2:
                
                System.out.println("\n\n\n\n\t\t\t\t\t Records not deleted ");
                modify();
                break;
                
            default:
                System.out.println("PLEASE ENTER BETWEEN 1 TO 2 ONLY");
                delete();
        }
    
      }
      
      
      
      
      
    //1.1 PRINT RECORDS 
    public void printstd() throws Exception {

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t ___Welcome To See Student Records___ ");
        System.out.println("\t\t Please choose 1 option to find record ");

        System.out.println("\n\n\t\t\t Select 1 Option to find records : \n\n\t\t\t\t\t 1.BY ADMID \n\t\t\t\t\t 2.BY NAME \n\t\t\t\t\t 3.ALL RECORDS \n\t\t\t\t\t 4.MAIN MENU ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        int ch;
        ch = s.nextInt();
        switch (ch) {
            case 1:
                byAdmId();
                break;
            case 2:
                byName();
                break;
            case 3:
                show();
                break;
            case 4:
                mainmenu();
                break;
            default:
                System.out.println("Please choice between 1 to 4 only");
                printstd();
        }

    }

    
    
    //1.2 all records here
    public void show() throws Exception {
        rs = st.executeQuery("select*from student");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\tAdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }
            System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    
    
    
    //1.3 search by admid
    public void byAdmId() throws Exception {

        System.out.println("ENTER ADMID BELOW : ");
        String admi = s.next().toUpperCase();
        String q = "select*from student where AdmId='" + admi + "'";
        rs = st.executeQuery(q);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\tAdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }
   System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    
    
   //2.4 by name
    public void byName() throws Exception {
        System.out.println("\n\n\n\t\t\t\t\t ENTER FULL NAME BELOW : ");
        System.out.print(" FIRST NAME : ");
        String frtname = s.next().toUpperCase();
        System.out.print(" LAST NAME : ");
        String lastname = s.next().toUpperCase();
        String names = frtname + " " + lastname;

        String q = "select*from student where Name='" + names + "'";
        rs = st.executeQuery(q);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\tAdmId\t\tName\t\tAge\t\tGender \t\t Fname \t\t\tDate Of Birth \t\tClass\t\tAddress");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6) + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8));
        }
      System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // TEACHER CORNER DATA HERE
    public void techc() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t____TEACHER DATA SYSTEM____\n\t\t\t\t\t\t\t\t\t GOVT. MODEL. SR. SEC. SCHOOL SECTOR 23-A CHANDIGARH");

        System.out.println("\n\n\t\t\t Select 1 Option From Teacher : \n\n\t\t\t\t\t 1.ALL TEACHER'S LIST \n\t\t\t\t\t 2.CLASS WISE TEACHER LIST \n\t\t\t\t\t 3.TEACHER'S RECORD MODEIFY \n\t\t\t\t\t 4.GO TO STUDENT CORNER \n\t\t\t\t\t 5.GO BACK TO MAIN MENU \n\t\t\t\t\t 5.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                   showTeacher();
                    break;
                case 2:
                    classwise();
                    break;
                case 3:
                    tmodify();
                    break;
                case 4:
                    stdc();
                    break;
                case 5:
                    mainmenu();
                    break;

                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 5 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    
    //teacher all records find
    
     public void showTeacher() throws Exception {
        rs = st.executeQuery("select*from teacher");
        System.out.println("\n\n\n\n\n\n\t TID \t\t TNAME \t\t\t\t GENDER \t\t\t CLASSINCHARGE \t\t\t EXPERIENCE");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t\t\t\t" + rs.getString(3) + "\t\t\t\t" + rs.getString(4) + "\t\t\t\t" + rs.getString(5));
        }
            System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
     
     
    
    //class wise list
    public void classwise()throws Exception{
           System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t WECLOME TO SEE CLASS WISE TEACHERS LIST");

           System.out.println("\n\n\n\t\t\t\t\t\t\t ENTER CLASS NUMBER BELOW TO FIND TEACHERS DETAILS");
           System.out.print("\n\n\t\t\t\t Class Number : ");
           int clas=s.nextInt();
      rs = st.executeQuery("select*from teacher where CLASS_INCHARGE='"+clas+"'");
      
        System.out.println("\n\n\n\n\n\n\t TID \t\t TEACHER NAME\t\t GENDER \t CLASS INCHARGE \t EXPERIENCE");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) +"\t\t\t" +  rs.getString(4) + "\t\t\t"   +rs.getString(5));
        }
            System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    //teacher modify
    
    public void tmodify()throws Exception{
    System.out.print("\n\n\n\n\t\t\t\t\t\t ENTER ADMID FIELD NUMBER TO UPDATE ALL RECORDS OF TEACHER  ");
        System.out.print("\n\n\t\t\t ENTER ADMID : ");
        String old = s.next().toUpperCase();

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t OLD DATA ");
        
         System.out.println("\n\n\t\t\t\t NOTE** please don't enter any record if old data not visible ");
        rs = st.executeQuery("select*from teacher where TID='"+old+"'");
      
        System.out.println("\n\n\n\n\n\n\t TID \t\t TEACHER NAME\t\t GENDER \t CLASS INCHARGE \t EXPERIENCE");
        while (rs.next()) {
            System.out.println("\t" + rs.getString(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) +"\t\t\t" +  rs.getString(4) + "\t\t\t"   +rs.getString(5));
        }

        System.out.println("\n\n\n\t\t\t\t\t\t\t ENTER ALL THE DETAILS CAREFULLY ");
        System.out.print("ENTER NEW ADMID: ");
        String tid = s.next().toUpperCase();
         String q = "update teacher set TID='" + tid + "' where TID='" + old + "'";
        st.executeUpdate(q);
        
          System.out.println("ENTER NEW TEACHER FULLNAME  ");
          System.out.print("ENTER FIRSTNAME : ");
          String fn=s.next().toUpperCase();
          System.out.print("ENTER LASTNAME : ");
          String ln=s.next().toUpperCase();
        String tn = fn+" "+ln;
        
         String q1 = "update teacher set TNAME='" + tn + "' where TID='" + old + "'";
        st.executeUpdate(q1);
        
        System.out.print("ENTER NEW GENDER : ");
        String gen = s.next().toUpperCase();
         String q2 = "update teacher set GENDER='" + gen + "' where TID='" + old + "'";
        st.executeUpdate(q2);
        
        System.out.print("ENTER CLASS INCHARE : ");
        String cl = s.next().toUpperCase();
        
         String q3 = "update teacher set CLASS_INCHARGE='" + cl + "' where TID='" + old + "'";
        st.executeUpdate(q3);
        
        System.out.print("ENTER EXPERIENCE: ");
        int ep=s.nextInt();
        
         String q4 = "update teacher set EXPERIENCE='" + ep + "' where TID='" + old + "'";
        st.executeUpdate(q4);

        System.out.println("\n\n\t\t\t\t\t\t\t\t\t TEACHER  DATA SUCCESSFULLY UPDATED ");

System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // FEE  Corner Data Here
    public void fee() {

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t____FEE DATA SYSTEM____\n\t\t\t\t\t\t\t\t\t GOVT. MODEL. SR. SEC. SCHOOL SECTOR 23-A CHANDIGARH");

        System.out.println("\n\n\t\t\t Select 1 Option From FEE : \n\n\t\t\t\t\t 1.UPDATE RECORDS \n\t\t\t\t\t 2.SEE OLD FEE RECORD \n\t\t\t\t\t 3.ADD NEW FEE RECORDS \n\t\t\t\t\t 4.GO BACK TO MAIN MENU \n\t\t\t\t\t 5.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                   uFee();
                    break;
                case 2:
                    feeData();
                    break;
                case 3:
                    
                    
                  //add new data of fee
                    
                     int amount;
        String AdmId,lastDate;

        System.out.println("\n\n\n\n\t\t\t\t\t WELCOME TO ADD FEE RECORDS");
        System.out.println("PLEASE FILL ALL THE DETAILS CAREFULLY  ");

        System.out.println("\n\n\n\t\t\t\t\t ENTER ADMISSION ID OF STUDENT **please enter unqiue value ");
        System.out.println(" 4 numbers only ex=[S002] ");
        System.out.print(" ENTER AdmId: ");
        AdmId = s.next().toUpperCase();

      
        System.out.println("\n\n\n\t\t\t\t\t ENTER FEE AMOUNT [ ex= 1800 ]");
        System.out.print(" ENTER Amount : ");
        amount = s.nextInt();

        

        System.out.println("\n\n\n\t\t\t\t\t ENTER TODAYS DATE ex=(yyyy-mm-dd) : ");
        System.out.print(" YEAR : ");
        int yy = s.nextInt();
        System.out.print(" MONTH : ");
        int mm = s.nextInt();
        System.out.print(" DATE : ");
        int dd = s.nextInt();
        lastDate = yy + "-" + mm + "-" + dd;

        

        String q = "insert into fee values('" + AdmId + "'," + amount + ",'" + lastDate+ "')";

        st.executeUpdate(q);
        System.out.println("\n\n\n\t\t\t\t\t\t\t FEE DATA SUCCESSFULLY ADDED");
       System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int chs;
            chs = s.nextInt();

            switch (chs) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
                    
                    
                    break;
                case 4:
                    mainmenu();
                    break;

                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 4 number only");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    
    //update fee
    
    public void uFee()throws Exception{
           System.out.println("\n\n\n\n\t\t\t\t\t Welcome To MODIFY OR UPDATE FEE Records ");
        System.out.println("\t\t Please choose 1 option to Modifiy FEE Record ");

        System.out.println("\n\n\t\t\t which field you wanted to update : \n\n\t\t\t\t\t 1.ADMID \n\t\t\t\t\t 2.FEE AMOUNT \n\t\t\t\t\t  3.LAST DATE");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        int ch;
        ch = s.nextInt();
        switch (ch) {
            case 1:
                
                
 System.out.print("\n\n\n\n\t\t ENTER ADMID FIELD NUMBER TO UPDATE ADMID RECORDS : ");
        String old = s.next().toUpperCase();
System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t OLD DATA ");
         System.out.println("\n\n\t\t\t\t NOTE** please don't enter any record if old data not visible ");
         String q="select*from fee where AdmId ='"+old+"'";
       rs = st.executeQuery(q);
        System.out.println("\n\n\n\n\n\t\t\t\t\t\t\t\tAdmId\t\tFEE AMOUNT \t\tLAST DATE");
        while (rs.next()) {
            System.out.println("\t\t\t\t\t\t\t\t"+rs.getString(1) +"\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3));
        }

        System.out.print("\n\n\t\t ENTER NEW ADMID : ");
      
        String name =s.next();
        String qq = "update fee set AdmId='" + name + "' where AdmId='" + old + "'";
        st.executeUpdate(qq);

        System.out.println("\n\n\t\t\t\t\t\t\t\t\t ADMID FIELD SUCCESSFULLY UPDATED ");

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t UPDATED DATA ");

        String qqq="select*from fee where AdmId ='"+name+"'";
       rs = st.executeQuery(qqq);
        System.out.println("\n\n\n\n\n\t\t\t\t\t\t\t\tAdmId\t\tFEE AMOUNT \t\tLAST DATE");
        while (rs.next()) {
            System.out.println("\t\t\t\t\t\t\t\t"+rs.getString(1) +"\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3));
        }
    System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int chs;
            chs = s.nextInt();

            switch (chs) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
                
                break;
                
                
                
                
            case 2:
  

            
 System.out.print("\n\n\n\n\t\t ENTER ADMID FIELD NUMBER TO UPDATE FEE AMOUNT RECORDS : ");
        String olds = s.next().toUpperCase();
System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t OLD DATA ");
         System.out.println("\n\n\t\t\t\t NOTE** please don't enter any record if old data not visible ");
         String q1="select*from fee where AdmId ='"+olds+"'";
       rs = st.executeQuery(q1);
        System.out.println("\n\n\n\n\n\t\t\t\t\t\t\t\tAdmId\t\tFEE AMOUNT \t\tLAST DATE");
        while (rs.next()) {
            System.out.println("\t\t\t\t\t\t\t\t"+rs.getString(1) +"\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3));
        }

        System.out.print("\n\n\t\t ENTER NEW FEE AMOUNT : ");
      
        int names =s.nextInt();
        String qq1 = "update fee set Fee_Amount='" + names + "' where AdmId='" + olds + "'";
        st.executeUpdate(qq1);

        System.out.println("\n\n\t\t\t\t\t\t\t\t\t FEE AMOUNT FIELD SUCCESSFULLY UPDATED ");

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t UPDATED DATA ");

        String qqq1="select*from fee where AdmId ='"+olds+"'";
       rs = st.executeQuery(qqq1);
        System.out.println("\n\n\n\n\n\t\t\t\t\t\t\t\tAdmId\t\tFEE AMOUNT \t\tLAST DATE");
        while (rs.next()) {
            System.out.println("\t\t\t\t\t\t\t\t"+rs.getString(1) +"\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3));
        }
    System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int chs;
            chs = s.nextInt();

            switch (chs) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
                
                
                
                break;

                
                
            case 3:
            
                
                System.out.print("\n\n\n\n\t\t ENTER ADMID FIELD NUMBER TO UPDATE LAST DATE RECORDS : ");
        String olds1 = s.next().toUpperCase();
System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t OLD DATA ");
         System.out.println("\n\n\t\t\t\t NOTE** please don't enter any record if old data not visible ");
         String q11="select*from fee where AdmId ='"+olds1+"'";
       rs = st.executeQuery(q11);
        System.out.println("\n\n\n\n\n\t\t\t\t\t\t\t\tAdmId\t\tFEE AMOUNT \t\tLAST DATE");
        while (rs.next()) {
            System.out.println("\t\t\t\t\t\t\t\t"+rs.getString(1) +"\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3));
        }

      System.out.println("\n\n\n\t\t\t\t\t ENTER NEW LAST DATE ex=(yyyy-mm-dd) : ");
        System.out.print(" YEAR : ");
        int yy = s.nextInt();
        System.out.print(" MONTH : ");
        int mm = s.nextInt();
        System.out.print(" DATE : ");
        int dd = s.nextInt();
        String dob = yy + "-" + mm + "-" + dd;
        
         String q22 = "update fee set Last_Datet23='" + dob + "' where AdmId='" + olds1 + "'";
        st.executeUpdate(q22);
      

        System.out.println("\n\n\t\t\t\t\t\t\t\t\t LAST DATE FIELD SUCCESSFULLY UPDATED ");

        System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t UPDATED DATA ");

        String qqq11="select*from fee where AdmId ='"+olds1+"'";
       rs = st.executeQuery(qqq11);
        System.out.println("\n\n\n\n\n\t\t\t\t\t\t\t\tAdmId\t\tFEE AMOUNT \t\tLAST DATE");
        while (rs.next()) {
            System.out.println("\t\t\t\t\t\t\t\t"+rs.getString(1) +"\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3));
        }
    System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int chs;
            chs = s.nextInt();

            switch (chs) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
               
                
                
                break;
           
            default:
                System.out.println("Please choice between 1 to 8 only");
                modify();
        }
    }
    
    //fee data
    public void feeData()throws Exception{
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t STUDENT FEE DATA ");
        System.out.println("\n\t\t\t\t\t\t ENTER AMDID TO SEE OLD FEE RECORD");
         System.out.print("\n\n\t\t\tENTER ADMID : ");
        String admi = s.next().toUpperCase();
        String q = "select*from fee where AdmId='" + admi + "'";
        rs = st.executeQuery(q);
        System.out.println("\n\n\n\n\n\t\t\t\t\t\t\t\tAdmId\t\tFEE AMOUNT \t\tLAST DATE");
        while (rs.next()) {
            System.out.println("\t\t\t\t\t\t\t\t"+rs.getString(1) +"\t\t" + rs.getString(2) + "\t\t\t" + rs.getString(3));
        }
   System.out.println("\n\n\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // 5. Report Corner Data Here
    public void rep() {

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t____REPORT DATA SYSTEM____\n\t\t\t\t\t\t\t\t\t GOVT. MODEL. SR. SEC. SCHOOL SECTOR 23-A CHANDIGARH");

        System.out.println("\n\n\t\t\t Select 1 Option From Report : \n\n\t\t\t\t\t 1.WEBSITE NOT WORKING \n\t\t\t\t\t 2.CONTACT TO SCHOOL \n\t\t\t\t\t 3.DATA NOT FOUND \n\t\t\t\t\t 4.ANY QUERY \n\t\t\t\t\t 5.GO BACK TO MAIN MENU \n\t\t\t\t\t 6.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    wnw();
                    break;
                case 2:
                    cts();
                    break;
                case 3:
                    dnf();
                    break;
                case 4:
                    aq();
                    break;
                case 5:
                    mainmenu();
                    break;

                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 5 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 5.1 report (website not working feature) control  here
    public void wnw() {
        System.out.println("\n\n\n\t\t\t\t\t SORRY FOR TROUBLE .  THANKS FOR COMPLAINING , WE SEND YOUR WEBSITE NOT WORKING PROLBEM TO OUR SERVER STAFF ");

        System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 5.2 report (contact to school feature) control  here
    public void cts() {
        System.out.println("\n\n\n\t\t\t\t\t YOU CAN CONTACT US BY = \n\t\t\t Phone Nuber : \t\t 0172-2700009  \n\t\t\t Email Id : \t\t gmsss23chd@gmail.com \n\t\t\t Full ADDRESS : \t goverment model senior secondary school sector 23-A chandigarh");

        System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 5.3 report (data not found feature) control  here   
    public void dnf() {
        System.out.println("\n\n\n\t\t\t\t\t SORRY FOR TROUBLE .  THANKS FOR COMPLAINING , WE SEND YOUR DATA NOT FOUND PROLBEM TO OUR SERVER STAFF ");

        System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 5.4 report (ANY QUERY feature) control  here   
    public void aq() throws Exception{
          System.out.println("\n\t\t please don't give space . use [ - ] or underscore [ _ ] sign instends of space ");
        System.out.println("\t\t\t ex=[ website_not_working_please_contact-me ]");
        System.out.println("\n\n\n\t\t\t\t\t PLEASE ENTER YOUR QUERY BELOW AND AFTER WRITING YOUR QUERY PLEASE PRESS [ ENTER ] KEY  : ");
      
        String report;
report = s.next();

String q = "insert into query values ('"+report+"')";

        System.out.println("\n\t\t\t\t\t 1:SEND YOUR QUERY \n\t\t\t\t\t 2.GO BACK TO MAIN MENU \n\t\t\t\t\t 3.EXIT");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");
          int ch= s.nextInt();
        try {
       switch (ch) {
                case 1:
                   st.executeUpdate(q);
                    msg();
                    break;
                case 2:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\t Thanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 5.5 report (message feature) control  here
    public void msg() {
        System.out.println("\n\n\n\t\t\t\t\t YOUR QUERY HAS BEEN SUCCESSFULLY SEND TO OUR SERVER STAFF. \t YOU WILL RECEIVE RESPONSE WITHIN 24 HOURS");

        System.out.println("\n\n\t\t\t Select 1 Option To Continue : \n\t\t\t\t\t 1.GO BACK TO MAIN MENU \n\t\t\t\t\t 2.EXIT ");
        System.out.print("\n\n\n\n\t\t\t YOUR CHOICE : ");

        try {
            int ch;
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    mainmenu();
                    break;
                default:
                    System.out.println("\n\n\n\t\t\t\t\t\t\t\t\t\t\tThanks for Accessing Our Application");
            }
        } catch (InputMismatchException e) {

            System.out.println("please enter between 1 to 2 number only");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
