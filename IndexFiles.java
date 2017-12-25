//package lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;



// Index all text files under a directory.
 
public class IndexFiles {
  
  private IndexFiles() {}

  /** Index all text files under a directory. */
 public static void main(String[] args) {
	 
    String indexPath = "/home/rahul/java/lucene-5.0.0/indexdir";
    String docsPath = "/home/rahul/java/lucene-5.0.0/datadir";
    boolean create = true;


 final Path docDir = Paths.get(docsPath);
    if (!Files.isReadable(docDir)) {
      System.out.println("Document directory '" +docDir.toAbsolutePath()+ "' does not exist or is not readable, please check the path");
      System.exit(1);
    }
   
    Date start = new Date();
    try {
      System.out.println("Indexing to directory '" + indexPath + "'...");

      Directory dir = FSDirectory.open(Paths.get(indexPath));
      Analyzer analyzer = new StandardAnalyzer();
      IndexWriterConfig iwc = new IndexWriterConfig(analyzer);


      IndexWriter writer = new IndexWriter(dir, iwc);
      //here if try to pass docsPath instead of docDir we would get an error because string cant be treated like a path
      indexDocs(writer, docDir);

      writer.close();

      Date end = new Date();
      System.out.println(end.getTime() - start.getTime() + " total milliseconds");

    } catch (IOException e) {
      System.out.println(" caught a " + e.getClass() +
       "\n with message: " + e.getMessage());
    }
  }

  /**
   * Indexes the given file using the given writer, or if a directory is given,
   * recurses over files and directories found under the given directory.
   * 
   */

  static void indexDocs(final IndexWriter writer, Path path) throws IOException {
    
      File folder = new File("/home/rahul/java/lucene-5.0.0/datadir");
    File[] listOfFiles = folder.listFiles();

    String tempPath;


    for (File file : listOfFiles) {
        if (file.isFile()) {
      tempPath=file.getAbsolutePath();
         final Path docDir2 = Paths.get(tempPath);
            indexDoc(writer,docDir2);
        }
    }

} 

  
  static void indexDoc(IndexWriter writer, Path file) throws IOException {
    try (InputStream stream = Files.newInputStream(file)) {
      Document doc = new Document();
      
     // Add the path of the file as a field named "path".  Use a
      // field that is indexed (i.e. searchable), but don't tokenize 
      // the field into separate words.
      Field pathField = new StringField("path", file.toString(), Field.Store.YES);
      doc.add(pathField);
      
     
      // Add the contents of the file to a field named "contents".
      // Note that FileReader expects the file to be in UTF-8 encoding.
      // If that's not the case searching for special characters will fail.
      doc.add(new TextField("contents", new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))));
      
      if (writer.getConfig().getOpenMode() == OpenMode.CREATE) {
        // New index, so we just add the document (no old document can be there):
        System.out.println("adding " + file);
        writer.addDocument(doc);
      } else {
        // Existing index (an old copy of this document may have been indexed) so 
        // we use updateDocument instead to replace the old one matching the exact 
        // path, if present:
        System.out.println("updating " + file);
        writer.updateDocument(new Term("path", file.toString()), doc);
      }
    }
  }

}

