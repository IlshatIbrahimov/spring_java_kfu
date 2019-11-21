<!DOCTYPE html>
<html lang="RU">
<head>
    <meta charset="UTF-8">
    <title>SpaceX</title>
    <!--    CSS  -->
    <link rel="stylesheet" href="/css/main.css">
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
            <#if auth??>
                <a href="/logout" style="float: right">Log out</a>
                <a href="/flights" style="float: right">All flights</a>
            <#else>
                <a href="/signUp" style="float: right">Sign Up</a>
                <a href="/login" style="float: right">Log in</a>
            </#if>
        </div>
    </nav>
</div>
<div class="wrapper">
    <div class="container">
        <div class="content-container">
            <div class="main-content">
                <div class="row">
                    <div class="col-4">
                        <div class="image">
                            <img src="${flight.getImageUrl()}" alt=""
                                 class="flight_img">
                        </div>
                    </div>
                    <div class="col-8">
                        <div class="info">
                            <span class="flight_name">${flight.flightName}</span>
                            ${flight.description}
                        </div>
                    </div>
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
                        <td>${flight.flightNumber}</td>
                    </tr>
                    <tr>
                        <th scope="row">Rocket</th>
                        <td>${flight.rocketName}</td>
                    </tr>
                    <tr>
                        <th scope="row">Launch Date</th>
                        <td>${flight.launchDate}</td>
                    </tr>
                    <tr>
                        <th scope="row">Launch Success</th>
                        <#if flight.launchSuccess == "true">
                            <td>Success</td>
                        <#else >
                            <td>Fail</td>
                        </#if>
                    </tr>
                    <tr>
                        <th scope="row">Wikipedia</th>
                        <td><a href="${flight.wikipedia}">Click</a></td>
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
                        src="https://www.youtube.com/embed/${flight.videoLink}">
                </iframe>
            </div>
        </div>
    </div>

</div>


</body>
</html>