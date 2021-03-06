package test.java.framework;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpSession {
  private CloseableHttpClient httpclient;
  private ApplicationManager app;


  public HttpSession(ApplicationManager app) {
    httpclient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
    this.app = app;
  }


  public boolean isLanguageSelected(String lang, String title) throws IOException {
    HttpGet get = new HttpGet(app.getProperty("web.baseUrl") +lang);

    CloseableHttpResponse response = httpclient.execute(get);
    String head = getTextFrom(response);

    return  head.contains(String.format("<title>%s</title>", title));
  }

  private String getTextFrom(CloseableHttpResponse response) throws IOException {
    try {
      return EntityUtils.toString(response.getEntity());
    } finally {
      response.close();
    }
    }
  }

