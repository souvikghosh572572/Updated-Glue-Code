//package com.ehelpy.brihaspati4.testgc;
//Glue Code Pseudo Code:

//  Authentication Manager = am
//  Communication Manager = cm
//  Indexing Manager = im
//  Routing Manager = rm
//  Web Server Module = ws
//  Web Module = web
//  VoIP = voip
//  DFS = dfs
//  UFS = ufs
//  Mail = mail
//  Message = sms

//import the required packages...
import java.util.*;
import java.util.LinkedList;
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
/*
import com.ehelpy.brihaspati4.testgc.CommMgr;
import com.ehelpy.brihaspati4.testgc.RoutingMgr;
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
*/
//import com.ehelpy.brihaspati4.DFS.dfs3Mgr.DFS3Config;
//import com.ehelpy.brihaspati4.simulateGC.init.DFSInit;

//import com.ehelpy.brihaspati4.simulateGC.IM.Testing;


public static class TestGC {
//Start thread of Routing Manager.
//Start thread of Communication Manager.

    private String final_query;
    //Example: private static ConfigData config;
    //         config = ConfigData.getInstance();

    //final_query = ModuleCheck.findModuleName(qname);
    //Call the final query...

    //private int status_skip_flag_am = 1;
    private int status_skip_flag_rm = 1;
    private int status_skip_flag_cm = 1;
    //private int status_skip_flag_im = 1;
    //private int status_skip_flag_ws = 1;
    private int max_limit_of_skip_flags = 32;
    private int count = 0;
    //private String[] module_acronyms = {"am", "cm", "im", "rm", "ws", "web", "voip", "dfs", "ufs", "mail", "sms"};

    // inputModule_buffer_outputModule
    //private LinkedList gc_buffer_am = new LinkedList();
    // here am sent the data to gc
    private static LinkedList gc_buffer_rm = new LinkedList();
    private static LinkedList gc_buffer_cm = new LinkedList();
    //private LinkedList gc_buffer_im = new LinkedList();
    //private LinkedList gc_buffer_ws = new LinkedList();
    //private LinkedList gc_buffer_web = new LinkedList();
    private static LinkedList internal_process_queue = new LinkedList();
    TestGC gc = new TestGC();

    // gc.addMessage_gc_buffer(rm, list_variable)


    // public addMessage_gc_buffer(String source_module_acronym, List message)
    // {
    //     String =
    //     gc_buffer_{source_module_acronym}.add(message);
    // }

    // gc.addMessage_gc_buffer_rm(list_variable)


    public static void addMessage_gc_buffer_rm(List rmMessage)
    {
        gc_buffer_rm.add(rmMessage);
        System.out.println("3. List received by gc.");
    }
    public static void addMessage_gc_buffer_cm(List cmMessage)
    {
        gc_buffer_cm.add(cmMessage);
    }

    public static void routingMgr_addMessage_gc_buffer_rm()
    {
        List abc = new ArrayList();
        abc.add("Souvik");
        abc.add(20104127);
        System.out.println("2. List sent to gc.");
        addMessage_gc_buffer_rm(abc);
        System.out.println("4. List already received by gc.");
    }
    private int current_skip_flag_rm = 1;
    private int current_skip_flag_cm = 1;



    public static void main (String[] str)
    {
        System.out.println("1. Program starts.");
        routingMgr_addMessage_gc_buffer_rm();
        System.out.println("5. Program returned to main.");
        System.out.println(gc_buffer_rm);
        /*
        while (1)
        {
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
        }

        while (1)
        {
            // List index starts from 1, and not 0 (unlike array)
            // While declaring List, no need of "[]".
            List process_var = internal_process_queue.pollFirst();
            String destination_module = process_var[3];
            if ((process_var[1] == "que") || (process_var[1] == "res"))
            {
                //if ((process_var[1] in module_acronyms) && (process_var[2] in module_acronyms))
                //{
                {destination_module}.addMessage_{destination_module}_buffer_gc(process_var);

                //}
            }
        }
         */
    }


}
