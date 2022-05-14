# sof-q72173964

Please, folow this steps to reproduce the error:

1. Build the project, in this step, maven will create the folder org/wsdl/1.0.0 inside .m2/repository
2. Copy the jar file /lib/nfe-wsdl-4.00.0-1.0.0.jar to the folder that maven has created in step 1
3. Replace the credentials to log via email inside src/main/resources/log4j2.xml and inside sof-q72173964/src/main/java/com/mycompany/sof/q72173964/SofQ72173964.java
4. Run this project

The expected erro must be:
```
DEBUG: getProvider() returning provider protocol=smtps; type=javax.mail.Provider$Type@69409c81; class=com.sun.mail.smtp.SMTPSSLTransport; vendor=Oracle
DEBUG SMTP: useEhlo true, useAuth false
DEBUG SMTP: trying to connect to host "localhost", port 465, isSSL true
Exception in thread "main" org.apache.commons.mail.EmailException: Sending the email to the following server failed : smtp.gmail.com:465
	at org.apache.commons.mail.Email.sendMimeMessage(Email.java:1469)
	at org.apache.commons.mail.Email.send(Email.java:1496)
	at com.mycompany.sof.q72173964.SofQ72173964.main(SofQ72173964.java:52)
Caused by: javax.mail.SendFailedException: Send failure (com.sun.mail.util.MailConnectException: Couldn't connect to host, port: localhost, 465; timeout -1 (java.net.ConnectException: Conexão recusada))
	at javax.mail.Transport.send(Transport.java:163)
	at javax.mail.Transport.send(Transport.java:48)
	at org.apache.commons.mail.Email.sendMimeMessage(Email.java:1459)
	... 2 more
Caused by: com.sun.mail.util.MailConnectException: Couldn't connect to host, port: localhost, 465; timeout -1 (java.net.ConnectException: Conexão recusada)
	at com.sun.mail.smtp.SMTPTransport.openServer(SMTPTransport.java:2118)
	at com.sun.mail.smtp.SMTPTransport.protocolConnect(SMTPTransport.java:712)
	at javax.mail.Service.connect(Service.java:248)
	at javax.mail.Service.connect(Service.java:91)
	at javax.mail.Service.connect(Service.java:76)
	at javax.mail.Transport.send(Transport.java:94)
	... 4 more
Caused by: java.net.ConnectException: Conexão recusada
	at java.base/sun.nio.ch.Net.connect0(Native Method)
	at java.base/sun.nio.ch.Net.connect(Net.java:576)
	at java.base/sun.nio.ch.Net.connect(Net.java:565)
	at java.base/sun.nio.ch.NioSocketImpl.connect(NioSocketImpl.java:588)
	at java.base/java.net.SocksSocketImpl.connect(SocksSocketImpl.java:333)
	at java.base/java.net.Socket.connect(Socket.java:645)
	at java.base/java.net.Socket.connect(Socket.java:595)
	at com.sun.mail.util.SocketFetcher.createSocket(SocketFetcher.java:331)
	at com.sun.mail.util.SocketFetcher.getSocket(SocketFetcher.java:238)
	at com.sun.mail.smtp.SMTPTransport.openServer(SMTPTransport.java:2084)
	... 9 more
Command execution failed.
org.apache.commons.exec.ExecuteException: Process exited with an error: 1 (Exit value: 1)
    at org.apache.commons.exec.DefaultExecutor.executeInternal (DefaultExecutor.java:404)
    at org.apache.commons.exec.DefaultExecutor.execute (DefaultExecutor.java:166)
    at org.codehaus.mojo.exec.ExecMojo.executeCommandLine (ExecMojo.java:982)
    at org.codehaus.mojo.exec.ExecMojo.executeCommandLine (ExecMojo.java:929)
    at org.codehaus.mojo.exec.ExecMojo.execute (ExecMojo.java:457)
    at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo (DefaultBuildPluginManager.java:137)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:210)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:156)
    at org.apache.maven.lifecycle.internal.MojoExecutor.execute (MojoExecutor.java:148)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:117)
    at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject (LifecycleModuleBuilder.java:81)
    at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build (SingleThreadedBuilder.java:56)
    at org.apache.maven.lifecycle.internal.LifecycleStarter.execute (LifecycleStarter.java:128)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:305)
    at org.apache.maven.DefaultMaven.doExecute (DefaultMaven.java:192)
    at org.apache.maven.DefaultMaven.execute (DefaultMaven.java:105)
    at org.apache.maven.cli.MavenCli.execute (MavenCli.java:972)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:293)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:196)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:78)
    at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:567)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:282)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:225)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:406)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:347)
    ```
