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

function buildMessage(body) {
  return `${body.message}\n\r
  ${body.roomState ? body.roomState.title : "" }
  ${body.roomState ? body.roomState.description : ""}`;
}

function connect() {
  var socket = new SockJS('/gs-guide-websocket');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/greetings', function (gameStateResponse) {
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
  stompClient.send("/app/hello", {}, JSON.stringify({'command': $("#name").val()}));
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