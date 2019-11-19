<!DOCTYPE html>
<html lang="RU">
<head>
    <meta charset="UTF-8">
    <title>SpaceX</title>
    <!--    CSS  -->
    <link rel="stylesheet" href="css/main.css">
    <!--    Google Fonts-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
    <!--    Bootstrap-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <nav class="navbar navbar-expand-lg">
        <a href="/"><img src="https://utmagazine.ru/uploads/content/logo.jpg" alt="" class="spacex_icon"></a>
        <div class="nav-bar">
            <a href="/signUp" style="float: right">Sign Up</a>
            <a href="/login" style="float: right">Log in</a>
        </div>
    </nav>
</div>
<div class="wrapper">
    <div class="container">
        <div class="content-container">
            <div class="content">
                <div class="image"><img src="${flight.getImageUrl()}" alt=""
                                        class="flight_img"></div>
                <div class="info">
                    <span class="flight_name">${flight.getName()}</span>
                    ${flight.getDescription()}
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="content-container">
            <div class="content">
                <div style="text-align: center; margin-bottom: 40px;">Launch Information</div>
                <table class="table table-borderless">
                    <tbody>
                    <tr>
                        <th scope="row">Flight Number</th>
                        <td>${flight.getNumber()}</td>
                    </tr>
                    <tr>
                        <th scope="row">Rocket</th>
                        <td>${flight.getRocketName()}</td>
                    </tr>
                    <tr>
                        <th scope="row">Launch Date</th>
                        <td>${flight.getLaunchDate()}</td>
                    </tr>
                    <tr>
                        <th scope="row">Launch Success</th>
                        <#if flight.getLaunchSuccess() == "true">
                            <td>Success</td>
                        <#else>
                            <td>Fail</td>
                        </#if>

                    </tr>
                    <tr>
                        <th scope="row">Wikipedia</th>
                        <td><a href="${flight.getWikipedia()}">Click</a></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="content-container">
            <div class="content">
                <div style="text-align: center; margin-bottom: 40px;">YouTube Launch Video</div>
                <iframe width="100%" height="550px"
                        src="https://www.youtube.com/embed/VshdafZvwrg">
                </iframe>
            </div>
        </div>
    </div>

</div>


</body>
</html>