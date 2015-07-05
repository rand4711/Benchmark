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

@WebServlet("/BenchmarkTest19886")
public class BenchmarkTest19886 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.benchmark.helpers.Utils.testfileDir + bar));
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a17891 = param; //assign
		StringBuilder b17891 = new StringBuilder(a17891);  // stick in stringbuilder
		b17891.append(" SafeStuff"); // append some safe content
		b17891.replace(b17891.length()-"Chars".length(),b17891.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map17891 = new java.util.HashMap<String,Object>();
		map17891.put("key17891", b17891.toString()); // put in a collection
		String c17891 = (String)map17891.get("key17891"); // get it back out
		String d17891 = c17891.substring(0,c17891.length()-1); // extract most of it
		String e17891 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d17891.getBytes() ) )); // B64 encode and decode it
		String f17891 = e17891.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g17891 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g17891); // reflection
	
		return bar;	
	}
}
