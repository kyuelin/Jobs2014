package dev.kyuelin.twos.queuecomp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		final double[] prices1 = {4.9, 5.99, 9.99, 13.99, 15.99 };
		final double[] prices2 = {4.8, 5.9, 9.79, 10.99, 14.99, 15 };
		
		DataOutputStream oos1 = new DataOutputStream(new FileOutputStream("test1.txt"));
		DataOutputStream oos2 = new DataOutputStream(new FileOutputStream("test2.txt"));

		for(double d: prices1) {
			oos1.writeDouble(d);
		}
		oos1.close();
		
		for(double d: prices2) {
			oos2.writeDouble(d);
		}
		
		oos2.close();
		
		class T implements Runnable {			
			private DataInputStream dis;
			private BlockingQueue<Double> q1, q2;
			//private double unit_of_incrementaion = 0.1;
			private double gap = 0.9;
			
			T(DataInputStream dis, BlockingQueue<Double> q1, BlockingQueue<Double> q2) {
				this.dis = dis;
				this.q1 = q1;
				this.q2 = q2;
			}
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					double d = 0;
					try {
						d = dis.readDouble();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						try {
							dis.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					}
					q1.add(d);
					while(!q2.isEmpty() && (Math.abs(d-(double)q2.peek()) > gap )) {
						q2.poll();
					}
					
					for(double d2 : q2) {
						if (Math.abs(d-d2) <= gap) {
							System.out.println(d + ":" + d2 + ":" + Math.abs(d-d2) );
						}
					}
				}
				
			}
		}
		
		BlockingQueue<Double> q1 = new LinkedBlockingQueue<Double>();
		BlockingQueue<Double> q2 = new LinkedBlockingQueue<Double>();

		DataInputStream dis1 = new DataInputStream(new FileInputStream("test1.txt"));
		DataInputStream dis2 = new DataInputStream(new FileInputStream("test2.txt"));
		Thread d1 = new Thread(new T(dis1, q1, q2));		
		Thread d2 = new Thread(new T(dis2, q2, q1));
		
		d1.start();
		d2.start();
		
		d1.join();
		d2.join();

	}

}
