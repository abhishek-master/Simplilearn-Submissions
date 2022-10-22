import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Phase_3_Submission_Abhishek_Sinha{

    //Method to add item in the file !!
    public static void ADD (String [ ]arr , List lines , String FILE_PATH) throws IOException {
        System.out.println("Enter the File Name to be inserted in the File Collections : " );
        Scanner sc = new Scanner(System.in) ;
        String data = sc.next() ;
        lines.add(data) ;
        Files.write(Paths.get(FILE_PATH), lines, StandardOpenOption.CREATE);
        System.out.println("File Name has been added ! ");
        System.out.println("If you want to view the modified list here print Y ");
        char option = sc.next().charAt(0)  ;
        if ( option == 'Y' || option == 'y') {
            DISPLAY(FILE_PATH);
        }

        System.out.println("\n Want to go to Main menu ? (Y/N)");
        char b  = sc.next().charAt(0) ;
        if (b == 'y' || b =='Y'){
            MENU(arr ,lines , FILE_PATH) ;
        }
        else{
            System.out.println("Thanks for using our application !!");
            System.exit(0);
        }
    }

    //Delete method to remove desired items from your file !!
    public static void DELETE (String [ ]arr , List lines , String FILE_PATH) throws IOException {
        System.out.println("Enter ITEM to be deleted from file : ");
        Scanner sc = new Scanner(System.in) ;
        String v = sc.nextLine() ;
        boolean flag = true ;
        for(int i = 0 ; i < lines.size() ; i++) {
            if ((v).equals((String)lines.get(i))) {
                lines.remove(v);
                flag = false;
            }
        }

        if(flag) {
            Files.write(Paths.get(FILE_PATH), lines,StandardOpenOption.CREATE);
            System.out.println("Element not found for deletion !!");
        }
        else {
            Files.write(Paths.get(FILE_PATH), lines,StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Element deleted from the file !! ");
        }
        System.out.println("Want to display the items in file ? (Y/N) ");
        char option = sc.next().charAt(0)  ;
        if ( option == 'Y' || option == 'y') {
            DISPLAY(FILE_PATH);
        }
        System.out.println("\n Want to go to Main menu ? (Y/N)");
        char a  = sc.next().charAt(0) ;
        if (a == 'y' || a=='Y'){
            MENU(arr ,lines , FILE_PATH) ;
        }
        else{
            System.out.println("Thank you for using our application !!");
            System.exit(0) ;
        }

    }


    //DISPLAY method to put on screen content of file for user !!
    public static void DISPLAY (String FILE_PATH) throws IOException {
        Scanner sc  =new Scanner(System.in) ;
        List<String> lines = Collections.emptyList() ;
        try {
            lines = Files.readAllLines(Paths.get(FILE_PATH), StandardCharsets.UTF_8);
        }
        catch (IOException e){
            e.printStackTrace () ;
        }

        System.out.println("This is the list of Items in file  : ");
        String [] arr =  new String [lines.size()] ;
        // Using Selection Sort to Sort the Array !!
        for(int a = 0 ; a <lines.size() ; a++) {
            arr[a] = lines.get(a) ;
        }
        for(int i = 0; i<arr.length; i++) {
            for (int j = i+1; j<arr.length; j++) {
                if(arr[i].compareTo(arr[j])>0) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Content of File : ");
        for(int i = 0 ; i < arr.length ;i++)
        {
            System.out.print(arr[i] + "," + " ");
        }
        /*System.out.println(lines);*/

        System.out.println("\n Want to go to Main menu ? (Y/N) " );
        char abcd  = sc.next().charAt(0) ;
        if (abcd == 'y' || abcd == 'Y'){
            MENU(arr , lines , FILE_PATH) ;
        }
        else{
            System.out.println("Thank you for using our application !! ");
            System.exit(0);
        }
    }

    public static void SEARCH (String [ ]arr , List lines , String FILE_PATH) throws IOException {
        Scanner sc = new Scanner(System.in ) ;
        boolean flag = false ;
        System.out.println("Enter the ITEM you want to search in the File : ");
        String str = sc.next();

        //Implementing Linear Search !!
        for (int i = 0; i < arr.length; i++) {

            if ((str).equalsIgnoreCase(arr[i])) {
                flag = true ;
                System.out.println("ITEM is Present !! " );

            }
        }
        if(!flag) {
            System.out.println("ITEM Not Found !!");
        }

        System.out.println("\n Want to go to Main menu ? (Y/N) ");
        char abc  = sc.next().charAt(0) ;
        if (abc == 'y' || abc == 'Y'){
            MENU(arr ,lines ,FILE_PATH) ;
        }
        else{
            System.out.println("Thank You for Using our Application !!");
            System.exit(0) ;
        }
    }


    public static void MENU (String [ ]arr , List lines , String FILE_PATH) throws IOException {
        //Body Of Menu -->
        Scanner sc  =new Scanner(System.in) ;
        System.out.println("Select Options for Operation :  ");
        System.out.println(" 1> Display  \n 2> Add to File \n 3> Delete from file \n 4> Search Item \n Note: Enter (1 - 4) only !!");
        int k = sc.nextInt() ;
        if (k == 1) {
            DISPLAY(FILE_PATH);
        }
        else if (k ==2 ){
            ADD(arr , lines , FILE_PATH) ;
        }
        else if (k == 3) {
            DELETE(arr ,lines , FILE_PATH);
        }

        else if (k ==4){
            SEARCH(arr , lines , FILE_PATH);
        }

        else{
            System.out.println("WRONG choice exiting the program !!");
        }


    }
    public static void main(String[] args) throws IOException {

        System.out.println("****************** READ EACH COMMAND CAREFULLY BEFORE TAKING ACTION ******************");
        Scanner sc  =new Scanner(System.in) ;
        System.out.println("You want to \n 1> create a new file \n 2> give access to existing file ? \n Note : Enter (1/2) \n Note: format of path to be entered is --> D:\\FileHandlingDemo\\xyz.txt \n DO NOT put file name between \" \"   ");
        int qwe = sc.nextInt() ;
        String FILE_PATH = "" ;
        if(qwe == 1 ){
            System.out.println("Enter path detail where you want to create a file (Note that add \"extension\" to the file also !!) : " );
            FILE_PATH =  sc.next( );
            Path newFilePath = Paths.get(FILE_PATH)  ;
            Files.createFile(newFilePath) ;
            /*Reading Text File into List*/
            List<String> lines = Collections.emptyList() ;
            try {
                lines = Files.readAllLines(Paths.get(FILE_PATH), StandardCharsets.UTF_8);
            }
            catch (IOException e){
                e.printStackTrace () ;
            }
            //Converting to Array from list for Operations (It is my preference , I know we can do it directly by list only !!)
            String [] arr =  new String [lines.size()] ;
            for(int a = 0 ; a <lines.size() ; a++) {
                arr[a] = lines.get(a) ;
            }
            System.out.println("*****DEVELOPER'S DETAILS***** \n ABHISHEK SINHA \n Email --> sinha.abhishek18nov@gmail.com \n Application Name --> FileName Editor " );
            System.out.println("You want to launch Application (Y/N) ");
            String abc = sc.next() ;
            if ((abc.equalsIgnoreCase("y"))){
                MENU(arr , lines , FILE_PATH ) ;
            }
        }
        else if (qwe == 2 ){
            System.out.println("Enter the file path you want to access : ");
            FILE_PATH =  sc.next( );
            Path newFilePath = Paths.get(FILE_PATH)  ;
            /*Reading Text File into List*/
            List<String> lines = Collections.emptyList() ;
            try {
                lines = Files.readAllLines(Paths.get(FILE_PATH), StandardCharsets.UTF_8);
            }
            catch (IOException e){
                e.printStackTrace () ;
            }
            //Converting to Array from list for Operations (It is my preference , I know we can do it directly by list only !!)
            String [] arr =  new String [lines.size()] ;
            for(int a = 0 ; a <lines.size() ; a++) {
                arr[a] = lines.get(a) ;
            }

            System.out.println("*****DEVELOPER'S DETAILS***** \n ABHISHEK SINHA \n Email --> sinha.abhishek18nov@gmail.com \n Application Name --> FileName Editor " );
            System.out.println("You want to launch Application (Y/N)");
            String abc = sc.next() ;
            if ((abc.equalsIgnoreCase("y"))){
                MENU(arr , lines , FILE_PATH ) ;
            }
        }
        else{
            System.out.println("Wrong Choice Aborting the Application !!");
        }

    }
}
