package br.com.desafio.application;

import br.com.desafio.infra.FileRepository;

public class ApplicationStart {

  public static void main(String[] args) {
    final var fileRepository = new FileRepository();
    final var files = fileRepository.findAllFiles();

    ReportCreator reportCreator = new ReportCreator();
    reportCreator.create(files);
  }

}
