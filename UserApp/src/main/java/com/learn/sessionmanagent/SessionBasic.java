package com.learn.sessionmanagent;


/*
 * 
 * 
 * HTTP Stateless :
 * 
 * HTTP statless mean server doesn't main a continues connection once the server once the server handle the request and 
 * sent back the response.
 *  There is not socket connection alive and destroy.
 *  
 *  like when request come socket connection create and when server response back connection destroy.
 *  
 *  if new request come again client create new connection and server will handle it and after response its also destroy.
 *  
 *  and http don't know what http did in last request as every time there is new connection.
 *  
 *  Advantages of HTTP Stateless :
 *  1. Performance :
 *                 If client don't sent request then server doesn't need to main connection, server kill connection,
 *                 
 *  2. Stability :
 *                 We can deploy our application to mutiple server like Loadblancer.
 *                 like first time may be handle request by server 1 and second time may be by server 28.
 *                 
 *                 
 *                 
 *  Disadvantages :
 *  1. We can't main the services like shopping cart
 *  2. or we want to keep memory from last request then its not possible.
 *  
 *  
 *  Thats why session Tracking come to overcome this issue.
 *  
 *  
 *  Steps to handle session in JAVA EE :
 *  
 *  there are 3 step in JAVA SE to handle session,
 *  
 *  
 * 1. Create session :
 *         HttpSession session=request.getSession();
   and we used the method available on HttpSession object , object to handle this session we can create shopping
 *    cart and whatever user want.
 *    
 * 2. Main the data using the four attribute method on HttpSession.
 * 
 * 3. End the session. : there is two way to end the session.
 * 
 * How the session Work  :
 * 
 *   we will design as htmp page thats allowed to end user to enter user name 
 *   
 *   then this html page submitted to source servlet that set the request parameter into session object ,
 *   it will retrieve the http session object from the request. and it will set username on it.
 *   
 *   then we will generate a html which will have a hyperlink when will click on second servlet that the target servlet.
 *   in the target servlet we will retrieve the username from session which the source servlet set. and then we will display
 *   to end user.
 *   
 *   
 *   
 *   
 *   and parameter username set to Session object (HttpSession session)
 *   
 *   
 * 
 *  * 
 *  
 *  What Does Container do when we invoke http servlet request getSession method to get a session.
 *    HttpSession session=request.getSession();
 *    
 *    When user request come in and invoke request.getSession servlet web Container like TOMCAT has to see session ID in it
 *    if there is no session id Web Container creare a new session id in memory and will generate a unique session id for that web
 *    client and i will associate the newly created session  with that unique id then handover it  http session to serlvet program
 *    and maintan the state 
 *    
 *    and then httpServlet responce back to clinet and the next time if web clinet sent request again then tomcat (web container)
 *    check if there is session id in it or not
 *    if session id request_id in session list then its used that session otherwise request new session id same as above.
 *    
 *    
 *    Basically web container check if there is session_id in request then its check in session list if its present
 *    there its use that otherwise it create new and same process repeat.
 *    
 *    
 *    Session Tracking :
 *    
 *    Session tracking is mainting the state across the application request , despite the statelessness of http proctocaol that
 *    that is if you want to maintain something like 
 *    
 *    like you main something like shopping cart but http is stateless show we need to do some extra work called session 
 *    Tracking.
 *    
 *    What is session :
 *    first definition : 
 *    Whatever happens right from the unser login in application and till he logout can be termed as session.
 *    Second Definition 
 *    Tracking user interction : time from user access the website first time to to user close the browser.
 *                    Entire time  is called the the session. like user login as guest and you close website
 *                    for this we maintain session.
 *                    
 *                    where from and to flight city price fair all if e commerce then cart add product and other info.
 *                    
 *              Javax.servlet.http.server in java. represent a session object.
 *              
 *           2 things important of Session  :
 *           
 *           1. Client/User indetification
 *           2. State maintains : like 
 *           
 *           
 *           
 *         End the Session :
 *         
 *         Way 1 : When user click on logout button and logout from application
 *         Way 2 : User be in-active more then specified time, then container explict the destory session called
 *         session expiry for tomcat its default 30 min but we can change.
 *         
 *         Override Session Expire :
 *         session.setMaxInactiveInterval(600);  inside jsp and servelt time in seconds
 *         
 *         in Web.xml  : 
 *                    <web-app ...>
              <session-config>
              <session-timeout>10</session-timeout> : here time in 10 min
              </session-config>

</web-app>




 *                          
 *          
 *          
 *         HTTP Cookies: 
 *              Http cookies are name-value pairs of textual information that can be used for exchange data between
 *              web server and web client as part of HTTP HEADER.
 *              
 *              WE CAN pass any kind of parameter like fav product ect.
 *              
 *              but usually cookies are used to maintain session between web browser and container.
 *              
 *              IN JAVAEE : cookies used for session management is jsessionid=1234.
 *              
 *              When web clinet sent first request to web container then web container create
 *              unique jsession id when container sent back response then container also used this
 *              jsession id as part of http header.
 *              
 *              when client sent again request its sent jsession id to container so container can
 *              can now this particular jsession associated with particular session.
 *              
 *              
 *              Generally we rarely create cookies by own
 *              but how we create cookies as below :
 *              
 *              Cookie c=new Cookie("jsessionid","1235")
 *              
 *              responce.addCookie(c)
 *              
 *              
 *              
 *              URL Re-wrting :
 *              its required when cookies are disable at client browser for some reason.
 *              if we can to exchange session id as we are not using the cookies will have to fall back to URL
 *              RE-WRITING
 *              url re-writting only works with URL not with Forms.
 *              
 *    
 *    
 *    
 *    
 *  
 * 
 */


public class SessionBasic {

}
