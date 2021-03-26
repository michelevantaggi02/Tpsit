package tpsit;

import java.io.FileWriter;
import java.io.IOException;

public class Run{

    public static void main(String[] args){

        Person michele = new Person("Michele", "Vantaggi", "13-07-2002", "Java","JavaScript","PHP");

        
        try {
        	FileWriter writer = new FileWriter("C:/Users/michi/person.txt");
			writer.write(michele.name+"\n");
            writer.write(michele.surname+"\n");
            writer.write(michele.birthday+"\n");
            writer.write(michele.languages+"\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}