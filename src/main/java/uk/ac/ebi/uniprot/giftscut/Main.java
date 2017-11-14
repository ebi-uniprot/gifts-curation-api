package uk.ac.ebi.uniprot.giftscut;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class Main {
    public static void main(String[] args) throws Exception {
        ResourceConfig config = new ResourceConfig();
        config.packages("uk.ac.ebi.uniprot.giftscut.rest");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));

        Server jettyServer = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(jettyServer, "/rest/*");
        context.addServlet(servlet, "/*");


        try {
            jettyServer.start();
            jettyServer.join();
        } catch (Exception e){
            e.printStackTrace();
            jettyServer.stop();
            jettyServer.destroy();
        }
    }
}