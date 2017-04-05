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

public class TestPaperGenerator implements IdentifierGenerator {   

	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		 /*Connection connection = session.connection();
	        PreparedStatement ps = null;
	        String result = "";

	        try {
	            // Oracle-specific code to query a sequence
	            ps = connection.prepareStatement("SELECT CourseSequence.nextval AS courseId FROM dual");
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                int pk = rs.getInt("courseId");

	                // Convert to a String
	                result = Integer.toString(pk);
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
	        }*/
		
		
        String prefix = "CRS";
        Connection connection = session.connection();
        PreparedStatement ps = null;
        String result = "";
        
        try {
            // Oracle-specific code to query a sequence
            ps = connection.prepareStatement("SELECT payal.TestPaperSequence.nextval AS testPaperId FROM dual");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int pk = rs.getInt("testPaperId");
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
        
        /*try {

            PreparedStatement ps = connection
                    .prepareStatement("SELECT nextval ('CourseSequence') as nextval");

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
        return result;
    }
	

	
}
