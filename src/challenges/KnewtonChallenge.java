package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class KnewtonChallenge {
	
    private static Log logger = LogFactory.getLog(KnewtonChallenge.class);

	// 1. read files
	// 2. foreach line create a runnable task to add compounded names into a map
	// 3. create executor 
	// 4. create completionservice for executor
	// 5. add runnable to executor
	// 6. start processes
	// 7. loop through map for name pair with count of lines > 50
	public static void main(String[] args) {
		
		Path file=Paths.get("C:\\Users\\linken\\Downloads\\Artist_lists_small.txt");
		Charset charset = Charset.forName("UTF-8");
		List<String> lines = new ArrayList<String>(100);
		
		long start=System.currentTimeMillis();
		
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	lines.add(line.trim());
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		
		Map<String, List<Integer>> map = new ConcurrentHashMap<String, List<Integer>>(); 
		
//		int nThreads=lines.size();
//		ExecutorService executor = Executors.newFixedThreadPool(nThreads);
		
		KnewtonChallenge kc = new KnewtonChallenge();
		
		for (int i=0; i<lines.size(); ++i) {
//			executor.execute(kc.new MyRunnable(lines.get(i), map, i));
			Thread t = new Thread(kc.new MyRunnable(lines.get(i), map, i));
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Iterator<Entry<String, List<Integer>>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, List<Integer>> entry = iterator.next();
			if (entry.getValue().size() >= 50) {
				logger.info(entry.getKey()+ ":" + entry.getValue().size());			
			}
		}
		logger.info("map size:"+map.entrySet().size());
		logger.info("program completed in : " + Long.toString(System.currentTimeMillis()-start) + "seconds.");
	}

	class MyRunnable implements Runnable {

		Map<String, List<Integer>> map;
		String in;
		Integer line_no;
		
		public MyRunnable(String input, Map<String, List<Integer>> m, int lno) {
			map=m;
			in=input;
			line_no=new Integer(lno);
		}
		
		@Override
		public void run() {
			String[] inp = in.split(",");
			for (int x=0; x<inp.length;x++) {
				for (int y=x+1; y<inp.length; y++) {
					String key = inp[x]+","+inp[y];
						if (map.containsKey(key)) {
							map.get(key).add(line_no);
						}
						else {
							synchronized (map) {
								List<Integer> list = new LinkedList<Integer>();
								list.add(line_no);
								map.put(key, list);		
						}
					}
				}
			}
		}
		
	}

}
