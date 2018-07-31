package br.com.desafio.application;

import br.com.desafio.infra.FileRepository;
import java.io.IOException;

public class ApplicationStart {

  public static void main(String[] args) throws IOException, InterruptedException {

    final var fileRepository = new FileRepository();
    final var reportCreator = new ReportCreator(fileRepository);
    WatchService watchService = new WatchService(reportCreator, fileRepository);
    reportCreator.create();
    watchService.observer();


  }


}


