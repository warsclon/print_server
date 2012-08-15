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

import java.util.Observable;
import java.util.Observer;

/**
 * <p>Copyright: Copyright (c) 2012</p>
 * @author Diego Martín Moreno
 * @version 1.0
 */
public class SimpleEvent extends Observable  {
    
        String valor; 
        
        // The setChanged() protected method must overridden to make it public
        public synchronized void setChanged() {
            super.setChanged();
        }
        
    public void addObserver(Observer observer) {
        System.out.println("Llamada evento simple");
         
        
    }
}

