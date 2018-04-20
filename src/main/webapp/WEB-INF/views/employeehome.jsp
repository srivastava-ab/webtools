<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>
	<jsp:attribute name="footer">
      <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
    </jsp:attribute>
	<jsp:body>
        <p>Hi I'm the heart of the message</p>
        
        <a href="profile.htm">Profile</a>
		</br>
		<a href="findJob.htm">Find a job</a>
		</br>
		<a href="myJob.htm">My jobs</a>
    </jsp:body>
</t:genericpage>