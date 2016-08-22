package dev.kyuelin.twos.queuecomp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStreamDemo implements Serializable {
	public static void main(String[] args) {
		ObjectStreamDemo ob = new ObjectStreamDemo();
		
		try {
			FileOutputStream fos = new FileOutputStream("obj.tmp");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			FileInputStream fis = new FileInputStream("obj.tmp");

			ObjectInputStream ois = new ObjectInputStream(fis);

			oos.writeObject(ob);
			oos.writeObject(new ObjectStreamDemo());

			ObjectStreamDemo ob2 = (ObjectStreamDemo) ois.readObject();
			ObjectStreamDemo ob3 = (ObjectStreamDemo) ois.readObject();

			System.out.println(ob2==ob3);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
