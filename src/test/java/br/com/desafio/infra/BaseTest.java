package br.com.desafio.infra;

public abstract class BaseTest {

  protected String getResourceLocal(String path) {
    return ClassLoader.getSystemResource(path).getPath();
  }
}
