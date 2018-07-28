package br.com.desafio.infra;

public abstract class BaseFileRepository {

  private String inputFilePath = getPathUserHome().concat("/data/in");
  private String outputFilePath = getPathUserHome().concat("/data/out");

  private static String getPathUserHome() {
    return System.getProperty("user.home");
  }

  public String getInputFilePath() {
    return inputFilePath;
  }

  public String getOutputFilePath() {
    return outputFilePath;
  }
}
