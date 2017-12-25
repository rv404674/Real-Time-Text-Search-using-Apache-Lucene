import javax.swing.*;  
import java.awt.*;    
import java.io.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;
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



class FinalCode extends SearchFiles{
    
public int count =0;

FinalCode() throws Exception {    
JFrame f=new JFrame("Search Engine");            
JButton b=new JButton(new ImageIcon("search.png"));
b.setBounds( 800,80,400, 100); 

JButton b1= new JButton(new ImageIcon("exit.jpg"));    
b1.setBounds(1000,510,80,120);


//arguement is complicated
b1.addActionListener( new ActionListener(){
	 public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()==b1)
	  {
		  f.dispose();
	  }
    }
	
	
}  );

//
JButton b2= new JButton(new ImageIcon("rs.png"));
b2.setBounds(300,510,150,150);
//very complicated arguement
b2.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==b2)
		{   
     
	
count++; 
	JFrame fr = new JFrame();
	JLabel l2;
	l2=new JLabel("Reacent Search");
	l2.setFont(new Font("Comic Sans Ms",Font.PLAIN,36));
	l2.setForeground(Color.WHITE);

			
			//fr.setExtendedState(JFrame.MAXIMIZED_BOTH);  
fr.add(l2);
		
         fr.setTitle("recently search");
       fr.setSize(1200,800);
        fr.setLocationRelativeTo(null);
      // fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
         fr.setVisible(true);
		fr. setLayout(new BorderLayout());
        fr.setContentPane(new JLabel(new ImageIcon("finalb.jpg")));
       fr.setLayout(new FlowLayout());
		 fr.add(l2);
		// setText("yes it is"); 
//sqilite part ................
		

	//	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
            fr.setVisible(true);
	 
	
		}
	}
	
});


JButton b3= new JButton(new ImageIcon("deleteg.gif"));    
b3.setBounds(650,500,150,130);

b3.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent r)
	{
		if(r.getSource()==b3 )
		{ 
	  
			JFrame j2 = new JFrame("Deleted");
			
			j2.setLayout(new BorderLayout());
        j2.setContentPane(new JLabel(new ImageIcon("deleted.gif")));
		
	JLabel	l4=new JLabel("Everythings is now deleted");
	l4.setFont(new Font("Comic Sans Ms",Font.PLAIN,36));
	l4.setForeground(Color.BLACK);
	j2.add(l4);
     
			 j2.setLayout(new FlowLayout());
			 j2.setSize(480,480);
			  j2.setVisible(true);
	  }
		
		
	}
	
	
});

JLabel l1;
l1=new JLabel("Please search the result");

l1.setFont(new Font("Serif",Font.BOLD, 36));
l1.setForeground(Color.BLACK);
l1.setBounds(200,10,500,100);
 JTextField tf;

 tf=new JTextField();  
 tf.setFont(new Font("Serif",Font.BOLD, 36));
 
 tf.setBounds(200,80, 600,100);
         		   
         f.setLocationRelativeTo(null);
       //  f.setDefaultCloseOperation(EXIT_ON_CLOSE);
         f.setVisible(true);		
         f.setLayout(new BorderLayout());
         f.setContentPane(new JLabel(new ImageIcon("background2.jpg")));
         f.setLayout(new FlowLayout()); 
 f.add(tf);
f.add(l1);  
f.add(b);   
f.add(b1); 
f.add(b2);
f.add(b3);
//f.setSize(1000,1000);    
f.setLayout(null);    
f.setVisible(true);    


  f.setExtendedState(JFrame.MAXIMIZED_BOTH);  

f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
//sqlite part............



b.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent p)
    {
      if(p.getSource()==b)
	  {
try 
{  
//Class.forName("com.mysql.jdbc.Driver");  
  
//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rahul","root","tiger");  
  
//PreparedStatement stmt=con.prepareStatement("insert into Emp values(?,?)");  
String str1 = tf.getText( );
//queryString=str1;

SearchFiles obj=new SearchFiles();
obj.fnc(str1);

//int j=1;
//stmt.setInt(1,j);//1 specifies the first parameter in the query  
//stmt.setString(2,str1);  
//j++;
  
//int i=stmt.executeUpdate();  


//System.out.println(i+" records inserted");  

	  
    
	
	

//con.close();  
}
	  
catch(Exception e){ System.out.println(e);}  
  
	  }}}
   
);


/*System.out.println("if you want to delete the coloumn press y else n \n");
Scanner sc = new Scanner( System.in);
String str = sc.next( );
if(str.equals("y"))
{
	
 stmt=con.prepareStatement("delete from emp where id=?");  
stmt.setInt(1,101);  
  
 i=stmt.executeUpdate();  
System.out.println(i+" records deleted"); 
}
*/
  

             
  
}

public static void main(String[] args) throws Exception
{    
    new FinalCode();    
}  

//end one is class bracket
}

