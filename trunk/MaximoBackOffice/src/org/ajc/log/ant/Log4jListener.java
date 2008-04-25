/**
 * 
 */
package org.ajc.log.ant;

import java.util.StringTokenizer;

import org.ajc.log.Log4jLogger;
import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.util.StringUtils;

/**
 * @author AJC
 */
public class Log4jListener extends BaseListener implements BuildListener {
  private static final Class iClass = Log4jListener.class;
  /**
   * <p>
   * Default constructor.
   * </p>
   */
  public Log4jListener() {
    super();
  }
  
  /**
   * @see org.ajc.log.ant.BaseListener#buildStarted(org.apache.tools.ant.BuildEvent)
   */
  public void buildStarted(BuildEvent bldEvent) {
    super.buildStarted(bldEvent);
    Log4jLogger.info(iClass, " BUILD STARTED");
  }
  
  /**
   * @see org.apache.tools.ant.BuildListener#buildFinished(org.apache.tools.ant.BuildEvent)
   */
  public void buildFinished(BuildEvent bldEvent) {
    Throwable error = bldEvent.getException();
    
    if (error == null) {
      Log4jLogger.info(iClass, " BUILD SUCCESSFUL");
      
    } else {
      Log4jLogger.info(iClass, " BUILD FAILED");
      
      if (!(error instanceof BuildException)) {
        Log4jLogger.info(iClass, StringUtils.getStackTrace(error));
        
      } else {
        if (error instanceof BuildException) {
          Log4jLogger.info(iClass, error.toString());
        } else {
          Log4jLogger.info(iClass, error.getMessage());
        }
      }
      
    }
    Log4jLogger.info(iClass, " Total time: "
        + ((System.currentTimeMillis() - start_time) / 1000));
  }
  
  /**
   * @see org.apache.tools.ant.BuildListener#targetStarted(org.apache.tools.ant.BuildEvent)
   */
  public void targetStarted(BuildEvent bldEvent) {
    
    Log4jLogger.info(iClass, bldEvent.getTarget().getName());
  }
  
  /**
   * @see org.apache.tools.ant.BuildListener#taskFinished(org.apache.tools.ant.BuildEvent)
   */
  public void taskFinished(BuildEvent bldEvent) {
    Log4jLogger.info(iClass, ".taskFinished(BuildEvent) executed.");
  }
  
  /**
   * @see org.apache.tools.ant.BuildListener#messageLogged(org.apache.tools.ant.BuildEvent)
   */
  public void messageLogged(BuildEvent bldEvent) {
    if (bldEvent.getPriority() <= log_level) {
      StringBuffer message = new StringBuffer();
      if (bldEvent.getTask() != null) {
        // Print out the name of the task if we're in one.
        String name = bldEvent.getTask().getTaskName();
        String label = "[" + name + "] ";
        
        StringTokenizer tok = new StringTokenizer(bldEvent.getMessage(),
            "\r\n", false);
        while (tok.hasMoreTokens()) {
          Log4jLogger.info(iClass, label);
          Log4jLogger.info(iClass, tok.nextToken());
        }
        
      } else {
        Log4jLogger.info(iClass, bldEvent.getMessage());
      }
      Log4jLogger.info(iClass, " Priority:" + bldEvent.getPriority());
      Log4jLogger.info(iClass, message.toString());
    }
  }
  
}
