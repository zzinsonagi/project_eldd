
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="db.*" %>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="java.text.*" %>
    
    <%
    
    Connection conn = DBmanager.getIns().getConn();
    
    if(conn != null) {
    	out.print("접속 완료");
    }else{
    	out.print("접속 실패");
    }
    
    %>
