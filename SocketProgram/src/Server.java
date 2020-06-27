import java.net.*;
import java.io.*;
public class Server 
{
public static void main (String []args) {
    //int i,freq;
    
    try{ 
                      ServerSocket ss = new ServerSocket(1999); 
                      Socket s = ss.accept(); 
                      DataInputStream dis = new DataInputStream(s.getInputStream()); 
                      String k = dis.readUTF(); 
                      String[] keys = k.split(" ");
        String[] uniqueKeys;
        int count = 0;
        System.out.println(k);
        uniqueKeys = getUniqueKeys(keys);
             for(String key: uniqueKeys)
        {
            if(null == key)
            {
                break;
            }           
            for(String p : keys)
            {
                if(key.equals(p))
                {
                    count++;
                }               
            }
            System.out.println("Count of ["+key+"] is : "+count);
            count=0;
        }
                          //System.out.println(k);
                      System.out.println("File Transferred"); 
    }         
        catch (IOException ie) { 
                       ie.printStackTrace(); 
                     }
}

     private static String[] getUniqueKeys(String[] keys)
        {
        //To change body of generated methods, choose Tools | Templates.
        String[] uniqueKeys = new String[keys.length];
        uniqueKeys[0] = keys[0];
        int uniqueKeyIndex = 1;
        boolean keyAlreadyExists = false;
        for(int i=1; i<keys.length ; i++)
        { 
            for(int j=0; j<uniqueKeyIndex; j++)
            {
                if(keys[i].equals(uniqueKeys[j]))
                {
                    keyAlreadyExists = true;
                }
            }
                if(!keyAlreadyExists)
            {
                uniqueKeys[uniqueKeyIndex] = keys[i];
                uniqueKeyIndex++;               
            }
             keyAlreadyExists = false;
        }       
        return uniqueKeys;
        }
    
        }


        

        
    
