package com.ehelpy.brihaspati4.GC;

//import com.ehelpy.brihaspati4.DFS.DFSUI;
//import com.ehelpy.brihaspati4.DFS.Save_Retrive_data_Structures;

import com.ehelpy.brihaspati4.comnmgr.CommunicationManager;
/*
import com.ehelpy.brihaspati4.comnmgr.NATHandler;
import com.ehelpy.brihaspati4.comnmgr.NATServer;
import com.ehelpy.brihaspati4.indexmanager.IndexManagement;
import com.ehelpy.brihaspati4.indexmanager.IndexManagementUtilityMethods;
import com.ehelpy.brihaspati4.overlaymgmt.OverlayManagement;
*/
//import com.ehelpy.brihaspati4.routingmgmt.RMThreadPrimary;
//import com.ehelpy.brihaspati4.routingmgmt.SysOutCtrl;
//import com.ehelpy.brihaspati4.routingmgmt.UpdateIP;
//import com.ehelpy.brihaspati4.voip.B4services;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.Properties;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
/*
import com.ehelpy.brihaspati4.authenticate.emailid;
import com.ehelpy.brihaspati4.authenticate.Config;
import com.ehelpy.brihaspati4.authenticate.GlobalObject;
import com.ehelpy.brihaspati4.authenticate.dateTimeCheck;
import com.ehelpy.brihaspati4.authenticate.Gui;
import com.ehelpy.brihaspati4.authenticate.Integrity;
import com.ehelpy.brihaspati4.authenticate.GenerateCertificate2;
import com.ehelpy.brihaspati4.authenticate.createConnection;
import com.ehelpy.brihaspati4.authenticate.debug_level;
import com.ehelpy.brihaspati4.authenticate.ReadVerifyCert;
import com.ehelpy.brihaspati4.authenticate.CertificateSignature;
*/
import com.ehelpy.brihaspati4.authenticate.Config; // to be changed when config file is moved to GC
import com.ehelpy.brihaspati4.authenticate.GlobalObject; // to be changed when config file is moved to GC

//import com.ehelpy.brihaspati4.indexmanager.IndexingManager;

import com.ehelpy.brihaspati4.routingmgmt.RoutingManager;
import com.ehelpy.brihaspati4.GC.GlueCode;
import com.ehelpy.brihaspati4.DFS.dfs3Mgr.DFS3Config;
import com.ehelpy.brihaspati4.simulateGC.init.DFSInit;

import com.ehelpy.brihaspati4.WebSrVr.WebUIServer;
import com.ehelpy.brihaspati4.authenticate.Authenticator;
import com.ehelpy.brihaspati4.comnmgr.Communicator;
import com.ehelpy.brihaspati4.indexmanager.IndexingManager;
//import com.ehelpy.brihaspati4.simulateGC.IM.Testing;


public class ClientMainNew extends Thread
{
    private static X509Certificate client_cert = null;
    private static X509Certificate server_cert = null;
    private static boolean flagset = false;
    public static int CtrlConsoleOut=0;
    public static String Device_Id="";
    public static String Node_Id="";
    public static String Node_Ip="";
    public static int port = 9000;
    public static String updated_time = "";
    
