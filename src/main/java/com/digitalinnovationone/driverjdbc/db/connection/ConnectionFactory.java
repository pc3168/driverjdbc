package com.digitalinnovationone.driverjdbc.db.connection;

import java.nio.channels.ConnectionPendingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionParameter connectionParameter;

    public ConnectionFactory(ConnectionParameter connectionParameter) {
        this.connectionParameter = connectionParameter;
    }

    public Connection connection() throws Exception {
        buildUrl();
        Connection con = null;
        try{
            con = DriverManager.getConnection(connectionParameter.getUrl(), connectionParameter.getUsername(), connectionParameter.getPassword());
        }catch( SQLException e){
            e.printStackTrace();
            throw new Exception("Não foi possível conectar com o banco de dados."+System.lineSeparator()+e.getMessage());
        }

        return con;
    }

    private void buildUrl(){
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:");
        sb.append(connectionParameter.getDriver());
        sb.append("://");
        if (!connectionParameter.getHost().isEmpty()){
            sb.append(connectionParameter.getHost());
        }
        if (!connectionParameter.getPort().isEmpty()){
            sb.append(":");
            sb.append(connectionParameter.getPort());
        }
        sb.append("/");
        sb.append(connectionParameter.getDatabase());
        connectionParameter.setUrl(sb.toString());
    }
}
