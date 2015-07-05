/**
* OWASP Benchmark Project v1.1
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details
*
* @author Nick Sanidas <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06516")
public class BenchmarkTest06516 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a64767 = param; //assign
		StringBuilder b64767 = new StringBuilder(a64767);  // stick in stringbuilder
		b64767.append(" SafeStuff"); // append some safe content
		b64767.replace(b64767.length()-"Chars".length(),b64767.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64767 = new java.util.HashMap<String,Object>();
		map64767.put("key64767", b64767.toString()); // put in a collection
		String c64767 = (String)map64767.get("key64767"); // get it back out
		String d64767 = c64767.substring(0,c64767.length()-1); // extract most of it
		String e64767 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64767.getBytes() ) )); // B64 encode and decode it
		String f64767 = e64767.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g64767 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g64767); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement = org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.addBatch( sql );
			int[] counts = statement.executeBatch();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
