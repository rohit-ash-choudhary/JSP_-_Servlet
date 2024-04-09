package com.learn.CustomTagsInJSP;

/*
 * 
 *  CustomTags in JSP :
 *          When inbuild tags are not enough then we create custom tags.
 *          CustomTags is 2  step prcoess :
 *          1. First create java class that whaterver he do when we create a custom jsp tag.
 *          2. then we map the custom class in file called Tag Lib Descriptor. : TLD file
 *          TLD is xml file that help us to pass in some propeties to this handler class at runtime and also mapped this
 *          handler class to the tag itself 
 *          Container read this file and let us know which tag in jsp correcspond which tag handler class
 *                    
 *                    
 *          to Implement or create  a handler class we either implement the tag interface in JSP API or i most
 *           implicit the tag thats already implement the tags.
 *           
 *           Javax.servlet.jsp.targext.Tags
 *           
 *           
 *           Javax.servlet.jsp.targext.TagSupport 
 *           
 *           we can override the method that need.
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
 */
public class CustomTagInfo {

}
