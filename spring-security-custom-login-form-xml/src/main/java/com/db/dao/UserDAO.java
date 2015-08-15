package com.db.dao;
import com.dao.model.User;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import javax.sql.DataSource;

public class UserDAO {
	 @Autowired  
	 DataSource dataSource;  
	 
	 public User getById(int id) {
		 String query = "select userName from Users where id = ?";
		 User user = null;
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 try{
			 con = dataSource.getConnection();
			 ps = con.prepareStatement(query);
			 ps.setInt(1, id);
			 rs = ps.executeQuery();
			 if(rs.next()){
				 user = new User();
				 user.setUserID(id);
				 user.setUserName(rs.getString("userName"));
				 //user.setRole(rs.getString("role"));
				 System.out.println("User Found::"+user);
			 }else{
				 System.out.println("No User found with id="+id);
			 }
		 }catch(SQLException e){
			 e.printStackTrace();
		 }finally{
			 try {
				 rs.close();
				 ps.close();
				 con.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		 }
		 return user;
	 }
}
