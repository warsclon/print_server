/*******************************************************************************
 * Copyright 2012 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
/*
 * Copyright 2012 Diego Martin Moreno (dmartmorsoft@gmail.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.dmartmor.javawebstart.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.io.FileOutputStream;
import org.apache.log4j.Category;

/**
 * <p>Copyright: Copyright (c) 2012</p>
 * @author Diego Martín Moreno
 * @version 1.0
 */
public class Dll {
    
    final String DIR = "dir";
    
    final String URL_DLL = "urldll";
    
    final String DLL = "dll";
    
    static Category log = Category.getInstance(Dll.class.getName());
    
    /** Creates a new instance of MakeFolder */
    public Dll() {
    }
    
    
    public boolean makeDir() {
        // Create a directory; all ancestor directories must exist
        log.info("Make dir:"+Properties.getString(DIR));
        return (new File(Properties.getString(DIR))).mkdir();
    }
    
    
    public void deleteAllDir() {
        log.info("Delete All Dir:"+Properties.getString(DIR));
        deleteDir(new File(Properties.getString(DIR)));
    }
    
    private boolean deleteDir(File dir) {
        //Empty
        log.info("Delete dir:"+dir.getAbsolutePath());
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // The directory is now empty so delete it
        return dir.delete();
    }
    
    
    public boolean loadFile() {
        
        log.info("Init Load Dll");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            URL url = new URL(Properties.getString(URL_DLL));
            // file.
            // Use Buffered Stream for reading/writing.
            bis = new BufferedInputStream(url.openStream());
            FileOutputStream os = new FileOutputStream(Properties.getString(DLL));
            
            byte[] buff = new byte[2048];
            int bytesRead;
            
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                os.write(buff, 0, bytesRead);
            }
            
        } catch (Exception ex) {
            log.error(ex);
            return false;
        }
        log.info("End Load Dll");
        return true;
    }
    
}
