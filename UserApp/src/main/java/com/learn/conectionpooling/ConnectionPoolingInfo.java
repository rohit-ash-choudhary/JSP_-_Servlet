package com.learn.conectionpooling;
/*
 * 
 * 
 *  Connection Pooling :
 *               Connection Pooling allow us to request the container to create a set of JDBC connection.
 *               
 *               When its startup these connection can used by servlet or jsp or any other web services.
 *               and the connection back then they did their work.
 *               
 *              Advantages :
 *              1. Increase performce :  as all the connections are ready even before client request.
 *              so servlet no need to connect database save time
 *              2. Re-Use : Once one jsp used and it work completed its don't close database connection
 *              sent connection to pool and then other jsp/servlet can use that connection from pool
 *              
 *              Context.xml and jdbc jar 
 *              
 *              inside context.xml:
 *               <Resource name="mydb" outh="Container" type="javax.sql.DataSource" driverClassName="com.sql.jdbc.Driver"
                    url="jdbc:mysql://localhost/mydb" username="root" password="Rooh@#2001"/>
                    here when tomcat start create connection pool
                    
          Aquire A database Connection from connection pool:
          first connect a naming services  then lookup for  the DataSource  and Get Connection
                 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class ConnectionPoolingInfo {

}
