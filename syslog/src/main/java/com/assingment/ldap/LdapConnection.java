package com.assingment.ldap;

import javax.naming.*;
import javax.naming.ldap.*;
import javax.naming.directory.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public class LdapConnection {

      LdapConnection()
    {
        Properties prop = new Properties();
        Map<String, String> environment = new Hashtable<>();
        try {
            //load a properties file from class path, inside static method
            InputStream input= (InputStream) getClass().getClassLoader().getResourceAsStream("credentialsForLdap.properties");
            if(input!=null)
            {
                prop.load(input);
                environment.put(Context.INITIAL_CONTEXT_FACTORY, prop.getProperty("INITIAL_CONTEXT_FACTORY"));
                environment.put(Context.PROVIDER_URL,prop.getProperty("PROVIDER_URL"));
                environment.put(Context.SECURITY_AUTHENTICATION,prop.getProperty("SECURITY_AUTHENTICATION"));
                environment.put(Context.SECURITY_PRINCIPAL,prop.getProperty("SECURITY_PRINCIPAL"));
                environment.put(Context.SECURITY_CREDENTIALS,prop.getProperty("SECURITY_CREDENTIALS"));
                DirContext context = new InitialDirContext((Hashtable<?,?>)environment );
                System.out.println(context.getEnvironment());
                Attributes attributes =new BasicAttributes();
                Attribute attribute =new BasicAttribute("objectClass");
                attribute.add("inetOrgPerson");
                attributes.put(attribute);
                Attribute sn =new BasicAttribute("sn");
                sn.add("Karthik");
                Attribute cn =new BasicAttribute("cn");
                cn.add("Raja");
                attributes.put(sn);
                attributes.put(cn);
                attributes.put("telephoneNumber", "12332");
                context.createSubcontext("employeeNumber=1 ,ou=users,ou=system",attributes);
                System.out.println(" success");
                context.close();
            }
            else
            {
                throw new FileNotFoundException();
            }

        }
        catch (IOException | NamingException ex) {
            ex.printStackTrace();
            throw  new RuntimeException();
        }

    }
}