    public static void main(String args[]) throws Exception
    {
        public static GlueCode gc = new GlueCode();

        try(FileReader reader =  new FileReader("configuration/gc_config.txt"))
        {
            Properties properties = new Properties();
            properties.load(reader);
            max_limit_of_skip_flags = properties.getProperty("max_limit_of_skip_flags");
            max_limit_of_buffer = properties.getProperty("max_limit_of_buffer");

            System.out.println(max_limit_of_skip_flags);
            System.out.println(max_limit_of_buffer);
        }catch (Exception e)
        {
            ;
            e.printStackTrace();
        }
        // @SuppressWarnings("unused")

        // Create a singleton global object and set run status as true.
        // GlobalObject will keep status of various threads and run status. This will be used
        // for proper closure of threads when closing the application.
        // Each module, will have separate singleton status object - which can
        // be set as true or false by API from glue code.

        GlobalObject globj= GlobalObject.getGlobalObject();
        globj.setRunStatus(true);



        // Configuration object created and object reference is saved in
        // Authenticator object in the Authentication module (see
        // ../authenticate directory)
        //

        // The messages received from webserver module based on browser UI
        // inputs, will be redirected to Authenticator object for reading or
        // writing of configuration. -[Surbhi]

        Authenticator auth = Authenticator.getInstance();
        if( auth.isAlive() != true) {
            auth.start();
        } else {
            printLog("ClientMainNew: authenticator thread already running.");
        }
        globj.updateObjRef("Authenticator", auth);

// to be added in GlobalObject to maintain array of module name and
// corresponding object reference.

// Starting Routing Manager thread. The RoutingManager object will be in
// ../routingmgmt directory
        RoutingManager RoutMgr = RoutingManager.getInstance();
        //   if ( RoutMgr.isAlive() != true){RoutMgr.start();}
        //	else { printLog("ClientMainNew: Routing Manager thread already running.");}
        globj.updateObjRef("RoutingManager", RoutMgr);

// Create routing manager instance
            //    RoutingManager rm=RoutingManager.getInstance();
                // Getting the Node ID of the Client
                Node_Id=RoutMgr.getNodeID();
                System.out.println("The Node id is "+Node_Id);
                Device_Id=RoutMgr.getSystemMACAddress();
                System.out.println("The device id is "+Device_Id);
                Node_Ip=RoutMgr.getIPAddress();
                System.out.println("The device ip is "+Node_Ip);
// Starting GUI webserver for React based web UI interface.
//        String StaticFilesPath = "C:\\Users\\hp\\b4client\\java\\com\\ehelpy\\brihaspati4";
     //  String StaticFilePath="/home/nksingh/b4client-rw/java/com/ehelpy/brihaspati4/";
     //   String StaticFilePath="../";
        
        // Create a file object
        File f = new File("java/com/ehelpy/brihaspati4");
  
        // Get the absolute path of file f
        String StaticFilePath = f.getAbsolutePath();

        WebUIServer WebUIS = WebUIServer.getInstance();
//	if (WebUIS.isAlive()!=true) {

//	if((Class.forName("java.lang.String").isInstance(WebUIS)) !=true){
        WebUIS.start(port,StaticFilePath);
        //   }
//	else { printLog("ClientMainNew: WebUIS thread already running.");}
        System.out.println("Coming here");
        //   WebUIServer WebUIS = WebUIServer.getInstance();
        //	if (WebUIS.isAlive()!=true) { WebUIS.start();}
        //	else { printLog("ClientMainNew: WebUIS thread already running.");}
        globj.updateObjRef("WebUI", WebUIS);

// Starting Communication Manager thread. The CommunicationManager object will be in ../comnmgr directoryCommunicator
        Communicator comn = Communicator.getInstance();
        if (comn.isAlive() !=true) {
            comn.start();
        }
        else {
            printLog("ClientMainNew: Communication Mgr thread already running.");
        }
        globj.updateObjRef("Communicator", comn);

// Starting Index Manager thread. The IndexManager object will be in ../indexmanager directory
        IndexingManager inm = IndexingManager.getInstance();
        //  if(inm.isAlive() !=true){
        //  inm.start();
        // }
        //  else { printLog("ClientMainNew: Index manager thread already running.");}
        globj.updateObjRef("IndexingManager", inm);
        

// dateTimeCheck -- should be move to authenticate Module.
	
    //    boolean timeflg=dateTimeCheck.checkDate();
    
	updated_time = auth.getUpdatedTime();      
	System.out.println("node's updated time is"+updated_time);
        /*
        * To be done in authentication and security module - [Anupam]
        * Date and time is to be checked. It should be same as on standard time
               * server or greater than equal to last logout date time value.  If the returns
               * value false (in case the above conditions fails) then exit the user from the
               * system with advise to user to correct the system date and time. otherwise
               * start the services.
               */

    gc.mainMethod();

	flagset = auth.getAuthVerifyFlag();
        if(flagset) {
            // get singleton object for DHTRouter, RTManager, DHTable,
            // SpillOverTable, ComnMgr, ProxyRouter, MulticastMgr, MediaBridge,
            // IndexingMgr, KeyCache, SearchEngine, ContentCache,
            // Broadcast-RWRouter.
            // DHTRouter dhtr = DHTRouter.getDHTRouter();
            // RTManager rtmgr = RTManager.getRTManager();
            // DHTable dhtable = DHTable.getDHTable();
            // start the nat server

//		    RoutingManager rm=RoutingManager.getInstance();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // call objects of routing  mangement

            System.out.println("Starting IndexManagement thread");
     
        }
	
        // Loop created so that object reference of Global object is maintained and it is not garbage collected.
        // It need to exist for all the modules to run.
        while(globj.getRunStatus()) {
            Thread.sleep(30000);
        }

    }

    public static void printLog(String name) {

        System.out.println("Log = " + name);
    }


}
