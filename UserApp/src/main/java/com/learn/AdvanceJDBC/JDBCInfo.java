package com.learn.AdvanceJDBC;

/*******************
 * 
 * 
 * JDBC Advance :
 * 
 * JDBC BATCH :
 * 
 *   if we take mutiple DML state from JDBC client through the DRIVER , SO Web server is different location and database server
 *   somewhere else so its request over harmed and its effect performance.
 *   
 *   But Using jdbc batch group , we can set a group of DML statement and data manuplution and sent then to database at once.
 *   
 *   for precoessing. 
 *   
 *   DB process all them and group of result back and let us know ehat happend to these statements.
 *   
 *   We do batching in two Steps :
 *   
 *   Step 1 : Add the DML statements 
 *                   stmt.addBatching(String DML)
 *   
 *   Step 2 : execute the BATCH
 *                   int result []=stmt.executeBatch();
 *                   
 *                   
 *                   
 *    ResultSetMetaData :
 *   
 *                  
 *    Result set is an inteface  in the JDBC API using which we can move through the row of data comes back when we
 *    execute the select query and deal with each row and data in each cplumn one at time.
 *    
 *    its give meta deta like now of rows no of element in each row numner of columns
 *    
 *    ResultSet rs= stmt.executeQuery("select * from user");
 *    
 *    
 *    
 *    ResultSetMetaData RSM=rs.getMetaDeta()
 *    
 *    int no_of_columns=RSM.getColumnCount();
 *    
 *    
 *    
 *    
 *    Transaction ManageMent :
 *    
 *    Four properties that every transtion has and the method that we can use to manage and control or trasaction.
 *    
 *    Transaction is a logical unit or its get done complete or nothing like 1 for completed or 0 for nothing.
 *    
 *    not like .6, .6 half transction completed.
 *    
 *    Tranaction follow ACID properties
 *    
 *    ATOMOCITY
 *    CONSTITENCE
 *    ISOLATION 
 *    Duralbality 
 *    
 *    Control Transaction  :
 *    
 *    Commit, rollback and SavePoint 
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
 * 
 * 
 * 
 * 
 * 
 * @author choudhar
 *
 */
public class JDBCInfo {

}
