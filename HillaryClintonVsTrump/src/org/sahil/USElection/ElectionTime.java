package org.sahil.USElection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ElectionTime 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		HowTrumpWins h1  =new HowTrumpWins("HillaryClinton", "Donald J.Trump",1000);
		System.out.println("Candidate1 Name :"+h1.candidate1);
		System.out.println("Candidate2 Name :"+h1.candidate2);
		System.out.println("Cuurent Voting :"+h1.Votes);

		FileOutputStream fos  =new FileOutputStream("F:/oracle/USElection/USElection.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(h1);
		
		FileInputStream fis = new FileInputStream("F:/oracle/USElection/USElection.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		HowTrumpWins h2 =(HowTrumpWins)ois.readObject();
		
		System.out.println("After Election votes are: "+h2.Votes);
	}
}
