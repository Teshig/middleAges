let stompClient = null;
let playerId = null;

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

function buildMessage(body) {
  return `${body.message}\n\r
  ${body.roomState ? body.roomState.title : "" }
  ${body.roomState ? body.roomState.description : ""}`;
}

function loginRequest() {
  const name = $("#nameI");
  const pass = $("#pass");
  if (name && pass) {
    const data = {
      name: name.val(),
      password: pass.val()
    }
    fetch("http://localhost:8088/login", {
      headers : {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
      },
      method: "POST",
      body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
      playerId = data.id;
      connect(data.id);
    });
  }
}

function connect(playerId) {
  var socket = new SockJS('/middle-ages');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/greetings', function (gameStateResponse) {
      const messageToBeDisplayed = buildMessage(JSON.parse(gameStateResponse.body));
      showGreeting(messageToBeDisplayed);
    });
    stompClient.subscribe('/topic/personal-channel', function (gameStateResponse) {
      const messageToBeDisplayed = buildMessage(JSON.parse(gameStateResponse.body));
      showGreeting(messageToBeDisplayed);
    });
    stompClient.subscribe('/personal-channel/' + playerId, function (gameStateResponse) {
      const messageToBeDisplayed = buildMessage(JSON.parse(gameStateResponse.body));
      showGreeting(messageToBeDisplayed);
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
  stompClient.send("/app/command", {}, JSON.stringify({'playerId': playerId,'command': $("#name").val()}));
  $("#name").val('');
  $("#name").focus();
}

function showGreeting(message) {
  const tetArea = $("#textWindow");
  tetArea.text(tetArea.text() + "\n\r" + message);
}

$(function () {
  $("form").on('submit', function (e) {
    e.preventDefault();
  });
  $( "#connect" ).click(function() { connect(); });
  $( "#disconnect" ).click(function() { disconnect(); });
  $( "#send" ).click(function() { sendName(); });
});