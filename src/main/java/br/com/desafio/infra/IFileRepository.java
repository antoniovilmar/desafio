package br.com.desafio.infra;

import br.com.desafio.domain.Report;
import java.io.File;
import java.util.List;

public interface IFileRepository {

  List<File> findAllFiles();

  void saveReport(Report report);

}
