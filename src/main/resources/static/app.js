var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    const data = {
        "applicationID": "9",
        "applicationName": "Testjuandi",
        "deviceName": "Nodo1",
        "devEUI": "iy3cj9AP2C8=",
        "rxInfo": [
            {
                "gatewayID": "JOEk//7zYMM=",
                "time": "2022-08-01T22:41:43.617449Z",
                "timeSinceGPSEpoch": "1343428921.617s",
                "rssi": -78,
                "loRaSNR": 13.5,
                "channel": 6,
                "rfChain": 1,
                "board": 0,
                "antenna": 0,
                "location": {
                    "latitude": -2.88678,
                    "longitude": -78.99069,
                    "altitude": 2550,
                    "source": "UNKNOWN",
                    "accuracy": 0
                }
            }
        ]
    };
    stompClient.send("/app/hello", {}, JSON.stringify(data));
    // stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});