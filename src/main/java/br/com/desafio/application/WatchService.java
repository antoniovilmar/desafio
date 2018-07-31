package br.com.desafio.application;

import br.com.desafio.infra.FileRepository;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.util.List;

public class WatchService {

  private static System.Logger LOGGER = System.getLogger(WatchService.class.getName());
  private IReportCreator reportCreator;
  private FileRepository fileRepository;

  public WatchService(IReportCreator reportCreator, FileRepository fileRepository) {
    this.reportCreator = reportCreator;
    this.fileRepository = fileRepository;
  }

  public void observer() throws IOException, InterruptedException {
    Path path = Paths.get(fileRepository.getInputFilePath());
    FileSystem fileSystem = FileSystems.getDefault();
    java.nio.file.WatchService watchService = fileSystem.newWatchService();
    path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
        StandardWatchEventKinds.ENTRY_MODIFY);
    while (true) {
      WatchKey watchKey = watchService.take();
      List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
      for (WatchEvent<?> we : watchEvents) {
        if (we.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
          LOGGER.log(Level.INFO, "Created: " + we.context());
          LOGGER.log(Level.INFO, "Lendo diretório..");
          reportCreator.create();
          System.out.println("Created: " + we.context());
        } else if (we.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
          LOGGER.log(Level.INFO, "Modified: " + we.context());
          LOGGER.log(Level.INFO, "Lendo diretório..");
          reportCreator.create();
        }
      }
      if (!watchKey.reset()) {
        break;
      }
    }
  }
}
