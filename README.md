# Real-Time-Text-Search-using-Apache-Lucene

## Description
Apache Lucene is a high performance , information Retrieval (IR) library. Information retreival is the process for searching
for documents, information within documents , or metadata about documents.
Instead of normal indexing ,it uses INVERTED INDEXING for achieving higher search speeds.The whole project is based on this idea.

## Installation
1. jdk and jre (build > 1.8.0)
2. Apache lucene 5.0.0

Install jdk ,jre using ```sudo apt-get install openjdk-7-jre ```.
Download lucene 5.0.0 and extract it in your current directory.

### Usage
Download the ```test data``` directory and rename it as ```data dir```. 
Paste the contents of setpath on terminal(for ubuntu) .

If you are using windows/an ide ,add given files into classpath
1. lucene-5.0.0/queryparser/lucene-queryparser-5.0.0.jar
2. lucene-5.0.0/analysis/common/lucene-analyzers-common-5.0.0.jar 
3. core/lucene-core-5.0.0.jar 
4. lucene-demo-5.0.0.jar

Now run index.java. Index.java takes raw txt files from data dir and creates another directory ```index dir``` ,that contains
an index made from txt files.
After that run ```Search.java``` to perform search on the text files in data dir.
To perform search write ```java search virus```.
Here virus is the word you want to be searched.

At last ,run ```FinalCode.java``` to add gui using swing.
