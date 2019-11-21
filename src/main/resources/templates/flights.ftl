<!DOCTYPE html>
<html lang="RU">
<head>
    <meta charset="UTF-8">
    <title>SpaceX</title>
    <!--    CSS  -->
    <link rel="stylesheet" href="css/all_flights.css">
    <!--    Google Fonts-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
    <!--    Bootstrap-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <nav class="navbar navbar-expand-lg">
        <img src="https://utmagazine.ru/uploads/content/logo.jpg" alt="" class="spacex_icon">
        <div class="nav-bar">
            <a href="/logout" style="float: right">Log out</a>
        </div>
    </nav>
</div>
<div class="container">
    <div class="list-header">
        <div class="header-inner">All flights</div>
    </div>
    <div class="wrapper">

        <a href="/flights/${flight.flightNumber}">
            <div class="flight">
                <div class="row">
                    <div class="col-3">
                        <div class="img-container">
                            <div class="img">
                                <img src="${flight.missionPatchUrl}" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-7 flight_name">
                    <span class="name">
                        ${flight.flightName}
                    </span>
                    </div>
                </div>
            </div>
        </a>

        <a href="/flights/${flight.flightNumber}">
            <div class="flight">
                <div class="row">
                    <div class="col-3">
                        <div class="img-container">
                            <div class="img">
                                <img src="${flight.missionPatchUrl}" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-7 flight_name">
                    <span class="name">
                        ${flight.flightName}
                    </span>
                    </div>
                </div>
            </div>
        </a>

        <a href="/flights/${flight.flightNumber}">
            <div class="flight">
                <div class="row">
                    <div class="col-3">
                        <div class="img-container">
                            <div class="img">
                                <img src="${flight.missionPatchUrl}" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-7 flight_name">
                    <span class="name">
                        ${flight.flightName}
                    </span>
                    </div>
                </div>
            </div>
        </a>

        <a href="/flights/${flight.flightNumber}">
            <div class="flight">
                <div class="row">
                    <div class="col-3">
                        <div class="img-container">
                            <div class="img">
                                <img src="${flight.missionPatchUrl}" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-7 flight_name">
                    <span class="name">
                        ${flight.flightName}
                    </span>
                    </div>
                </div>
            </div>
        </a>

        <a href="/flights/${flight.flightNumber}">
            <div class="flight">
                <div class="row">
                    <div class="col-3">
                        <div class="img-container">
                            <div class="img">
                                <img src="${flight.missionPatchUrl}" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-7 flight_name">
                    <span class="name">
                        ${flight.flightName}
                    </span>
                    </div>
                </div>
            </div>
        </a>

        <a href="/flights/${flight.flightNumber}">
            <div class="flight">
                <div class="row">
                    <div class="col-3">
                        <div class="img-container">
                            <div class="img">
                                <img src="${flight.missionPatchUrl}" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-7 flight_name">
                    <span class="name">
                        ${flight.flightName}
                    </span>
                    </div>
                </div>
            </div>
        </a>

        <a href="/flights/${flight.flightNumber}">
            <div class="flight">
                <div class="row">
                    <div class="col-3">
                        <div class="img-container">
                            <div class="img">
                                <img src="${flight.missionPatchUrl}" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-7 flight_name">
                    <span class="name">
                        ${flight.flightName}
                    </span>
                    </div>
                </div>
            </div>
        </a>

        <a href="/flights/${flight.flightNumber}">
            <div class="flight">
                <div class="row">
                    <div class="col-3">
                        <div class="img-container">
                            <div class="img">
                                <img src="${flight.missionPatchUrl}" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-7 flight_name">
                    <span class="name">
                        ${flight.flightName}
                    </span>
                    </div>
                </div>
            </div>
        </a>

    </div>
</div>


</body>
</html>