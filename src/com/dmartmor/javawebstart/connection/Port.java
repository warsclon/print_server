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
package com.dmartmor.javawebstart.connection;

import com.dmartmor.javawebstart.util.Properties;
import org.apache.log4j.Category;

/**
 * <p>Copyright: Copyright (c) 2012</p>
 * @author Diego Martín Moreno
 * @version 1.0
 */
public class Port {
    
    final static String DLL_PATH = "dll";
    
    static Category log = Category.getInstance(Port.class.getName());
    
    // Prints a Java String in native code and returns a Java String
    native public String printLine(String text);
    
    // Prints a Java String in native code and returns a Java String
    native public String openPort(String port, String type);
    
    // Prints a Java String in native code and returns a Java String
    native public String closePort();
    
    // Loads the file Native.DLL at run-time
    static {
        //System.loadLibrary("NATIVE");
        log.info("Load Library DLL");
        System.load(Properties.getString(DLL_PATH));
    }
}
