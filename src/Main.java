import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int size;
        int index;
        boolean isTrue = true;

        System.out.println("eneter the bitvector size");
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        BitVector bitVector = new BitVector(size);

        String toDo;
        do {
            System.out.println("enter the index (from 0 to " + (size - 1) + ')');

            index = sc.nextInt();
            if (index >= size) {
                throw new ArrayIndexOutOfBoundsException("Please enter the valid index");

            }
            sc.nextLine();
            System.out.println("enter what you want to do - set - 1 , reset - 2 or save - 0 ");

            toDo = sc.nextLine();
/*
            if(toDo == "1"){
                System.out.println("barev");
            }else if ( toDo == "2") {
                bitVector.reset(index);
            }
 */
            switch (toDo) {
                case "1" -> bitVector.set(index);
                case "2" -> bitVector.reset(index);
                case "0" -> {

                    isTrue = false;
                }
                default -> System.out.println("no such operation");
            }


        }
        while (isTrue);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("bitvector.txt"));
            writer.write(bitVector.toString());
            writer.close();
//            File file = new File("bitvector.txt");
//            FileWriter fileWriter = new FileWriter(file);
//            fileWriter.write(bitVector.toString());
//            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}