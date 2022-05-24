package projet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/note_pad")
public class note_pad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Set<String> Email = new HashSet<String>();
	
	Map<String,String> mail_pass=new HashMap<String,String>();
	Map<String,String> mail_name=new HashMap<String,String>();
       
    public note_pad() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prénom = request.getParameter("prenom");
		String mail = request.getParameter("newEmail");
		String password = request.getParameter("password");
		
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(true);
		
		response.setContentType("text/html");
		
		
		out.println("<html>"
				+ "<head>"
				+ "<link rel=\"stylesheet\" href=\"css/all.min.css\">"
				+ "<title>TODO APP</title>");
				
		
		for (String key : mail_pass.keySet()) {
		    Email.add(key);
		}
		
		if(nom == null) {
			
			if(Email.contains(email) && mail_pass.get(email).compareTo(mdp) == 0) {
				String repeat = (String)session.getAttribute(email);
				out.println("<link rel=\"stylesheet\" href=\"Note/css/all.min.css\">\r\n"
						+ "    <link rel=\"stylesheet\" href=\"Note/css/style.css\">\r\n"
						+ "    <link rel=\"stylesheet\" href=\"Note/css/app.css\">"
						+ "<style>"
						+ "        body {\r\n"
						+ "            background: linear-gradient(90deg, #01dade, #f604fe);\r\n"
						+ "            width: 100%;\r\n"
						+ "            height: 100vh;\r\n"
						+ "        }\r\n"
						+ "        h2:first-of-type {\r\n"
						+ "            color: white;\r\n"
						+ "            text-align: center;\r\n"
						+ "            font-size: xxx-large;\r\n"
						+ "            font-family: sans-serif;\r\n"
						+ "            padding-top: 2%;\r\n"
						+ "        }\r\n"
						+ "    </style>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <h2>TODO APP</h2>\r\n"
						+ "    <div class=\"con\" clicked>\r\n"
						+ "        <ul>\r\n"
						+ "            <li>User name: <span>"+mail_name.get(email)+"</span></li>\r\n"
						+ "            <li>Email: <span>"+email+"</span></li>\r\n"
						+ "            <li>Password: <span>****</span></li>\r\n");
						if(repeat == null) {
							out.println("<li style=\"text-align: center; padding-top: 120%; font-size: x-large;\">Welcome</li>");
							session.setAttribute(email,"yes");
						}
						else
							out.println("<li style=\"text-align: center; padding-top: 120%; font-size: x-large;\">Welcome Again</li>");
						out.println("        </ul>\r\n"
						+ "        <div class=\"content\">\r\n"
						+ "            <form>"
						+ "                <input type=\"text\" maxlength=\"20\">\r\n"
						+ "                <input type=\"submit\">\r\n"
						+ "            </form>"
						+ "			   <ul></ul>");
						out.println("<footer>\r\n"
						+ "                <p></p>\r\n"
						+ "                <p>Clear all</p>\r\n"
						+ "            </footer>\r\n"
						+ "        </div>\r\n"
						+ "    </div>\r\n");
						out.println("<script>"
								+ "// clear Strorage\r\n"
								+ "function clear() {\r\n"
								+ "    localStorage.clear();\r\n"
								+ "}\r\n"
								+ "\r\n"
								+ "// create li with children \r\n"
								+ "let newLi = document.createElement(\"li\"); \r\n"
								+ "let newImg1 = document.createElement(\"img\");\r\n"
								+ "newImg1.src = \"Note/images/icon-check.svg\";\r\n"
								+ "newImg1.alt = \"check.svg\";\r\n"
								+ "let newImg2 = document.createElement(\"img\");\r\n"
								+ "newImg2.src = \"Note/images/icon-cross.svg\";\r\n"
								+ "newImg2.alt = \"cross.svg\";\r\n"
								+ "newImg2.className = \"cross\";\r\n"
								+ "let newP = document.createElement(\"p\");\r\n"
								+ "\r\n"
								+ "newLi.append(newImg1);\r\n"
								+ "newLi.append(newP);\r\n"
								+ "newLi.append(newImg2);\r\n"
								+ "\r\n"
								+ "// add input\r\n"
								+ "let form = document.forms[0];\r\n"
								+ "let list = document.querySelector(\".content ul\");\r\n"
								+ "let footer = document.querySelector(\"footer\");\r\n"
								+ "let [,b] = [...footer.children];\r\n"
								+ "let counter = 0;\r\n"
								+ "\r\n"
								+ "b.onclick = function() {\r\n"
								+ "    [...list.children].forEach(function(ele) {\r\n"
								+ "        ele.remove();\r\n"
								+ "    });\r\n"
								+ "    clear();\r\n"
								+ "};\r\n"
								+ "\r\n"
								+ "// Verif BOM has items\r\n"
								+ "if(localStorage.length != 0 && ( localStorage.hasOwnProperty(\""+email+"1\") || localStorage.hasOwnProperty(\""+email+"2\") || localStorage.hasOwnProperty(\""+email+"3\")) ) {"
								+ "    counter = localStorage.length;\r\n"
								+ "    let j = 1;\r\n"
								+ "    for(let i=0; i<localStorage.length; i++) {\r\n"
								+ "        let li = newLi.cloneNode(true);\r\n"
								+ "        if(localStorage.getItem(`"+email+"${j}`).endsWith(\"T\")) {\r\n"
								+ "            li.children[1].textContent = localStorage.getItem(`"+email+"${j}`).slice(0,localStorage.getItem(`"+email+"${j}`).length - 1);\r\n"
								+ "            li.className = \"done\";\r\n"
								+ "        } else \r\n"
								+ "            li.children[1].textContent = localStorage.getItem(`"+email+"${j}`);\r\n"
								+ "        list.append(li);\r\n"
								+ "        // li active\r\n"
								+ "        li.addEventListener(\"click\",function(e) {\r\n"
								+ "            this.classList.toggle(\"done\");\r\n"
								+ "            \r\n"
								+ "            if(e.target == li.lastChild) {\r\n"
								+ "                [...list.children].forEach(function(ele,i) {\r\n"
								+ "                    if (ele.lastChild == e.target) {\r\n"
								+ "                        localStorage.removeItem(`"+email+"${i+1}`);\r\n"
								+ "                    }\r\n"
								+ "                });\r\n"
								+ "                this.remove();\r\n"
								+ "            } else {\r\n"
								+ "                if (this.className == \"done\") {\r\n"
								+ "                    window.localStorage.setItem(`"+email+"${i+1}`,`${this.textContent}T`);\r\n"
								+ "                } else {\r\n"
								+ "                    window.localStorage.setItem(`"+email+"${i+1}`,`${this.textContent}`);\r\n"
								+ "                }\r\n"
								+ "            }\r\n"
								+ "        });\r\n"
								+ "        j++;\r\n"
								+ "    }\r\n"
								+ "\r\n"
								+ "}\r\n"
								+ "\r\n"
								+ "form[1].addEventListener(\"click\",function(e) {\r\n"
								+ "    e.preventDefault();"
								+ "    if(! form[0].value == \"\") {\r\n"
								+ "        let li = newLi.cloneNode(true);\r\n"
								+ "        li.children[1].textContent = form[0].value;\r\n"
								+ "        list.append(li);\r\n"
								+ "        //start BOM\r\n"
								+ "        window.localStorage.setItem(`"+email+"${++counter}`,`${form[0].value}`);"
								+ "\r\n"
								+ "        // li active\r\n"
								+ "        li.addEventListener(\"click\",function(e) {\r\n"
								+ "            this.classList.toggle(\"done\");\r\n"
								+ "            \r\n"
								+ "            if(e.target == li.lastChild) {\r\n"
								+ "                if (this.className == \"done\") {\r\n"
								+ "                    a.textContent = `${--counter} items left`;\r\n"
								+ "                } else {\r\n"
								+ "                    a.textContent = `${counter} items left`;\r\n" ////
								+ "                }\r\n"
								+ "                [...list.children].forEach(function(ele,i) {\r\n"
								+ "                    if (ele.lastChild == e.target) {\r\n"
								+ "                        localStorage.removeItem(`"+email+"${i+1}`);\r\n"
								+ "                    }\r\n"
								+ "                });\r\n"
								+ "                this.remove();\r\n"
								+ "            } else {\r\n"
								+ "                if (this.className == \"done\") {\r\n"
								+ "                    window.localStorage.setItem(`"+email+"${i+1}`,`${this.textContent}T`);"
								+ "                } "
								+ "            }\r\n"
								+ "        });\r\n"
								+ "        // set BOM\r\n"
								+ "        [...list.children].forEach(function(ele,i) {\r\n"
								+ "            ele.addEventListener(\"click\",function() {\r\n"
								+ "                if(this.className == \"done\") {\r\n"
								+ "                    window.localStorage.setItem(`"+email+"${i+1}`,`${this.textContent}T`);\r\n"
								+ "                } else \r\n"
								+ "                    window.localStorage.setItem(`"+email+"${i+1}`,`${this.textContent}`);\r\n"
								+ "            });\r\n"
								+ "        });\r\n"
								+ "    }\r\n"
								+ "    form[0].value = \"\";\r\n"
								+ "});"
								+ "</script>");
			} else {
				if(!Email.contains(email)) {
					out.println("<style>"
							+"* {font-family: sans-serif;}"
							+".count {"
							+"background: linear-gradient(90deg, #01dade, #f604fe);"
							+"width: 100%;"
							+"height: 100vh;}"
							+".login {"
							+"padding: 10px;"
							+"border: none;"
							+"border-radius: 30px;"
							+"outline: none;"
							+"background: -webkit-linear-gradient(right, #fc00ff, #00dbde, #fc00ff, #00dbde);"
							+"width: 18%;"
							+"color: white;"
							+"font-size: 18px;"
							+"font-weight: 700;"
							+"cursor: pointer;"
							+"background-size: 300% 100%;"
							+"transition: .4s;"
							+"display: block;"
							+"text-decoration: none;"
							+"margin: auto}"
							+".login:hover {"
							+"        background-position: 50% 0;}"
							+"</style>"
							+"</head>"
							+"<body style=\"margin: 0 \">"
							+"<div class='count'>");
					out.println("<div style=\"width: fit-content; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); background-color: white; padding: 1% 3% 2%; border-radius: 10px; box-shadow: 0px 0px 11px 0px #d5d5d5; text-align: center; color: #666\"><h2>Create an account</h2>");
					out.println("<a style=\"width: 65%\" href=\"index.jsp\" class=\"login\">Create One</a>");
					out.println("</div>");
				} else {
					out.println("<style>"
							+"* {font-family: sans-serif;}"
							+".count {"
							+"background: linear-gradient(90deg, #01dade, #f604fe);"
							+"width: 100%;"
							+"height: 100vh;}"
							+".login {"
							+"padding: 10px;"
							+"border: none;"
							+"border-radius: 30px;"
							+"outline: none;"
							+"background: -webkit-linear-gradient(right, #fc00ff, #00dbde, #fc00ff, #00dbde);"
							+"width: 18%;"
							+"color: white;"
							+"font-size: 18px;"
							+"font-weight: 700;"
							+"cursor: pointer;"
							+"background-size: 300% 100%;"
							+"transition: .4s;"
							+"display: block;"
							+"text-decoration: none;"
							+"margin: auto}"
							+".login:hover {"
							+"        background-position: 50% 0;}"
							+"</style>"
							+"</head>"
							+"<body style=\"margin: 0 \">"
							+"<div class='count'>");
					out.println("<div style=\"width: fit-content; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); background-color: white; padding: 1% 3% 2%; border-radius: 10px; box-shadow: 0px 0px 11px 0px #d5d5d5; text-align: center; color: #666\"><h2>Wrong password</h2>");
					out.println("<a style=\"width: 74%\" href=\"index.jsp\" class=\"login\">Log In Again</a>");
					out.println("</div>");
				}
			}
		} else {
			
			if(Email.contains(mail)) {
				out.println("<style>"
						+"* {font-family: sans-serif;}"
						+".count {"
						+"background: linear-gradient(90deg, #01dade, #f604fe);"
						+"width: 100%;"
						+"height: 100vh;}"
						+".login {"
						+"padding: 10px;"
						+"border: none;"
						+"border-radius: 30px;"
						+"outline: none;"
						+"background: -webkit-linear-gradient(right, #fc00ff, #00dbde, #fc00ff, #00dbde);"
						+"width: 18%;"
						+"color: white;"
						+"font-size: 18px;"
						+"font-weight: 700;"
						+"cursor: pointer;"
						+"background-size: 300% 100%;"
						+"transition: .4s;"
						+"display: block;"
						+"text-decoration: none;"
						+"margin: auto}"
						+".login:hover {"
						+"        background-position: 50% 0;}"
						+"</style>"
						+"</head>"
						+"<body style=\"margin: 0 \">"
						+"<div class='count'>");
				out.println("<div style=\"width: fit-content; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); background-color: white; padding: 1% 3% 2%; border-radius: 10px; box-shadow: 0px 0px 11px 0px #d5d5d5; text-align: center\"><h2>This email "+"<span style=\"color: #666; font-size: smaller;\">"+mail+"</span>"+" existe</h2>");
				out.println("<a href=\"index.jsp\" class=\"login\">Go Back</a>");
				out.println("</div>");
			} else {
				mail_pass.put(mail, password);
				mail_name.put(mail, prénom + " " + nom);
				out.println("<style>"
						+"* {font-family: sans-serif;}"
						+".count {"
						+"background: linear-gradient(90deg, #01dade, #f604fe);"
						+"width: 100%;"
						+"height: 100vh;}"
						+".login {"
						+"padding: 10px;"
						+"border: none;"
						+"border-radius: 30px;"
						+"outline: none;"
						+"background: -webkit-linear-gradient(right, #fc00ff, #00dbde, #fc00ff, #00dbde);"
						+"width: 18%;"
						+"color: white;"
						+"font-size: 18px;"
						+"font-weight: 700;"
						+"cursor: pointer;"
						+"background-size: 300% 100%;"
						+"transition: .4s;"
						+"display: block;"
						+"text-decoration: none;"
						+"margin: auto}"
						+".login:hover {"
						+"        background-position: 50% 0;}"
						+"</style>"
						+"</head>"
						+"<body style=\"margin: 0 \">"
						+"<div class='count'>");
				out.println("<div style=\"width: fit-content; position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); background-color: white; padding: 1% 3% 2%; border-radius: 10px; box-shadow: 0px 0px 11px 0px #d5d5d5; text-align: center\"><h2 style=\"display: inline-block; color: #666\">Welcome Your account has created successfully</h2>");
				out.println("<i class=\"fa-solid fa-circle-check\" style=\"font-size: 25px; color: #01dade;margin-left: 15px\"></i>");
				out.println("<a href=\"index.jsp\" class=\"login\">Go Back</a>");
				out.println("</div>");
			}
		}
		out.println("</div></body></html>");
	}
}
