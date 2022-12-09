package com.webhooks.service;


//import com.crud.demo.crud.repository.DepartmentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webhooks.dto.getAssetDetails;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

@Service
public class DepartmentServiceImpl  {

    @Autowired
    RestTemplate restTemplate;
    private Object getAssetDetails;

    public static String hello()
        {
            return "Hello There!";
        }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {

        InputStream is = new URL(url).openStream();
        try {

//            ObjectMapper objectMapper= new ObjectMapper();
//            HttpHeaders httpHeaders new HttpHeaders();



            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public void getassets() throws JsonProcessingException {
        final String URL = "https://api.cimediacloud.com/assets/554c3cdc348e4ff7a0a03ac6c1f7bbec";
        ObjectMapper mapper = new ObjectMapper();
        String jsonFormat = mapper.writeValueAsString(getAssetDetails);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBearerAuth("Bearer " + "66af261325a54f82bf0e32c48505f02f");
        HttpEntity<String> entity = new HttpEntity<>(jsonFormat, httpHeaders);
        System.out.println("Sending API request to Sony Ci");
        ResponseEntity<getAssetDetails> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, entity, new ParameterizedTypeReference<>() { });

    }

}
