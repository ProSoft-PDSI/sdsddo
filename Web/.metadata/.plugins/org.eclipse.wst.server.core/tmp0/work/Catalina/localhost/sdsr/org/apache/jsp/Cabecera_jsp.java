/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.35
 * Generated at: 2014-07-18 18:41:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Cabecera_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<script>\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t$(\"#menu a\").click(function(){\r\n");
      out.write("\t\t\t$(\"#menu li\").removeClass(\"active\");\r\n");
      out.write("\t\t\t$(\"this\").parent().addClass(\"active\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<a href=\"home.jsp\" id=\"ac_content\" class=\"ac_content\" target=\"frame\"><h1>\r\n");
      out.write("\t\t<span>PIZZERIA</span>RAVIOLI\r\n");
      out.write("\t</h1></a>\r\n");
      out.write("<nav>\r\n");
      out.write("\t<ul id=\"top_nav\">\r\n");
      out.write("\t\t<li><a href=\"index.html\"><img src=\"images/icon_1.gif\" alt=\"\"></a></li>\r\n");
      out.write("\t\t<li><a href=\"#\"><img src=\"images/icon_2.gif\" alt=\"\"></a></li>\r\n");
      out.write("\t\t<li class=\"end\"><a href=\"Contacto.html\"><img\r\n");
      out.write("\t\t\t\tsrc=\"images/icon_3.gif\" alt=\"\"></a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</nav>\r\n");
      out.write("<nav>\r\n");
      out.write("\t<ul id=\"menu\">\r\n");
      out.write("\t\t<li><a href=\"home.jsp\" target=\"frame\">Restaurant</a></li>\r\n");
      out.write("\t\t<li><a href=\"Entrada\" target=\"frame\">Entrada</a></li>\r\n");
      out.write("\t\t<li><a href=\"Clasica.jsp\" target=\"frame\">Pizza Clasica</a></li>\r\n");
      out.write("\t\t<li><a href=\"Especiales.jsp\" target=\"frame\">Especiales</a></li>\r\n");
      out.write("\t\t<li><a href=\"Contacto.html\" target=\"frame\">Contacto</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</nav>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}