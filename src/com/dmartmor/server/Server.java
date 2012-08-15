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
package com.dmartmor.server;

import com.dmartmor.javawebstart.gui.Menu;
import com.dmartmor.javawebstart.util.Properties;
import org.apache.log4j.Category;
import org.mortbay.http.HttpContext;
import org.mortbay.http.HttpServer;
import org.mortbay.http.SocketListener;
import org.mortbay.http.handler.ResourceHandler;
import org.mortbay.jetty.servlet.ServletHandler;


/**
 * <p>Copyright: Copyright (c) 2012</p>
 * @author Diego Martín Moreno
 * @version 1.0
 */
public class Server {

    static Category log = Category.getInstance(Server.class.getName());        
    final String PORT_SERVER = "port";
    
    /** Creates a new instance of Server */
    public Server() throws Exception {
        
        log.info("Create Server");        
        Menu.pintar("Create Server");
        // Create the server
        HttpServer server=new HttpServer();
        
        server.setTrace(false);
        
        // Create a port listener
        SocketListener listener=new SocketListener();
        listener.setPort(Integer.parseInt(Properties.getString(PORT_SERVER)));
        server.addListener(listener);
        
        // Create a context
        HttpContext context = new HttpContext();
        context.setContextPath("/dmartmor/*");
        server.addContext(context);
        
        // Create a servlet container
        ServletHandler servlets = new ServletHandler();
        context.addHandler(servlets);
        
        // Map a servlet onto the container
        servlets.addServlet("Print","/print/*","com.dmartmor.server.servlet.Print");
        
        // Serve static content from the context
        //TODO habria que ver como se puede quitar
        String home = System.getProperty("jetty.home",".");
        context.setResourceBase(home+"/demo/webapps/jetty/tut/");
        context.addHandler(new ResourceHandler());
        
        // Start the http server
        server.start();
        log.info("Start Server");        
        Menu.pintar("Start Server");
        
    }
}


