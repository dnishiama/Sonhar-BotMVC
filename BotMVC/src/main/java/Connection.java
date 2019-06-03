import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Connection{

    private final String USER_AGENT = "Mozilla/5.0";
    String url1;
    // HTTP GET request
    
    public String sendGetVol(String url2) throws Exception {

        //pedir variavel nome
    	url1 = url2;
    	try {
    	String url = "http://127.0.0.1:2323/volu/" + url2;
    	
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL: " + url);
        System.out.println("Response Code: " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("Response: " + response.toString());

        String found = findvol(new JSONArray(response.toString()));

        return found;
        
    	}catch (JSONException e) {
            return null;
        }        
    }
    
    public String findvol(JSONArray response) {
        String email = null;
        try {
        	for (int i = 0; i < response.length(); i++) {
	        	JSONObject obj = response.getJSONObject(i);
	            email = obj.getString ("email");
        	}
        	return email;        	

        } catch (JSONException e) {
            return null;
        }
    }

    public int sendGetCri(String url2) throws Exception {

        //pedir variavel nome
    	url1 = url2;
    	try {
    	String url = "http://127.0.0.1:2323/cri/" + url2;
    	
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL: " + url);
        System.out.println("Response Code: " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("Response: " + response.toString());

        int found = findcri(new JSONArray(response.toString()));
        return found;
        
    	}catch (JSONException e) {
            return 0;
        }        
    }

    public int findcri (JSONArray response) {
        int idade = 0;
        try {
           	for (int i = 0; i < response.length(); i++) {
	        	JSONObject obj = response.getJSONObject(i);
	        	idade = obj.getInt("idade");
        	}
        	return idade;        	

        } catch (JSONException e) {
            return idade;
        }
    }

    public String sendGetLoc(String url2) throws Exception {

        //pedir variavel nome
    	url1 = url2;
    	try {
    	String url = "http://127.0.0.1:2323/loca/" + url2;
    	
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL: " + url);
        System.out.println("Response Code: " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("Response: " + response.toString());

        String found = findloc(new JSONArray(response.toString()));

        return found;
        
    	}catch (JSONException e) {
            return null;
        }        
    }
    
    public String findloc(JSONArray response) {
        String endereco = null;
        try {
        	for (int i = 0; i < response.length(); i++) {
	        	JSONObject obj = response.getJSONObject(i);
	        	endereco = obj.getString ("endereco");
        	}
        	return endereco;        	

        } catch (JSONException e) {
            return null;
        }
    }

}
