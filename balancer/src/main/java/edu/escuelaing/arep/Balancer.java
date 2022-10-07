package edu.escuelaing.arep;

import static spark.Spark.*;

import java.io.*;
import java.net.*;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.text.Position;

public class Balancer {

    private static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>() {
        {
            add("1");
            add("2");
            add("3");
        }
    };

    public static void main(String[] args) {
        staticFiles.location("/public");
        port(getPort());
        post("/balancer", (req, res) -> {
            res.header("Access-Control-Allow-Origin","*");
            res.type("application/json");
            return balancer(req.queryParams("value"));
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    public static String balancer(String a) {
        String temp = queue.poll();
        queue.add(temp);
        return doPost(a, temp);
    }

    public static String doPost(String a,String f) {
        String linea = "";
        try {
            String data = "value="+a;
            System.out.println(f);
            URL url = new URL("http://backend"+f+":3500"+f);
            System.out.println(url.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.getOutputStream().write(data.getBytes("UTF-8"));
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            linea = reader.readLine();
            reader.close();
        } catch (MalformedURLException me) {
            System.err.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.err.println("IOException:  " + ioe);
        }
        return linea;
    }
}
