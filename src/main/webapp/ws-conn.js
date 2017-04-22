var ws = new WebSocket('ws://localhost:8081/exchange_websocket/websocket');

ws.onopen = function (msg) {
    ws.send('sync_msg')
};

ws.onmessage = function (msg) {
    var data = JSON.parse(msg.data);

    var contentElement = document.getElementById("content");
    contentElement.innerHTML = JSON.stringify(data, null, 2);
};
