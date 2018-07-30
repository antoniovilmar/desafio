package br.com.desafio.domain.factory;

import br.com.desafio.domain.IDataReport;

public interface IReportDataFactory<T extends IDataReport> {

  T create(String lista);

}