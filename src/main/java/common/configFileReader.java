package common;

import java.io.*;
import java.util.Properties;

 public class configFileReader {

    private Properties properties;
    private final String propertyFilePath ;


    public configFileReader(String propsPath){
        propertyFilePath = propsPath;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(propsPath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }finally {
            try{
            if(reader != null)
                reader.close();
        }catch (IOException ignore){}
        }

        }


    public String readProperty(String Key){
        String reportConfigPath = properties.getProperty(Key);
        if(reportConfigPath !=null) {
            return reportConfigPath;
        }
        else {
            throw new RuntimeException(Key + " is not mentioned in the file.");
        }
    }

    public void setPropertyInFile(String key , String val){
        BufferedReader reader;
            try{
                reader =  new BufferedReader(new FileReader(propertyFilePath));
                properties = new Properties();
                try{
                    properties.load(reader);
                }catch (IOException e){
                    e.printStackTrace();
                }

            }catch (FileNotFoundException e){
                throw new RuntimeException("Properties file not found at path : "+propertyFilePath);
            }

            try{
                properties.setProperty(key,val);
                properties.store(new FileOutputStream(new File(propertyFilePath)), null);
            }catch (Exception fnf){}

    }

}
