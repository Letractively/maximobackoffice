/**
 * 
 */
package org.ajc.log.ant;

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.Project;

/**
 * @author joao
 */
public abstract class BaseListener implements BuildListener {
  
  /**
   * 
   */
  protected int log_level = Project.MSG_INFO;
  /**
   * 
   */
  protected long start_time = System.currentTimeMillis();
  
  /**
   * 
   */
  public void buildStarted(BuildEvent event) {
    start_time = System.currentTimeMillis();
  }
  
  /**
   * 
   */
  public void targetFinished(BuildEvent event) {
  }
  
  /**
   * 
   */
  public void taskStarted(BuildEvent event) {
  }
  
  /**
   * 
   */
  public void taskFinished(BuildEvent event) {
  }
}
