package br.com.desafio.domain;

public interface IGroupDataReport<T extends IDataReport> extends IDataReport {

  void add(T t);

}
