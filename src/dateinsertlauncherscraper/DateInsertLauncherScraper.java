package dateinsertlauncherscraper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class DateInsertLauncherScraper 
{
    public static void main(String[] args) throws IOException, InterruptedException, InterruptedException {
       int counteroftheloop  = 0;
       int loopcap = 10;
       int subloopcount = 0;
       int typecounter = 0;
       String[] URLHolderArrayL = new String[22]; 
       File file3 = new File("C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\DateInsertLauncherScraper\\DateInsertLauncherScraperFileArea\\urlstoscrape.txt");
       File UrlLoaderFile = new File("C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\DateInsertLauncherScraper\\DateInsertLauncherScraperFileArea\\UrlLoader.txt");
       BufferedReader br3 = new BufferedReader(new FileReader(file3));
       String Manipulator = "";     
       
        //Read the url list and populate current url with scraping url.
	String line3;
	while ((line3 = br3.readLine()) != null) 
            {          
            if(subloopcount == 11)
            {
                subloopcount = 0;                
            }
            
            URLHolderArrayL[subloopcount] = line3;
                
             subloopcount++;
            }
             subloopcount = 0;
             br3.close();

                   while (counteroftheloop != loopcap)
                {  
                if(counteroftheloop < 6)
                {
                System.out.println("Launching Date_Inserts_Scraper_Type 1");            
                // Run Date Insert Scraper 1
                Process proc = Runtime.getRuntime().exec("java -jar C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\DateInsertLauncherScraper\\DateInsertLauncherScraperFileArea\\Date_Inserts_Scraper_Type1.jar");
                InputStream in = proc.getInputStream();
                InputStream err = proc.getErrorStream();     
                }
                if(counteroftheloop == 6)
                {
                System.out.println("Launching Date_Inserts_Scraper_Type 2");            
                // Run Date Insert Scraper 2
                Process proc = Runtime.getRuntime().exec("java -jar C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\DateInsertLauncherScraper\\DateInsertLauncherScraperFileArea\\Date_Inserts_Scraper_Type2.jar");
                InputStream in = proc.getInputStream();
                InputStream err = proc.getErrorStream();       
                }
                if(counteroftheloop > 6)
                {
                System.out.println("Launching Date_Inserts_Scraper_Type 2");            
                // Run Date Insert Scraper 2
                Process proc = Runtime.getRuntime().exec("java -jar C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\DateInsertLauncherScraper\\DateInsertLauncherScraperFileArea\\Date_Inserts_Scraper_Type2.jar");
                InputStream in = proc.getInputStream();
                InputStream err = proc.getErrorStream();       
                }
                //Give it time to run
                TimeUnit.SECONDS.sleep(120);                 
                    
                //Move Number Matching URL name from URLHolder Array To Manipulator                       
               Manipulator = URLHolderArrayL[counteroftheloop];
               System.out.println(Manipulator);
               
               //Write URL TO UrlLoader.txt for LeonardScraper2 To Use On Next Iteration
                   FileWriter fw3 = new FileWriter(UrlLoaderFile);
                   PrintWriter out3 = new PrintWriter(fw3);     
                   out3.print(Manipulator);
                    out3.flush(); 
                     out3.close();
                     fw3.close();                
                
                counteroftheloop++;
                }
                   //Reset UrlLoader.txt for next use
                   FileWriter fw3 = new FileWriter(UrlLoaderFile);
                   PrintWriter out3 = new PrintWriter(fw3);     
                   out3.print("http://www.pcs-company.com/viewproduct/mold-components/mold-date-(amp)-recycling-inserts/pcs-date-stamps/standard-date-stamps/CSM");
                    out3.flush(); 
                     out3.close(); 
                     fw3.close();     
                     
                //Launch The Combiner
                Process proc = Runtime.getRuntime().exec("java -jar C:\\Users\\tremanleo\\Documents\\NetBeansProjects\\DateInsertLauncherScraper\\DateInsertLauncherScraperFileArea\\DateScraperCSVCombiner.jar");
                InputStream in2 = proc.getInputStream();
                InputStream err2 = proc.getErrorStream();  
    }    
}