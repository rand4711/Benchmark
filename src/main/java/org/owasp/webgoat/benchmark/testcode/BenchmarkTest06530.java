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

@WebServlet("/BenchmarkTest06530")
public class BenchmarkTest06530 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		// Chain a bunch of propagators in sequence
		String a18156 = param; //assign
		StringBuilder b18156 = new StringBuilder(a18156);  // stick in stringbuilder
		b18156.append(" SafeStuff"); // append some safe content
		b18156.replace(b18156.length()-"Chars".length(),b18156.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map18156 = new java.util.HashMap<String,Object>();
		map18156.put("key18156", b18156.toString()); // put in a collection
		String c18156 = (String)map18156.get("key18156"); // get it back out
		String d18156 = c18156.substring(0,c18156.length()-1); // extract most of it
		String e18156 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d18156.getBytes() ) )); // B64 encode and decode it
		String f18156 = e18156.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f18156); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new int[] { 1, 2 } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
