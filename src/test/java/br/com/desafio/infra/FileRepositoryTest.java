package br.com.desafio.infra;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileRepositoryTest extends BaseTest {

  private FileRepository fileRepository;


  @Before
  public void setUp() throws Exception {
    fileRepository = new FileRepository();
  }

  @Test
  public void shouldReturnOneFile() throws IOException {
    fileRepository = spy(fileRepository);
    when(fileRepository.getInputFilePath()).thenReturn(this.getResourceLocal("mockFiles"));
    final List<File> files = fileRepository.findAll();

    Assert.assertEquals(1, files.size());
  }

}