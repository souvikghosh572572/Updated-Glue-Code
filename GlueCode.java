package com.ehelpy.brihaspati4.GC;
//Glue Code Pseudo Code:

//  Glue Code = gc
//  Authentication Manager = am
//  Communication Manager = cm
//  Indexing Manager = im
//  Routing Manager = rm
//  Web Server Module = ws
//  Web Module = web
//  DFS = dfs
//  UFS = ufs
//  Message = sms
//  Mail = mail
//  VoIP = voip
//  Address Book = adbk
//  Search = srch

//import the required packages...
import java.util.*;
import java.util.LinkedList;
import java.lang.reflect.*;
//import com.ehelpy.brihaspati4.GC.ModuleCheck;  XXXXXXXXXXXX
//import com.ehelpy.brihaspati4.DFS.DFSUI;
//import com.ehelpy.brihaspati4.DFS.Save_Retrive_data_Structures;
/*import com.ehelpy.brihaspati4.comnmgr.CommunicationManager;
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

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

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

//import com.ehelpy.brihaspati4.indexmanager.IndexingManager;

import com.ehelpy.brihaspati4.routingmgmt.RoutingManager;

//import com.ehelpy.brihaspati4.DFS.dfs3Mgr.DFS3Config;
//import com.ehelpy.brihaspati4.simulateGC.init.DFSInit;

//import com.ehelpy.brihaspati4.simulateGC.IM.Testing;


public class GlueCode
{
    //Start thread of Authentication Manager.
    //Start thread of Routing Manager.
    //Start thread of Communication Manager.
    //Start thread of Indexing Manager.
    //Start thread of Web Server.

    //Initialize a status_skip_flag corresponding to each input buffer (one input buffer for each module) of the Glue Code with 1. (This status_skip_flag will contain values in the powers of 2 such as 1, 2, 4, etc., upto some specific number limit such as 16 or 32.) (The default value for the status_skip_flag for each module at starting will be 1.)

    //private String final_query;
    //Example: private static ConfigData config;
    //         config = ConfigData.getInstance();

    //final_query = ModuleCheck.findModuleName(qname);
    //Call the final query...

    private int status_skip_flag_am = 1;
    private int status_skip_flag_cm = 1;
    private int status_skip_flag_im = 1;
    private int status_skip_flag_rm = 1;
    private int status_skip_flag_ws = 1;
    private int status_skip_flag_web = 1;
    private int status_skip_flag_dfs = 1;
    private int status_skip_flag_ufs = 1;
    private int status_skip_flag_sms = 1;
    private int status_skip_flag_mail = 1;
    private int status_skip_flag_voip = 1;
    private int status_skip_flag_adbk = 1;
    private int status_skip_flag_srch = 1;

    //Initialize a current_skip_flag corresponding to each input buffer (one input buffer for each module) of the Glue Code with 1. (This current_skip_flag will contain the current value; ie., after how many rotations the input buffer corresponding to that respective module will be checked.) (The default value for the current_skip_flag for each module at starting will be 1.)

    private int current_skip_flag_am = 1;
    private int current_skip_flag_cm = 1;
    private int current_skip_flag_im = 1;
    private int current_skip_flag_rm = 1;
    private int current_skip_flag_ws = 1;
    private int current_skip_flag_web = 1;
    private int current_skip_flag_dfs = 1;
    private int current_skip_flag_ufs = 1;
    private int current_skip_flag_sms = 1;
    private int current_skip_flag_mail = 1;
    private int current_skip_flag_voip = 1;
    private int current_skip_flag_adbk = 1;
    private int current_skip_flag_srch = 1;

    private int max_limit_of_skip_flags = 32;
    private int count = 0;
    //private String[] module_acronyms = {"am", "cm", "im", "rm", "ws", "web", "voip", "dfs", "ufs", "mail", "sms"};

    // inputModule_buffer_outputModule
    // here, in the next line, "am" sent the data to "gc"
    private static LinkedList gc_buffer_am = new LinkedList();
    private static LinkedList gc_buffer_cm = new LinkedList();
    private static LinkedList gc_buffer_im = new LinkedList();
    private static LinkedList gc_buffer_rm = new LinkedList();
    private static LinkedList gc_buffer_ws = new LinkedList();
    private static LinkedList gc_buffer_web = new LinkedList();
    private static LinkedList gc_buffer_dfs = new LinkedList();
    private static LinkedList gc_buffer_ufs = new LinkedList();
    private static LinkedList gc_buffer_sms = new LinkedList();
    private static LinkedList gc_buffer_mail = new LinkedList();
    private static LinkedList gc_buffer_voip = new LinkedList();
    private static LinkedList gc_buffer_adbk = new LinkedList();
    private static LinkedList gc_buffer_srch = new LinkedList();
    
    private static LinkedList internal_process_queue = new LinkedList();
    private static List process_var = new ArrayList();
    private static String destination_module = new String();

    public static GlueCode gc = new GlueCode();
    //public static TestCM cm = new TestCM();
    //public static TestRM rm = new TestRM();

    // gc.addMessage_gc_buffer(rm, list_variable)


    // public addMessage_gc_buffer(String source_module_acronym, List message)
    // {
    //     String =
    //     gc_buffer_{source_module_acronym}.add(message);
    // }

    // gc.addMessage_gc_buffer_rm(list_variable)

    public static void addMessage_gc_buffer_am(List amMessage)
    {
        gc_buffer_am.add(amMessage);
        System.out.println("List received by GC's (AM) input buffer.");
    }
    public static void addMessage_gc_buffer_cm(List cmMessage)
    {
        gc_buffer_cm.add(cmMessage);
        System.out.println("List received by GC's (CM) input buffer.");
    }
    public static void addMessage_gc_buffer_im(List imMessage)
    {
        gc_buffer_im.add(imMessage);
        System.out.println("List received by GC's (IM) input buffer.");
    }
    public static void addMessage_gc_buffer_rm(List rmMessage)
    {
        gc_buffer_rm.add(rmMessage);
        System.out.println("List received by GC's (RM) input buffer.");
    }
    public static void addMessage_gc_buffer_ws(List wsMessage)
    {
        gc_buffer_ws.add(wsMessage);
        System.out.println("List received by GC's (WS) input buffer.");
    }
    public static void addMessage_gc_buffer_web(List webMessage)
    {
        gc_buffer_web.add(webMessage);
        System.out.println("List received by GC's (WEB) input buffer.");
    }
    public static void addMessage_gc_buffer_dfs(List dfsMessage)
    {
        gc_buffer_dfs.add(dfsMessage);
        System.out.println("List received by GC's (DFS) input buffer.");
    }
    public static void addMessage_gc_buffer_ufs(List ufsMessage)
    {
        gc_buffer_ufs.add(ufsMessage);
        System.out.println("List received by GC's (UFS) input buffer.");
    }
    public static void addMessage_gc_buffer_sms(List smsMessage)
    {
        gc_buffer_sms.add(smsMessage);
        System.out.println("List received by GC's (SMS) input buffer.");
    }
    public static void addMessage_gc_buffer_mail(List mailMessage)
    {
        gc_buffer_mail.add(mailMessage);
        System.out.println("List received by GC's (MAIL) input buffer.");
    }
    public static void addMessage_gc_buffer_voip(List voipMessage)
    {
        gc_buffer_voip.add(voipMessage);
        System.out.println("List received by GC's (VOIP) input buffer.");
    }
    public static void addMessage_gc_buffer_adbk(List adbkMessage)
    {
        gc_buffer_adbk.add(adbkMessage);
        System.out.println("List received by GC's (ADBK) input buffer.");
    }
    public static void addMessage_gc_buffer_srch(List srchMessage)
    {
        gc_buffer_srch.add(srchMessage);
        System.out.println("List received by GC's (SRCH) input buffer.");
    }
    
    
    public static void display_buffer_status()
    {
        System.out.println("\nSHOWING BUFFER STATUS:");
        System.out.println("GC's (AM) Input Buffer: " + gc_buffer_am);
        System.out.println("GC's (CM) Input Buffer: " + gc_buffer_cm);
        System.out.println("GC's (IM) Input Buffer: " + gc_buffer_im);
        System.out.println("GC's (RM) Input Buffer: " + gc_buffer_rm);
        System.out.println("GC's (WS) Input Buffer: " + gc_buffer_ws);
        System.out.println("GC's (WEB) Input Buffer: " + gc_buffer_web);
        System.out.println("GC's (DFS) Input Buffer: " + gc_buffer_dfs);
        System.out.println("GC's (UFS) Input Buffer: " + gc_buffer_ufs);
        System.out.println("GC's (SMS) Input Buffer: " + gc_buffer_sms);
        System.out.println("GC's (MAIL) Input Buffer: " + gc_buffer_mail);
        System.out.println("GC's (VOIP) Input Buffer: " + gc_buffer_voip);
        System.out.println("GC's (ADBK) Input Buffer: " + gc_buffer_adbk);
        System.out.println("GC's (SRCH) Input Buffer: " + gc_buffer_srch);
        System.out.println("GC's internal process queue: " + internal_process_queue);
        System.out.println("process_var: " + process_var + "\n");
    }

    /*
    List abc = new ArrayList();
    abc.add("Souvik");
    abc.add(20104127);
    addMessage_gc_buffer_rm(abc);
    public static void addMessage_gc_buffer_rm(List rmMessage) { gc_buffer_rm.add(rmMessage); }
    System.out.println(gc_buffer_rm);
     */

    // Starting Authentication Manager thread. The Authenticator object will be in
    // ../authenticate directory
    Authenticator auth = Authenticator.getInstance();
    auth.start();
    globj.updateObjRef("Authenticator", auth);

    // Starting Routing Manager thread. The RoutingManager object will be in
    // ../routingmgmt directory
    RoutingManager RoutMgr = RoutingManager.getInstance();
    RoutMgr.start();
    globj.updateObjRef("RoutingManager", RoutMgr);

    // Starting Communication Manager thread. The CommunicationManager object will be in
    // ../comnmgr directory
    Communator comn = Communator.getObject();
    comn.start();
    globj.updateObjRef("Communator", comn);

    // Starting Index Manager thread. The IndexManager object will be in
    // ../indexmanager directory
    IndexingManager inm = IndexingManager.getInstance();
    inm.start();
    globj.updateObjRef("IndexingManager", inm);

    // Starting GUI webserver for React based web UI interface.
    WebUIServer WebUIS = WebUIServer.getInstance();
    WebUIS.start();
    globj.updateObjRef("WebUI", WebUIS);

    //The input buffers of the Glue Code will be checked periodically (only if the current_skip_flag’s value is 1. More about this in the next point.) for all the modules in Round Robin fashion. Each input buffer will be checked for 5 seconds or until all the data/query are extracted, whichever time is less.

    //If the current_skip_flag value is 1, then only the corresponding module’s input buffer is checked. Otherwise, the current_skip_flag’s value is decremented by 1.

    public static void readingthread()
    {
        Thread readingThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                // This statement will request Routing manager to ascertain keys for which I am root node.
                while (true)
                {
                    //System.out.println("Reading Thread running...");
                    if(current_skip_flag_am == 1)
                    {
                        //check output buffer of authentication manager;
                        //if (data found in the output buffer of authentication manager)
                        if ((gc_buffer_am.size())>0)
                        {
                            status_skip_flag_am = 1;
                            count=0;
                            while ( (gc_buffer_am.size()>0) && (count<1000) )
                            {
                                internal_process_queue.add(gc_buffer_am.pollFirst());
                                count = count+1;
                            }
                        }
                        //else if (no query found in the output buffer of Authentication Manager)
                        //else if (gc_buffer_am.size()==0)
                        else
                        {
                            if (status_skip_flag_am < max_limit_of_skip_flags)
                            {
                                status_skip_flag_am = status_skip_flag_am * 2;
                            }
                            current_skip_flag_am = status_skip_flag_am;
                        }
                    }
                    else
                    {
                        current_skip_flag_am--;
                    }


                    if(current_skip_flag_cm ==1)
                    {
                        //check output buffer of communication manager;
                        //if (data found in the output buffer of communication manager)
                        if ((gc_buffer_cm.size())>0)
                        {
                            status_skip_flag_cm = 1;
                            count=0;
                            while ( (gc_buffer_cm.size()>0) && (count<1000) )
                            {
                                internal_process_queue.add(gc_buffer_cm.pollFirst());
                                count = count+1;
                            }
                        }
                        //else if (no query found in the output buffer of Communication Manager)
                        //else if (gc_buffer_cm.size()==0)
                        else
                        {
                            if (status_skip_flag_cm < max_limit_of_skip_flags)
                            {
                                status_skip_flag_cm = status_skip_flag_cm * 2;
                            }
                            current_skip_flag_cm = status_skip_flag_cm;
                        }
                    }
                    else
                    {
                        current_skip_flag_cm--;
                    }


                    if(current_skip_flag_im ==1)
                    {
                        //check output buffer of indexing manager;
                        //if (data found in the output buffer of indexing manager)
                        if ((gc_buffer_im.size())>0)
                        {
                            status_skip_flag_im = 1;
                            count=0;
                            while ( (gc_buffer_im.size()>0) && (count<1000) )
                            {
                                internal_process_queue.add(gc_buffer_im.pollFirst());
                                count = count+1;
                            }
                        }
                        //else if (no query found in the output buffer of Indexing Manager)
                        //else if (gc_buffer_im.size()==0)
                        else
                        {
                            if (status_skip_flag_im < max_limit_of_skip_flags)
                            {
                                status_skip_flag_im = status_skip_flag_im * 2;
                            }
                            current_skip_flag_im = status_skip_flag_im;
                        }
                    }
                    else
                    {
                        current_skip_flag_im--;
                    }


                    if(current_skip_flag_rm ==1)
                    {
                        //check output buffer of routing manager;
                        //if (data found in the output buffer of routing manager)
                        if ((gc_buffer_rm.size())>0)
                        {
                            status_skip_flag_rm = 1;
                            count=0;
                            while ( (gc_buffer_rm.size()>0) && (count<1000) )
                            {
                                internal_process_queue.add(gc_buffer_rm.pollFirst());
                                count = count+1;
                            }
                        }
                        //else if (no query found in the output buffer of Routing Manager)
                        //else if (gc_buffer_rm.size()==0)
                        else
                        {
                            if (status_skip_flag_rm < max_limit_of_skip_flags)
                            {
                                status_skip_flag_rm = status_skip_flag_rm * 2;
                            }
                            current_skip_flag_rm = status_skip_flag_rm;
                        }
                    }
                    else
                    {
                        current_skip_flag_rm--;
                    }


                    if(current_skip_flag_ws ==1)
                    {
                        //check output buffer of web server;
                        //if (data found in the output buffer of web server)
                        if ((gc_buffer_ws.size())>0)
                        {
                            status_skip_flag_ws = 1;
                            count=0;
                            while ( (gc_buffer_ws.size()>0) && (count<1000) )
                            {
                                internal_process_queue.add(gc_buffer_ws.pollFirst());
                                count = count+1;
                            }
                        }
                        //else if (no query found in the output buffer of Web Server)
                        //else if (gc_buffer_ws.size()==0)
                        else
                        {
                            if (status_skip_flag_ws < max_limit_of_skip_flags)
                            {
                                status_skip_flag_ws = status_skip_flag_ws * 2;
                            }
                            current_skip_flag_ws = status_skip_flag_ws;
                        }
                    }
                    else
                    {
                        current_skip_flag_ws--;
                    }
                    

                    if(current_skip_flag_web == 1)
                    {
                        //check output buffer of Web Module;
                        //if (data found in the output buffer of Web Module)
                        if ((gc_buffer_web.size())>0)
                        {
                            status_skip_flag_web = 1;
                            count=0;
                            while ( (gc_buffer_web.size()>0) && (count<1000) )
                            {
                                internal_process_queue.add(gc_buffer_web.pollFirst());
                                count = count+1;
                            }
                        }
                        //else if (no query found in the output buffer of Web Module)
                        //else if (gc_buffer_web.size()==0)
                        else
                        {
                            if (status_skip_flag_web < max_limit_of_skip_flags)
                            {
                                status_skip_flag_web = status_skip_flag_web * 2;
                            }
                            current_skip_flag_web = status_skip_flag_web;
                        }
                    }
                    else
                    {
                        current_skip_flag_web--;
                    }


                    if(current_skip_flag_dfs ==1)
                    {
                        //check output buffer of DFS Module;
                        //if (data found in the output buffer of DFS Module)
                        if ((gc_buffer_dfs.size())>0)
                        {
                            status_skip_flag_dfs = 1;
                            count=0;
                            while ( (gc_buffer_dfs.size()>0) && (count<1000) )
                            {
                                internal_process_queue.add(gc_buffer_dfs.pollFirst());
                                count = count+1;
                            }
                        }
                        //else if (no query found in the output buffer of DFS Module)
                        //else if (gc_buffer_dfs.size()==0)
                        else
                        {
                            if (status_skip_flag_dfs < max_limit_of_skip_flags)
                            {
                                status_skip_flag_dfs = status_skip_flag_dfs * 2;
                            }
                            current_skip_flag_dfs = status_skip_flag_dfs;
                        }
                    }
                    else
                    {
                        current_skip_flag_dfs--;
                    }


                    if(current_skip_flag_ufs ==1)
                    {
                        //check output buffer of UFS Module;
                        //if (data found in the output buffer of UFS Module)
                        if ((gc_buffer_ufs.size())>0)
                        {
                            status_skip_flag_ufs = 1;
                            count=0;
                            while ( (gc_buffer_ufs.size()>0) && (count<1000) )
                            {
                                internal_process_queue.add(gc_buffer_ufs.pollFirst());
                                count = count+1;
                            }
                        }
                        //else if (no query found in the output buffer of UFS Module)
                        //else if (gc_buffer_ufs.size()==0)
                        else
                        {
                            if (status_skip_flag_ufs < max_limit_of_skip_flags)
                            {
                                status_skip_flag_ufs = status_skip_flag_ufs * 2;
                            }
                            current_skip_flag_ufs = status_skip_flag_ufs;
                        }
                    }
                    else
                    {
                        current_skip_flag_ufs--;
                    }


                    if(current_skip_flag_sms ==1)
                    {
                        //check output buffer of Messaging Module;
                        //if (data found in the output buffer of Messaging Module)
                        if ((gc_buffer_sms.size())>0)
                        {
                            status_skip_flag_sms = 1;
                            count=0;
                            while ( (gc_buffer_sms.size()>0) && (count<1000) )
                            {
                                internal_process_queue.add(gc_buffer_sms.pollFirst());
                                count = count+1;
                            }
                        }
                        //else if (no query found in the output buffer of Messaging Module)
                        //else if (gc_buffer_sms.size()==0)
                        else
                        {
                            if (status_skip_flag_sms < max_limit_of_skip_flags)
                            {
                                status_skip_flag_sms = status_skip_flag_sms * 2;
                            }
                            current_skip_flag_sms = status_skip_flag_sms;
                        }
                    }
                    else
                    {
                        current_skip_flag_sms--;
                    }
                    

                    if(current_skip_flag_mail == 1)
                    {
                        //check output buffer of Mailing Module;
                        //if (data found in the output buffer of Mailing Module)
                        if ((gc_buffer_mail.size())>0)
                        {
                            status_skip_flag_mail = 1;
                            count=0;
                            while ( (gc_buffer_mail.size()>0) && (count<1000) )
                            {
                                internal_process_queue.add(gc_buffer_mail.pollFirst());
                                count = count+1;
                            }
                        }
                        //else if (no query found in the output buffer of Mailing Module)
                        //else if (gc_buffer_mail.size()==0)
                        else
                        {
                            if (status_skip_flag_mail < max_limit_of_skip_flags)
                            {
                                status_skip_flag_mail = status_skip_flag_mail * 2;
                            }
                            current_skip_flag_mail = status_skip_flag_mail;
                        }
                    }
                    else
                    {
                        current_skip_flag_mail--;
                    }


                    if(current_skip_flag_voip ==1)
                    {
                        //check output buffer of VOIP Module;
                        //if (data found in the output buffer of VOIP Module)
                        if ((gc_buffer_voip.size())>0)
                        {
                            status_skip_flag_voip = 1;
                            count=0;
                            while ( (gc_buffer_voip.size()>0) && (count<1000) )
                            {
                                internal_process_queue.add(gc_buffer_voip.pollFirst());
                                count = count+1;
                            }
                        }
                        //else if (no query found in the output buffer of VOIP Module)
                        //else if (gc_buffer_voip.size()==0)
                        else
                        {
                            if (status_skip_flag_voip < max_limit_of_skip_flags)
                            {
                                status_skip_flag_voip = status_skip_flag_voip * 2;
                            }
                            current_skip_flag_voip = status_skip_flag_voip;
                        }
                    }
                    else
                    {
                        current_skip_flag_voip--;
                    }


                    if(current_skip_flag_adbk ==1)
                    {
                        //check output buffer of Address Book Module;
                        //if (data found in the output buffer of Address Book Module)
                        if ((gc_buffer_adbk.size())>0)
                        {
                            status_skip_flag_adbk = 1;
                            count=0;
                            while ( (gc_buffer_adbk.size()>0) && (count<1000) )
                            {
                                internal_process_queue.add(gc_buffer_adbk.pollFirst());
                                count = count+1;
                            }
                        }
                        //else if (no query found in the output buffer of Address Book Module)
                        //else if (gc_buffer_adbk.size()==0)
                        else
                        {
                            if (status_skip_flag_adbk < max_limit_of_skip_flags)
                            {
                                status_skip_flag_adbk = status_skip_flag_adbk * 2;
                            }
                            current_skip_flag_adbk = status_skip_flag_adbk;
                        }
                    }
                    else
                    {
                        current_skip_flag_adbk--;
                    }


                    if(current_skip_flag_srch ==1)
                    {
                        //check output buffer of Search Module;
                        //if (data found in the output buffer of Search Module)
                        if ((gc_buffer_srch.size())>0)
                        {
                            status_skip_flag_srch = 1;
                            count=0;
                            while ( (gc_buffer_srch.size()>0) && (count<1000) )
                            {
                                internal_process_queue.add(gc_buffer_srch.pollFirst());
                                count = count+1;
                            }
                        }
                        //else if (no query found in the output buffer of Search Module)
                        //else if (gc_buffer_srch.size()==0)
                        else
                        {
                            if (status_skip_flag_srch < max_limit_of_skip_flags)
                            {
                                status_skip_flag_srch = status_skip_flag_srch * 2;
                            }
                            current_skip_flag_srch = status_skip_flag_srch;
                        }
                    }
                    else
                    {
                        current_skip_flag_srch--;
                    }


                    //If data/query is found in the input buffer of Glue Code (output buffer of the respective module), then both the status_skip_flag and the current_skip_flag values are set to 1.


                    //If no data/query is found, then the status_skip_flag value is multiplied by 2 if the status_skip_flag value is less than the number limit which is set before (something like 16 or 32), else, the status_skip_flag value is kept the same as the number limit (16 or 32). Also, the current_skip_flag is made equal to the status_skip_flag.


                    //If any query is found in any input buffer, read it, analyse it, and then do the appropriate operation.
                    try {
                        //System.out.println("Reading Thread going to sleep");
                        Thread.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        readingThread.start();
    }

    public static void processingthread()
    {
        Thread processingThread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {

                // This statement will request Routing manager to ascertain keys for which I am root node.
                while (true)
                {
                    // List or String array?   Ans: List
                    // ArrayList index starts from 0.
                    /*
                    List abc = new ArrayList();
                    abc.add("Souvik");
                    abc.add(20104127);
                    addMessage_gc_buffer_rm(abc);
                    public static void addMessage_gc_buffer_rm(List rmMessage) { gc_buffer_rm.add(rmMessage); }
                    System.out.println(gc_buffer_rm);
                    */

                    //System.out.println("My Processing Thread running...");
                    //System.out.println("6. GC's (CM) input buffer element moved to internal process queue.");
                    //display_buffer_status();
                    process_var = (ArrayList) internal_process_queue.get(0);
                    internal_process_queue.pollFirst();
                    //display_buffer_status();
                    //System.out.println(process_var.get(0));
                    if(process_var != null)
                    {
                        if ((process_var.get(0) == "que") || (process_var.get(0) == "res"))
                        {
                            //display_buffer_status();
                            System.out.println("process_var starts with que or res");
                            destination_module = (String) process_var.get(2);
                            //display_buffer_status();
                            System.out.println("Destination Module = " + destination_module);

                            //if ((process_var.get(1) in module_acronyms) && (process_var.get(2) in module_acronyms))
                            //{
                            //(destination_module)_addMessage_(destination_module)_buffer_gc(process_var);
                            //rm_addMessage_rm_buffer_gc(process_var);
                            //String temp001 = destination_module+"_addMessage_"+destination_module+"_buffer_gc";//destination_module+"_addMessage_"+destination_module+"_buffer_gc"(process_var);
                            //System.out.println(temp001);
                            //gc.temp001(process_var);
                            //}

                            if (destination_module == "rm") {
                                rm.addMessage_rm_buffer_gc(process_var);
                                //display_buffer_status();
                            } else if (destination_module == "cm") {
                                cm.addMessage_cm_buffer_gc(process_var);
                                //display_buffer_status();
                            }
                        }
                    }
                    try {
                        //System.out.println("Processing Thread going to sleep");
                        Thread.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        processingThread.start();
    }

    public static void main (String[] str)
    {
        cm.get_gc_instance(gc);
        rm.get_gc_instance(gc);

        System.out.println("1. Program starts.");
        display_buffer_status();
        cm.sendQuery_gc_buffer_cm();
        System.out.println("5. Program returned to main.");
        display_buffer_status();

        readingthread();
        processingthread();

        //while (1)
        //{
            //When the Glue Code does an API call related to a query, the module will just send the response of the query as a reply and nothing else. The Glue Code will form the respective response in the below mentioned format and then send the response to the module which initiated the query. (Glue Code will get to know about which module initiated the query from the “.cm” present at the end of the query or the process which has to be preserved even after forming the response.)
            //All the modules can form the responses in the form of messages and send them to the Glue Code one by one in the following Format:
            //res.{query_or_process_with_parameters_in_their_correct_sequence}.{response_of_query_or_process_in_appropriate_format}.{acronym_of_the_module_which_sends_the_response}.
            //Example: Routing Manager can send this following response to the Glue Code:
            //res.findNextHop(String 6FB23548386CCDB, int 2).details_of_the_next_hop_node.cm
            //When the Glue Code sees that the message starts with “res.”, GLUE CODE will understand that this is a response and then the GLUE CODE will check the acronym of the module present at the end of the response and forward the response by putting it at the input buffer of the module which initiated the query.

            //    send the response back to the module which initiated the query.
            //}
            //else if (process found)
            //{
            //Some processes will have a reply, others will not. The process (if responded) will be responded later after some time through the corresponding input buffer of the Glue Code.
            //
            //Messages Form:
            //Processes in the form of messages can be formed and sent to the Glue Code in the same way as the queries are being sent to the Glue Code. The only difference is that the processes will start with “pro.” instead of “que.”.
            //All the modules can form the processes in the form of messages and send them to the Glue Code one by one in the following Format:
            //pro.{process_with_parameters_in_their_correct_sequence}.{acronym_of_the_module_which_sends_the_process}
            //Example: Communication Manager can send this following process to the Glue Code: pro.findNextHop(String 6FB23548386CCDB, int 2).cm
            //The Glue Code will see that it’s a process from the “pro.” and then check that to which module the process belongs to (by using the ModuleCheck class), and then the Glue Code will just forward the process to the concerned module in the same format as it received the process by putting the process as a message element to the input buffer of the concerned module. The module can form the response in the response format (mentioned below) and send the response back to the corresponding input buffer of the Glue Code. The Glue code will just forward the response to the module which initiated the query. (The Glue Code will get to know about it from the “.cm” mentioned at the end of the response received.)
            //
            //XML File Form:
            //In case a module needs to send a File as a process parameter, then the module will at first save the file (if the file is not already saved) and find out the absolute path of the file and pass it as a parameter inside the query in the appropriate place…
            //For example, the Routing Manager of Node A wants to send a file of Routing Table to the Routing Manager of Node B. The Routing Manager will hand over a process of the Communication Manager (in the form of a message) to the Glue Code stating the method and it will also pass the absolute address of the (Routing Table) file as a parameter in the process (message). When the Glue Code gets the process, it simply searches for the module name to which the process belongs to, using the ModuleCheck class. Then the Glue Code puts the process to the input buffer of Communication Manager. When the Communication Manager gets the process from its input buffer, it checks the parameters and then it can locate the File from the file name (along with its’ absolute path). The same thing happens when the Communication Manager needs to send a file to the Routing Manager. The Communication Manager will save the file in the hard drive, find the File Name (along with the absolute path) and then it can put the file name along with the absolute path as a parameter in the process, and send the process as a message to the input buffer of the Glue Code. The Glue Code will see that it is a process and from the ModuleCheck, it will understand that the process belongs to the Routing Manager, and then it will send the process to the input buffer of Routing Manager.

            //    send the process file to the respective module
            //}
            //else if (query found)
            //{
            //Queries have to be sent to the Glue Code in the form of messages only which will be responded immediately using the API call.
            //All the modules can form the queries and send them to the Glue Code one by one in the following Format:
            //que.{query_with_parameters_in_their_correct_sequence}.{acronym_of_the_module_which_sends_the_query}
            //Example: Communication Manager can send this following query to the Glue Code:
            //que.getNodeID().cm
            //The Glue Code will see that it’s a query from the “que.” and then check that to which module the query belongs to (by using the ModuleCheck class) and then the Glue Code will use the API call to get the response of the query from the module the method belongs to, and then send the response of the query to the corresponding module which initiated the query (Glue Code will get to know about this from the “.cm” present at the end of the query or the process which has to be preserved even after forming the response).

            //    read the XML file check that the query belongs to which of the following categories... If the query belongs to any of the following categories, then process the query...
            //}

            //The required appropriate operation may be to give some information (publish) to any module or to get some information (query) from any module.
            // All the modules can send only one query/publish at a single time. The query/publish will be sent in the form of messages or XML files, one query/publish at a time. There wil be a seperate Java file (a seperate class) which will be a part of the Glue Code. The file/class will contain the information about which methods belongs to which module. When the Glue Code receives a query/publish message/file, the Glue Code matches the query/publish with the queries (methods) mentioned in the file and tries to find out that which query (method) belongs to which module, and then the Glue Code sends the received query/publish message/file to the respective module.
            // The other modules needs to make sure that the query/publish message/file contains the name of the module who sent the query/publish message/file to the Glue Code.

            //In such a case, the Glue Code will call the respective module directly via an API call.

            //The modules will respond to such calls instantly with the required data/information (in case of a query). (As no response is needed in case of a publish).

            //After the Glue Code receives the required information, it will send back the information to the module which initially demanded for it.

            //In this case the information is directly put in the input buffer of that respective module which initially demanded for that information.

            //All these while, the Glue Code will also update all the required statistics and data to a web browser using the web-server module.
            //(This will be the user interface; to be done using React JS).


            //The below threads will be started based on demand… (These will always have a Singleton Thread.)

            //(Singleton Thread - Whenever a thread needs to be started, we will check whether there is a thread already running or not. If yes, we will process that thread only. Otherwise, we will start a new thread. And whenever the requirement of the module ends, we will stop the thread.)


            //Message Service
            //Start thread of Messaging System.
            //Condition for Starting Thread:
            //(i)	Message comes from other node via Communication Manager. This information reaches the Glue Code. The Glue Code starts the singleton Messaging thread, and hands over the Message to the Messaging module. The messaging module will read the messages and write it on the hard disk. Then the messaging module will create a pop-up that a message has been received and then the messaging module thread will be closed.
            //(ii)	Whenever the user clicks on the pop-up, the messaging module thread will run again, and the Messaging UI Window will be opened. … The messaging thread will keep running until the user manually closes the messaging window.
            //(iii)	When the user opens the messaging service manually, the messaging module thread will run again, and the Messaging UI Window will be opened. … The messaging thread will keep running until the user manually closes the messaging window.


            //Mailing Service
            //Start thread of Mailing System.
            //Condition for Starting Thread:
            //(i)	Mail comes from other node via Communication Manager. This information reaches the Glue Code. The Glue Code starts the singleton Mailing thread, and hands over the Mail to the Mailing module. The mailing module will create a pop-up that a mail has been received and then the mailing module thread will be closed.
            //(ii)	Whenever the user clicks on the pop-up, the mailing module thread will run again, and the Mail UI Window will be opened. The mailing thread will keep running until the user manually closes the Mail UI Window.
            //(iii)	When the user opens the mailing service manually, the mailing module thread will run again, and the Mail UI Window will be opened. The mailing thread will keep running until the user manually closes the Mail UI Window.


            //VOIP Service
            //Start thread of VoIP.
            //Condition for starting Thread:
            //(i)	When the user manually starts the VoIP, the VoIP module thread will start. … When the user manually closes the VoIP window, the VoIP module will be closed.
            //(ii)	When VoIP call request arrives from the other node, then the request arrives through the Communication Manager to the Glue Code, and then the VoIP thread will start running, the VoIP window will be opened requesting user to accept the call.
            //(a)	If the user accepts the call, then the call will continue until the user disconnects the call. …*** (After the call has been set–up, then the VoIP service directly communicates with the Communication Manager… That means, the Glue Code is bypassed…) When the user disconnects the call, the VoIP thread will close.)
            //(b)	If the user does not accept the call, then the ring will happen for about 30 seconds, and then a pop-up of missed call will be shown the window by the VoIP, and the VoIP module thread will be closed.
            //(c)	When the user rejects the call, the VoIP service thread will be closed.
            //(iii)	When the user clicks on the pop-up, the VoIP module thread will start. When the user manually closes the VoIP window, the VoIP module will be closed.


            //Storage Service
            //Start service of DFS Storage.
            //Start service of UFS Storage.


            //Web Service
            //Start service of Web.


            //Search Service
            //Start thread of Search.


            //Address Book Service
            //Start thread of Address Book.
        //} // Process Loop while close
    } // Main method close
} // GlueCode Class close
