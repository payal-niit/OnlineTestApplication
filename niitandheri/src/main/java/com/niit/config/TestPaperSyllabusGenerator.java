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

public class TestPaperSyllabusGenerator implements IdentifierGenerator {

    

	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {

        String prefix = "TESTP";
        Connection connection = session.connection();
        try {

            PreparedStatement ps = connection
                    .prepareStatement("SELECT nextval ('dbo.TestPaperSyllabusSequence') as nextval");

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("nextval");
                String code = prefix + StringUtils.leftPad("" + id,3,"0");
                
                return code;
            }

        } catch (SQLException e) {
            
            throw new HibernateException(
                    "Unable to generate Stock Code Sequence");
        }
        return null;
    }

	
}
