/**
 * <pre>
 * Copyright 2008 Antonio Jacob Costa (jacob.costa@gmail.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the &quot;License&quot;);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an &quot;AS IS&quot; BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 * </pre>
 */
package org.ajc.log;

import org.apache.log4j.Logger;

/**
 * @author AJC
 */
public class Log4jLogger {
  /**
   * 
   */
  static final String prefix = new String("<AJC> ");
  
  // ---------------------------- Class Logger ----------------------------
  /**
   * <p>
   * </p>
   * 
   * @param iClass
   * @param message
   */
  public static void debug(Class iClass, Object message) {
    Logger lLogger = Logger.getLogger(iClass.getName());
    lLogger.debug(prefix.concat(iClass.getName()) + message);
  }
  
  /**
   * <p>
   * </p>
   * 
   * @param iClass
   * @param message
   */
  public static void info(Class iClass, Object message) {
    Logger lLogger = Logger.getLogger(iClass.getName());
    lLogger.info(prefix.concat(iClass.getName()) + message);
  }
  
  /**
   * <p>
   * </p>
   * 
   * @param iClass
   * @param message
   */
  public static void warn(Class iClass, Object message) {
    Logger lLogger = Logger.getLogger(iClass.getName());
    lLogger.warn(prefix.concat(iClass.getName()) + message);
  }
  
  /**
   * <p>
   * </p>
   * 
   * @param iClass
   * @param message
   */
  public static void error(Class iClass, Object message) {
    Logger lLogger = Logger.getLogger(iClass.getName());
    lLogger.error(prefix.concat(iClass.getName()) + message);
  }
  
  /**
   * <p>
   * </p>
   * 
   * @param iClass
   * @param message
   */
  public static void fatal(Class iClass, Object message) {
    Logger lLogger = Logger.getLogger(iClass.getName());
    lLogger.fatal(prefix.concat(iClass.getName()) + message);
  }
  
  // ---------------------- DEBUG LEVEL VERIFICATION ----------------
  /**
   * <p>
   * </p>
   * 
   * @param iClass
   * @return
   */
  public static boolean isDebugEnabled(Class iClass) {
    Logger lLogger = Logger.getLogger(iClass.getName());
    return lLogger.isDebugEnabled();
  }
  
  /**
   * <p>
   * </p>
   * 
   * @param iClass
   * @return
   */
  public static boolean isInfoEnabled(Class iClass) {
    Logger lLogger = Logger.getLogger(iClass.getName());
    return lLogger.isInfoEnabled();
  }
}
