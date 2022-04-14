package thk.hive;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONArray;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.CompareFilter;

public class TestClient {

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);
            server.createContext("/api/v1/users", new MyHandler());
            server.setExecutor(null); // creates a default executor
            server.start();
        } catch (IOException e) {
            System.out.println("err");
            e.printStackTrace();
        }
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            Map <String,String>parms = TestClient.queryToMap(t.getRequestURI().getQuery());

            String country =  parms.getOrDefault("country", "");
            String gender =  parms.getOrDefault("gender", "");

            TestClient app = new TestClient();
            JSONArray arr = app.test(country, gender);

            String rr = arr.toString();

            t.sendResponseHeaders(200, rr.length());
            t.getResponseHeaders().set("Content-Type", "application/json");
            OutputStream os = t.getResponseBody();
            
            os.write(rr.getBytes());
            os.close();
        }
    }

    public JSONArray test(String country, String gender) {
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "hbase");
        conf.set("hbase.zookeeper.property.clientPort","2181");

        JSONArray data = new JSONArray();

        try (Connection conn = ConnectionFactory.createConnection(conf)) {
            Table table = conn.getTable(TableName.valueOf("users_hbase"));

            // SCAN
            System.out.println("scan: ");

            Scan scan = new Scan();
            //scan.setRowPrefixFilter("");
            //Scan scan = new Scan().withStartRow(Bytes.toBytes(rowStart + "_" + country + "_00_*")).withStopRow(Bytes.toBytes(rowEnd + "_" + country + "_00_*"));

            SingleColumnValueFilter f0 = new SingleColumnValueFilter(Bytes.toBytes("cf"), Bytes.toBytes("country"), CompareFilter.CompareOp.EQUAL, Bytes.toBytes(country));
            SingleColumnValueFilter f1 = new SingleColumnValueFilter(Bytes.toBytes("cf"), Bytes.toBytes("gender"), CompareFilter.CompareOp.EQUAL, Bytes.toBytes(gender));
            FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);
            filterList.addFilter(f0);
            filterList.addFilter(f1);

            scan.setFilter(filterList);
            scan.setCaching(100000);
            scan.setLimit(5);

            //scan.setFilter(new PageFilter(5));
            ResultScanner rs = table.getScanner(scan);
            //for (Result rv : rs) {
            for (Result result = rs.next(); (result != null); result = rs.next()) {
                JSONObject jo = new JSONObject();
                jo.put("user_id", Bytes.toString(result.getValue(Bytes.toBytes("cf"), Bytes.toBytes("user_id"))));
                jo.put("gender", Bytes.toString(result.getValue(Bytes.toBytes("cf"), Bytes.toBytes("gender"))));
                jo.put("email", Bytes.toString(result.getValue(Bytes.toBytes("cf"), Bytes.toBytes("email"))));

                data.put(jo);
            }
            System.out.println("done");
            table.close();

            return data;
        } catch (IOException e) {
            System.out.println("err");
            e.printStackTrace();
        }

        return data;
    }

    /**
     * returns the url parameters in a map
     * @param query
     * @return map
     */
    public static Map<String, String> queryToMap(String query){
        Map<String, String> result = new HashMap<String, String>();
        for (String param : query.split("&")) {
            String pair[] = param.split("=");
            if (pair.length>1) {
                result.put(pair[0], pair[1]);
            } else {
                result.put(pair[0], "");
            }
        }
        return result;
    }
}
