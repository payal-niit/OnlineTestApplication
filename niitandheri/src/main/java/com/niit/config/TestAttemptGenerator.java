package com.niit.config;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;

import org.hibernate.id.IdentifierGenerator;
import org.hibernate.tool.hbm2x.StringUtils;

public class TestAttemptGenerator implements IdentifierGenerator {

    

	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {

        /*String prefix = "TST-ATT";
        Connection connection = session.connection();
        try {

            PreparedStatement ps = connection
                    .prepareStatement("SELECT nextval ('TestAttemptSequence') as nextval");

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("nextval");
                String code = prefix + StringUtils.leftPad("" + id,3,"0");
                
                return code;
            }

        } catch (SQLException e) {
            
            throw new HibernateException(
                    "Unable to generate Stock Code Sequence");
        }*/
        
        String prefix = "TEST-ATT";
        Connection connection = session.connection();
        PreparedStatement ps = null;
        String result = "";
        
        try {
            // Oracle-specific code to query a sequence
            ps = connection.prepareStatement("SELECT payal.TestAttemptSequence.nextval AS testAttemptId FROM dual");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int pk = rs.getInt("testAttemptId");
                System.out.println("pk value is"+pk);
                // Convert to a String
                result = prefix + StringUtils.leftPad("" + pk,3,"0");
                System.out.println("result value is"+result);
            }
        } catch (SQLException e) {
            throw new HibernateException("Unable to generate Primary Key");
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new HibernateException("Unable to close prepared statement.");
                }
            }
        }
        return result;
    }

	
}
