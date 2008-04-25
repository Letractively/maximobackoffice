 /**
 * 
 */
package org.ajc.log.ant;

import java.io.PrintWriter;
import java.util.StringTokenizer;

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.BuildListener;
import org.apache.tools.ant.util.StringUtils;

/**
 * @author AJC
 */
public class HtmlListener extends BaseListener implements BuildListener {
  
  /**
   * 
   */
  private PrintWriter printWriter;
  
  /**
   * @param printWriter
   */
  public HtmlListener(PrintWriter printWriter) {
    super();
    this.printWriter = printWriter;
  }
  
  /**
   * @see org.ajc.log.ant.BaseListener#buildStarted(org.apache.tools.ant.BuildEvent)
   */
  public void buildStarted(BuildEvent event) {
    super.buildStarted(event);
    printWriter.println("BUILD STARTED<br>");
  }
  
  /**
   * @see org.apache.tools.ant.BuildListener#buildFinished(org.apache.tools.ant.BuildEvent)
   */
  public void buildFinished(BuildEvent bldEvent) {
    Throwable throwE = bldEvent.getException();
    StringBuffer strBuffer = new StringBuffer();
    
    if (throwE == null) {
      strBuffer.append("<br>");
      strBuffer.append("BUILD SUCCESSFUL<br>");
      
    } else {
      strBuffer.append(StringUtils.LINE_SEP);
      strBuffer.append("BUILD FAILED<br>");
      
      if (!(throwE instanceof BuildException)) {
        strBuffer
            .append("<pre>" + StringUtils.getStackTrace(throwE) + "</pre>");
        
      } else {
        if (throwE instanceof BuildException) {
          strBuffer.append(throwE.toString()).append("<br>");
        } else {
          strBuffer.append(throwE.getMessage()).append("<br>");
        }
      }
      
    }
    strBuffer.append("<br>");
    strBuffer.append("Total time: ");
    strBuffer.append((System.currentTimeMillis() - start_time) / 1000);
    
    printWriter.println(strBuffer.toString() + "<br>");
  }
  
  /**
   * @see org.apache.tools.ant.BuildListener#taskFinished(org.apache.tools.ant.BuildEvent)
   */
  public void targetStarted(BuildEvent event) {
    printWriter.println(StringUtils.LINE_SEP + event.getTarget().getName()
        + ":<br>");
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
          message.append(label);
          message.append(tok.nextToken() + "<br>");
        }
        
      } else {
        message.append(bldEvent.getMessage() + "<br>");
      }
      
      printWriter.println("<b>" + bldEvent.getPriority() + "</b> "
          + message.toString());
    }
  }
  
}
