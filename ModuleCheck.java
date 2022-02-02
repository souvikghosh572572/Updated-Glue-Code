package com.ehelpy.brihaspati4.GC;
//ModuleCheck Pseudo Code:

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
import java.util.LinkedList;
import java.lang.String;
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


public class ModuleCheck
{
    private String module_name;
    private String f_qname;
    public static String findModuleName(String qname)
    {
        // qname.startsWith("am01")  ---> Here, qname will contain the whole name (for now, we are considering that all the queries will be case sensitive.) and the string mentioned in the qname.startsWith("am01"), for example "am01", will only contain the method names without the parameters, so that the qname and the method name matches exactly.

        if ((qname.startsWith("am01")) || (qname.startsWith("am02")) || (qname.startsWith("am03")))
        {
            module_name = "am";

            // To consider the case insensitive matching of all the query names, we can lowercase all the qnames we receive and then check if they match with the lowercased method names. If both of them match, then we can extract out the parameters from the received query as they are, and substitute the actual method name in it's place and then add (concatenate) the parameters after the substituted actual method name. After that we will need to add (concatenate) the "module_name." in front of the qname and then we can return the "module_name.actual_method_name_based_on_the_query_received+(any_parameters_received_with_the_actual_query_without_changing_the_case)"

            /*
            if (qname == "am01")
            {
                qname = "Am01";
            }
            else if (qname == "am02")
            {
                qname = "Am02";
            }
            */
        }
        else if ((qname.startsWith("cm01")) || (qname.startsWith("cm02")) || (qname.startsWith("cm03")))
        {
            module_name = "cm";
        }
        else if ((qname.startsWith("im01")) || (qname.startsWith("im02")) || (qname.startsWith("im03")))
        {
            module_name = "im";
        }
        else if ((qname.startsWith("rm01")) || (qname.startsWith("rm02")) || (qname.startsWith("rm03")))
        {
            module_name = "rm";
        }
        else if ((qname.startsWith("ws01")) || (qname.startsWith("ws02")) || (qname.startsWith("ws03")))
        {
            module_name = "ws";
        }
        else if ((qname.startsWith("webm01")) || (qname.startsWith("web02")) || (qname.startsWith("web03")))
        {
            module_name = "web";
        }
        else if ((qname.startsWith("voip01")) || (qname.startsWith("voip02")) || (qname.startsWith("voip03")))
        {
            module_name = "voip";
        }
        else if ((qname.startsWith("dfs01")) || (qname.startsWith("dfs02")) || (qname.startsWith("dfs03")))
        {
            module_name = "dfs";
        }
        else if ((qname.startsWith("ufs01")) || (qname.startsWith("ufs02")) || (qname.startsWith("ufs03")))
        {
            module_name = "ufs";
        }
        else if ((qname.startsWith("mail01")) || (qname.startsWith("mail02")) || (qname.startsWith("mail03")))
        {
            module_name = "mail";
        }
        else if ((qname.startsWith("sms01")) || (qname.startsWith("sms02")) || (qname.startsWith("sms03")))
        {
            module_name = "sms";
        }
        else
        {
            // print query not defined in any module
            // module_name = "no_module";
            module_name = "none";
        }
        f_qname = module_name+"."+qname;
        return (f_qname);
    }

//The required appropriate operation may be to give some information (publish) to any module or to get some information (query) from any module.
// All the modules will only send one query at a single time. The query/publish will be sent in the form of messages or XML files, one query/publish at a time. There will be a seperate Java file (a seperate class) which will be a part of the Glue Code. The file/class will contain the information about which methods belongs to which module. When the Glue Code receives a query/publish message/file, the Glue Code matches the query/publish with the queries (methods) mentioned in the file and tries to find out that which query (method) belongs to which module, and then the Glue Code sends the received query/publish message/file to the respective module.
// The other modules needs to make sure that the query/publish message/file contains the name of the module who sent the query/publish message/file to the Glue Code.

//In such a case, the Glue Code will call the respective module directly via an API call.

//The modules will respond to such calls instantly with the required data/information (in case of a query). (As no response is needed in case of a publish).

//After the Glue Code receives the required information, it will send back the information to the module which initially demanded for it.

//In this case the information is directly put in the input buffer of that respective module which initially demanded for that information.

//All these while, the Glue Code will also update all the required statistics and data to a web browser using the web-server module.
//(This will be the user interface; to be done using React JS).



}
