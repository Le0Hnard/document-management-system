package src.main.com.demo.documentmanagementsystem;

import java.io.File;
import java.io.IOException;

public interface Importer {

    Document importFile(File file) throws IOException;

}
