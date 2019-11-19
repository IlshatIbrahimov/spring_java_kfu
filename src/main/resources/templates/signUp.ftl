<!DOCTYPE html>
<html lang="RU">
<head>
    <meta charset="UTF-8">
    <title>SpaceX SignUp</title>
    <!--    CSS  -->
    <link rel="stylesheet" href="css/login.css">
    <!--    Google Fonts-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
    <!--    Bootstrap-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="wrapper">
    <div class="form">
        <form action="/signUp" method="POST">
            <ul>
                <li class="login_text">SpaceX</li>
                <li class="login_input">
                    <div>
                        <span class="info_text">Введите вашу почту</span>
                        <input type="text" name="email" class="li" placeholder="Email">
                    </div>
                </li>
                <li class="password_input">
                    <div>
                        <span class="info_text">Введите ваш пароль</span>
                        <input type="password" name="password" class="pi" placeholder="Password">
                    </div>
                </li>
                <li class="password_input">
                    <input type="submit" name="" class="bi" value="Sign Up">
                </li>
                <li>
                    <#if error??>
                        ${error}
                    </#if>
                </li>
            </ul>
        </form>
    </div>
</div>
</body>
</html>