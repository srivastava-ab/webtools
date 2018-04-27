<%@page import="com.me.webtools.controllers.LoginController"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome to upload</title>
    </head>
    <body>


        <div class="modal-dialog">
            <div class="modal-content">
                <div class="panel panel-primary" style="margin-bottom: 0px;">
                    <div class="panel-heading">
                        Form Upload Photo
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-6">
                            <form:form id="imgUpload" action="/uploadimgctlr" method="GET" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label>File input</label>
                                        <input type="file" method="POST" accept=".jpg" name="file"/>
                                    </div>
                                    <div >
                                        <button type="submit" class="btn btn-primary">Upload</button>
                                    </div>
                                </form:form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>

    </body>
    </html>