package br.com.desafio.application;

import br.com.desafio.domain.Layout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReportCreator {

  public void create(List<File> files) {
    files.stream().forEach(file -> {
      try {
        Files.readAllLines(file.toPath()).forEach(line -> {
          Layout.solveFactory(line).ifPresent(layoutFactory -> layoutFactory.create(line));
        });
      } catch (IOException e) {

      }

    });

  }
}
