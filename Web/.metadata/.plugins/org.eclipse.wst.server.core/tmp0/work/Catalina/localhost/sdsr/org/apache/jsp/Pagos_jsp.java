/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.35
 * Generated at: 2014-07-22 01:37:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Pagos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>..::Sistema de Servicios de Restaurantes::..</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/miEstilos.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/foundation.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/javaScript.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-1.10.0.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"agrupar\">\r\n");
      out.write("\t\t<header id=\"cabecera\">\r\n");
      out.write("\t\t\t<h1>PAGOS</h1>\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t\t<nav id=\"menu\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li>Principal1</li>\r\n");
      out.write("\t\t\t\t<li>Principal2</li>\r\n");
      out.write("\t\t\t\t<li>Principal3</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t<section id=\"seccion\">\r\n");
      out.write("\t\t\t<form id=\"formulario\" name=\"formulario\" method=\"post\" action=\"\">\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>Pedido:</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"td_pedido\" name=\"td_pedido\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.pedido}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>Total Pedido:</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"td_total_pedido\" name=\"td_total_pedido\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.total}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>Tipo Pago:</td>\r\n");
      out.write("\t\t\t\t\t\t<td><select id=\"tipo_pago\" name=\"tipo_pago\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"E\">Efectivo</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"D\">Debito</option>\r\n");
      out.write("\t\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>Monto:</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"td_imp_efec\" name=\"td_imp_efec\"><input type=\"number\" id=\"imp_efec\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"imp_efec\" min=\"0\" pattern=\"[0-9]*[.,]?[0-9]+\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>Cambio:</td>\r\n");
      out.write("\t\t\t\t\t\t<td id=\"td_imp_camb\" td=\"td_imp_camb\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"><input type=\"button\" value=\"Procesar\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"button\" id=\"btn_Procesar\" name=\"btn_Procesar\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"hid_tipo_pago\" name=\"hid_tipo_pago\"> <input\r\n");
      out.write("\t\t\t\t\ttype=\"hidden\" id=\"hid_usuario\" name=\"hid_usuario\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.usuario}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" id=\"hid_cambio\" name=\"hid_cambio\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t\t<aside id=\"columna\"></aside>\r\n");
      out.write("\t\t<footer id=\"pie\"> Sistema Delivery Online &copy; 2014-2015 </footer>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
