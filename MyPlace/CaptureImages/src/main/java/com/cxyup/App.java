package com.cxyup;

import java.io.IOException;

/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        int imagePage=0;
        int folderPage=1;
        int[] years={2015,2016,2017,2018};
        int year=0;
        int count=1296;
      CatchImage catchImage= new CatchImage();
      while (--count!=0){
              while (catchImage.execute(++imagePage, folderPage,years[year])){
                  if (folderPage==489){
                      year++;
                  }
                  if (folderPage==862){
                      year++;
                  }
                  if (folderPage==1215){
                      year++;
                  }
              }
                ++folderPage;
                imagePage=1;
      }
    }
}
