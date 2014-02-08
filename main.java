import java.io.*;

class srcTable1{
    int index;
    int hash_value;
    int line_no;
   };
   
class srcTable2{
    int index;
    int hash_value;
    int line_no;
   };
   
public class main {
	public static Integer ctr1,ctr2;
	public static void main(String[] args) {
        
        
    for (ctr1=1; ctr1<10; ctr1++)
    {
    	for (ctr2=ctr1+1; ctr2<=10; ctr2++)
    	{
        
        
    String src1, src2 ;
    char current; 
    int line = 1, i = 0 , char_cnt1 = 0, char_cnt2 = 0 , m = 0 ;
    int arr_newline1[] = new int[1000];
    int arr_newline2[] = new int[1000];
    
    
//    File filein1 = new File("biggest.c");
//    File filein2 = new File("big.c");

	File filein1 = new File(ctr1.toString()+".txt");
    File filein2 = new File(ctr2.toString()+".txt");
   	File fileout1 = new File("src1.txt");
    File fileout2 = new File("src2.txt");
    
    if (!filein1.exists()) 
    {
      System.out.println(args[0] + " does not exist.");
      return;
    }
    if (!(filein1.isFile() && filein1.canRead())) 
    {
      System.out.println(filein1.getName() + " cannot be read from.");
      return;
    }
    if (!filein2.exists()) 
    {
      System.out.println(args[0] + " does not exist.");
      return;
    }
    if (!(filein2.isFile() && filein2.canRead()))
    {
      System.out.println(filein2.getName() + " cannot be read from.");
      return;
    }
    
    try 
    {
      FileInputStream fin1 = new FileInputStream(filein1);
      FileInputStream fin2 = new FileInputStream(filein2);
      FileOutputStream fout1 = new FileOutputStream(fileout1);
      FileOutputStream fout2 = new FileOutputStream(fileout2);
        
      while (fin1.available() > 0) 
      {
        
          current = (char) fin1.read();
        
                if(current != ' ' && current != '\n' && current != '\r')
                {
                    char_cnt1 = char_cnt1 + 1;
                    fout1.write(current);
                }    
                if(current == '\r') 
                {
                    arr_newline1[i] = char_cnt1 ;
                    i++;
                }
      } 
       
		arr_newline1[i] = char_cnt1 ;
        i = 0;
            
      while (fin2.available() > 0) 
      {
        
          current = (char) fin2.read();
       
                if(current != ' ' && current != '\n' && current != '\r')
                {
                    char_cnt2++;
                    fout2.write(current);
                }
                if(current == '\r')
                {
                    arr_newline2[i] = char_cnt2 ;
                    i++;
                }   
      }
      
      arr_newline2[i] = char_cnt2;
      
    /* for(i=0;i<=10;i++)
      {
          System.out.print(arr_newline1[i]+" ");
      }
      System.out.println();
             
      
      
       for(i=0;i<=10;i++)
      {
          System.out.print(arr_newline2[i]+" ");
      }
            
       
      */
            int m1 = char_cnt1 ;
            int m2 = char_cnt2 ;
      
                if( m1 < m2 )
                m = m1 ;
                else
                m = m2 ;
    }//end try block
     
    
      catch (IOException e) 
      {
      e.printStackTrace();
      }
    
       File file1 = new File("src1.txt");
       File file2 = new File("src2.txt");
       BufferedInputStream bin1 = null;
       BufferedInputStream bin2 = null;
      try
      {
       FileInputStream fin1 = new FileInputStream(file1);
       FileInputStream fin2 = new FileInputStream(file2);
                       
                        //create object of BufferedInputStream
       bin1 = new BufferedInputStream(fin1);
       bin2 = new BufferedInputStream(fin2);
                        //create a byte array
       byte[] contents1 = new byte[1024];
       byte[] contents2 = new byte[1024];
       int bytesRead1=0;
       int bytesRead2=0;
       String strFileContents1 = null;
       String strFileContents2 = null;
                     
       while( (bytesRead1 = fin1.read(contents1)) != -1)
       {
                               
           strFileContents1 = new String(contents1, 0, bytesRead1);
                                //System.out.print(strFileContents1);
       }
                       
       while( (bytesRead2 = fin2.read(contents2)) != -1)
       {
                               
            strFileContents2 = new String(contents2, 0, bytesRead2);
                                //System.out.print(strFileContents2);
       }
                        //String s1 = new String(strFileContents1);
       rk(strFileContents1,strFileContents2,arr_newline1,arr_newline2);
                      
                        
       }
       catch(FileNotFoundException e)
       {
            System.out.println("File not found" + e);
       }
       catch(IOException ioe)
       {
                        System.out.println("Exception while reading the file "+ ioe);
       }
       finally
       {
                        //close the BufferedInputStream using close method
            try
               {
                    if(bin1 != null)
                        bin1.close();
                                
                    if(bin2 != null)
                        bin2.close();
               }
            catch(IOException ioe)
               {
                    System.out.println("Error while closing the stream :"+ ioe);
               }
        }
        
      } //end for 2
      
      } //end for 1
           
      }//end main

    
    static void rk(String txt1,String txt2,int arr_newline1[],int arr_newline2[])
     {
        srcTable1[] ob1 = new srcTable1[1000];
        srcTable2[] ob2 = new srcTable2[1000];
        int m = 0; 
        
      
        int n1  = txt1.length();
        int n2 =  txt2.length();
        int gotyou = -1;
        
        if( n1 < n2)
            m = n1 ;
        if( n1 > n2)
            m = n2 ;
        
    // System.out.println(m);     
        //int m =140;
    //Calculating the d^(m-1) 
  
    while( true )
    {
       
        int i , t1 = 0 , t2 = 0, p = 0 , h1 = 1 , h2 = 1 , q = 131 , d = 256 ;
        int j , flag = -1, flag1 = -1 , flag2 = -1, flag3 = -1 , flag4 = -1  , flag5 = -1;
        
        for( i = 0 ; i < m - 1 ; i++ )
        h1 = ( h1 * d ) % q ;
    
        for( i = 0 ; i < m - 1 ; i++ )
        h2 = ( h2 * d ) % q ;
   
        int low = 0 , high =0 ; 
   
        for ( i = 0 ; i < 1000 ; i++)
        {
            if(arr_newline1[i]==0)
            {
            flag2 = 0;
            break;
            }
     
        }
   
        if( flag2 == 0 )
            high = i-1 ;
        else
            high = i ;
   
        int high1_temp = high ;     
       // System.out.println("high1:"+high);
   
        for( j = 0 ; j < m ; j++ )
            {
                t1 =  ( t1*d + txt1.charAt(j) ) % q ;
                t2 =  ( t2*d + txt2.charAt(j) ) % q ;
            }
  
        for( i = 0 ; i <= n1-m ; i++ )
            {
                ob1[i] = new srcTable1();
                ob1[i].index = i;
                ob1[i].hash_value = t1;
               
                
                while( low <= high )
                 {
                    int mid = ( low + high ) / 2;
                    
                    if( ( i + 1 ) == arr_newline2[mid])
                        {
                            ob1[i].line_no = mid + 1;
                            flag = 0;
                            break;
                        }
                    
                    else if( ( i + 1 ) < arr_newline1[mid])
                    {
                        high = mid - 1;
                    }
                    else 
                    {
                        low = mid + 1;     
                    }
                    
                 }//end while
                
                if(flag == -1)
                {
                     ob1[i].line_no = high + 2;
                     
                }
                
                low = 0 ;
                high = high1_temp; 
                flag  = -1 ;
                
                if( i < n1 - m )
                {
                t1 =( ( t1 - txt1.charAt(i) * h1) * d ) % q  + ( txt1.charAt( i + m ));
                if( t1 < 0 )
                t1 = t1 + q ;
                }
                }//end for
    
          
            
            low = 0 ; high =0 ; 
   
            for ( i = 0 ; i < 1000 ; i++)
                {
                if(arr_newline2[i]==0)
                    {
                    flag3 = 0;
                    break;
                    }
     
                }
   
            if( flag3 == 0 )
            high = i - 1;
            else
            high = i  ;
   
            int high2_temp = high ;  
            //System.out.println("high2:"+ high);         
            
            for( i = 0 ; i <= n2-m ; i++ )
                {
                ob2[i] = new srcTable2();
                ob2[i].index = i;
                ob2[i].hash_value = t2;
               
                
                while( low <= high )
                    {
                        int mid = ( low + high )/2;
                    
                        if( ( i + 1 ) == arr_newline2[ mid ] )
                        {
                            ob2[i].line_no = mid+1;
                            flag1 = 0;
                            break;
                        }
                        else if( ( i + 1 ) < arr_newline2[mid])
                        {
                            high = mid - 1;
                        }
                        else 
                        {
                        low = mid + 1;     
                        }
                    }
                
                if(flag1 == -1)
                {
                  ob2[i].line_no = high + 2; 
                  
                }
                
                high = high2_temp;
                low = 0;
                flag1  = -1 ;
                 
               if( i < n2 - m )
                {
                    t2 =( ( t2 - txt2.charAt(i) * h2) * d ) % q  + ( txt2.charAt( i + m ));
                    if( t2 < 0 )
                    t2 = t2 + q ;
                }
            }//end for
         
          
    int t;
    for( i = 0 ; i <= n1-m ; i++ )
    {
       int hv1=ob1[i].hash_value;
       for( j = 0 ; j <= n2-m ; j++ )  
        {
          if(hv1==ob2[j].hash_value)
          {
              
               int k = i;
               for( t = j ; t < j + m ; t++,k++ )
                    {
                    if( txt1.charAt(k) != txt2.charAt(t))
                        break;
                    }
               if( t == j+ m )
               {    System.out.println("PLAGIARISED "+ctr1.toString()+".txt  and   "+ctr2.toString()+".txt");
               /*
                    System.out.print("pairs are :"+ob1[i].line_no );
                    System.out.println(" "+ob2[j].line_no );  
                    System.out.println("FOR A WINDOW OF " +m+ " BYTES");  
                    System.out.println();
                   */
                    flag4 = 0;
                    gotyou =0;
                    break;
               }
               
          }
          if( flag4  == 0 )
              break;
        }//end j for
       if(flag4 == 0)
           break;
    }//end i for
    if( flag4 == 0)
     break;
    
    if( m >= 50)
      m--;
    else
        break;
 }//end while    
    if ( gotyou == -1)
    {
      System.out.println("NOT PLAGIARISED");  
    }
}//end rk
}//end class
