/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2020-04-01 14:31:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1578469475550L));
    _jspx_dependants.put("jar:file:/D:/javaproject/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/sj/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098682290000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html >\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0\">\r\n");
      out.write("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\r\n");
      out.write("<meta name=\"robots\" content=\"index, follow\">\r\n");
      out.write("<title></title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/layout.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/top.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/box.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/ltbox.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/columns.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/circleReset.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/circleStyle.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/echarts.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-2.2.1.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery-2.2.1.min.js\"></script>\r\n");
      out.write("<script src=\"js/common.js\"></script>\r\n");
      out.write("<script src=\"js/date.js\"></script>\r\n");
      out.write("<script src=\"js/source/online.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/html5_3d_animation.js\"></script>\r\n");
      out.write("<!-- circle.js圆圈 -->\r\n");
      out.write("<script src=\"js/circle.js\" ></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\tvar window_width = $(window).width();\r\n");
      out.write("\t\tvar window_height = $(window).height()\r\n");
      out.write("\t\t$(\"#html5_3d_animation\").html5_3d_animation({\r\n");
      out.write("\t\t\twindow_width : window_width,\r\n");
      out.write("\t\t\twindow_height : window_height + 200,\r\n");
      out.write("\t\t\twindow_background : '#00040d',\r\n");
      out.write("\t\t\tstar_count : '250',\r\n");
      out.write("\t\t\tstar_color : 'rgba(100,149,237,0.9)',\r\n");
      out.write("\t\t\tstar_depth : '300'\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(window).resize(function() {\r\n");
      out.write("\t\t\tvar window_width = $(window).width();\r\n");
      out.write("\t\t\tvar window_height = $(window).height()\r\n");
      out.write("\t\t\t$(\"#html5_3d_animation\").html5_3d_animation({\r\n");
      out.write("\t\t\t\twindow_width : window_width,\r\n");
      out.write("\t\t\t\twindow_height : window_height + 200,\r\n");
      out.write("\t\t\t\twindow_background : '#02050a',\r\n");
      out.write("\t\t\t\tstar_count : '250',\r\n");
      out.write("\t\t\t\tstar_color : 'rgba(100,149,237,0.9)',\r\n");
      out.write("\t\t\t\tstar_depth : '300'\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tvar hearderH = $(\".header\").height();\r\n");
      out.write("\t\tvar mainH = $(\".main\").height();\r\n");
      out.write("\t\t$(\"#map_box\").height(mainH - hearderH);\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".box:after {\r\n");
      out.write("\tcontent: \"\";\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: -8px;\r\n");
      out.write("\tright: -32px;\r\n");
      out.write("\tleft: -32px;\r\n");
      out.write("\tbottom: -8px;\r\n");
      out.write("\t/*border: 2px solid red;\r\n");
      out.write("\t\t\tbackground: skyblue;\r\n");
      out.write("\t\t\tmargin: -20px;\r\n");
      out.write("\t\t\tz-index: -1;*/\r\n");
      out.write("\t-webkit-animation: lineB 8s linear infinite;\r\n");
      out.write("\t-o-animation: lineB 8s linear infinite;\r\n");
      out.write("\tanimation: lineB 8s linear infinite;\r\n");
      out.write("\tbackground: url(\"./img/box/rb_w.png\") no-repeat right bottom;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media screen and (max-width: 2000px) {\r\n");
      out.write("\t#map_box {\r\n");
      out.write("\t\theight: 700px;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media screen and (max-width: 1366px) {\r\n");
      out.write("\t#map_box {\r\n");
      out.write("\t\theight: 500px;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table {       \r\n");
      out.write("                width: 90%;\r\n");
      out.write("\t\t\t\tmargin: 5px auto;\r\n");
      out.write("                rgba(0,0,0,0);\r\n");
      out.write("\t\t\t\tborder-collapse: collapse;/*border-collapse:collapse合并内外边距(去除表格单元格默认的2个像素内外边距*/\t\r\n");
      out.write("\t\t\t}\t\t\t\t\t\r\n");
      out.write("\t\t\tth,td {\r\n");
      out.write("\t\t\t     height: 24px;\r\n");
      out.write("\t\t\t\tline-height: 24px;\r\n");
      out.write("\t\t\t\ttext-align: center;\r\n");
      out.write("\t\t\t\tborder: 2px solid #ccc;\r\n");
      out.write("\t\t\t}\t\t\r\n");
      out.write("\t\t\tth {\r\n");
      out.write("\t\t\t    background: #2F4F4F ;\t\r\n");
      out.write("\t\t\t\tcolor:white;\r\n");
      out.write("\t\t\t\tfont-weight: normal;\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t}\t\t\r\n");
      out.write("\t\t\ttr {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t}\t\r\n");
      out.write("\t\t\ttr:hover {\r\n");
      out.write("\t\t\t\tbackground: #00FFFF;\r\n");
      out.write("\t\t\t\t/*background:#FBFBFF;*/\r\n");
      out.write("\t\t\t}\t\t\r\n");
      out.write("\t\t\ttd a {\r\n");
      out.write("\t\t\t\ttext-decoration: none;\r\n");
      out.write("\t\t\t}\t\t\r\n");
      out.write("\t\t\ttd a:hover {\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tcolor:#FBFBFF;\r\n");
      out.write("\t\t\t\ttext-decoration: underline;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"main bg\">\r\n");
      out.write("\t\t<canvas id=\"html5_3d_animation\"></canvas>\r\n");
      out.write("\t\t<!-- 这是圆圈导航 -->\r\n");
      out.write("\t\t<div class=\"radmenu\">\r\n");
      out.write("\t\t\t<a ></a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class='contentWrap'>\r\n");
      out.write("\t\t\t<!-- 导航栏 -->\r\n");
      out.write("\t\t\t<div class=\"header\">\r\n");
      out.write("\t\t\t\t<!--logo-->\r\n");
      out.write("\t\t\t\t<div class=\"logo\">\r\n");
      out.write("\t\t\t\t\t<h3>\r\n");
      out.write("\t\t\t\t\t\t新加坡爱彼迎数据分析<small></small>\r\n");
      out.write("\t\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!--导航-->\r\n");
      out.write("\t\t\t\t<div class=\"nav_menu nav\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=\"on\">首页</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href='TrafficLive.jsp'>数据展示</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"TrafficImpression.jsp\">关于我们</a>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!--时间，设置，帮助-->\r\n");
      out.write("\t\t\t\t<div class=\"nav_extra\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li id=\"date\">\r\n");
      out.write("\t\t\t\t\t\t\t<!--星期-年/月/日-->\r\n");
      out.write("\t\t\t\t\t\t\t<p id=\"date1\"></p> <!--时-分-秒-->\r\n");
      out.write("\t\t\t\t\t\t\t<p id=\"date2\"></p>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 平台主题 -->\r\n");
      out.write("\t\t\t<div class=\"content\" >\r\n");
      out.write("\t\t\t<div id=\"main\" style=\"width: 600px;height:320px;margin-left:30px;margin-top:50px;float: left;\"></div>\r\n");
      out.write("\t\t\t <div id=\"main2\" style=\"width: 650px;height:320px;margin-right:80px;margin-top:50px;float: right;\"></div>\r\n");
      out.write("\t\t\t<div style=\"width: 1200px;height:300px;margin-top:10px;margin-left:50px;\">\r\n");
      out.write("\t\t\t<table>\t<tr>\r\n");
      out.write("\t                  <th>酒店名称</th>\r\n");
      out.write("\t                  <th>具体地区</th>\r\n");
      out.write("\t                  <th>酒店评论数</th>\r\n");
      out.write("\t                  <th>酒店入住价格</th>\r\n");
      out.write("\t                  <th>回头率</th>\r\n");
      out.write("\t\r\n");
      out.write("\t                </tr>\r\n");
      out.write("\t\r\n");
      out.write("\t             ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t                 </table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t <script type=\"text/javascript\">\r\n");
      out.write("\tvar myChart = echarts.init(document.getElementById('main'));\r\n");
      out.write("\t\r\n");
      out.write("\tvar arr=new Array();\r\n");
      out.write("\tvar index =0;\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tvar option ={\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\ttooltip:{\r\n");
      out.write("\t\t\t\t trigger: 'axis',\r\n");
      out.write("\t\t\t        axisPointer : {            // 坐标轴指示器，坐标轴触发有效\r\n");
      out.write("\t\t\t            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'\r\n");
      out.write("\t\t\t        },\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t    title: {\r\n");
      out.write("        //left: 'center',\r\n");
      out.write("        text: '回头率高的酒店价格图',\r\n");
      out.write("        \ttextStyle : {\r\n");
      out.write("  \t\t\t  color : '#FBFBFF',\r\n");
      out.write("  \t\t\t   fontStyle : 'italic',\r\n");
      out.write("                },\r\n");
      out.write("        },\r\n");
      out.write("        toolbox:{              //工具栏。内置有导出图片，数据视图，动态类型切换，数据区域缩放，重置五个工具。\r\n");
      out.write("\t\t\tfeature:{          //各工具配置项。\r\n");
      out.write("\t\t\t   saveAsImage:{\r\n");
      out.write("\t\t\t\t   type:'png',\r\n");
      out.write("\t\t\t\t   title:'保存图片',\r\n");
      out.write("\t\t\t   },\r\n");
      out.write("\t\t\t   restore:{\r\n");
      out.write("\t\t\t\t   show:true,\r\n");
      out.write("\t\t\t   },\r\n");
      out.write("\t\t\t   dataView:{\r\n");
      out.write("\t\t\t\t\t show:true,\r\n");
      out.write("\t\t\t\t\t title:'数据视图工具',\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t   dataZoom:{\r\n");
      out.write("\t\t\t\t    show:true,\r\n");
      out.write("\t\t\t   },\r\n");
      out.write("\t\t\t   magicType:{\r\n");
      out.write("\t\t\t\t   type:['line','bar','stack','tiled'],\r\n");
      out.write("\t\t\t   },\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\ticonStyle:{\r\n");
      out.write("\t\t\t    borderColor:'#F0F8FF',\r\n");
      out.write("\t\t\t    borderWidth:'2',\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\txAxis:{\r\n");
      out.write("\t\t\t// type: 'category',\r\n");
      out.write("\t\t\t name:'酒店名称',\r\n");
      out.write("\t\t\t data: [\r\n");
      out.write("\t              //  \"Homestay\",\"A\",\"B\",\"C\",\"D\",\"E\",\"F\",\"G\",\"H\",\"I\"\r\n");
      out.write("\t\t\t\t ");
      if (_jspx_meth_c_005fforEach_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t            ],\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t nameTextStyle:{\r\n");
      out.write("     \t\t  color:'#FBFBFF',\r\n");
      out.write("     \t\t  fontFamily:'KaiTi',\r\n");
      out.write("     \t\t  fontSize:'20',\r\n");
      out.write("     \t\t  fontWeight:'400',\r\n");
      out.write("     \t  },\r\n");
      out.write("     \taxisLabel:{                  //坐标轴刻度标签的相关设置。\r\n");
      out.write("\t\t    color:'#FBFBFF', \t\t    \r\n");
      out.write(" },\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tyAxis:{\r\n");
      out.write("\t\t\ttype:'value',\r\n");
      out.write("\t\t\tmin:0,\r\n");
      out.write("\t\t\tmax:100,\r\n");
      out.write("\t\t\tname:'价格',\r\n");
      out.write("\t\t\tsplitNumber:10,\r\n");
      out.write("\t\t\t nameTextStyle:{\r\n");
      out.write("         \t\t  color:'#FBFBFF',\r\n");
      out.write("         \t\t  fontFamily:'KaiTi',\r\n");
      out.write("         \t\t  fontSize:'20',\r\n");
      out.write("         \t\t  fontWeight:'400',\r\n");
      out.write("         \t  },\r\n");
      out.write("         \taxisLabel:{                  //坐标轴刻度标签的相关设置。\r\n");
      out.write("\t\t\t    color:'#FBFBFF', \t\t    \r\n");
      out.write("\t  },\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tseries:[\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\tname:'酒店入住价格',\r\n");
      out.write("\t\t\t\ttype:'line',\r\n");
      out.write("\t\t\t\tdata:arr,\r\n");
      out.write("\t\t\t\tsmooth: true,\r\n");
      out.write("\t\t        showAllSymbol: true,\r\n");
      out.write("\t\t        symbol: 'emptyCircle',\r\n");
      out.write("\t\t        symbolSize: 15,\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t},{\r\n");
      out.write("\t\t\t\tname: 'line',\r\n");
      out.write("\t\t        type: 'bar',\r\n");
      out.write("\t\t        barGap: '-100%',\r\n");
      out.write("\t\t        barWidth: 10,\r\n");
      out.write("\t\t        itemStyle: {\r\n");
      out.write("\t\t            color: new echarts.graphic.LinearGradient(\r\n");
      out.write("\t\t                0, 0, 0, 1,\r\n");
      out.write("\t\t                [\r\n");
      out.write("\t\t                    {offset: 0, color: 'rgba(0,255,255,0.9)'},\r\n");
      out.write("\t\t                    {offset: 0.2, color: 'rgba(0,255,255,0.5)'},\r\n");
      out.write("\t\t                    {offset: 1, color: 'rgba(0,255,255,0)'}\r\n");
      out.write("\t\t                ]\r\n");
      out.write("\t\t            )\r\n");
      out.write("\t\t        },\r\n");
      out.write("\t\t        z: -12,\r\n");
      out.write("\t\t        data: arr\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t]\r\n");
      out.write("\t\t\r\n");
      out.write("\t};\r\n");
      out.write("\t myChart.setOption(option);\r\n");
      out.write(" </script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("         var myChart2 = echarts.init(document.getElementById('main2'));\r\n");
      out.write("         var datas =[];\r\n");
      out.write("         var arr,area;\r\n");
      out.write("\r\n");
      out.write("      ");
      if (_jspx_meth_c_005fforEach_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    console.log(datas);\r\n");
      out.write("\r\n");
      out.write("var option ={\r\n");
      out.write("\t\ttitle:{\r\n");
      out.write("\t\t\tleft:'right',\r\n");
      out.write("\t\t text:'酒店回头率集中地区扇形图',\r\n");
      out.write("\t\t textStyle : {\r\n");
      out.write(" \t\t\t  color : '#FBFBFF',\r\n");
      out.write(" \t\t\t   fontStyle : 'italic',\r\n");
      out.write("               },\r\n");
      out.write("\t\t},\r\n");
      out.write("\t  //  backgroundColor: '#404a59',\r\n");
      out.write("\t    legend:{\r\n");
      out.write("\t    \ttop:'80%',\r\n");
      out.write("\t    \tleft:'left',\r\n");
      out.write("\t    \tdata:datas.name,\r\n");
      out.write("\t    \torient:'vertical'\r\n");
      out.write("\t    },\r\n");
      out.write("\t\ttooltip:{},//提示框\r\n");
      out.write("\t\t// 饼图的标签的视觉引导线的颜色设置为浅色\r\n");
      out.write("\t\tlabelLine:{\r\n");
      out.write("\t\t    \t\r\n");
      out.write("\t\t    normal:\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t    \tlineStyle:{\r\n");
      out.write("\t\t    \t\tcolor:'rgba(255, 255, 255, 0.3)'\r\n");
      out.write("\t\t    \t}\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\titemStyle:{\r\n");
      out.write("\t\t\temphasis:{\r\n");
      out.write("\t\t\t   \t// 阴影的大小\r\n");
      out.write("                 shadowBlur: 200,\r\n");
      out.write("                 // 阴影颜色\r\n");
      out.write("                 shadowColor: 'rgba(0, 0, 0, 0.5)'\r\n");
      out.write("\t\t\t   }\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tvisualmap:[{\r\n");
      out.write("\t\t\thoverLink:true\r\n");
      out.write("\t\t}],\r\n");
      out.write("\t\tseries:[\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tname:'访问来源',\r\n");
      out.write("\t\t\ttype:'pie',\r\n");
      out.write("\t\t\t//center:['60%','40%'],\r\n");
      out.write("\t\t\tradius:['40%','75%'],//饼图半径\r\n");
      out.write("\r\n");
      out.write("\t\t    data:datas\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t]\r\n");
      out.write("\r\n");
      out.write("\t};\r\n");
      out.write("myChart2.setOption(option);\r\n");
      out.write("</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("<!-- 导航栏实时显示时间 -->\r\n");
      out.write("<script>\r\n");
      out.write("var date1 = document.getElementById(\"date1\");\r\n");
      out.write("\t\tvar date2 = document.getElementById(\"date2\");\r\n");
      out.write("\t\tvar haha = new Date();\r\n");
      out.write("\t\tdate1.innerHTML = haha.getWeek() + \"   \" + haha.format(\"YY-MM-DD\");\r\n");
      out.write("\t\tdate2.innerHTML = haha.getNowTime();\r\n");
      out.write("\t\tsetTimeout(function() {\r\n");
      out.write("\t\t\tdate1.innerHTML = haha.update(\"week\") + \"   \" + haha.update(\"YYYY-MM-DD\");\r\n");
      out.write("\t\t\tdate2.innerHTML = haha.update(\"nowTime\");\r\n");
      out.write("\t\t\tsetTimeout(arguments.callee,50)\r\n");
      out.write("\t\t},50)\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /test2.jsp(175,14) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.hotelsList }", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      // /test2.jsp(175,14) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("item");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\r\n");
            out.write("\t                <tr>\r\n");
            out.write("\t                  <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t                  <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.neigh}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t                  <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.comments}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t                  <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t                  <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.reviews_per_month}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("\t\r\n");
            out.write("\t                </tr>\r\n");
            out.write("\t                              ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f1_reused = false;
    try {
      _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f1.setParent(null);
      // /test2.jsp(195,1) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.hotelsList}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      // /test2.jsp(195,1) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setVar("g");
      int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
        if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("    arr[index++] = \"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${g.price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\";\r\n");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f1.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
      _jspx_th_c_005fforEach_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f2_reused = false;
    try {
      _jspx_th_c_005fforEach_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f2.setParent(null);
      // /test2.jsp(246,5) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.hotelsList}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      // /test2.jsp(246,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f2.setVar("g");
      int[] _jspx_push_body_count_c_005fforEach_005f2 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f2 = _jspx_th_c_005fforEach_005f2.doStartTag();
        if (_jspx_eval_c_005fforEach_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                 [\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${g.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"],\r\n");
            out.write("             ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f2.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f2[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f2.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f2.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f2);
      _jspx_th_c_005fforEach_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f3 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f3_reused = false;
    try {
      _jspx_th_c_005fforEach_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f3.setParent(null);
      // /test2.jsp(317,6) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f3.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${requestScope.hotelsList}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      // /test2.jsp(317,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f3.setVar("g");
      int[] _jspx_push_body_count_c_005fforEach_005f3 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f3 = _jspx_th_c_005fforEach_005f3.doStartTag();
        if (_jspx_eval_c_005fforEach_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("          area = \"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${g.neigh}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\";\r\n");
            out.write("          arr = \"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${g.reviews_per_month}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\";\r\n");
            out.write("\r\n");
            out.write("      datas.push({\r\n");
            out.write("\t       \"name\": area,\t\"value\":arr\r\n");
            out.write("\t\r\n");
            out.write("    });\r\n");
            out.write("       ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f3.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f3[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f3.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f3.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f3);
      _jspx_th_c_005fforEach_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f3, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f3_reused);
    }
    return false;
  }
}
