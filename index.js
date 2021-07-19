const express = require("express");

const app = express();

const PORT = 3000;

app.get("/ping", (req, res) => {
  res.send("ping pong");
});

app.get("/", (req,res) => {
  res.send("Hello World, Welcome to the party!");
});



app.listen(PORT, () => {
  console.log(`Listening on port: ${PORT}`);
});
