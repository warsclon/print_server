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
package com.dmartmor.server.servlet;

import com.dmartmor.javawebstart.connection.Port;
import com.dmartmor.javawebstart.gui.Menu;
import com.dmartmor.javawebstart.util.Properties;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.log4j.Category;

/**
 * <p>Copyright: Copyright (c) 2012</p>
 * @author Diego Martín Moreno
 * @version 1.0
 */
public class Print extends HttpServlet {
    // This method is called by the servlet container just before this servlet
    // is put into service. Note that it is possible that more than one
    // instance of this servlet can be created in the same VM.
    final String PARAM_REQUEST = "print";
    final String RESPONSE_OK = "OK";
    final String RESPONSE_ERROR = "ERROR";
    final String PRINT_PORT = "print_port";
    final String PRINT_TYPE = "print_type";
    


        
    static Category log = Category.getInstance(Print.class.getName());    
    
    public void init() throws ServletException {
        // Initialization code...
        // See e1036 Getting and Setting Initialization Parameters for a Servlet
    }
    
    // This method is called by the servlet container to process a GET request.
    // There may be many threads calling this method simultaneously.
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        String toPrint = req.getParameter(PARAM_REQUEST);
        String result = "";
       if (toPrint != null) {
        log.debug("toPrint:"+toPrint);
        Menu.pintar("Print Label");        
        Port port = new Port();
        port.openPort(Properties.getString(PRINT_PORT),Properties.getString(PRINT_TYPE));
        result = port.printLine(toPrint);
        log.info("result:"+result);
        Menu.pintar("Result print label:"+result);
        port.closePort();
       }
        PrintWriter out = resp.getWriter();
        if (toPrint != null) {
            out.println(result);
        } else {
            out.println(result);
        }
        out.close();
        
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }
    
    // This method is called by the servlet container just after this servlet
    // is removed from service.
    public void destroy() {
        // Shutdown code...
    }
}