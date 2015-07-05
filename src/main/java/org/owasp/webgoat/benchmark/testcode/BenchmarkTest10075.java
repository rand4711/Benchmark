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
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10075")
public class BenchmarkTest10075 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a47400 = param; //assign
		StringBuilder b47400 = new StringBuilder(a47400);  // stick in stringbuilder
		b47400.append(" SafeStuff"); // append some safe content
		b47400.replace(b47400.length()-"Chars".length(),b47400.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map47400 = new java.util.HashMap<String,Object>();
		map47400.put("key47400", b47400.toString()); // put in a collection
		String c47400 = (String)map47400.get("key47400"); // get it back out
		String d47400 = c47400.substring(0,c47400.length()-1); // extract most of it
		String e47400 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d47400.getBytes() ) )); // B64 encode and decode it
		String f47400 = e47400.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g47400 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g47400); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
