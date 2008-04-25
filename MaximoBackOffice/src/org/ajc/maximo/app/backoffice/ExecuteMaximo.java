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
package org.ajc.maximo.app.backoffice;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

import org.ajc.log.Log4jLogger;
import org.ajc.log.ant.HtmlListener;
import org.ajc.log.ant.Log4jListener;

/**
 * Servlet implementation class for Servlet: EjecuteMaximo
 */
public class ExecuteMaximo extends javax.servlet.http.HttpServlet implements
    javax.servlet.Servlet {
  static final long serialVersionUID = 1L;
  
  /*
   * (non-Java-doc)
   * 
   * @see javax.servlet.http.HttpServlet#HttpServlet()
   */
  public ExecuteMaximo() {
    super();
  }
  
  /*
   * (non-Java-doc)
   * 
   * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
   *      HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  }
  
  /*
   * (non-Java-doc)
   * 
   * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
   *      HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Class iClass = this.getClass();
    Log4jLogger.info(iClass,
        ".doPost(HttpServletRequest,HttpServletResponse) started...");
    String maximo_home = getServletConfig().getInitParameter("MAXIMO_HOME");
    String cmd = request.getParameter("option");
    Log4jLogger.debug(iClass, " response.getWriter()");
    PrintWriter out = response.getWriter();
    out.write("Action: <i>".concat(cmd));
    out.write("</i><br />");
    Log4jLogger.debug(iClass, " CASE cmd:");
    if (cmd.equalsIgnoreCase("configdb")) {
      this.configDB(out, maximo_home, "configdb");
      out.flush();
    } else if (cmd.equalsIgnoreCase("restorefrombackup")) {
      this.configDB(out, maximo_home, "restorefrombackup");
      out.flush();
    } else if (cmd.equalsIgnoreCase("dropbackup")) {
      this.configDB(out, maximo_home, "dropbackup");
      out.flush();
    } else if (cmd.equalsIgnoreCase("buildmaximoear")) {
      this.buildMaximoEar(out, maximo_home, "buildmaximoear");
      out.flush();
    } else if (cmd.equalsIgnoreCase("buildacwebear")) {
      this.buildMaximoEar(out, maximo_home, "buildacwebear");
      out.flush();
    } else if (cmd.equalsIgnoreCase("buildhelpear")) {
      this.buildMaximoEar(out, maximo_home, "buildhelpear");
      out.flush();
    } else if (cmd.equalsIgnoreCase("buildrmiregwar")) {
      this.buildMaximoEar(out, maximo_home, "buildrmiregwar");
      out.flush();
    } else if (cmd.equalsIgnoreCase("buildbocrystalwar")) {
      this.buildMaximoEar(out, maximo_home, "buildbocrystalwar");
      out.flush();
    } else if (cmd.equalsIgnoreCase("buildhelpear")) {
      this.buildMaximoEar(out, maximo_home, "buildhelpear");
      out.flush();
    } else if (cmd.equalsIgnoreCase("redeploy")) {
      out.write("<h3>redeploy - NOT IMPLEMENTED</h3>");
      out.flush();
    } else if (cmd.equalsIgnoreCase("refreshdd")) {
      out.write("<h3>redeploy - NOT IMPLEMENTED</h3>");
      out.flush();
    } else if (cmd.equalsIgnoreCase("other")) {
      out.write("<h3>redeploy - NOT IMPLEMENTED</h3>");
      out.flush();
    } else if (cmd.equalsIgnoreCase("showlicense")) {
      out
          .write("Copyright 2008 Antonio Jacob Costa (jacob.costa@gmail.com)<br />");
      out.write("<br />");
      out
          .write("Licensed under the Apache License, Version 2.0 (the \"License\");<br />");
      out
          .write("you may not use this file except in compliance with the License.<br />");
      out.write("You may obtain a copy of the License at <br />");
      out.write("<br />");
      out.write("  http://www.apache.org/licenses/LICENSE-2.0<br />");
      out.write("<br />");
      out
          .write("Unless required by applicable law or agreed to in writing, software<br />");
      out
          .write("distributed under the License is distributed on an \"AS IS\" BASIS,<br />");
      out
          .write("WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.<br />");
      out
          .write("See the License for the specific language governing permissions and <br />");
      out.write("limitations under the License.<br />");
      out.write("<br />");
      out.flush();
    } else {
      out.write("<h3>INVALID Action</h3>");
      out.flush();
    }
    out.write("<br />");
    out.write("<b>Finished!</b><br />");
    out.flush();
    Log4jLogger.info(iClass,
        ".doPost(HttpServletRequest,HttpServletResponse) terminado.");
  }
  
  /**
   * <p>
   * Builds the Maximo EAR calling IBMs ant script.
   * </p>
   * 
   * @param out
   * @param maximo_home
   */
  private synchronized void buildMaximoEar(PrintWriter out, String maximo_home,
      String name) {
    Class iClass = this.getClass();
    Log4jLogger.info(iClass,
        ".buildMaximoEar(PrintWriter,String,String) started...");
    out.write("<b>Ejecutando tarea ant!</b><br />");
    out.flush();
    String baseDir = maximo_home.concat(File.separator).concat("deployment");
    String buildFile = new String(name.concat(".xml"));
    this.executeAnt(out, baseDir, buildFile, null);
    Log4jLogger.info(iClass,
        ".buildMaximoEar(PrintWriter,String,String) finished.");
  }
  
  /**
   * <p>
   * Executes CONFIGDB.
   * </p>
   * 
   * @param out
   * @param maximo_home
   */
  private synchronized void configDB(PrintWriter out, String maximo_home,
      String targetS) {
    Class iClass = this.getClass();
    Log4jLogger.info(iClass, ".configDB(PrintWriter,String,String) started...");
    out.write("<b>Executing configdb!</b><br />");
    out.flush();
    String baseDir = maximo_home.concat(File.separator).concat("tools").concat(
        File.separator).concat("maximo");
    String buildFile = new String("maximo_backoffice_tools.xml");
    out.flush();
    // Call to the method with the ant script.
    this.executeAnt(out, baseDir, buildFile, targetS);
    Log4jLogger.info(iClass, ".configDB(PrintWriter,String,String) finished.");
  }
  
  /**
   * <p>
   * Calls ant scripts in a generic way.
   * </p>
   * 
   * @param out
   *          <p>
   *          </p>
   * @param baseDir
   *          <p>
   *          </p>
   * @param fileName
   *          <p>
   *          </p>
   * @param targetName
   *          <p>
   *          </p>
   */
  private void executeAnt(PrintWriter out, String baseDir, String fileName,
      String targetName) {
    Class iClass = this.getClass();
    Log4jLogger.info(iClass,
        ".executeAnt(PrintWriter,String,String,String) started...");
    if (Log4jLogger.isDebugEnabled(iClass)) {
      Log4jLogger.debug(iClass, " baseDir:" + baseDir);
      Log4jLogger.debug(iClass, " fileName:" + fileName);
      Log4jLogger.debug(iClass, " targetName:" + targetName);
    }
    Project project = new Project();
    project.init();
    project.setBasedir(baseDir);
    String fileS = baseDir.concat(File.separator).concat(fileName);
    Log4jLogger.debug(iClass, " File:".concat(fileS));
    File bFile = new File(fileS);
    ProjectHelper.getProjectHelper().parse(project, bFile);
    project.addBuildListener(new DefaultLogger());
    project.addBuildListener(new Log4jListener());
    project.addBuildListener(new HtmlListener(out));
    project.setProperty("base_dir", baseDir);
    Hashtable targetsHT = project.getTargets();
    if (targetName == null) {
      // If there is no target I get the default one.
      targetName = project.getDefaultTarget();
    }
    if (targetsHT.containsKey(targetName)) {
      Log4jLogger.debug(iClass, " Target " + targetName + " exists.");
      try {
        Log4jLogger.debug(iClass, " Executing target " + targetName + "...");
        project.executeTarget(targetName);
        Log4jLogger.debug(iClass, " ...executed!");
      } catch (BuildException buildE) {
        String exMsg = buildE.getMessage();
        String exE = buildE.toString();
        Log4jLogger.error(iClass, " Error:" + exMsg);
        Log4jLogger.error(iClass, " Exception:" + exE);
        out.write("<br />");
        out.write(exMsg);
        out.write("<br />");
        out.write(exE);
        out.write("<br />");
      }
    } else {
      Log4jLogger.error(iClass, " Target " + targetName + " not found.");
      Log4jLogger.error(iClass, " Targets:" + targetsHT.keySet().toString());
    }
    out.flush();
    Log4jLogger.info(iClass,
        ".executeAnt(PrintWriter,String,String,String) finished.");
  }
}
