package dev.kyuelin.structures.trie;

/**
 * Created by linken on 10/6/15.
 */
public class TrieNode {
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    private String url;
    private TrieNode[] children;
    private boolean isLeaf;

    TrieNode() {
        this.url=null;
        this.setIsLeaf(false);
        children = new TrieNode[11];
        for(int i=0; i<children.length; ++i) {
            children[i]=null;
        }
    }

    public static void insert(TrieNode root, String ipAdd, String url) {
        int len = ipAdd.length();
        TrieNode crawl = root;

        for (int level=0; level<len; level++)
        {
            int index = getIndex(ipAdd.charAt(level)) ;

            if(null == crawl.getChildren()[index]) {
                crawl.getChildren()[index] = new TrieNode();
            }
            crawl = crawl.getChildren()[index];
        }

        crawl.setIsLeaf(true);
        crawl.setUrl(url);
    }

    public static String searchDNSCache(TrieNode root, String ipAdd) {
       TrieNode crawl = root;
        int len = ipAdd.length();

        for(int level=0; level<len; level++) {
            int index = getIndex(ipAdd.charAt(level));
            if (null == crawl.getChildren()[index])
                return null;
            crawl = crawl.getChildren()[index];
        }
        if (null != crawl && crawl.isLeaf()) {
            return crawl.getUrl();
        }
        return null;
    }

    public static int getIndex(char c) {
        return (c == '.') ? 10 : (c - '0');
    }

    public static char getCharFromIndex(int i) {
        return (i==10) ? '.' : (char) ('0' + i);
    }

    public static void main(String[] args) {
        String[] ipAdd = {"107.108.11.123", "107.109.123.255",
                "74.125.200.106"};
        String[] url = {"www.samsung.com", "www.samsung.net",
                "www.google.in"};
        int n = ipAdd.length;
        TrieNode root = new TrieNode();

        for(int i=0; i<n; i++) {
           insert(root, ipAdd[i], url[i]);
        }

        String ip = "107.108.11.123";
        String res_url = searchDNSCache(root, ip);
        if (null != res_url) {
            System.out.printf("Reverse DNS look up resolved in cache:\n%s --> %s",
                    ip, res_url);
        }
        else
            System.out.println("Reverse DNS look up not resolved in cache ");
    }

}
