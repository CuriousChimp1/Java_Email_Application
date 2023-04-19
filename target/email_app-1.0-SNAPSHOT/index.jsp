<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="mail.MailClt" %>
<html>
<style>
    body {
        background: hsla(225, 78%, 59%, 1);
        background: linear-gradient(90deg, hsla(225, 78%, 59%, 1) 0%, hsla(197, 85%, 51%, 1) 100%);
        background: -moz-linear-gradient(90deg, hsla(225, 78%, 59%, 1) 0%, hsla(197, 85%, 51%, 1) 100%);
        background: -webkit-linear-gradient(90deg, hsla(225, 78%, 59%, 1) 0%, hsla(197, 85%, 51%, 1) 100%);
        filter: progid: DXImageTransform.Microsoft.gradient( startColorstr="#456FE8", endColorstr="#19B0EC", GradientType=1 );
    }
    input, textarea {
        border-radius: 20px !important;
        padding: 12px !important;
    }

</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Java Mail Client</title>
</head>

<body class="container">
<div style="height: 100vh;" class="d-flex flex-column justify-content-center align-items-center">
    <div class="shadow-lg p-4 border-0 bg-white" style="border-radius: 20px;">
        <h1 class="text-center mb-4" style="color: darkblue;"> Emailing Web Application</h1>
        <div class="d-flex justify-content-center">
            <div class="col-md-6 d-flex justify-content-center">
                <img src="./email.svg" alt="" style="width:60%;">
            </div>
            <div class="col-md-6">
                <form action="MailClt" method="post">
                    <div class="mb-3">
                        <label for="e" class="form-label">Email address</label>
                        <input class="form-control shadow-sm border-0" type="text" name="email" id="e" placeholder="Email To.." required>
                    </div>
                    <div class="mb-3">
                        <label for="subject" class="form-label">Subject</label>
                        <input class="form-control shadow-sm border-0" type="text" name="subject" id="subject" placeholder="Subject..">
                    </div>
                    <div class="mb-3">
                        <label for="m" class="form-label">Message</label>
                        <textarea class="form-control shadow-sm border-0" rows="3" cols="6" name="message" id="m" placeholder="Type your message here" required></textarea>
                    </div>
                    <input style="width:100%; background: #456FE8" type="submit" class="btn btn-primary shadow" onclick="perform()" name="operation" value="<%=MailClt.OP_GO%>"/>
                    <div id="loading" class="mt-4 text-center" style="display: none;">
                        <div class="spinner-border text-primary" role="status">
                            <span class="visually-hidden">Loading...</span>
                        </div>
                    </div>
                    <h4 class="mt-4 text-center">
                        <%String msg=(String)request.getAttribute("msg");%>
                        <font color="black"><%=(msg!=null)?msg:""%></font>
                    </h4>
                </form>
            </div>
        </div>
    </div>

</div>
<script>
    const perform = () => {
        document.getElementById("loading").style.display = "block";
        setTimeout(() => {
            document.getElementById("loading").style.display = "none";
        }, 7000);
    }
</script>
</body>
</html>