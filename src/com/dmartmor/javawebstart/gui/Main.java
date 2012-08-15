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
package com.dmartmor.javawebstart.gui;

import com.dmartmor.server.Server;
import com.dmartmor.javawebstart.util.*;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;
import java.net.URL;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import javax.print.event.*;
import com.jeans.trayicon.*;
import org.apache.log4j.Category;

/**
 * <p>Copyright: Copyright (c) 2012</p>
 * @author Diego Martín Moreno
 * @version 1.0
 */
public class Main {
    
    private static int count;
    private static List buttons = new ArrayList();
    private JButton button = new JButton();
    static Category log = Category.getInstance(Main.class.getName());
    final String URL_DLL = "urldll";
    
    public Main() {
        
        log.info("Start AnalizerPrint");
        // Get the currently installed look and feel
        LookAndFeel lf = UIManager.getLookAndFeel();
        
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            log.error(e);
        }
        
        log.info("Start Frame");
        Menu frame= new Menu();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        frame.setLocation(new Point((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.width) / 2));
        frame.setVisible(true);
        // Importante. Si se hace un exit se cerrar? el loader
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        log.info("Check Dir install");
        Dll dll = new Dll();
        
        if (dll.makeDir()) {
            Menu.pintar("Make dir");
            if(!dll.loadFile()){
                Menu.pintar("Error Download DLL from "+Properties.getString(URL_DLL));
                dll.deleteAllDir();
            } else {
                Menu.pintar("Download dll");
                startServer();
            }
        } else {
            startServer();
        }
        
        
        
    }
    
    public void startServer() {
        try {
            log.info("Start Server");
            Server server = new Server();
        } catch (Exception e) {
            log.error(e);
        }
        
    }
    public static void main(String[] args) {
        new Main();
    }
}
