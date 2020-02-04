<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ taglib uri="/com/gx/soft/office/util/dateutil" prefix="dateutil" %>

<%pageContext.setAttribute("ctx", request.getContextPath());%>
<%pageContext.setAttribute("locale", request.getLocale());%>