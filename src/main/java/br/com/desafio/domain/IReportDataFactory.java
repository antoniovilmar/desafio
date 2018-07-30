package br.com.desafio.domain;

public interface IReportDataFactory<T extends IDataReport> {

  T create(String lista);

}