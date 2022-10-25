package com.silkimen.http;

import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLStreamHandler;
import java.net.Proxy;

public class OkConnectionFactory implements HttpRequest.ConnectionFactory {

  public HttpURLConnection create(URL url) throws IOException {

    return (HttpURLConnection) url.openConnection();
  }

  public HttpURLConnection create(URL url, Proxy proxy) throws IOException {
    OkHttpClient clientWithProxy = new OkHttpClient.Builder().proxy(proxy).build();
    HttpURLConnection urlFactory = (HttpURLConnection) url.openConnection(proxy);

    return urlFactory;
  }
}

