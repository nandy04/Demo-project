package JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filemanager_JDBC2")
public class filemanager_JDBC2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
       public filemanager_JDBC2() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		 
		super.init( config );

	        try
	        {
	            Class.forName( "com.mysql.jdbc.Driver" );
	        }
	        catch( ClassNotFoundException e )
	        {
	            throw new ServletException( e );
	        }
	}

	
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<JDBC_model> entries = new ArrayList<JDBC_model>();
	
		String parent_id = request.getParameter("id");
		Integer id = null;
	
		if(parent_id!=null)
		{
			id = Integer.parseInt(parent_id);
		}
		
		
        Connection c = null;
        try
        {
        	 String url = "jdbc:mysql://cs3calstatela/cs3220stu54";
             String username = "cs3220stu54";
             String password = "VUd*!E*7";


            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            if(id==null)
            { 	
            	ResultSet rs = stmt.executeQuery( "select * from files where owner_id = (select id from users where name='cysun')"
            			+ "and parent_id is null");
          
	            while( rs.next() )
	            {
	                entries.add(new JDBC_model(rs.getInt("id"),rs.getString("name"),rs.getInt( "parent_id" ),
	                		rs.getBoolean( "is_folder" ), rs.getInt( "owner_id" ))); 	
	            }
	            c.close();
            }
            
            else
            {
            	ResultSet rs = stmt.executeQuery( "select * from files where owner_id = (select id from users where name='cysun')"
            			+ "and parent_id='"+id+"'");
          
	            while( rs.next() )
	            {
	                entries.add(new JDBC_model(rs.getInt("id"),rs.getString("name"),rs.getInt( "parent_id" ),
	                		rs.getBoolean( "is_folder" ), rs.getInt( "owner_id" ))); 	
	            }
	            c.close();
            	
            	
            }
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }

        request.setAttribute( "entries",entries );
        request.getRequestDispatcher( "/WEB-INF/JDBC_display.jsp" ).forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
