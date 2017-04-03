package dev.kyuelin.challenges;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KnewtonChallenge {

	private static Logger logger = LoggerFactory.getLogger(KnewtonChallenge.class);

	// 1. read files
	// 2. foreach line create a runnable task to add compounded names into a map
	// 3. create executor
	// 4. create completionservice for executor
	// 5. add runnable to executor
	// 6. start processes
	// 7. loop through map for name pair with count of lines > 50
	public static void main(String[] args) {

		Path file = Paths
				.get("/Users/kennethlin/git/Jobs2014/src/challenges/Artist_lists_small.txt");
//				.get("D:\\linken\\Workspace\\Jobs2014\\src\\challenges\\Artist_lists_small.txt");
		Charset charset = Charset.forName("UTF-8");

		long start = System.currentTimeMillis();

		KnewtonChallenge kc = new KnewtonChallenge();
		Map<String, List<Integer>> map = new ConcurrentHashMap<String, List<Integer>>();

		int nThreads = 8;
		ExecutorService executor = Executors.newFixedThreadPool(nThreads);

		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				executor.submit(kc.new MyRunnable(line.trim(), map, i++));
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}

		executor.shutdown();
		while (!executor.isTerminated())
			;

		Iterator<Entry<String, List<Integer>>> iterator = map.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, List<Integer>> entry = iterator.next();
			if (entry.getValue().size() >= 50) {
				logger.info(entry.getKey() + ":" + entry.getValue().size());
			}
		}
		logger.info("map size:" + map.entrySet().size());
		logger.info("program completed in : "
				+ Long.toString(System.currentTimeMillis() - start) + "ms.");
	}

	class MyRunnable implements Runnable {

		Map<String, List<Integer>> map;
		String in;
		Integer line_no;

		public MyRunnable(String input, Map<String, List<Integer>> m, int lno) {
			map = m;
			in = input;
			line_no = new Integer(lno);
		}

		@Override
		public void run() {
			String[] inp = in.split(",");
			Arrays.sort(inp);
			for (int x = 0; x < inp.length; x++) {
				for (int y = x + 1; y < inp.length; y++) {
					String key = inp[x] + "," + inp[y];
					if (map.containsKey(key)) {
						map.get(key).add(line_no);
					} else {
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
