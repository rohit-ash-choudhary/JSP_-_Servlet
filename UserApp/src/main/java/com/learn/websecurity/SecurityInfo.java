package com.learn.websecurity;
/*
 * 
 * 
 * 
 * 
 * tomcat-users.xml and web.xml
 * 
 *  in tomcat-user.xml
 *  
 *  
 *  <!--
  <role rolename="tomcat"/>
  <role rolename="role1"/>
  <user username="tomcat" password="<must-be-changed>" roles="tomcat"/>
  <user username="both" password="<must-be-changed>" roles="tomcat,role1"/>
  <user username="role1" password="<must-be-changed>" roles="role1"/>
-->


    <role rolename="myUserRole"/>
     <user username="MyUser" password="myPassword" roles="myUserRole"/>
     
     
     in web.xml
     
     
     
 <security-constraint>
    <web-resource-collection>
        <web-resource-name>myResource</web-resource-name>
        <url-pattern>/*</url-pattern>
    </web-resource-collection>
    <auth-constraint>
        <role-name>myUserRole</role-name>
    </auth-constraint>
</security-constraint>
<login-config>
    <auth-method>FORM</auth-method>
    <realm-name>FILE</realm-name>
   <!--  <form-login-config>
       <form-login-page>FormSecurity.jsp</form-login-page>
        <form-error-page>error.jsp</form-error-page> 
    </form-login-config> --> 
</login-config>
 */
public class SecurityInfo {

}
