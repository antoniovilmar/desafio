package br.com.desafio.domain;

public interface IDataReport {

  default IGroupDataReport group() {
    return null;
  }

}
