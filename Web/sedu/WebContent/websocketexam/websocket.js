var databox, socket;
function initiate(){
  databox=document.getElementById('databox');
  var button=document.getElementById('button'); 
  button.addEventListener('click', send, false);

  socket=new WebSocket("ws://localhost:8000/sedu/TheWebSocketServlet");
  socket.addEventListener('message', received, false);
}
function received(e){
  databox.innerHTML+='Received: '+e.data+'<br>';
}
function send(){
  var command=document.getElementById('command').value;
  socket.send(command);
}
window.addEventListener('load', initiate, false);


