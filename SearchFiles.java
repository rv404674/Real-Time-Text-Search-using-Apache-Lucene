//package lucene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;


public class SearchFiles{


   void fnc(String guiInput) throws Exception {
//System.out.println(queryString);

 // public static void main(String[] args) throws Exception 
  
      String index = "/home/rahul/java/lucene-5.0.0/indexdir";
    String field = "contents";
    String queries = null;
    int repeat = 0;
    boolean raw = false;
    
   //pass arguement that you want to search 
    
    IndexReader reader= DirectoryReader.open(FSDirectory.open(Paths.get(index)));


    //standard analyzer ignores stop word
    IndexSearcher indexSearcher = new IndexSearcher(reader);
    Analyzer analyzer = new StandardAnalyzer();

    String queryString=guiInput;
    //field="contents",querString="computer"
    QueryParser parser= new QueryParser(field,analyzer);
    Query query=parser.parse(queryString);

    System.out.println("Searching for: " + query.toString(field));

    //First parameter is the query to be executed and second parameter is the no of search results to fetch
  TopDocs topDocs = indexSearcher.search(query, 20);
    System.out.println( topDocs.totalHits+ " total matching documents");

    int i=0;
    //get an array of reference to matched documents
    ScoreDoc[] scoreDocsArray=topDocs.scoreDocs;
    for(ScoreDoc scoredoc:scoreDocsArray){
        
        //retrieve matched documents and show relevant results
        //
        Document doc = indexSearcher.doc(scoredoc.doc);
       String path = doc.get("path");
        if (path != null) {
          System.out.println((i+1) + ". " + path);
          i++;
          String title = doc.get("title");
          if (title != null) {
            System.out.println("   Title: " + doc.get("title"));
          }
        } else {
          System.out.println((i+1) + ". " + "No path for this document");
        }
                  
      }
    }

  }

