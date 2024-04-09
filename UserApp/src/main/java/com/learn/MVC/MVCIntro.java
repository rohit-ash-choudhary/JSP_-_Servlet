package com.learn.MVC;
/*
 * 
 *   MVC :
 *       MVC is a design pattern or a framework that split the web layer into 3 Parts
 *       Model  : Current state of application, most of code and business logic.
 *               its call other database class and connect to database and other work.
 *       View   :  View is responblice for view current model to end user.
 *                  its generate html and sent back to the browser.
 *       Controller  : 
 *               Controller is a glue between Model and view so it is resposible for selecting approiate model to
 *               serve the approriate request so when request come from client it go to controller and container will
 *               call the container.
 *               
 *               Clinet ----request-come---> Controller(Controller understood the approritate model which perfom business logic
 *                                           
 *                                          |                                   \                |
 *                                           |                                     \               |
 *                                          |                                       \              |
 *                                          |                                        \             |
 *                   Controller select 
 *                   the approtiate view    \                                        \              \
 *                   to disply data         \                          responce back  \             |
 *                                          |                                           \           |
 *                                          |                                            \          |
 *                                          |                                             \         |
 *                                                                                        \ ______  Model *                                                                                    \           Model (model understood businees
 *                                    View                                                           logic and sent back request to controller)
 *              and then view sent back to clinet browser
 * 
 * 
 *   Reason of use mvc :
 *   1. Maintance : if we face issue in any componet like display then developer need to touch only view 
 *                not other module , if there wrong in business logic we will check model componets 
 *   2.Parallel Development : we can developer parallel like fronted team focus on view module and developer team can 
 *            model to write business logic.
 *   
 *               
 * 
 * 
 * 
 * 
 * 
 */
public class MVCIntro {

}
