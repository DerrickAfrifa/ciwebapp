/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-04-09 14:24:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class query_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:wght@800&display=swap\" rel=\"stylesheet\">\n");
      out.write("<title>Query</title>\n");
      out.write("</head>\n");
      out.write("<body style=\"min-height: 100%; background-color: #212121;\">\n");
      out.write("\t<div class=\"row align-items-center\" style=\"height:100vh;\">\n");
      out.write("\t\t<div class=\"col offset-4\">\n");
      out.write("\t\t\t<h1 style=\"font-family: 'Open Sans', sans-serif; color: white;\">QUERY</h1>\n");
      out.write("\t\t\t<form style=\"color: white;\" action=\"/queryDisplay\">\n");
      out.write("\t\t\t  <input type='hidden' name='filePath' id='file' value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${filePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("' />\n");
      out.write("\t\t\t  <label for=\"queryType\">Choose a query:</label>\n");
      out.write("\t\t\t  <select id=\"queryType\" name=\"queryType\">\n");
      out.write("\t\t\t    <option value=\"pdc\">Missing personal data category</option>\n");
      out.write("\t\t\t    <option value=\"dsubj\">Missing data subject</option>\n");
      out.write("\t\t\t    <option value=\"dsrc\">Missing data source</option>\n");
      out.write("\t\t\t    <option value=\"rec\">Missing recipient</option>\n");
      out.write("\t\t\t    <option value=\"pur\">Missing purpose</option>\n");
      out.write("\t\t\t    <option value=\"tom\">Missing technical/organisational measures</option>\n");
      out.write("\t\t\t    <option value=\"tid\">Missing 3rd part recipient identity</option>\n");
      out.write("\t\t\t    <option value=\"vag\">Violation</option>\n");
      out.write("\t\t\t  </select>\n");
      out.write("\t\t\t  <input type=\"submit\">\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
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
