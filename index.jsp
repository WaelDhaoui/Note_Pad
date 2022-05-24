<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/all.min.css">
    <title>Note Pad</title>
    <style type="text/css">
    
    * {
        padding: 0;
        margin: 0;
        font-family: Arial, Helvetica, sans-serif;
    }
    .count {
        background: linear-gradient(90deg, #01dade, #f604fe);
        width: 100%;
        height: 100vh;
    }
    form {
        background-color: white;
        width: 450px;
        text-align: center;
        border-radius: 10px;
        box-shadow: 0px 0px 11px 0px #d5d5d5;    
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        backface-visibility: hidden;
        transition: 1s;
    }
    form.signUp {
        transform: translate(-50%, -50%) rotateY(-180deg);
    }
    h2 {
        font-size: 30px;
        font-weight: 700;
        padding: 20px 0;
        margin: 20px 0;
    }
    .user_fild, .pass_fild {
        height: 60px;
            margin: 0 0 40px 0;
        line-height: 50px;
        position: relative;
    }
    .user_fild label,
    .pass_fild label {
        color: rgb(40, 40, 40);
        font-size: 12px;
        font-weight: bold;
        position: absolute;
        top: -30px;
    }
    .user_fild input,
    .pass_fild input {
        width: 65%;
        outline: none;
        border: none;
        border-bottom: 1px solid #666;
        padding: 15px;
        padding-left: 20px;
        transition: 0.3s;
    }
    .user_fild input:focus,
    .pass_fild input:focus {
        border: 1px solid #01dade;
        border-radius: 5px;
        width: 67%;
    }
    .signUp .user_fild {
        display: inline-block;
        width: 38.8%;
    }
    .signUp .user_fild,
    .signUp .pass_fild {
        margin-bottom: 20px;
    }
    form label {
        position: relative;
    }
    form:first-of-type .pass_fild label::before,
    form:last-of-type .pass_fild label::before {
        font-family: "Font Awesome 5 Free";
        content: '\f023';
        position: absolute;
        top: 63%;
        left: 2px;
        color: #707070;
    }
    form:first-of-type .user_fild label::before,
    form:last-of-type .email label::before {
        font-family: "Font Awesome 5 Free";
        content: '\f0e0';
        position: absolute;
        top: 63%;
        left: 2px;
        color: #707070;
    }
    form:last-of-type .user_fild label::before {
        font-family: "Font Awesome 5 Free";
        content: '\f007';
        position: absolute;
        top: 63%;
        left: 2px;
        color: #707070;
    }
    .signUp .login {
        margin-bottom: 15px;
    }
    .signUp .sign {
        padding: 0px;
        height: 125px;
    }
    .check {
        width: 70%;
        height: 40px;
        position: relative;
    }
    .check input {
        position: absolute;
        left: 25%;
        top: -20px;
    }
    .check label {
        position: absolute;
        left: 10%;
        top: -22px;
        font-size: 15px;
        color: #666;
    }
    .check a {
        position: absolute;
        right: -18%;
        top: -22px;
        font-size: 15px;
        color: #666;
        text-decoration: none;
    }
    .sign p:last-of-type:hover {
        text-decoration: underline;
    }
    .login {
        padding: 12px;
        margin-bottom: 30px;
        border: none;
        border-radius: 30px;
        outline: none;
        background: -webkit-linear-gradient(right, #fc00ff, #00dbde, #fc00ff, #00dbde);
        width: 65%;
        color: white;
        font-size: 20px;
        font-weight: 700;
        cursor: pointer;
        background-size: 300% 100%;
        transition: .4s;
    }
    .login:hover {
        background-position: 50% 0;
    }
    .sign {
        height: 130px;
        padding: 20px 0 0 0;
    }
    .sign p,
    .sign p:last-of-type {
        color: #666;
        margin-bottom: 10px;
    }
    .sign p:last-of-type {
        border: none;
        background-color: transparent;
        font-size: initial;
        cursor: pointer;
        width: fit-content;
        margin: auto;
    }
    </style>
</head>
<body>
    <div class="count">
        <form method="get" class="signIn" action="note_pad">
            <h2>Login</h2>
            <div class="user_fild">
                <label for="user">Email</label>
                <input type="email" id="user" placeholder="Type your email" name="email" required>
            </div>
            <div class="pass_fild">
                <label for="passIn">PassWord</label>
                <input type="password" id="passIn" placeholder="Type your password" name="mdp" required>
            </div>
            <input class="login" type="submit" value="Login">
            <div class="sign">
                <p>Or</p>
                <p>Sign Up</p>
            </div>
        </form>
        <form method="get" class="signUp" action="note_pad">
            <h2>Sign Up</h2>
            <div class="user_fild">
                <label for="name">Name</label>
                <input type="text" id="name" placeholder="Type your name" name="prenom" required>
            </div>
            <div class="user_fild">
                <label for="last">Last Name</label>
                <input type="text" id="last" placeholder="Type your last name" name="nom" required>
            </div>
            <div class="pass_fild email">
                <label for="email">Email</label>
                <input type="email" id="email" placeholder="o@gmail.com" name="newEmail" required>
            </div>
            <div class="pass_fild">
                <label for="pass">PassWord</label>
                <input type="password" id="pass" placeholder="Type your password" name="password" required>
            </div>
            <input class="login" type="submit" value="Sign Up">
            <div class="sign">
                <p>Or</p>
                <p>Sign In</p>
            </div>
        </form>
    </div>
    <script>
        document.querySelector(".signIn p:last-of-type").onclick = function() {
            this.parentElement.parentElement.style.transform = "translate(-50%, -50%) rotateY(-180deg)";
            document.forms[1].style.transform = "translate(-50%, -50%) rotateY(0deg)";
        }
        document.querySelector(".signUp p:last-of-type").onclick = function() {
            this.parentElement.parentElement.style.transform = "translate(-50%, -50%) rotateY(-180deg)";
            document.forms[0].style.transform = "translate(-50%, -50%) rotateY(0deg)";
        }
    </script>
</body>
</html>