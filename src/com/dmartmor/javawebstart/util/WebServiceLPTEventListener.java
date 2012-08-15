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

/**
 * <p>Copyright: Copyright (c) 2012</p>
 * @author Diego Martín Moreno
 * @version 1.0
 */
 // Add the event registration and notification code to a class.
    public class WebServiceLPTEventListener {
        // Create the listener list
        protected javax.swing.event.EventListenerList listenerList =
            new javax.swing.event.EventListenerList();
    
        // This methods allows classes to register for MyEvents
        public void addMyEventListener(WebServiceLPTListener listener) {
            listenerList.add(WebServiceLPTListener.class, listener);
        }
    
        // This methods allows classes to unregister for MyEvents
        public void removeMyEventListener(WebServiceLPTListener listener) {
            listenerList.remove(WebServiceLPTListener.class, listener);
        }
    
        // This private class is used to fire MyEvents
        void fireMyEvent(WebServiceLPTEvent evt) {
            Object[] listeners = listenerList.getListenerList();
            // Each listener occupies two elements - the first is the listener class
            // and the second is the listener instance
            for (int i=0; i<listeners.length; i+=2) {
                if (listeners[i]==WebServiceLPTListener.class) {
                    ((WebServiceLPTListener)listeners[i+1]).WebServiceLPTOccurred(evt);
                }
            }
        }
    }