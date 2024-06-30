package src.main.com.demo.documentmanagementsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentManagementSystem {

    private List<Document> documents = new ArrayList<>();
    private Map<String, Importer> extensionToImporter = new HashMap<>();

    public DocumentManagementSystem() {
        extensionToImporter.put("jpg", new ImageImporter());
    }

    public void importFile(String path) throws IOException {
        File file = new File(path);

        if (!file.exists()) {
            throw new FileNotFoundException(path);
        }

        int separatorIndex = path.lastIndexOf(".");
        if (separatorIndex != -1) {
            if (separatorIndex == path.length()) {
                throw new UnknownFileTypeException("No extension found for file: " + path);
            }

            String extension = path.substring(separatorIndex + 1);
            Importer importer = extensionToImporter.get(extension);

            if (importer == null) {
                throw new UnknownFileTypeException("For file: " + path);
            }

            Document document = importer.importFile(file);
            documents.add(document);
        } else {
            throw new UnknownFileTypeException("No extension found for file: " + path);
        }
    }

    public List<Document> contents() {
        return new ArrayList<>();
    }

}
