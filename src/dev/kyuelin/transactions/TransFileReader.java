package dev.kyuelin.transactions;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;
import org.slf4j.Logger;

public class TransFileReader {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TransFileReader.class);

    private BeanReader reader = null;
    private String transBIOConfig = "transactions.xml";

    public static void main(String[] args) {
        TransFileReader reader = new TransFileReader();
        //reader.init("/Users/kennethlin/Google Drive/19204/archive/transactions_1712.csv");
        reader.init(args);
    }

    private void init(final String[] args) {
        StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource(transBIOConfig);
        InputStream in = this.getClass().getResourceAsStream(args[1]);
        reader = factory.createReader("transactions", new InputStreamReader(in));
    }

    //"Date","Description","Original Description","Amount","Transaction Type","Category","Account Name","Labels","Notes"

    public List<Transaction> readTransList() {
        List<Transaction> transactionList = new ArrayList<>();
        Object record;
        if (null != reader) {
            while ((record = reader.read()) != null) {
                if ("detail".equals(reader.getRecordName())) {
                    Transaction transaction = (Transaction) record;
                    transactionList.add(transaction);
                }
            }
            LOGGER.info(transactionList.stream().toString());
        }
        return transactionList;
    }


}
