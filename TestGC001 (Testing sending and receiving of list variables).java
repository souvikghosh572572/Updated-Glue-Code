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


public class TestGC {
//Start thread of Routing Manager.
//Start thread of Communication Manager.

    private String final_query;
    //Example: private static ConfigData config;
    //         config = ConfigData.getInstance();

    //final_query = ModuleCheck.findModuleName(qname);
    //Call the final query...

    private int status_skip_flag_rm = 1;
    private int status_skip_flag_cm = 1;

    private int current_skip_flag_rm = 1;
    private int current_skip_flag_cm = 1;

    private int max_limit_of_skip_flags = 32;
    private int count = 0;

    //private String[] module_acronyms = {"am", "cm", "im", "rm", "ws", "web", "voip", "dfs", "ufs", "mail", "sms"};

    // inputModule_buffer_outputModule
    //private LinkedList gc_buffer_am = new LinkedList();
    // here cm and rm sent the data to gc
    private static LinkedList gc_buffer_cm = new LinkedList();
    private static LinkedList gc_buffer_rm = new LinkedList();

    private static LinkedList cm_buffer_gc = new LinkedList();
    private static LinkedList rm_buffer_gc = new LinkedList();

    private static LinkedList internal_process_queue = new LinkedList();
    private static List process_var = new ArrayList();
    private static String destination_module = new String();

    // gc.addMessage_gc_buffer(rm, list_variable)


    // public addMessage_gc_buffer(String source_module_acronym, List message)
    // {
    //     String =
    //     gc_buffer_{source_module_acronym}.add(message);
    // }

    // gc.addMessage_gc_buffer_rm(list_variable)

    public static void addMessage_gc_buffer_cm(List cmMessage)
    {
        gc_buffer_cm.add(cmMessage);
        System.out.println("3. List received by GC's (CM) input buffer.");
    }
    public static void addMessage_gc_buffer_rm(List rmMessage)
    {
        gc_buffer_rm.add(rmMessage);
        System.out.println("List received by GC's (RM) input buffer");
    }
    public static void commMgr_addMessage_gc_buffer_cm()
    {
        List abc = new ArrayList();
        abc.add("que");
        abc.add("cm");
        abc.add("rm");
        abc.add("getNodeID");
        abc.add("TLV Format of arguments 2CCD68");
        System.out.println("2. List being sent to gc.");
        // System.out.println("2a."+abc.get(1));
        addMessage_gc_buffer_cm(abc);
        System.out.println("4. List already received by gc.");
    }
    public static void routingMgr_addMessage_gc_buffer_rm()
    {
        
    }
    public static void cm_addMessage_cm_buffer_gc(List gcMessage)
    {
        cm_buffer_gc.add(gcMessage);
        System.out.println("List received by CM's input buffer");
    }
    public static void rm_addMessage_rm_buffer_gc(List gcMessage)
    {
        rm_buffer_gc.add(gcMessage);
        System.out.println("List received by RM's input buffer");
    }
    public static void display_buffer_status()
    {
        System.out.println("\nSHOWING BUFFER STATUS:");
        System.out.println("GC's CM Buffer: " + gc_buffer_cm);
        System.out.println("GC's RM Buffer: " + gc_buffer_rm);
        System.out.println("GC's internal process queue: " + internal_process_queue);
        System.out.println("process_var: " + process_var);
        System.out.println("CM's input buffer: " + cm_buffer_gc);
        System.out.println("RM's input buffer: " + rm_buffer_gc + "\n");
    }

    public static void main (String[] str)
    {
        TestGC gc = new TestGC();
        System.out.println("1. Program starts.");
        commMgr_addMessage_gc_buffer_cm();
        System.out.println("5. Program returned to main.");
        display_buffer_status();
        internal_process_queue.add(gc_buffer_cm.pollFirst());
        System.out.println("6. GC's (CM) input buffer element moved to internal process queue.");
        display_buffer_status();
        process_var = (ArrayList)internal_process_queue.get(0);
        internal_process_queue.pollFirst();
        display_buffer_status();
        //System.out.println(process_var.get(0));
        if ((process_var.get(0) == "que") || (process_var.get(0) == "res"))
        {
            //if ((process_var.get(1) in module_acronyms) && (process_var.get(2) in module_acronyms))
            //{
            System.out.println("process_var starts with que or res");
            destination_module = (String)process_var.get(2);
            System.out.println("Destination Module = " + destination_module);

            //rm_addMessage_rm_buffer_gc(process_var);
            //(destination_module)_addMessage_(destination_module)_buffer_gc(process_var);

            if (destination_module == "rm")
            {
                rm_addMessage_rm_buffer_gc(process_var);
            }
            else if (destination_module == "cm")
            {
                cm_addMessage_cm_buffer_gc(process_var);
            }

            //String temp001 = destination_module+"_addMessage_"+destination_module+"_buffer_gc";
            //destination_module+"_addMessage_"+destination_module+"_buffer_gc"(process_var);
            //System.out.println(temp001);
            //gc.temp001(process_var);
            //}
        }
        display_buffer_status();
        routingMgr_addMessage_gc_buffer_rm();
        

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
            // But, ArrayList index starts from 0.
            // While declaring List, no need of "[]".

            process_var = internal_process_queue.pollFirst();
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
