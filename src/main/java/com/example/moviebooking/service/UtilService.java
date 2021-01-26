package com.example.moviebooking.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@Component
public class UtilService {

    public void saveFile(String path, MultipartFile image)  {
        File file;
        FileOutputStream stream;
        try{
            file = new File(path);
            file.createNewFile();
            stream = new FileOutputStream(file);
            stream.write(image.getBytes());
            stream.close();
            System.out.println(path +" saved");
        }
        catch (IOException ex){
            try {
                throw new IOException(ex.getMessage());
            } catch (IOException e) {
            }
        }
    }

    public boolean createDir(File dir) {
        if (!dir.isDirectory()) {
            dir.mkdir();
            System.out.println("create " + dir.getPath() + " directory");
            return true;
        }
        return false;
    }

    public void deleteDirectoryOfUploadedFile(String directoryPath){
        File dir=  new File(directoryPath);
        if (dir.isDirectory()) {
            String[] filenames = dir.list();
            Arrays.stream(filenames).forEach(s -> new File(dir.getPath(),s).delete());
            dir.delete();
        }


    }
}
