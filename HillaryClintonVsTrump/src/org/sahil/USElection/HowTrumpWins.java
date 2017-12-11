package org.sahil.USElection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HowTrumpWins implements Serializable
{
	String candidate1;
	String candidate2;
	transient int Votes;
	
	public HowTrumpWins(String candidate1,String candidate2 ,int votes)
	{
		this.candidate1=candidate1;
		this.candidate2=candidate2;
		this.Votes=votes;
	}
	
	private void writeObject(ObjectOutputStream os) throws IOException
	{
		os.defaultWriteObject();
		int EncryptedVotes = 1000+Votes;
		os.writeInt(EncryptedVotes);
	}

	private void readObject(ObjectInputStream is) throws Exception
	{
		is.defaultReadObject();
		int EncryptedVotes =is.readInt();
		Votes =EncryptedVotes-1000;
	}
}
